/**Copyright (c) 2020 Bird Software Solutions Ltd
 *  All rights reserved. This file and the accompanying materials are made available under the terms of the Eclipse Public License v2.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v20.html

 * SPDX-License-Identifier: EPL-2.0 

 *  Contributors:
 Neil Mackenzie - initial API and implementation*/
package org.eclipse.efbt.regdna.dsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.efbt.regdna.model.regdna.ELPackage
import org.eclipse.efbt.regdna.model.regdna.ELClass
import org.eclipse.efbt.regdna.model.regdna.ELEnum
import org.eclipse.efbt.regdna.model.regdna.ELAttribute
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.efbt.regdna.model.regdna.ELReference
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EEnum
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import java.nio.file.Path
import java.nio.file.Files
import org.eclipse.efbt.regdna.model.regdna.ELOperation
import org.eclipse.efbt.regdna.model.regdna.ELDataType
import org.eclipse.emf.common.util.BasicEList
import org.eclipse.efbt.regdna.model.regdna.ELPrivateOperation
import org.eclipse.efbt.regdna.model.regdna.ELPublicOperation
import org.eclipse.efbt.regdna.model.regdna.RulesForReport
import org.eclipse.efbt.regdna.model.regdna.SelectColumnAttributeAs
import org.eclipse.efbt.regdna.model.regdna.SelectColumnMemberAs
import org.eclipse.efbt.regdna.model.regdna.SelectValueAs

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class regdnaGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {

		// var packages = new ArrayList<EPackage>()

		for (elpackage : resource.allContents.toIterable.filter(ELPackage)) {

			processPackage(elpackage,fsa)
			createXCoreForPackage(elpackage,fsa,resource)
		}
		for (rulesForReport : resource.allContents.toIterable.filter(RulesForReport)) {

			processRulesForReport(rulesForReport,fsa)
			createOutputTablesAmendment(rulesForReport,fsa)
			
		}
	}
	
	def createOutputTablesAmendment(RulesForReport rulesForReport, IFileSystemAccess2 fsa) {
		fsa.generateFile(rulesForReport.outputLayerCube.name + "_output_layer_amendment.regdna",  '''
		package «rulesForReport.outputLayerCube.name»_output_layer_amendment
		import sdd_domains.*
		import input_tables.*
		import types.* 
		import «rulesForReport.outputLayerCube.name»_Logic.*
		class «rulesForReport.outputLayerCube.name»_UnionItem {
			refers «rulesForReport.outputLayerCube.name»_UnionItem  unionOfLayers 
		«FOR eloperation : rulesForReport.outputLayerCube.EOperations»
		
		«IF eloperation instanceof ELOperation» 	op «eloperation.EType.name» «IF eloperation.upperBound == -1»[]  «ELSEIF !((eloperation.lowerBound == 0) && ( (eloperation.upperBound == 1) || (eloperation.upperBound == 0)) ) »[«eloperation.lowerBound»..«eloperation.upperBound»]«ENDIF» «eloperation.name»«IF eloperation instanceof ELPublicOperation»()«ENDIF»«IF eloperation instanceof ELPrivateOperation»«IF eloperation.EParameters.size() == 0 »()«ENDIF»«FOR eparam : eloperation.EParameters BEFORE '(' SEPARATOR ',' AFTER ')'»«eparam.EType.name» «eparam.name»«ENDFOR»«ENDIF»
			{
				"<xcore>unionOfLayers.«eloperation.name»()</xcore>"
			}
		
		«ENDIF»«ENDFOR» 
		}
		class «rulesForReport.outputLayerCube.name»_Table {
						refers  «rulesForReport.outputLayerCube.name»_UnionTable  unionOfLayersTable
						contains  «rulesForReport.outputLayerCube.name» [0..-1] «rulesForReport.outputLayerCube.name»s 
						op  «rulesForReport.outputLayerCube.name» [0..-1] calc_«rulesForReport.outputLayerCube.name»s() {
							"<xcore>var items = new org.eclipse.emf.common.util.BasicEList<«rulesForReport.outputLayerCube.name»>()
						for( «rulesForReport.outputLayerCube.name»_UnionItem item : unionOfLayersTable.«rulesForReport.outputLayerCube.name»_UnionItems)
						{
							var newItem = Output_tablesFactory.eINSTANCE.create«rulesForReport.outputLayerCube.name»
							newItem.unionOfLayers =  item
							items.add(newItem)
		}
						return items</xcore>"
							} 
						op String  init() {
							"<xcore>regdnautils.Orchestration.init(this)
						 this.«rulesForReport.outputLayerCube.name»s.addAll(calc_«rulesForReport.outputLayerCube.name»s()) 
		 				return null</xcore>"
							}
					} 

		''')
	}
	
	def processRulesForReport(RulesForReport rulesForReport, IFileSystemAccess2 fsa) {
		fsa.generateFile(rulesForReport.outputLayerCube.name + "_Logic.regdna",  '''
		package «rulesForReport.outputLayerCube.name»_Logic
		import sdd_domains.*
		import input_tables.*
		import types.* 
		class «rulesForReport.outputLayerCube.name»_UnionItem {
			refers «rulesForReport.outputLayerCube.name»_Base base 
		«FOR eloperation : rulesForReport.outputLayerCube.EOperations»
		
		«IF eloperation instanceof ELOperation» 	op «eloperation.EType.name» «IF eloperation.upperBound == -1»[]  «ELSEIF !((eloperation.lowerBound == 0) && ( (eloperation.upperBound == 1) || (eloperation.upperBound == 0)) ) »[«eloperation.lowerBound»..«eloperation.upperBound»]«ENDIF» «eloperation.name»«IF eloperation instanceof ELPublicOperation»()«ENDIF»«IF eloperation instanceof ELPrivateOperation»«IF eloperation.EParameters.size() == 0 »()«ENDIF»«FOR eparam : eloperation.EParameters BEFORE '(' SEPARATOR ',' AFTER ')'»«eparam.EType.name» «eparam.name»«ENDFOR»«ENDIF»
			{
				"<xcore>base.«eloperation.name»()</xcore>"
			}
		
		«ENDIF»«ENDFOR» 
		}
		class «rulesForReport.outputLayerCube.name»_Base {
			
		«FOR eloperation : rulesForReport.outputLayerCube.EOperations»
				
		«IF eloperation instanceof ELOperation» 	op «eloperation.EType.name» «IF eloperation.upperBound == -1»[]  «ELSEIF !((eloperation.lowerBound == 0) && ( (eloperation.upperBound == 1) || (eloperation.upperBound == 0)) ) »[«eloperation.lowerBound»..«eloperation.upperBound»]«ENDIF» «eloperation.name»«IF eloperation instanceof ELPublicOperation»()«ENDIF»«IF eloperation instanceof ELPrivateOperation»«IF eloperation.EParameters.size() == 0 »()«ENDIF»«FOR eparam : eloperation.EParameters BEFORE '(' SEPARATOR ',' AFTER ')'»«eparam.EType.name» «eparam.name»«ENDFOR»«ENDIF»
			{
			«IF eloperation.EType.name == "double" »"<xcore>return 0</xcore>"
			«ELSEIF eloperation.EType.name == "int" »"<xcore>return 0</xcore>"
			«ELSEIF eloperation.EType.name == "boolean" »"<xcore>return true</xcore>"
			«ENDIF»
			}
		
		«ENDIF»«ENDFOR» 
		}
		
		class «rulesForReport.outputLayerCube.name»_UnionTable {
					 	contains  «rulesForReport.outputLayerCube.name»_UnionItem [0..-1]   «rulesForReport.outputLayerCube.name»_UnionItems	
					 	«FOR tableRules : rulesForReport.rulesForTable»
					 	«FOR tablePartRules : tableRules.rulesForTablePart»
					 	refers «tablePartRules.name»_Table  «tablePartRules.name»_table
					 	«ENDFOR»
					 	«ENDFOR»
					 	op «rulesForReport.outputLayerCube.name»_UnionItem [0..-1]   calc_«rulesForReport.outputLayerCube.name»_UnionItems() 
						{
						 	"<xcore>var items = new org.eclipse.emf.common.util.BasicEList<«rulesForReport.outputLayerCube.name»_UnionItem>()
						 	«FOR tableRules : rulesForReport.rulesForTable»
						 	«FOR tablePartRules : tableRules.rulesForTablePart»
		 		 		 	for(«tablePartRules.name» item : «tablePartRules.name»_table.«tablePartRules.name»s)
		 		 		 	{
		 		 		 		var newItem = «rulesForReport.outputLayerCube.name»_LogicFactory.eINSTANCE.create«rulesForReport.outputLayerCube.name»_UnionItem
		 		 		 		newItem.base = item
		 		 		 		items.add(newItem)
		 		 		 	}
						 	«ENDFOR»
						 	«ENDFOR»									
						 	return items</xcore>"
						}
					 	op String  init() 
						{
						 	"<xcore>regdnautils.Orchestration.init(this) 
			 	 			this.«rulesForReport.outputLayerCube.name»_UnionItems.addAll(calc_«rulesForReport.outputLayerCube.name»_UnionItems)
			 	 			  return null</xcore>"
						}
		
					}
		
		«FOR tableRules : rulesForReport.rulesForTable»
		«FOR tablePartRules : tableRules.rulesForTablePart»
		class «tablePartRules.name»  extends «rulesForReport.outputLayerCube.name»_Base {
		«FOR column : tablePartRules.columns»
		«IF (column instanceof SelectColumnAttributeAs)»
		  refers «(column.attribute.eContainer as ELClass).name» «(column.attribute.eContainer as ELClass).name.giveSmallFirstLetter»
		«ENDIF»	
		«ENDFOR»
		«FOR column : tablePartRules.columns»				
	 	op «column.asAttribute.EType.name»  «column.asAttribute.name»() 
		{
			«IF (column instanceof SelectColumnMemberAs)»
			"<xcore>sdd_domains.«column.asAttribute.EType.name».«column.memberAsConstant.name.toUpperCase»</xcore>"
			«ELSEIF (column instanceof SelectValueAs)»
			"<xcore>«column.value»</xcore>"
			«ELSEIF (column instanceof SelectColumnAttributeAs)»
			"<xcore>«(column.attribute.eContainer as ELClass).name.giveSmallFirstLetter».«column.attribute.name»</xcore>"
			«ENDIF»	
		}
		«ENDFOR»
		}
		
		class «tablePartRules.name»_Table {
						«FOR column : tablePartRules.columns»
						«IF (column instanceof SelectColumnAttributeAs)»
						refers «(column.attribute.eContainer as ELClass).name»_Table «(column.attribute.eContainer as ELClass).name.giveSmallFirstLetter»_Table
						// remove any duplicates in these refers statements
						«ENDIF»	
						«ENDFOR»
					 	contains  «tablePartRules.name» [0..-1]   «tablePartRules.name»s	
					 	op «tablePartRules.name» [0..-1]   calc_«tablePartRules.name»s() 
						{
						 	"<xcore>var items = new org.eclipse.emf.common.util.BasicEList<«tablePartRules.name»>()
				 		 	//Join up any refered tables that you need to join
				 		 	//loop through the main table
				 		 	//create an item using var newItem = «rulesForReport.outputLayerCube.name»_LogicFactory.eINSTANCE.create«tablePartRules.name»
				 		 	//set any references you want to on the new Item so that it can refer to themin operations
				 		 	return items</xcore>"
						}
					 	op String  init() 
						{
						 	"<xcore>regdnautils.Orchestration.init(this)
				 		 	this.«tablePartRules.name»s.addAll(calc_«tablePartRules.name»s) 		 
				 		 	return null</xcore>"
						}
					}
		«ENDFOR»
		«ENDFOR»

		        ''')
	}
	
	def giveSmallFirstLetter(String string) {
		var firstLetter = string.substring(0,1)
		var smallFirstLetter = firstLetter.toLowerCase()
		return smallFirstLetter + string.substring(1,string.length)
		
	}
	
	def createXCoreForPackage(ELPackage elpackage, IFileSystemAccess2 fsa,Resource resource) {
		fsa.generateFile(elpackage.name + '.xcore',  '''
		
		package «elpackage.name»
		«IF elpackage.name.trim != "types"»
		«FOR theImport : elpackage.imports»
		
		«IF theImport.importedNamespace.trim != "types.*"»
		import «theImport.importedNamespace» 
		«ENDIF»
		«ENDFOR»
		«FOR elclass : elpackage.EClassifiers.filter(ELClass)»
		«IF elclass.EAbstract»abstract «ENDIF»class «elclass.name» «IF elclass.ESuperTypes.length == 1» extends «elclass.ESuperTypes.get(0).name» «ENDIF»{
		«FOR elmember : elclass.EStructuralFeatures»  
		«IF elmember instanceof ELAttribute» 	«IF elmember.ID»id «ENDIF»«elmember.EAttributeType.name» «IF elmember.upperBound == -1»[]  «ELSEIF !((elmember.lowerBound == 0) && ( (elmember.upperBound == 1) || (elmember.upperBound == 0)) ) »[«elmember.lowerBound»..«elmember.upperBound»]«ENDIF» «elmember.name» «ENDIF»
		«IF elmember instanceof ELReference» 	«IF elmember.containment»contains «ELSE»refers«ENDIF» «elmember.EType.name» «IF elmember.upperBound == -1»[]  «ELSEIF !((elmember.lowerBound == 0) && ( (elmember.upperBound == 1) || (elmember.upperBound == 0)) ) »[«elmember.lowerBound»..«elmember.upperBound»]«ENDIF» «elmember.name»«ENDIF»	
		«ENDFOR»
		«FOR eloperation : elclass.EOperations»
		«IF eloperation instanceof ELOperation» 	op «eloperation.EType.name» «IF eloperation.upperBound == -1»[]  «ELSEIF !((eloperation.lowerBound == 0) && ( (eloperation.upperBound == 1) || (eloperation.upperBound == 0)) ) »[«eloperation.lowerBound»..«eloperation.upperBound»]«ENDIF» «eloperation.name»«IF eloperation instanceof ELPublicOperation»()«ENDIF»«IF eloperation instanceof ELPrivateOperation»«IF eloperation.EParameters.size() == 0 »()«ENDIF»«FOR eparam : eloperation.EParameters BEFORE '(' SEPARATOR ',' AFTER ')'»«eparam.EType.name» «eparam.name»«ENDFOR»«ENDIF»
			{
		«IF eloperation.body !== null »          «findXCoreSubstring(eloperation.body)»
		«ELSEIF eloperation.EType.name == "double" »        return 0
		«ELSEIF eloperation.EType.name == "int" »        return 0
		«ELSEIF eloperation.EType.name == "boolean" »        return true
			«ENDIF»
			}
			«ENDIF»«ENDFOR» 
		}
		«ENDFOR»
		«FOR elEnum : elpackage.EClassifiers.filter(ELEnum)»
		enum «elEnum.name» {«FOR elliteral : elEnum.ELiterals»  «elliteral.name»  as "«elliteral.literal»"  = «elliteral.value» «ENDFOR»}
		«ENDFOR»
		«FOR xDataType : resource.allContents.filter(ELDataType).toIterable»
		«IF !(xDataType instanceof ELEnum)»
		type  «xDataType.name» wraps «IF xDataType.name == "Date"»java.util.Date «ELSE»«xDataType.name» «ENDIF» 
		«ENDIF»	
		
		«ENDFOR»
		«ENDIF»
		        ''')
		         }
	

	def EPackage processPackage(ELPackage elpackage,IFileSystemAccess2 fsa ) {

		var dependantELPackages = new BasicEList<ELPackage>()
		var dependantEcorePackages = new BasicEList<EPackage>()
		var processedELPackages =  new BasicEList<ELPackage>()
		var ecore_package = EcoreFactory.eINSTANCE.createEPackage()
		// packages.add(ecore_package)
		ecore_package.name = elpackage.name
		ecore_package.nsURI = "http://www.eclipse.org/efbt/" + elpackage.nsURI
		ecore_package.nsPrefix = elpackage.name
		for (classifier : elpackage.EClassifiers) {
			if (classifier instanceof ELEnum) {
				
				var e_enum = EcoreFactory.eINSTANCE.createEEnum()
				
				e_enum.name = classifier.name
				for (literal : classifier.ELiterals) {
					var e_enum_literal = EcoreFactory.eINSTANCE.createEEnumLiteral()
					e_enum_literal.name = literal.name
					e_enum_literal.value = literal.value
					e_enum_literal.literal = literal.literal
					e_enum.ELiterals.add(e_enum_literal)					
				}
				ecore_package.EClassifiers.add(e_enum)
			}
			if (classifier instanceof ELClass) {
				var e_class = EcoreFactory.eINSTANCE.createEClass()
				e_class.name = classifier.name
				e_class.abstract = classifier.EAbstract
				if (classifier.ESuperTypes.size > 0) {
					var superTypesPackage = classifier.ESuperTypes.get(0).EPackage
					
					if ((processedELPackages.indexOf(superTypesPackage) == -1) && (superTypesPackage !== null) && (superTypesPackage.name != "types") && (superTypesPackage != elpackage)) {
						processedELPackages.add(superTypesPackage)
						dependantEcorePackages.add(processPackage(superTypesPackage,fsa))
					}
					var superTypeName = classifier.ESuperTypes.get(0).name
					// var superTypePackageName = classifier.ESuperTypes.get(0).package.name
					var annotation = EcoreFactory.eINSTANCE.createEAnnotation()
					annotation.source = "temp"
					annotation.details.put("superTypeName", superTypeName)
					// annotation.details.put("superTypePackageName", superTypePackageName)
					e_class.EAnnotations.add(annotation)
				}

				for (structural_feature : classifier.EStructuralFeatures) {
					if (structural_feature instanceof ELAttribute) {
						var e_attribute = EcoreFactory.eINSTANCE.createEAttribute
						e_class.EStructuralFeatures.add(e_attribute)
						e_attribute.name = structural_feature.name
						if(structural_feature.upperBound != 0 )
							e_attribute.upperBound = structural_feature.upperBound
						else
							e_attribute.upperBound = 1
						e_attribute.lowerBound = structural_feature.lowerBound
						var type_name = structural_feature.EAttributeType.name
						if (structural_feature.ID) 
							e_attribute.ID = true
							
							if (structural_feature.EAttributeType instanceof ELEnum) {
								var attribute_type_name = structural_feature.EAttributeType.name
								var enumsPackage = structural_feature.EAttributeType.EPackage
								
								
								//if ((dependantELPackage === null) && (enumsPackage !== null) && (enumsPackage.name != "types")) {
								if ((processedELPackages.indexOf(enumsPackage) == -1) && (enumsPackage !== null) && (enumsPackage.name != "types") && (enumsPackage != elpackage) ) {
									processedELPackages.add(enumsPackage)
									dependantEcorePackages.add(processPackage(enumsPackage,fsa))
								}

								// need somewhere to ensure that the dependent EPAckage is availabler
								// maybe we record the dependant package name.
								// if (!packages.contains(enumsPackage)){
								// packages.add(enumsPackage)
								// }										
								// var enumsPackageName = structural_feature.EAttributeType.package.name
								var annotation = EcoreFactory.eINSTANCE.createEAnnotation()
								annotation.source = "temp"
								annotation.details.put("attribute_type_name", attribute_type_name)
								// annotation.details.put("enumsPackageName", enumsPackageName)
								e_attribute.EAnnotations.add(annotation)
							} else if (type_name == 'double') {
								e_attribute.EType = EcorePackage.Literals.EDOUBLE
							} else if (type_name == 'String') {
								e_attribute.EType = EcorePackage.Literals.ESTRING
							} else if (type_name == 'String') {
								e_attribute.EType = EcorePackage.Literals.ESTRING
							} else if (type_name == 'int') {
								e_attribute.EType = EcorePackage.Literals.EINT
							} else if (type_name == 'Date') {
								e_attribute.EType = EcorePackage.Literals.EDATE
							} else if (type_name == 'boolean') {
								e_attribute.EType = EcorePackage.Literals.EBOOLEAN
							}
						}
				

					if (structural_feature instanceof ELReference) {
						var e_reference = EcoreFactory.eINSTANCE.createEReference()
						e_reference.name = structural_feature.name
						if(structural_feature.upperBound != 0 )
							e_reference.upperBound = structural_feature.upperBound
						else
							e_reference.upperBound = 1
						
						e_reference.lowerBound = structural_feature.lowerBound
						e_reference.containment = structural_feature.containment
						e_class.EStructuralFeatures.add(e_reference)
						var type_name = structural_feature.EType.name
						// var packageName = structural_feature.EType.package.name
						var referenceTypePackage = structural_feature.EType.EPackage
						if ((processedELPackages.indexOf(referenceTypePackage) == -1) && (referenceTypePackage !== null) && (referenceTypePackage.name != "types") && (referenceTypePackage != elpackage)) {
									processedELPackages.add(referenceTypePackage)
									dependantEcorePackages.add(processPackage(referenceTypePackage,fsa))
								}
						var annotation = EcoreFactory.eINSTANCE.createEAnnotation()
						annotation.source = "temp"
						annotation.details.put("type", type_name)
						// annotation.details.put("types_package", packageName)
						e_reference.EAnnotations.add(annotation)
					}
				}
				for (operation : classifier.EOperations) {
					var e_operation = EcoreFactory.eINSTANCE.createEOperation()
					e_operation.name = operation.name
					if(operation.upperBound != 0 )
							e_operation.upperBound = operation.upperBound
						else
							e_operation.upperBound = 1
					e_class.EOperations.add(e_operation)
					
					var type_name = operation.EType.name
					// var types_package = operation.EType.package.name
					var annotation = EcoreFactory.eINSTANCE.createEAnnotation()
					annotation.source = "temp"
					annotation.details.put("type_name", type_name)
					// annotation.details.put("types_package", types_package)
					var types_package = operation.EType.EPackage
						
					if ((processedELPackages.indexOf(types_package) == -1) && (types_package !== null) && (types_package.name != "types") && (types_package != elpackage)) {
									processedELPackages.add(types_package)
									dependantEcorePackages.add(processPackage(types_package,fsa))
								}
								
					e_operation.EAnnotations.add(annotation)
					
					if (operation instanceof ELPrivateOperation)
					{
						for (param : operation.EParameters ) {
							var e_param = EcoreFactory.eINSTANCE.createEParameter()
							e_param.name = param.name
							e_operation.EParameters.add(e_param)
							var param_type_name = param.EType.name
							// var types_package = operation.EType.package.name
							var param_annotation = EcoreFactory.eINSTANCE.createEAnnotation()
							param_annotation.source = "temp"
							param_annotation.details.put("type_name", param_type_name)
							var param_types_package = param.EType.EPackage
	
							if ((processedELPackages.indexOf(param_types_package) == -1) && (param_types_package !== null) && (param_types_package.name != "types") && (param_types_package != elpackage)) {
										processedELPackages.add(param_types_package)
										dependantEcorePackages.add(processPackage(param_types_package,fsa))
									}
							e_param.EAnnotations.add(param_annotation)
							
						}
					
					}

					
				}
				ecore_package.EClassifiers.add(e_class)
			}
		}

		// set the types for refernces, supercalss, and operations, and also set the enum types
		for (classifier : ecore_package.EClassifiers) {
			if (classifier instanceof EClass) {
				if (classifier.EAnnotations.size > 0) {
					var firstAnnotation = classifier.EAnnotations.get(0)
					var details = firstAnnotation.details
					var superTypeName = details.get("superTypeName")
					// var superTypePackageName = details.get("superTypePackageName")
					// classifier.ESuperTypes.add(findClass(packages, superTypeName, superTypePackageName))
					classifier.ESuperTypes.add(findClass(ecore_package, dependantEcorePackages, superTypeName))
					classifier.EAnnotations.remove(0)
				}

				for (structural_feature : classifier.EStructuralFeatures) {
					if (structural_feature instanceof EAttribute) {
						if (structural_feature.EAnnotations.size > 0) {
							var firstAttributeAnnotation = structural_feature.EAnnotations.get(0)
							var attributeDetails = firstAttributeAnnotation.details
							var attribute_type_name = attributeDetails.get("attribute_type_name")
							// var enumsPackageName = attributeDetails.get("enumsPackageName")
							// structural_feature.EType = findEnum(packages, attribute_type_name, enumsPackageName)
							var e_type = findEnum(ecore_package, dependantEcorePackages,
								attribute_type_name)
							structural_feature.EType = e_type
							structural_feature.EAnnotations.remove(0)
						}

					}
					if (structural_feature instanceof EReference) {
						if (structural_feature.EAnnotations.size > 0) {
							var firstAttributeAnnotation = structural_feature.EAnnotations.get(0)
							var attributeDetails = firstAttributeAnnotation.details
							var reference_type_name = attributeDetails.get("type")
							// var typesPackageName = attributeDetails.get("types_package")
							// structural_feature.EType = findClass(packages, reference_type_name, typesPackageName)
							structural_feature.EType = findClass(ecore_package, dependantEcorePackages,
								reference_type_name)
							structural_feature.EAnnotations.remove(0)
						}

					}
				}
				for (operation : classifier.EOperations) {
					var firstOperationAnnotation = operation.EAnnotations.get(0)
					var attributeDetails = firstOperationAnnotation.details
					var operationTypeName = attributeDetails.get("type_name")
					// var operationTypePackageName = attributeDetails.get("types_package")
					var operationTypesClass = findClass(ecore_package, dependantEcorePackages, operationTypeName)
					if (operationTypesClass !== null) {
						operation.EType = operationTypesClass
					} else if (operationTypeName == 'double') {
						operation.EType = EcorePackage.Literals.EDOUBLE
					} else if (operationTypeName == 'String') {
						operation.EType = EcorePackage.Literals.ESTRING
					} else if (operationTypeName == 'String') {
						operation.EType = EcorePackage.Literals.ESTRING
					} else if (operationTypeName == 'int') {
						operation.EType = EcorePackage.Literals.EINT
					} else if (operationTypeName == 'Date') {
						operation.EType = EcorePackage.Literals.EDATE
					} else if (operationTypeName == 'boolean') {
						operation.EType = EcorePackage.Literals.EBOOLEAN
					} else {
						var eEnum = findEnum(ecore_package, dependantEcorePackages, operationTypeName)
						operation.EType = eEnum
					}
					operation.EAnnotations.remove(0)
					for (param : operation.EParameters) {
						var firstParamAnnotation = param.EAnnotations.get(0)
						var paramAttributeDetails = firstParamAnnotation.details
						var paramTypeName = paramAttributeDetails.get("type_name")
						// var operationTypePackageName = attributeDetails.get("types_package")
						var paramTypesClass = findClass(ecore_package, dependantEcorePackages, paramTypeName)
						if (paramTypesClass !== null) {
							param.EType = paramTypesClass
						} else if (paramTypeName == 'double') {
							param.EType = EcorePackage.Literals.EDOUBLE
						} else if (paramTypeName == 'String') {
							param.EType = EcorePackage.Literals.ESTRING
						} else if (paramTypeName == 'String') {
							param.EType = EcorePackage.Literals.ESTRING
						} else if (paramTypeName == 'int') {
							param.EType = EcorePackage.Literals.EINT
						} else if (paramTypeName == 'Date') {
							param.EType = EcorePackage.Literals.EDATE
						} else if (paramTypeName == 'boolean') {
							param.EType = EcorePackage.Literals.EBOOLEAN
						} else {
							var eEnum = findEnum(ecore_package, dependantEcorePackages, paramTypeName)
							param.EType = eEnum
							
						param.EAnnotations.remove(0)
					}
					}
					
				}

			}
		}

		var resourceSet = new ResourceSetImpl()
		if (dependantEcorePackages !== null)
		{
			for(dependantEcorePackage: dependantEcorePackages)
			{
				var dependentEcoreResource = resourceSet.createResource(URI.createFileURI(dependantEcorePackage.name + ".ecore"));
				// add the root object to the resource
				dependentEcoreResource.getContents().add(dependantEcorePackage);
				// serialize resource – you can specify also serialization
				// options which defined on org.eclipse.emf.ecore.xmi.XMIResource
				dependentEcoreResource.save(null);
			}
		}
		var ecoreResource = resourceSet.createResource(URI.createFileURI(ecore_package.name + ".ecore"));
		// add the root object to the resource
		ecoreResource.getContents().add(ecore_package);
		// serialize resource – you can specify also serialization
		// options which defined on org.eclipse.emf.ecore.xmi.XMIResource
		ecoreResource.save(null);
		//var file = new File(ecore_package.name + ".ecore");
   		var filePath = Path.of(ecore_package.name + ".ecore")

		var content = Files.readString(filePath);
        
		fsa.generateFile(ecore_package.name + ".ecore",content)
		return ecore_package
	}

	def String findXCoreSubstring(String string) {
		var startIndex = string.indexOf("<xcore>")
		var endIndex = string.indexOf("</xcore>")
		var returnString = string
		if ( ( endIndex>0) && ( startIndex>-1))
			returnString = string.substring(startIndex+7,endIndex)
		return returnString
	}	

	def findEnum(EPackage thePackage, BasicEList<EPackage> dependantPackages,  String enumName) {
		var returnEnum = null as EEnum


		for (classifier : thePackage.EClassifiers)
		{
			if (classifier instanceof EEnum) 
			{
				if (classifier.name == enumName)
					returnEnum = classifier
			}
		}
		if (returnEnum === null)
		{
			for (dependantPackage : dependantPackages){
				if (dependantPackage !== null){
					for (classifier : dependantPackage.EClassifiers)
					{
						if (classifier instanceof EEnum) 
						{
							if (classifier.name == enumName)
								returnEnum = classifier
						}
					}
				}
			}
		}
		if (returnEnum !== null)
		{
			//System.out.println("returnEnum name = " + returnEnum.name)
		}
		
		return returnEnum
	}

	def findClass(EPackage thePackage, BasicEList<EPackage> dependantPackages, String className) {
		
		var returnClass = null as EClass

		for (classifier : thePackage.EClassifiers)
		{
			if (classifier instanceof EClass) {
				if (classifier.name == className)
					returnClass = classifier
			}

		}
		
		if (returnClass === null)
		{
			for (dependantPackage : dependantPackages){
				if (dependantPackage !== null){
				
			
					for (classifier : dependantPackage.EClassifiers)
					{
						if (classifier instanceof EClass) {
							if (classifier.name == className)
								returnClass = classifier
						}
		
					}
				}
				
			}
			
		}
		
		return returnClass
	}
}