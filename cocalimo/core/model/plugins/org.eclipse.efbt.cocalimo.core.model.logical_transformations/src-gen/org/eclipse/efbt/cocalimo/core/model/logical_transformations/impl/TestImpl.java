/**
 */
package org.eclipse.efbt.cocalimo.core.model.logical_transformations.impl;

import java.util.Collection;

import org.eclipse.efbt.cocalimo.core.model.logical_transformations.Logical_transformationsPackage;
import org.eclipse.efbt.cocalimo.core.model.logical_transformations.Scenario;
import org.eclipse.efbt.cocalimo.core.model.logical_transformations.Test;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efbt.cocalimo.core.model.logical_transformations.impl.TestImpl#getScenarios <em>Scenarios</em>}</li>
 *   <li>{@link org.eclipse.efbt.cocalimo.core.model.logical_transformations.impl.TestImpl#getInputData <em>Input Data</em>}</li>
 *   <li>{@link org.eclipse.efbt.cocalimo.core.model.logical_transformations.impl.TestImpl#getExpectedResult <em>Expected Result</em>}</li>
 *   <li>{@link org.eclipse.efbt.cocalimo.core.model.logical_transformations.impl.TestImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestImpl extends MinimalEObjectImpl.Container implements Test {
	/**
	 * The cached value of the '{@link #getScenarios() <em>Scenarios</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScenarios()
	 * @generated
	 * @ordered
	 */
	protected EList<Scenario> scenarios;

	/**
	 * The cached value of the '{@link #getInputData() <em>Input Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputData()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> inputData;

	/**
	 * The cached value of the '{@link #getExpectedResult() <em>Expected Result</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpectedResult()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> expectedResult;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Logical_transformationsPackage.Literals.TEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Scenario> getScenarios() {
		if (scenarios == null) {
			scenarios = new EObjectResolvingEList<Scenario>(Scenario.class, this, Logical_transformationsPackage.TEST__SCENARIOS);
		}
		return scenarios;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getInputData() {
		if (inputData == null) {
			inputData = new EObjectResolvingEList<EObject>(EObject.class, this, Logical_transformationsPackage.TEST__INPUT_DATA);
		}
		return inputData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EObject> getExpectedResult() {
		if (expectedResult == null) {
			expectedResult = new EObjectResolvingEList<EObject>(EObject.class, this, Logical_transformationsPackage.TEST__EXPECTED_RESULT);
		}
		return expectedResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Logical_transformationsPackage.TEST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Logical_transformationsPackage.TEST__SCENARIOS:
				return getScenarios();
			case Logical_transformationsPackage.TEST__INPUT_DATA:
				return getInputData();
			case Logical_transformationsPackage.TEST__EXPECTED_RESULT:
				return getExpectedResult();
			case Logical_transformationsPackage.TEST__NAME:
				return getName();
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
			case Logical_transformationsPackage.TEST__SCENARIOS:
				getScenarios().clear();
				getScenarios().addAll((Collection<? extends Scenario>)newValue);
				return;
			case Logical_transformationsPackage.TEST__INPUT_DATA:
				getInputData().clear();
				getInputData().addAll((Collection<? extends EObject>)newValue);
				return;
			case Logical_transformationsPackage.TEST__EXPECTED_RESULT:
				getExpectedResult().clear();
				getExpectedResult().addAll((Collection<? extends EObject>)newValue);
				return;
			case Logical_transformationsPackage.TEST__NAME:
				setName((String)newValue);
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
			case Logical_transformationsPackage.TEST__SCENARIOS:
				getScenarios().clear();
				return;
			case Logical_transformationsPackage.TEST__INPUT_DATA:
				getInputData().clear();
				return;
			case Logical_transformationsPackage.TEST__EXPECTED_RESULT:
				getExpectedResult().clear();
				return;
			case Logical_transformationsPackage.TEST__NAME:
				setName(NAME_EDEFAULT);
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
			case Logical_transformationsPackage.TEST__SCENARIOS:
				return scenarios != null && !scenarios.isEmpty();
			case Logical_transformationsPackage.TEST__INPUT_DATA:
				return inputData != null && !inputData.isEmpty();
			case Logical_transformationsPackage.TEST__EXPECTED_RESULT:
				return expectedResult != null && !expectedResult.isEmpty();
			case Logical_transformationsPackage.TEST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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

} //TestImpl
