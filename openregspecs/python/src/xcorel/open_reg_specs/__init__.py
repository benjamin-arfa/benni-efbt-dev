
from .open_reg_specs import getEClassifier, eClassifiers
from .open_reg_specs import name, nsURI, nsPrefix, eClass
from .open_reg_specs import BaseElement, FlowElementsContainer, FlowElement, FlowNode, SequenceFlow, Task, Activity, Gateway, ExclusiveGateway, InclusiveGateway, ParallelGateway, ServiceTask, SubProcess, ScriptTask, UserTask, Import, Module, ModuleList, AllowedTypes, RequirementsModule, RequirementsSection, RequirementsSectionImage, RequirementsSectionLinkWithText, RequirementsSectionText, RequirementType, TitledRequirementsSection, Tag, TagGroup, View, LayerSQL, SelectClause, SelectColumn, SelectColumnMemberAs, SelectValueAs, SelectColumnAttributeAs, Comparitor, WhereClause, ViewModule, ActivityTag, Scenario, ScenarioTag, Test, TestModule, DataConstraint, AttrComparison, SelectionLayer, TestScope, UnitTestScope, E2ETestScope, InputFile, WorkflowModule, XAttribute, XClass, XClassifier, XDataType, XEnum, XEnumLiteral, XMember, XModelElement, XNamedElement, XOperation, XPackage, XReference, XStructuralFeature, XTypedElement, VTLEnrichedCube, VTLGeneratedOutputlayer, VTLForOutputLayerAndIntermediateLayerCombination, VTLGeneratedIntermediateLayer, VTLTransformation, VTLScheme, VTLForSelectionLayer, VTLModule, EntityToVTLIntermediateLayerLink, VTLForView, VTLGeneratedOutputlayerModule, VTLForOutputLayerAndIntermediateLayerCombinationModule, VTLGeneratedIntermediateLayerModule, VTLSchemesModule, VTLForSelectionLayerModule, EntityToVTLIntermediateLayerLinkModule, VTLForViewModule


from . import open_reg_specs

__all__ = ['BaseElement', 'FlowElementsContainer', 'FlowElement', 'FlowNode', 'SequenceFlow', 'Task', 'Activity', 'Gateway', 'ExclusiveGateway', 'InclusiveGateway', 'ParallelGateway', 'ServiceTask', 'SubProcess', 'ScriptTask', 'UserTask', 'Import', 'Module', 'ModuleList', 'AllowedTypes', 'RequirementsModule', 'RequirementsSection', 'RequirementsSectionImage', 'RequirementsSectionLinkWithText', 'RequirementsSectionText', 'RequirementType', 'TitledRequirementsSection', 'Tag', 'TagGroup', 'View', 'LayerSQL', 'SelectClause', 'SelectColumn', 'SelectColumnMemberAs', 'SelectValueAs', 'SelectColumnAttributeAs', 'Comparitor', 'WhereClause', 'ViewModule', 'ActivityTag', 'Scenario', 'ScenarioTag', 'Test', 'TestModule', 'DataConstraint', 'AttrComparison', 'SelectionLayer',
           'TestScope', 'UnitTestScope', 'E2ETestScope', 'InputFile', 'WorkflowModule', 'XAttribute', 'XClass', 'XClassifier', 'XDataType', 'XEnum', 'XEnumLiteral', 'XMember', 'XModelElement', 'XNamedElement', 'XOperation', 'XPackage', 'XReference', 'XStructuralFeature', 'XTypedElement', 'VTLEnrichedCube', 'VTLGeneratedOutputlayer', 'VTLForOutputLayerAndIntermediateLayerCombination', 'VTLGeneratedIntermediateLayer', 'VTLTransformation', 'VTLScheme', 'VTLForSelectionLayer', 'VTLModule', 'EntityToVTLIntermediateLayerLink', 'VTLForView', 'VTLGeneratedOutputlayerModule', 'VTLForOutputLayerAndIntermediateLayerCombinationModule', 'VTLGeneratedIntermediateLayerModule', 'VTLSchemesModule', 'VTLForSelectionLayerModule', 'EntityToVTLIntermediateLayerLinkModule', 'VTLForViewModule']

eSubpackages = []
eSuperPackage = None
open_reg_specs.eSubpackages = eSubpackages
open_reg_specs.eSuperPackage = eSuperPackage

