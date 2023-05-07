
from .ecore4reg import getEClassifier, eClassifiers
from .ecore4reg import name, nsURI, nsPrefix, eClass
from .ecore4reg import Import, Module, ModuleList, AllowedTypes, RequirementsModule, RequirementsSection, RequirementsSectionImage, RequirementsSectionLinkWithText, RequirementsSectionText, RequirementType, TitledRequirementsSection, Tag, TagGroup, View, LayerSQL, SelectClause, SelectColumn, SelectColumnMemberAs, SelectValueAs, SelectColumnAttributeAs, Comparitor, WhereClause, ViewModule, SelectionLayer, ELAttribute, ELClass, ELClassifier, ELDataType, ELEnum, ELEnumLiteral, ELModelElement, ELNamedElement, ELOperation, ELPackage, ELReference, ELStructuralFeature, ELTypedElement, ELAnnotation, ELStringToStringMapEntry, VTLEnrichedCube, VTLGeneratedOutputlayer, VTLForOutputLayerAndIntermediateLayerCombination, VTLGeneratedIntermediateLayer, VTLTransformation, VTLScheme, VTLForSelectionLayer, VTLModule, EntityToVTLIntermediateLayerLink, VTLForView, VTLGeneratedOutputlayerModule, VTLForOutputLayerAndIntermediateLayerCombinationModule, VTLGeneratedIntermediateLayerModule, VTLSchemesModule, VTLForSelectionLayerModule, EntityToVTLIntermediateLayerLinkModule, VTLForViewModule


from . import ecore4reg

__all__ = ['Import', 'Module', 'ModuleList', 'AllowedTypes', 'RequirementsModule', 'RequirementsSection', 'RequirementsSectionImage', 'RequirementsSectionLinkWithText', 'RequirementsSectionText', 'RequirementType', 'TitledRequirementsSection', 'Tag', 'TagGroup', 'View', 'LayerSQL', 'SelectClause', 'SelectColumn', 'SelectColumnMemberAs', 'SelectValueAs', 'SelectColumnAttributeAs', 'Comparitor', 'WhereClause', 'ViewModule', 'SelectionLayer', 'ELAttribute', 'ELClass', 'ELClassifier', 'ELDataType', 'ELEnum', 'ELEnumLiteral', 'ELModelElement', 'ELNamedElement', 'ELOperation', 'ELPackage',
           'ELReference', 'ELStructuralFeature', 'ELTypedElement', 'ELAnnotation', 'ELStringToStringMapEntry', 'VTLEnrichedCube', 'VTLGeneratedOutputlayer', 'VTLForOutputLayerAndIntermediateLayerCombination', 'VTLGeneratedIntermediateLayer', 'VTLTransformation', 'VTLScheme', 'VTLForSelectionLayer', 'VTLModule', 'EntityToVTLIntermediateLayerLink', 'VTLForView', 'VTLGeneratedOutputlayerModule', 'VTLForOutputLayerAndIntermediateLayerCombinationModule', 'VTLGeneratedIntermediateLayerModule', 'VTLSchemesModule', 'VTLForSelectionLayerModule', 'EntityToVTLIntermediateLayerLinkModule', 'VTLForViewModule']

eSubpackages = []
eSuperPackage = None
ecore4reg.eSubpackages = eSubpackages
ecore4reg.eSuperPackage = eSuperPackage

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
View.outputLayer.eType = ELClass
View.selectionLayerSQL.eType = LayerSQL
LayerSQL.selectionLayer.eType = SelectionLayer
LayerSQL.columns.eType = SelectColumn
LayerSQL.whereClause.eType = WhereClause
SelectColumn.asAttribute.eType = ELOperation
SelectColumnMemberAs.memberAsConstant.eType = ELEnumLiteral
SelectColumnAttributeAs.attribute.eType = ELAttribute
WhereClause.attribute1.eType = ELAttribute
WhereClause.member.eType = ELEnumLiteral
ViewModule.views.eType = View
ELAttribute.eAttributeType.eType = ELDataType
ELClass.eSuperTypes.eType = ELClass
ELClass.eStructuralFeatures.eType = ELStructuralFeature
ELClass.eOperations.eType = ELOperation
ELEnum.eLiterals.eType = ELEnumLiteral
ELModelElement.eAnnotations.eType = ELAnnotation
ELReference.eReferenceType.eType = ELClassifier
ELTypedElement.eType.eType = ELClassifier
ELAnnotation.details.eType = ELStringToStringMapEntry
VTLEnrichedCube.transformations.eType = VTLTransformation
VTLGeneratedOutputlayer.dependant_intermediate_layers.eType = VTLGeneratedIntermediateLayer
VTLGeneratedOutputlayer.VTLForOutputLayerAndIntemedateLayerCombinations.eType = VTLForOutputLayerAndIntermediateLayerCombination
VTLGeneratedOutputlayer.outputLayer.eType = ELClass
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
EntityToVTLIntermediateLayerLink.entity.eType = ELClass
VTLForView.view.eType = View
VTLForView.vtl.eType = VTLGeneratedOutputlayer
VTLGeneratedOutputlayerModule.vTLGeneratedOutputlayerModules.eType = VTLGeneratedOutputlayer
VTLForOutputLayerAndIntermediateLayerCombinationModule.vTLForOutputLayerAndIntermediateLayerCombinations.eType = VTLForOutputLayerAndIntermediateLayerCombination
VTLGeneratedIntermediateLayerModule.vTLGeneratedIntermediateLayers.eType = VTLGeneratedIntermediateLayer
VTLSchemesModule.vTLSchemes.eType = VTLScheme
VTLForSelectionLayerModule.vTLForSelectionLayers.eType = VTLForSelectionLayer
EntityToVTLIntermediateLayerLinkModule.entityToVTLIntermediateLayerLinks.eType = EntityToVTLIntermediateLayerLink
VTLForViewModule.vTLForViews.eType = VTLForView
RequirementsSectionLinkWithText.linkedRuleSection.eType = TitledRequirementsSection
TitledRequirementsSection.referencingSections.eType = RequirementsSectionLinkWithText
TitledRequirementsSection.referencingSections.eOpposite = RequirementsSectionLinkWithText.linkedRuleSection
ELClassifier.package.eType = ELPackage
ELPackage.eClassifiers.eType = ELClassifier
ELPackage.eClassifiers.eOpposite = ELClassifier.package

otherClassifiers = [Comparitor]

for classif in otherClassifiers:
    eClassifiers[classif.name] = classif
    classif.ePackage = eClass

for classif in eClassifiers.values():
    eClass.eClassifiers.append(classif.eClass)

for subpack in eSubpackages:
    eClass.eSubpackages.append(subpack.eClass)
