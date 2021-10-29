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

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * @author Neil Mackenzie
 */
public class BPMNSessionListener implements SessionManagerListener {

	private ExternalLabelTrigger externalLabelTrigger = new ExternalLabelTrigger();
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.sirius.business.api.session.SessionManagerListener#notify(org
	 * .eclipse.sirius.business.api.session.Session, int)
	 */
	@Override
	public void notify(Session session, int notificationKind) {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.sirius.business.api.session.SessionManagerListener#
	 * notifyAddSession(org.eclipse.sirius.business.api.session.Session)
	 */
	@Override
	public void notifyAddSession(Session session) {
		session.getEventBroker().addLocalTrigger(ExternalLabelTrigger.EXTERNAL_LABEL_FILTER, this.externalLabelTrigger);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.sirius.business.api.session.SessionManagerListener#
	 * notifyRemoveSession(org.eclipse.sirius.business.api.session.Session)
	 */
	@Override
	public void notifyRemoveSession(Session session) {
		session.getEventBroker().removeLocalTrigger(this.externalLabelTrigger);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.sirius.business.api.session.SessionManagerListener#
	 * viewpointDeselected(org.eclipse.sirius.viewpoint.description.Viewpoint)
	 */
	@Override
	public void viewpointDeselected(Viewpoint viewpoint) {
		// do nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.sirius.business.api.session.SessionManagerListener#
	 * viewpointSelected(org.eclipse.sirius.viewpoint.description.Viewpoint)
	 */
	@Override
	public void viewpointSelected(Viewpoint arg0) {
		// do nothing
	}

}