FlowElementsContainer.flowElements.eType = FlowElement
ServiceTask.enrichedAttribute.eType = XOperation
ServiceTask.scenarios.eType = Scenario
ServiceTask.secondAttribute.eType = XAttribute
ServiceTask.requiredAttributesForScenarioChoice.eType = XMember
ServiceTask.requiredAttributesForEntityCreation.eType = XMember
ScriptTask.selectionLayers.eType = SelectionLayer
ScriptTask.outputLayer.eType = XClass
UserTask.entity.eType = XClass
Module.dependencies.eType = Module
Module.imports.eType = Import
ModuleList.modules.eType = Module
AllowedTypes.allowedTypes.eType = RequirementType
RequirementsModule.rules.eType = TitledRequirementsSection
RequirementsModule.allowedtypes.eType = AllowedTypes
TitledRequirementsSection.sections.eType = RequirementsSection
TitledRequirementsSection.requirementsType.eType = RequirementType
Tag.requirements.eType = TitledRequirementsSection
TagGroup.tags.eType = Tag
View.outputLayer.eType = XClass
View.selectionLayerSQL.eType = LayerSQL
LayerSQL.selectionLayer.eType = SelectionLayer
LayerSQL.columns.eType = SelectColumn
LayerSQL.whereClause.eType = WhereClause
SelectColumn.asAttribute.eType = XOperation
SelectColumnMemberAs.memberAsConstant.eType = XEnumLiteral
SelectColumnAttributeAs.attribute.eType = XMember
WhereClause.attribute1.eType = XAttribute
WhereClause.member.eType = XEnumLiteral
ViewModule.views.eType = View
ActivityTag.activity.eType = Activity
Scenario.requiredAttributes.eType = XMember
Scenario.data_constraints.eType = DataConstraint
ScenarioTag.scenario.eType = Scenario
Test.inputData.eType = InputFile
Test.expectedResult.eType = InputFile
Test.scope.eType = TestScope
TestModule.tests.eType = Test
DataConstraint.attr1.eType = XAttribute
DataConstraint.member.eType = XEnumLiteral
SelectionLayer.generatedEntity.eType = XClass
UnitTestScope.scenarios.eType = Scenario
E2ETestScope.scenarios.eType = Scenario
E2ETestScope.layer.eType = SelectionLayer
E2ETestScope.scriptTask.eType = ScriptTask
InputFile.entity.eType = XClass
WorkflowModule.taskTags.eType = ActivityTag
WorkflowModule.scenarioTags.eType = ScenarioTag
WorkflowModule.subProcess.eType = SubProcess
XClass.superTypes.eType = XClass
XTypedElement.type.eType = XClassifier
VTLEnrichedCube.transformations.eType = VTLTransformation
VTLGeneratedOutputlayer.dependant_intermediate_layers.eType = VTLGeneratedIntermediateLayer
VTLGeneratedOutputlayer.VTLForOutputLayerAndIntemedateLayerCombinations.eType = VTLForOutputLayerAndIntermediateLayerCombination
VTLGeneratedOutputlayer.outputLayer.eType = XClass
VTLForOutputLayerAndIntermediateLayerCombination.transformations.eType = VTLTransformation
VTLForOutputLayerAndIntermediateLayerCombination.outputLayer.eType = VTLGeneratedOutputlayer
VTLForOutputLayerAndIntermediateLayerCombination.intermediateLayer.eType = VTLGeneratedIntermediateLayer
VTLGeneratedIntermediateLayer.dependant_enriched_cubes.eType = VTLGeneratedIntermediateLayer
VTLGeneratedIntermediateLayer.transformations.eType = VTLTransformation
VTLScheme.expressions.eType = VTLTransformation
VTLForSelectionLayer.selectionLayer.eType = LayerSQL
VTLForSelectionLayer.outputLayer.eType = VTLGeneratedOutputlayer
VTLForSelectionLayer.intermediateLayer.eType = VTLGeneratedIntermediateLayer
VTLModule.VTLSchemes.eType = VTLSchemesModule
VTLModule.VTLGeneratedOutputLayers.eType = VTLGeneratedOutputlayerModule
VTLModule.VTLGeneratedIntermediateLayers.eType = VTLGeneratedIntermediateLayerModule
VTLModule.VTLEnrichedLayers.eType = VTLGeneratedIntermediateLayerModule
VTLModule.VTLForSelectionLayers.eType = VTLForSelectionLayerModule
VTLModule.entityToVTLIntermediateLayerLinks.eType = EntityToVTLIntermediateLayerLinkModule
VTLModule.VTLForViews.eType = VTLForViewModule
EntityToVTLIntermediateLayerLink.VTLIntermediateLayer.eType = VTLGeneratedIntermediateLayer
EntityToVTLIntermediateLayerLink.entity.eType = XClass
VTLForView.view.eType = View
VTLForView.vtl.eType = VTLGeneratedOutputlayer
VTLGeneratedOutputlayerModule.vTLGeneratedOutputlayerModules.eType = VTLGeneratedOutputlayer
VTLForOutputLayerAndIntermediateLayerCombinationModule.vTLForOutputLayerAndIntermediateLayerCombinations.eType = VTLForOutputLayerAndIntermediateLayerCombinationModule
VTLGeneratedIntermediateLayerModule.vTLGeneratedIntermediateLayers.eType = VTLGeneratedIntermediateLayer
VTLSchemesModule.vTLSchemes.eType = VTLScheme
VTLForSelectionLayerModule.vTLForSelectionLayers.eType = VTLForSelectionLayer
EntityToVTLIntermediateLayerLinkModule.entityToVTLIntermediateLayerLinks.eType = EntityToVTLIntermediateLayerLink
VTLForViewModule.vTLForViews.eType = VTLForView
FlowNode.outgoing.eType = SequenceFlow
FlowNode.incoming.eType = SequenceFlow
SequenceFlow.targetRef.eType = FlowNode
SequenceFlow.targetRef.eOpposite = FlowNode.incoming
SequenceFlow.sourceRef.eType = FlowNode
SequenceFlow.sourceRef.eOpposite = FlowNode.outgoing
RequirementsSectionLinkWithText.linkedRuleSection.eType = TitledRequirementsSection
TitledRequirementsSection.referencingSections.eType = RequirementsSectionLinkWithText
TitledRequirementsSection.referencingSections.eOpposite = RequirementsSectionLinkWithText.linkedRuleSection
XClass.members.eType = XMember
XClassifier.package.eType = XPackage
XEnum.literals.eType = XEnumLiteral
XEnumLiteral.enum.eType = XEnum
XEnumLiteral.enum.eOpposite = XEnum.literals
XMember.containingClass.eType = XClass
XMember.containingClass.eOpposite = XClass.members
XPackage.classifiers.eType = XClassifier
XPackage.classifiers.eOpposite = XClassifier.package

otherClassifiers = [Comparitor, AttrComparison]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
