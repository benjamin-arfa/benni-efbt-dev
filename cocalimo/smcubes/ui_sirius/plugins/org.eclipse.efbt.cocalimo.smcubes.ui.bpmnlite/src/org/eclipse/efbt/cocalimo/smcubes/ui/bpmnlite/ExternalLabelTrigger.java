/*******************************************************************************
 * Copyright (c) 2020 Bird Software Solutions Ltd
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Neil Mackenzie - initial API and implementation
 *******************************************************************************/
package org.eclipse.efbt.cocalimo.smcubes.ui.bpmnlite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.NotificationFilter.Custom;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.sirius.business.api.session.ModelChangeTrigger;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.ui.business.api.view.SiriusGMFHelper;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ext.base.Options;


/**
 * This triggers move "external labels" near the forms without label.
 */
public class ExternalLabelTrigger implements ModelChangeTrigger {

	protected static final NotificationFilter EXTERNAL_LABEL_FILTER = new Custom() {
		@Override
		public boolean matches(Notification notification) {
			return notification.getEventType() == Notification.SET && notification.getNotifier() instanceof Bounds
					&& notification.getFeature() == NotationPackage.Literals.LOCATION__X
					&& ((Integer) notification.getNewValue()) != 0 && ((Integer) notification.getOldValue()) == 0
					&& ((Bounds) notification.getNotifier()).eContainer() instanceof Node
					&& ((Node) ((Bounds) notification.getNotifier()).eContainer()).getElement() instanceof DNode //
					&& (//
			"ExternalLabel"
					.equals(((DNode) ((Node) ((Bounds) notification.getNotifier()).eContainer()).getElement())
							.getActualMapping().getName())//
					|| //
			"SPExternalLabel".equals(((DNode) ((Node) ((Bounds) notification.getNotifier()).eContainer()).getElement())
					.getActualMapping().getName())//
			);
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.sirius.business.api.session.ModelChangeTrigger#priority()
	 */
	@Override
	public int priority() {
		return 0;
	}

	@Override
	public Option<Command> localChangesAboutToCommit(Collection<Notification> notifications) {
		Option<Command> result = null;

		final List<DNode> dNodes = new ArrayList<DNode>();
		for (Notification notification : notifications) {
			// dNodes.add((DNode) notification.getNewValue());
			if (notification.getNotifier() instanceof Bounds) {
				Bounds bounds = (Bounds) notification.getNotifier();
				if (bounds.eContainer() instanceof Node) {
					Node node = (Node) bounds.eContainer();
					if (node.getElement() instanceof DNode) {
						dNodes.add((DNode) node.getElement());
					}
				}
			}
		}
		
		if (dNodes.isEmpty()) {
			return Options.<Command>newNone();
		}

		TransactionalEditingDomain ted = (TransactionalEditingDomain) AdapterFactoryEditingDomain
				.getEditingDomainFor(dNodes.get(0));
		Command rc = new RecordingCommand(ted) {
			@Override
			protected void doExecute() {
				for (DNode dNode : dNodes) {
					
				}
			}

			private DNode getDNodeWithoutLabel(DNode dNode) {
				for (DDiagramElement d : ((DNodeContainer) dNode.eContainer()).getElements()) {
					if (d.getTarget().equals(dNode.getTarget()) && (d instanceof DNode) && (//
					!"ExternalLabel".equals(d.getMapping().getName()) //
							|| //
					!"SPExternalLabel".equals(d.getMapping().getName()))//
					) {
						return (DNode) d;
					}
				}
				return null;
			}
		};

		result = Options.fromNullable(rc);

		return result != null ? result : Options.<Command>newNone();
	}

}
