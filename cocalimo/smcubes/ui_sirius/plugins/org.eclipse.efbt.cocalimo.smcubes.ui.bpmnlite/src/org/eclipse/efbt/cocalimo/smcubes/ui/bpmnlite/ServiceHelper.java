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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNode;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.efbt.cocalimo.smcubes.model.bpmn_lite.BaseElement;
import org.eclipse.efbt.cocalimo.smcubes.model.bpmn_lite.ExclusiveGateway;
import org.eclipse.efbt.cocalimo.smcubes.model.bpmn_lite.Gateway;
import org.eclipse.efbt.cocalimo.smcubes.model.bpmn_lite.InclusiveGateway;
import org.eclipse.efbt.cocalimo.smcubes.model.bpmn_lite.SequenceFlow;
import org.eclipse.efbt.cocalimo.smcubes.model.bpmn_lite.SubProcess;
import org.eclipse.efbt.cocalimo.smcubes.model.bpmn_lite.Task;

public class ServiceHelper {

	private static final String IS_EXTERNAL_LABEL = "isExternalLabel";

	/**
	 * Return the cross referencer attached to a particular EObject.
	 * 
	 * @param eo
	 *            EObject
	 * @return the cross referencer if it exists.
	 */
	public static ECrossReferenceAdapter getCrossReferenceAdapter(EObject eo) {
		ECrossReferenceAdapter eCrossReferenceAdapter = null;
		Iterator<Adapter> it = eo.eAdapters().iterator();
		while (eCrossReferenceAdapter == null && it.hasNext()) {
			Adapter adapter = it.next();
			if (adapter instanceof ECrossReferenceAdapter) {
				eCrossReferenceAdapter = (ECrossReferenceAdapter) adapter;
			}
		}
		return eCrossReferenceAdapter;
	}

	public static EObject trace(EObject eObject) {
		System.out.println("Trace(" + eObject + ")");
		return eObject;
	}


	public static Process getProcess(EObject eObject) {
		if (eObject == null) {
			return null;
		}
		if (eObject instanceof Process) {
			return (Process) eObject;
		}
		return getProcess(eObject.eContainer());
	}

	public static List<BaseElement> getElementsWithExternalLabel(DNodeContainer dNodeContainer) {
		List<BaseElement> result = new ArrayList<BaseElement>();

		Iterator<DDiagramElement> it = dNodeContainer.getElements().iterator();
		while (it.hasNext()) {
			DDiagramElement dde = it.next();
			Object bpmnElement = dde.getTarget();
			if (( (bpmnElement instanceof Gateway))) {
				if ( isExternalLabel((DNode) dde)) {
					result.add((BaseElement) bpmnElement);
				}
			} else if ((bpmnElement instanceof Task) || (bpmnElement instanceof SubProcess)) {
				DNodeContainer dNodeTask = (DNodeContainer) dde;
				for (DDiagramElement subDDE : dNodeTask.getElements()) {
					
				}
			}
		}

		return result;
	}

	public static boolean isExternalLabel(DNode dNode) {
		if (dNode == null || dNode.getOwnedStyle() == null || dNode.getOwnedStyle().getCustomFeatures() == null) {
			return false;
		}
		return dNode.getOwnedStyle().getCustomFeatures().contains(ServiceHelper.IS_EXTERNAL_LABEL);
	}

	public static void setExternalLabel(DNode dNode) {
		dNode.getStyle().getCustomFeatures().add(IS_EXTERNAL_LABEL);
	}

	public static void setInternalLabel(DNode dNode) {
		dNode.getStyle().getCustomFeatures().remove(IS_EXTERNAL_LABEL);
	}

	

}
