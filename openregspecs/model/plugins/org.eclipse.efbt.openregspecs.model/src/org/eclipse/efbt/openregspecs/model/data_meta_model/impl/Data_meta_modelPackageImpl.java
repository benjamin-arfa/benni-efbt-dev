/**
 */
package org.eclipse.efbt.openregspecs.model.data_meta_model.impl;

import org.eclipse.efbt.openregspecs.model.bpmn_lite.Bpmn_litePackage;

import org.eclipse.efbt.openregspecs.model.bpmn_lite.impl.Bpmn_litePackageImpl;

import org.eclipse.efbt.openregspecs.model.data_meta_model.Attribute;
import org.eclipse.efbt.openregspecs.model.data_meta_model.BasicEntity;
import org.eclipse.efbt.openregspecs.model.data_meta_model.Classifier;
import org.eclipse.efbt.openregspecs.model.data_meta_model.Concept;
import org.eclipse.efbt.openregspecs.model.data_meta_model.Data_meta_modelFactory;
import org.eclipse.efbt.openregspecs.model.data_meta_model.Data_meta_modelPackage;
import org.eclipse.efbt.openregspecs.model.data_meta_model.DerivedEntity;
import org.eclipse.efbt.openregspecs.model.data_meta_model.Element;
import org.eclipse.efbt.openregspecs.model.data_meta_model.Entity;
import org.eclipse.efbt.openregspecs.model.data_meta_model.EntityModule;
import org.eclipse.efbt.openregspecs.model.data_meta_model.EnumMember;
import org.eclipse.efbt.openregspecs.model.data_meta_model.GeneratedEntity;
import org.eclipse.efbt.openregspecs.model.data_meta_model.ManyToManyRelationshipAttribute;
import org.eclipse.efbt.openregspecs.model.data_meta_model.ManyToOneRelationshipAttribute;
import org.eclipse.efbt.openregspecs.model.data_meta_model.NamedElement;
import org.eclipse.efbt.openregspecs.model.data_meta_model.OneToManyRelationshipAttribute;
import org.eclipse.efbt.openregspecs.model.data_meta_model.OneToOneRelationshipAttribute;
import org.eclipse.efbt.openregspecs.model.data_meta_model.RelationshipAttribute;
import org.eclipse.efbt.openregspecs.model.data_meta_model.StructuralFeature;
import org.eclipse.efbt.openregspecs.model.data_meta_model.TypedElement;

import org.eclipse.efbt.openregspecs.model.module_management.Module_managementPackage;

import org.eclipse.efbt.openregspecs.model.module_management.impl.Module_managementPackageImpl;

import org.eclipse.efbt.openregspecs.model.requirements_text.Requirements_textPackage;

import org.eclipse.efbt.openregspecs.model.requirements_text.impl.Requirements_textPackageImpl;

import org.eclipse.efbt.openregspecs.model.sql_lite.Sql_litePackage;

import org.eclipse.efbt.openregspecs.model.sql_lite.impl.Sql_litePackageImpl;

import org.eclipse.efbt.openregspecs.model.testing.TestingPackage;

