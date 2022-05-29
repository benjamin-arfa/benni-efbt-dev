/**
 */
package org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.util;

import org.eclipse.efbt.openregspecs.model.data_meta_model.TypesAndConcepts;
import org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.openregspecs_smcubes_core_extensionPackage
 * @generated
 */
public class openregspecs_smcubes_core_extensionAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static openregspecs_smcubes_core_extensionPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public openregspecs_smcubes_core_extensionAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = openregspecs_smcubes_core_extensionPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected openregspecs_smcubes_core_extensionSwitch<Adapter> modelSwitch =
		new openregspecs_smcubes_core_extensionSwitch<Adapter>() {
			@Override
			public Adapter caseDomainModule(DomainModule object) {
				return createDomainModuleAdapter();
			}
			@Override
			public Adapter caseMemberHierarchyModule(MemberHierarchyModule object) {
				return createMemberHierarchyModuleAdapter();
			}
			@Override
			public Adapter caseMemberModule(MemberModule object) {
				return createMemberModuleAdapter();
			}
			@Override
			public Adapter caseVariableModule(VariableModule object) {
				return createVariableModuleAdapter();
			}
			@Override
			public Adapter caseSubDomainModule(SubDomainModule object) {
				return createSubDomainModuleAdapter();
			}
			@Override
			public Adapter caseSMCubesCoreModel(SMCubesCoreModel object) {
				return createSMCubesCoreModelAdapter();
			}
			@Override
			public Adapter caseModule(org.eclipse.efbt.openregspecs.model.module_management.Module object) {
				return createModuleAdapter();
			}
			@Override
			public Adapter caseTypesAndConcepts(TypesAndConcepts object) {
				return createTypesAndConceptsAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.DomainModule <em>Domain Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.DomainModule
	 * @generated
	 */
	public Adapter createDomainModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.MemberHierarchyModule <em>Member Hierarchy Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.MemberHierarchyModule
	 * @generated
	 */
	public Adapter createMemberHierarchyModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.MemberModule <em>Member Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.MemberModule
	 * @generated
	 */
	public Adapter createMemberModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.VariableModule <em>Variable Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.VariableModule
	 * @generated
	 */
	public Adapter createVariableModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.SubDomainModule <em>Sub Domain Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.SubDomainModule
	 * @generated
	 */
	public Adapter createSubDomainModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.SMCubesCoreModel <em>SM Cubes Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.SMCubesCoreModel
	 * @generated
	 */
	public Adapter createSMCubesCoreModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efbt.openregspecs.model.module_management.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efbt.openregspecs.model.module_management.Module
	 * @generated
	 */
	public Adapter createModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.efbt.openregspecs.model.data_meta_model.TypesAndConcepts <em>Types And Concepts</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.efbt.openregspecs.model.data_meta_model.TypesAndConcepts
	 * @generated
	 */
	public Adapter createTypesAndConceptsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //openregspecs_smcubes_core_extensionAdapterFactory
