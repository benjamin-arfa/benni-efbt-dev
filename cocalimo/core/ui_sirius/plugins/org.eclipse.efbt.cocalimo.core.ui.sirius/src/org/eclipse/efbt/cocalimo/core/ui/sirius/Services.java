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
package org.eclipse.efbt.cocalimo.core.ui.sirius;

import java.util.Iterator;

import org.eclipse.efbt.cocalimo.core.model.task.Task;
import org.eclipse.efbt.cocalimo.core.model.task.TaskTag;
import org.eclipse.efbt.cocalimo.core.model.task.ScenarioSetTask;
import org.eclipse.efbt.cocalimo.core.model.task.SerialTask;
import org.eclipse.efbt.cocalimo.core.model.scenarios.Scenario;
import org.eclipse.efbt.cocalimo.core.model.scenarios.ScenarioTag;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;



/**
 * The services class used by VSM.
 * 
 * @author Neil Mackenzie
 */
public class Services {

	/**
	 * See
	 * http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24
	 * for documentation on how to write service methods.
	 */
	public EObject myService(EObject self, String arg) {

		return self;
	}

	/**
	 * Given an instance of a Task, this method returns the previous
	 * functinalmodule in a chain, or null if there was not a previous one.
	 * 
	 * @param self
	 * @return
	 */
	public EList<Task> getPreviousFunctionalModule(Task self) {

		EList<Task> list = new BasicEList<Task>();
		EObject container = self.eContainer();

		boolean addIt = false;
		if (container != null && ((container instanceof SerialTask)
				|| container instanceof ScenarioSetTask))
		// why do we include ScenarioSetFunctionalModule in the if statement,
		// there may be a good reason but should check.
		{
			EList<EObject> list2 = container.eContents();
			for (Iterator iterator = list2.iterator(); iterator.hasNext();) {
				EObject eObject = (EObject) iterator.next();

				if (addIt) {
					list.add((Task) eObject);
					addIt = false;
				}
				if (eObject == self)
					addIt = true;

			}
		}
		return list;
	}
	
	public TaskTag getTaskTag(Task self) {

		
		EObject root = EcoreUtil.getRootContainer(self);
		TreeIterator<EObject> contents = root.eAllContents();
		while (contents.hasNext() )
		{
			EObject o = contents.next();
			if (o instanceof TaskTag)
			{
				if (((TaskTag) o).getTask().equals(self))
					return (TaskTag) o;
			}
		}
		return null;
		
	}
	
public ScenarioTag getScenarioTag(Scenario self) {

		
		EObject root = EcoreUtil.getRootContainer(self);
		TreeIterator<EObject> contents = root.eAllContents();
		while (contents.hasNext() )
		{
			EObject o = contents.next();
			if (o instanceof ScenarioTag)
			{
				if (((ScenarioTag) o).getScenario().equals(self))
					return (ScenarioTag) o;
			}
		}
		return null;
		
	}
	
	
	
	

}