import org.eclipse.efbt.openregspecs.model.testing.impl.TestingPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Data_meta_modelPackageImpl extends EPackageImpl implements Data_meta_modelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conceptEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oneToOneRelationshipAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass manyToOneRelationshipAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oneToManyRelationshipAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass manyToManyRelationshipAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generatedEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass basicEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumMemberEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.efbt.openregspecs.model.data_meta_model.Data_meta_modelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Data_meta_modelPackageImpl() {
		super(eNS_URI, Data_meta_modelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link Data_meta_modelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Data_meta_modelPackage init() {
		if (isInited) return (Data_meta_modelPackage)EPackage.Registry.INSTANCE.getEPackage(Data_meta_modelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredData_meta_modelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Data_meta_modelPackageImpl theData_meta_modelPackage = registeredData_meta_modelPackage instanceof Data_meta_modelPackageImpl ? (Data_meta_modelPackageImpl)registeredData_meta_modelPackage : new Data_meta_modelPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(Bpmn_litePackage.eNS_URI);
		Bpmn_litePackageImpl theBpmn_litePackage = (Bpmn_litePackageImpl)(registeredPackage instanceof Bpmn_litePackageImpl ? registeredPackage : Bpmn_litePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(Module_managementPackage.eNS_URI);
		Module_managementPackageImpl theModule_managementPackage = (Module_managementPackageImpl)(registeredPackage instanceof Module_managementPackageImpl ? registeredPackage : Module_managementPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(Requirements_textPackage.eNS_URI);
		Requirements_textPackageImpl theRequirements_textPackage = (Requirements_textPackageImpl)(registeredPackage instanceof Requirements_textPackageImpl ? registeredPackage : Requirements_textPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(Sql_litePackage.eNS_URI);
		Sql_litePackageImpl theSql_litePackage = (Sql_litePackageImpl)(registeredPackage instanceof Sql_litePackageImpl ? registeredPackage : Sql_litePackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(TestingPackage.eNS_URI);
		TestingPackageImpl theTestingPackage = (TestingPackageImpl)(registeredPackage instanceof TestingPackageImpl ? registeredPackage : TestingPackage.eINSTANCE);

		// Create package meta-data objects
		theData_meta_modelPackage.createPackageContents();
		theBpmn_litePackage.createPackageContents();
		theModule_managementPackage.createPackageContents();
		theRequirements_textPackage.createPackageContents();
		theSql_litePackage.createPackageContents();
		theTestingPackage.createPackageContents();

		// Initialize created meta-data
		theData_meta_modelPackage.initializePackageContents();
		theBpmn_litePackage.initializePackageContents();
		theModule_managementPackage.initializePackageContents();
		theRequirements_textPackage.initializePackageContents();
		theSql_litePackage.initializePackageContents();
		theTestingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theData_meta_modelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Data_meta_modelPackage.eNS_URI, theData_meta_modelPackage);
		return theData_meta_modelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_IsPK() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Concept() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Ordered() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConcept() {
		return conceptEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConcept_ConceptName() {
		return (EAttribute)conceptEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationshipAttribute() {
		return relationshipAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationshipAttribute_Entity() {
		return (EReference)relationshipAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationshipAttribute_Containment() {
		return (EAttribute)relationshipAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationshipAttribute_Mandatory() {
		return (EAttribute)relationshipAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationshipAttribute_Dominant() {
		return (EAttribute)relationshipAttributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOneToOneRelationshipAttribute() {
		return oneToOneRelationshipAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManyToOneRelationshipAttribute() {
		return manyToOneRelationshipAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOneToManyRelationshipAttribute() {
		return oneToManyRelationshipAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getManyToManyRelationshipAttribute() {
		return manyToManyRelationshipAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntityModule() {
		return entityModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityModule_NsURI() {
		return (EAttribute)entityModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntityModule_NsPrefix() {
		return (EAttribute)entityModuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntityModule_Entities() {
		return (EReference)entityModuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeature() {
		return structuralFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElement() {
		return typedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_Classifier() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneratedEntity() {
		return generatedEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneratedEntity_Attributes() {
		return (EReference)generatedEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity() {
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivedEntity() {
		return derivedEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedEntity_Attributes() {
		return (EReference)derivedEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBasicEntity() {
		return basicEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicEntity_Attributes() {
		return (EReference)basicEntityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBasicEntity_SuperClass() {
		return (EReference)basicEntityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumMember() {
		return enumMemberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data_meta_modelFactory getData_meta_modelFactory() {
		return (Data_meta_modelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__IS_PK);
		createEReference(attributeEClass, ATTRIBUTE__CONCEPT);
		createEAttribute(attributeEClass, ATTRIBUTE__ORDERED);

		conceptEClass = createEClass(CONCEPT);
		createEAttribute(conceptEClass, CONCEPT__CONCEPT_NAME);

		relationshipAttributeEClass = createEClass(RELATIONSHIP_ATTRIBUTE);
		createEReference(relationshipAttributeEClass, RELATIONSHIP_ATTRIBUTE__ENTITY);
		createEAttribute(relationshipAttributeEClass, RELATIONSHIP_ATTRIBUTE__CONTAINMENT);
		createEAttribute(relationshipAttributeEClass, RELATIONSHIP_ATTRIBUTE__MANDATORY);
		createEAttribute(relationshipAttributeEClass, RELATIONSHIP_ATTRIBUTE__DOMINANT);

		oneToOneRelationshipAttributeEClass = createEClass(ONE_TO_ONE_RELATIONSHIP_ATTRIBUTE);

		manyToOneRelationshipAttributeEClass = createEClass(MANY_TO_ONE_RELATIONSHIP_ATTRIBUTE);

		oneToManyRelationshipAttributeEClass = createEClass(ONE_TO_MANY_RELATIONSHIP_ATTRIBUTE);

		manyToManyRelationshipAttributeEClass = createEClass(MANY_TO_MANY_RELATIONSHIP_ATTRIBUTE);

		classifierEClass = createEClass(CLASSIFIER);

		elementEClass = createEClass(ELEMENT);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		entityModuleEClass = createEClass(ENTITY_MODULE);
		createEAttribute(entityModuleEClass, ENTITY_MODULE__NS_URI);
		createEAttribute(entityModuleEClass, ENTITY_MODULE__NS_PREFIX);
		createEReference(entityModuleEClass, ENTITY_MODULE__ENTITIES);

		structuralFeatureEClass = createEClass(STRUCTURAL_FEATURE);

		typedElementEClass = createEClass(TYPED_ELEMENT);
		createEReference(typedElementEClass, TYPED_ELEMENT__CLASSIFIER);

		generatedEntityEClass = createEClass(GENERATED_ENTITY);
		createEReference(generatedEntityEClass, GENERATED_ENTITY__ATTRIBUTES);

		entityEClass = createEClass(ENTITY);

		derivedEntityEClass = createEClass(DERIVED_ENTITY);
		createEReference(derivedEntityEClass, DERIVED_ENTITY__ATTRIBUTES);

		basicEntityEClass = createEClass(BASIC_ENTITY);
		createEReference(basicEntityEClass, BASIC_ENTITY__ATTRIBUTES);
		createEReference(basicEntityEClass, BASIC_ENTITY__SUPER_CLASS);

		enumMemberEClass = createEClass(ENUM_MEMBER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Module_managementPackage theModule_managementPackage = (Module_managementPackage)EPackage.Registry.INSTANCE.getEPackage(Module_managementPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		attributeEClass.getESuperTypes().add(this.getStructuralFeature());
		relationshipAttributeEClass.getESuperTypes().add(this.getAttribute());
		oneToOneRelationshipAttributeEClass.getESuperTypes().add(this.getRelationshipAttribute());
		manyToOneRelationshipAttributeEClass.getESuperTypes().add(this.getRelationshipAttribute());
		oneToManyRelationshipAttributeEClass.getESuperTypes().add(this.getRelationshipAttribute());
		manyToManyRelationshipAttributeEClass.getESuperTypes().add(this.getRelationshipAttribute());
		classifierEClass.getESuperTypes().add(this.getNamedElement());
		namedElementEClass.getESuperTypes().add(this.getElement());
		entityModuleEClass.getESuperTypes().add(theModule_managementPackage.getModule());
		structuralFeatureEClass.getESuperTypes().add(this.getTypedElement());
		typedElementEClass.getESuperTypes().add(this.getNamedElement());
		generatedEntityEClass.getESuperTypes().add(this.getEntity());
		entityEClass.getESuperTypes().add(this.getNamedElement());
		derivedEntityEClass.getESuperTypes().add(this.getEntity());
		basicEntityEClass.getESuperTypes().add(this.getEntity());

		// Initialize classes, features, and operations; add parameters
		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_IsPK(), ecorePackage.getEBoolean(), "isPK", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_Concept(), this.getConcept(), null, "concept", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Ordered(), ecorePackage.getEBoolean(), "ordered", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conceptEClass, Concept.class, "Concept", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConcept_ConceptName(), ecorePackage.getEString(), "conceptName", null, 0, 1, Concept.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipAttributeEClass, RelationshipAttribute.class, "RelationshipAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationshipAttribute_Entity(), this.getEntity(), null, "entity", null, 0, 1, RelationshipAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationshipAttribute_Containment(), ecorePackage.getEBoolean(), "containment", null, 0, 1, RelationshipAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationshipAttribute_Mandatory(), ecorePackage.getEBoolean(), "mandatory", null, 0, 1, RelationshipAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationshipAttribute_Dominant(), ecorePackage.getEBoolean(), "dominant", null, 0, 1, RelationshipAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oneToOneRelationshipAttributeEClass, OneToOneRelationshipAttribute.class, "OneToOneRelationshipAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(manyToOneRelationshipAttributeEClass, ManyToOneRelationshipAttribute.class, "ManyToOneRelationshipAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(oneToManyRelationshipAttributeEClass, OneToManyRelationshipAttribute.class, "OneToManyRelationshipAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(manyToManyRelationshipAttributeEClass, ManyToManyRelationshipAttribute.class, "ManyToManyRelationshipAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierEClass, Classifier.class, "Classifier", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityModuleEClass, EntityModule.class, "EntityModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntityModule_NsURI(), ecorePackage.getEString(), "nsURI", null, 0, 1, EntityModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntityModule_NsPrefix(), ecorePackage.getEString(), "nsPrefix", null, 0, 1, EntityModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntityModule_Entities(), this.getEntity(), null, "entities", null, 0, -1, EntityModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(structuralFeatureEClass, StructuralFeature.class, "StructuralFeature", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedElement_Classifier(), this.getClassifier(), null, "classifier", null, 0, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generatedEntityEClass, GeneratedEntity.class, "GeneratedEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneratedEntity_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, GeneratedEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(derivedEntityEClass, DerivedEntity.class, "DerivedEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDerivedEntity_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, DerivedEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(basicEntityEClass, BasicEntity.class, "BasicEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBasicEntity_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, BasicEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBasicEntity_SuperClass(), this.getBasicEntity(), null, "superClass", null, 0, 1, BasicEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumMemberEClass, EnumMember.class, "EnumMember", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //Data_meta_modelPackageImpl