/**
 */
package org.eclipse.efbt.ecore4reg.model.ecore4reg.impl;

import java.util.Collection;

import org.eclipse.efbt.ecore4reg.model.ecore4reg.ELClass;
import org.eclipse.efbt.ecore4reg.model.ecore4reg.Ecore4regPackage;
import org.eclipse.efbt.ecore4reg.model.ecore4reg.RulesForILTable;
import org.eclipse.efbt.ecore4reg.model.ecore4reg.RulesForReport;

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
 * An implementation of the model object '<em><b>Rules For Report</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efbt.ecore4reg.model.ecore4reg.impl.RulesForReportImpl#getOutputLayerCube <em>Output Layer Cube</em>}</li>
 *   <li>{@link org.eclipse.efbt.ecore4reg.model.ecore4reg.impl.RulesForReportImpl#getRulesForTable <em>Rules For Table</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RulesForReportImpl extends MinimalEObjectImpl.Container implements RulesForReport {
	/**
	 * The cached value of the '{@link #getOutputLayerCube() <em>Output Layer Cube</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputLayerCube()
	 * @generated
	 * @ordered
	 */
	protected ELClass outputLayerCube;

	/**
	 * The cached value of the '{@link #getRulesForTable() <em>Rules For Table</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRulesForTable()
	 * @generated
	 * @ordered
	 */
	protected EList<RulesForILTable> rulesForTable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RulesForReportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Ecore4regPackage.eINSTANCE.getRulesForReport();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELClass getOutputLayerCube() {
		if (outputLayerCube != null && outputLayerCube.eIsProxy()) {
			InternalEObject oldOutputLayerCube = (InternalEObject)outputLayerCube;
			outputLayerCube = (ELClass)eResolveProxy(oldOutputLayerCube);
			if (outputLayerCube != oldOutputLayerCube) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Ecore4regPackage.RULES_FOR_REPORT__OUTPUT_LAYER_CUBE, oldOutputLayerCube, outputLayerCube));
			}
		}
		return outputLayerCube;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ELClass basicGetOutputLayerCube() {
		return outputLayerCube;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputLayerCube(ELClass newOutputLayerCube) {
		ELClass oldOutputLayerCube = outputLayerCube;
		outputLayerCube = newOutputLayerCube;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Ecore4regPackage.RULES_FOR_REPORT__OUTPUT_LAYER_CUBE, oldOutputLayerCube, outputLayerCube));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RulesForILTable> getRulesForTable() {
		if (rulesForTable == null) {
			rulesForTable = new EObjectContainmentEList<RulesForILTable>(RulesForILTable.class, this, Ecore4regPackage.RULES_FOR_REPORT__RULES_FOR_TABLE);
		}
		return rulesForTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Ecore4regPackage.RULES_FOR_REPORT__RULES_FOR_TABLE:
				return ((InternalEList<?>)getRulesForTable()).basicRemove(otherEnd, msgs);
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
			case Ecore4regPackage.RULES_FOR_REPORT__OUTPUT_LAYER_CUBE:
				if (resolve) return getOutputLayerCube();
				return basicGetOutputLayerCube();
			case Ecore4regPackage.RULES_FOR_REPORT__RULES_FOR_TABLE:
				return getRulesForTable();
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
			case Ecore4regPackage.RULES_FOR_REPORT__OUTPUT_LAYER_CUBE:
				setOutputLayerCube((ELClass)newValue);
				return;
			case Ecore4regPackage.RULES_FOR_REPORT__RULES_FOR_TABLE:
				getRulesForTable().clear();
				getRulesForTable().addAll((Collection<? extends RulesForILTable>)newValue);
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
			case Ecore4regPackage.RULES_FOR_REPORT__OUTPUT_LAYER_CUBE:
				setOutputLayerCube((ELClass)null);
				return;
			case Ecore4regPackage.RULES_FOR_REPORT__RULES_FOR_TABLE:
				getRulesForTable().clear();
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
			case Ecore4regPackage.RULES_FOR_REPORT__OUTPUT_LAYER_CUBE:
				return outputLayerCube != null;
			case Ecore4regPackage.RULES_FOR_REPORT__RULES_FOR_TABLE:
				return rulesForTable != null && !rulesForTable.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RulesForReportImpl
