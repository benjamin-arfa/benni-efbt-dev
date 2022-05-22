/**
 */
package org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.impl;

import java.util.Collection;
import org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.DomainModule;
import org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.MemberHierarchyModule;
import org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.MemberModule;
import org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.SMCubesCoreModel;
import org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.SubDomainModule;
import org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.VariableModule;
import org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.openregspecs_smcubes_core_extensionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SM Cubes Core Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.impl.SMCubesCoreModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.impl.SMCubesCoreModelImpl#getVariableModules <em>Variable Modules</em>}</li>
 *   <li>{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.impl.SMCubesCoreModelImpl#getDomainModules <em>Domain Modules</em>}</li>
 *   <li>{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.impl.SMCubesCoreModelImpl#getMemberModules <em>Member Modules</em>}</li>
 *   <li>{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.impl.SMCubesCoreModelImpl#getSubDomainModules <em>Sub Domain Modules</em>}</li>
 *   <li>{@link org.eclipse.efbt.openregspecs.model.openregspecs_smcubes_core_extension.impl.SMCubesCoreModelImpl#getMemberHierarchyModules <em>Member Hierarchy Modules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SMCubesCoreModelImpl extends MinimalEObjectImpl.Container implements SMCubesCoreModel {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariableModules() <em>Variable Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableModules()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableModule> variableModules;

	/**
	 * The cached value of the '{@link #getDomainModules() <em>Domain Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainModules()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainModule> domainModules;

	/**
	 * The cached value of the '{@link #getMemberModules() <em>Member Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberModules()
	 * @generated
	 * @ordered
	 */
	protected EList<MemberModule> memberModules;

	/**
	 * The cached value of the '{@link #getSubDomainModules() <em>Sub Domain Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubDomainModules()
	 * @generated
	 * @ordered
	 */
	protected EList<SubDomainModule> subDomainModules;

	/**
	 * The cached value of the '{@link #getMemberHierarchyModules() <em>Member Hierarchy Modules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberHierarchyModules()
	 * @generated
	 * @ordered
	 */
	protected EList<MemberHierarchyModule> memberHierarchyModules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMCubesCoreModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return openregspecs_smcubes_core_extensionPackage.Literals.SM_CUBES_CORE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableModule> getVariableModules() {
		if (variableModules == null) {
			variableModules = new EObjectContainmentEList<VariableModule>(VariableModule.class, this, openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__VARIABLE_MODULES);
		}
		return variableModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DomainModule> getDomainModules() {
		if (domainModules == null) {
			domainModules = new EObjectContainmentEList<DomainModule>(DomainModule.class, this, openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__DOMAIN_MODULES);
		}
		return domainModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemberModule> getMemberModules() {
		if (memberModules == null) {
			memberModules = new EObjectContainmentEList<MemberModule>(MemberModule.class, this, openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_MODULES);
		}
		return memberModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SubDomainModule> getSubDomainModules() {
		if (subDomainModules == null) {
			subDomainModules = new EObjectContainmentEList<SubDomainModule>(SubDomainModule.class, this, openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__SUB_DOMAIN_MODULES);
		}
		return subDomainModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MemberHierarchyModule> getMemberHierarchyModules() {
		if (memberHierarchyModules == null) {
			memberHierarchyModules = new EObjectContainmentEList<MemberHierarchyModule>(MemberHierarchyModule.class, this, openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_HIERARCHY_MODULES);
		}
		return memberHierarchyModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__VARIABLE_MODULES:
				return ((InternalEList<?>)getVariableModules()).basicRemove(otherEnd, msgs);
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__DOMAIN_MODULES:
				return ((InternalEList<?>)getDomainModules()).basicRemove(otherEnd, msgs);
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_MODULES:
				return ((InternalEList<?>)getMemberModules()).basicRemove(otherEnd, msgs);
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__SUB_DOMAIN_MODULES:
				return ((InternalEList<?>)getSubDomainModules()).basicRemove(otherEnd, msgs);
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_HIERARCHY_MODULES:
				return ((InternalEList<?>)getMemberHierarchyModules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__NAME:
				return getName();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__VARIABLE_MODULES:
				return getVariableModules();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__DOMAIN_MODULES:
				return getDomainModules();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_MODULES:
				return getMemberModules();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__SUB_DOMAIN_MODULES:
				return getSubDomainModules();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_HIERARCHY_MODULES:
				return getMemberHierarchyModules();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__NAME:
				setName((String)newValue);
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__VARIABLE_MODULES:
				getVariableModules().clear();
				getVariableModules().addAll((Collection<? extends VariableModule>)newValue);
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__DOMAIN_MODULES:
				getDomainModules().clear();
				getDomainModules().addAll((Collection<? extends DomainModule>)newValue);
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_MODULES:
				getMemberModules().clear();
				getMemberModules().addAll((Collection<? extends MemberModule>)newValue);
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__SUB_DOMAIN_MODULES:
				getSubDomainModules().clear();
				getSubDomainModules().addAll((Collection<? extends SubDomainModule>)newValue);
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_HIERARCHY_MODULES:
				getMemberHierarchyModules().clear();
				getMemberHierarchyModules().addAll((Collection<? extends MemberHierarchyModule>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__VARIABLE_MODULES:
				getVariableModules().clear();
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__DOMAIN_MODULES:
				getDomainModules().clear();
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_MODULES:
				getMemberModules().clear();
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__SUB_DOMAIN_MODULES:
				getSubDomainModules().clear();
				return;
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_HIERARCHY_MODULES:
				getMemberHierarchyModules().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__VARIABLE_MODULES:
				return variableModules != null && !variableModules.isEmpty();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__DOMAIN_MODULES:
				return domainModules != null && !domainModules.isEmpty();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_MODULES:
				return memberModules != null && !memberModules.isEmpty();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__SUB_DOMAIN_MODULES:
				return subDomainModules != null && !subDomainModules.isEmpty();
			case openregspecs_smcubes_core_extensionPackage.SM_CUBES_CORE_MODEL__MEMBER_HIERARCHY_MODULES:
				return memberHierarchyModules != null && !memberHierarchyModules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //SMCubesCoreModelImpl
