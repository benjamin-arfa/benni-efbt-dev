/*
 * generated by Xtext 2.26.0
 */
package org.eclipse.efbt.openregspecs.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractOpenRegSpecsDSLValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efbt/bird_model"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efbt/data_meta_model"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.example.org/sql_lite"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efbt/bpmn_lite"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efbt/requirements_text"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efbt/testing"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efbt/openregspecs_smcubes_core_extension"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efbt/module_management"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/efbt/core"));
		return result;
	}
}
