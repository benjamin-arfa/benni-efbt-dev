/*
 * generated by Xtext 2.27.0
 */
package org.eclipse.efbt.openregspecs.dsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.efbt.openregspecs.model.open_reg_specs.XClass
import org.eclipse.efbt.openregspecs.model.open_reg_specs.XPackage
import org.eclipse.efbt.openregspecs.model.open_reg_specs.XAttribute
import org.eclipse.efbt.openregspecs.model.open_reg_specs.XReference
import org.eclipse.efbt.openregspecs.model.open_reg_specs.XEnum
import org.eclipse.efbt.openregspecs.model.open_reg_specs.XDataType
import org.eclipse.efbt.openregspecs.model.open_reg_specs.XOperation
import org.eclipse.efbt.openregspecs.model.open_reg_specs.UserTask
import org.eclipse.efbt.openregspecs.model.open_reg_specs.ServiceTask
import org.eclipse.efbt.openregspecs.model.open_reg_specs.Module

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class OpenRegSpecsGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		fsa.generateFile('datamodel.xcore',  '''
«FOR xpackage : resource.allContents.filter(XPackage).toIterable»
package «xpackage.name»
«ENDFOR»
«FOR xclass : resource.allContents.filter(XClass).toIterable»
«IF xclass.abstract»abstract «ENDIF»class «xclass.name» «IF xclass.superTypes.length == 1» extends «xclass.superTypes.get(0).name» «ENDIF»{
«FOR xmember : xclass.members»  
«IF xmember instanceof XAttribute» 	«IF xmember.ID»id «ENDIF»«xmember.type.name» «IF xmember.upperBound == -1»[]  «ELSEIF !((xmember.lowerBound == 0) && (xmember.upperBound == 1)) »[«xmember.lowerBound»..«xmember.upperBound»]«ENDIF» «xmember.name» «ENDIF»
«IF xmember instanceof XReference» 	«IF xmember.containment»contains «ELSE»refers«ENDIF» «xmember.type.name» «IF xmember.upperBound == -1»[]  «ELSEIF !((xmember.lowerBound == 0) && (xmember.upperBound == 1)) »[«xmember.lowerBound»..«xmember.upperBound»]«ENDIF» «xmember.name»«ENDIF»	
«IF xmember instanceof XOperation» 	op «xmember.type.name» «IF xmember.upperBound == -1»[]  «ELSEIF !((xmember.lowerBound == 0) && (xmember.upperBound == 1)) »[«xmember.lowerBound»..«xmember.upperBound»]«ENDIF» «xmember.name»() 
	{
	 	«IF xmember.body !== null»«xmember.body»«ENDIF»
	}
	«ENDIF»«ENDFOR» 
}
«ENDFOR»
«FOR xEnum : resource.allContents.filter(XEnum).toIterable»
enum «xEnum.name» {«FOR xliteral : xEnum.literals»  «xliteral.name»  as "«xliteral.literal»"  = «xliteral.value» «ENDFOR»}
«ENDFOR»
«FOR xDataType : resource.allContents.filter(XDataType).toIterable»
«IF !(xDataType instanceof XEnum)»
type  «xDataType.name» wraps «xDataType.name» 
«ENDIF»	
«ENDFOR»
        ''')
        
       fsa.generateFile('JavaRunner.java',  '''
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.efbt.openregspecs.model.open_reg_specs.UserTask;

«var packageName = ""»
«var capatilisedPackageNme = ""»
«FOR dependency : (resource.contents.get(0) as Module).dependencies»
«IF dependency instanceof XPackage »
import «packageName = dependency.name».«capatilisedPackageNme =  packageName.substring(0, 1).toUpperCase() + packageName.substring(1)»Package;
import «packageName».*;
«ENDIF»	
«ENDFOR»

public class JavaRunner {
	
	 public static void main(String[] args)
	 {
		 //run those specific steps, ans save as xmi
		 //load in the xmi files
		 
		 EPackage.Registry.INSTANCE.put(«packageName».«capatilisedPackageNme»Package.eNS_URI, «packageName».«capatilisedPackageNme»Package.eINSTANCE);
		 
		 
		 
		 Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		    Map<String, Object> m = reg.getExtensionToFactoryMap();
		    m.put("xmi", new XMIResourceFactoryImpl());

		    ResourceSet resSet = new ResourceSetImpl();
«var counter = 0» 
«FOR userTask : resource.allContents.filter(UserTask).toIterable»
Resource resource«counter++»  = resSet.getResource(URI.createURI("«userTask.entity.name»_BaseTable.xmi"), true);
«ENDFOR»
try {
«var counter2 = 0» 	
«FOR userTask2 : resource.allContents.filter(UserTask).toIterable»
resource«counter2++».load(Collections.EMPTY_MAP);
«ENDFOR»
}
catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    EcoreUtil.resolveAll(resSet);
«var counter3 = 0» 	
«FOR userTask3 : resource.allContents.filter(UserTask).toIterable»

«userTask3.entity.name»_BaseTable «userTask3.entity.name»_BaseTable1 = («userTask3.entity.name»_BaseTable) resource«counter3++».getContents().get(0);
«ENDFOR»
«var counter4 = 0»	
«FOR serviceTask : resource.allContents.filter(ServiceTask).toIterable»	 

«var tableName = serviceTask.enrichedAttribute.containingClass.name»
«var derived = tableName.endsWith("derived")»
«IF derived »
«IF serviceTask.enrichedAttribute.ID »
«tableName»_DerivedTable «tableName»_DerivedTable1 = «capatilisedPackageNme»Factory.eINSTANCE.create«tableName»_DerivedTable();
«var sourceTable1Name = ""»	
«FOR member : (serviceTask.enrichedAttribute.eContainer as XClass).members»
«IF ((member instanceof XReference) && (sourceTable1Name == ""))» «tableName»_DerivedTable1.setSourceTable1(«sourceTable1Name = member.type.name»«IF member.type.name.endsWith("derived")»_DerivedTable1«ELSE»_BaseTable1«ENDIF»);
«ELSEIF ((member instanceof XReference) && !(sourceTable1Name == "")) » «tableName»_DerivedTable1.setSourceTable2(«member.type.name»«IF member.type.name.endsWith("derived")»_DerivedTable1«ELSE»_BaseTable1«ENDIF»);
EList<«tableName»> details«counter4» 	 = «tableName»_DerivedTable1.«tableName»s();
«tableName»_DerivedTable1.get«tableName»s().addAll(details«counter4»);
for («tableName» «tableName»1 : details«counter4++») {«ENDIF»
«ENDFOR»
«ENDIF»			 
«IF (serviceTask.enrichedAttribute instanceof XAttribute) » «tableName»1.set«serviceTask.enrichedAttribute.name»(«tableName»1.«serviceTask.enrichedAttribute.name»_default());«ENDIF»

«ENDIF»
«ENDFOR»
}
// save netted_delta_sensitivities_per_risk_factor_and_tenor_derived_DerivedTable
		    final ResourceSet resourceSet2 = new ResourceSetImpl();
«FOR serviceTask : resource.allContents.filter(ServiceTask).toIterable»	 
«IF serviceTask.enrichedAttribute.ID »
«var tableName = serviceTask.enrichedAttribute.containingClass.name»
«var derived = tableName.endsWith("derived")»
«IF derived »
	        
	        Resource «tableName»Resource = resourceSet2.createResource(URI.createFileURI("«tableName»_DerivedTable1.xmi"));
	        «tableName»Resource.getContents().add(«tableName»_DerivedTable1);
	        try {
				«tableName»Resource.save(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   
«ENDIF»
«ENDIF»
«ENDFOR»
    }
   }     ''')
	}
}
 
	
 