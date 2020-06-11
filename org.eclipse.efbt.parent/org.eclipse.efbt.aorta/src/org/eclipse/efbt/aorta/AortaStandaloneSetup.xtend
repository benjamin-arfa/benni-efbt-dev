/*
 * generated by Xtext 2.10.0
 */
package org.eclipse.efbt.aorta

import com.google.inject.Injector
import org.eclipse.emf.ecore.EPackage
import aorta_program.Aorta_programPackage
import aortafunctions.AortafunctionsPackage
import base_column_structured_data.Base_column_structured_dataPackage

import cell_transformation_logic.Cell_transformation_logicPackage
import column_structured_data.Column_structured_dataPackage 
import column_structures.Column_structuresPackage
import data_lineage.Data_lineagePackage
import dataset_based_functional_domain_breakdown.Dataset_based_functional_domain_breakdownPackage
import deep_structures.Deep_structuresPackage
import functionality_module.Functionality_modulePackage
import execution_environments.Execution_environmentsPackage
import input_data_structures.Input_data_structuresPackage
import module_management.Module_managementPackage
import output_data_sets.Output_data_setsPackage
import output_data_structures.Output_data_structuresPackage
import report_based_report_based_functional_domain_breakdown.Report_based_report_based_functional_domain_breakdownPackage
import report_structures.Report_structuresPackage
import requirements_text.Requirements_textPackage
import requirements_artefacts.Requirements_artefactsPackage
import scenarios.ScenariosPackage
import technical_specification_breakdown.Technical_specification_breakdownPackage
import test_definition.Test_definitionPackage
import test_input_data.Test_input_dataPackage
import test_worked_example.Test_worked_examplePackage
import test.TestPackage


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class AortaStandaloneSetup extends AortaStandaloneSetupGenerated {

	def static void doSetup() {
		new AortaStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	override register(Injector injector) {
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/aorta_program")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/aorta_program", Aorta_programPackage.eINSTANCE);
		}

		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/aortafunctions")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/aortafunctions", AortafunctionsPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/base_column_structured_data")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/base_column_structured_data", Base_column_structured_dataPackage.eINSTANCE);
		}

		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/cell_transformation_logic")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/cell_transformation_logic", Cell_transformation_logicPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/column_structured_data")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/column_structured_data", Column_structured_dataPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/column_structures")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/column_structures", Column_structuresPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/data_lineage")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/data_lineage", Data_lineagePackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/dataset_based_functional_domain_breakdown")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/dataset_based_functional_domain_breakdown", Dataset_based_functional_domain_breakdownPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/deep_structures")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/deep_structures", Deep_structuresPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/execution_environments")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/execution_environments", Execution_environmentsPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/functionality_module")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/functionality_module", Functionality_modulePackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/input_data_structures")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/input_data_structures", Input_data_structuresPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/module_management")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/module_management", Module_managementPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/output_data_sets")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/output_data_sets", Output_data_setsPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/output_data_structures")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/output_data_structures", Output_data_structuresPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/report_based_report_based_functional_domain_breakdown")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/report_based_report_based_functional_domain_breakdown", Report_based_report_based_functional_domain_breakdownPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/report_structures")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/report_structures", Report_structuresPackage.eINSTANCE);
		}
		
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/requirements_text")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/requirements_text", Requirements_textPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/requirements_artefacts")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/requirements_artefacts", Requirements_artefactsPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/scenarios")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/scenarios", ScenariosPackage.eINSTANCE);
		}

		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/technical_specification_breakdown")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/technical_specification_breakdown", Technical_specification_breakdownPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/test_definition")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/test_definition", Test_definitionPackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/test_input_data")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/test_input_data", Test_input_dataPackage.eINSTANCE);
		}

		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/test_worked_example")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/test_worked_example", Test_worked_examplePackage.eINSTANCE);
		}
		if (!EPackage.Registry.INSTANCE.containsKey("http://www.eclipse.org/test")) {
			EPackage.Registry.INSTANCE.put("http://www.eclipse.org/test", TestPackage.eINSTANCE);
		}
		
		
		super.register(injector)
	}
	
}
