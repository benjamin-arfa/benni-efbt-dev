/**
 */
package org.eclipse.efbt.openregspecs.model.sql_lite.impl;

import java.util.Collection;

import org.eclipse.efbt.openregspecs.model.data_meta_model.GeneratedEntity;

import org.eclipse.efbt.openregspecs.model.sql_lite.GeneratedEntitySQL;
import org.eclipse.efbt.openregspecs.model.sql_lite.Sql_litePackage;
import org.eclipse.efbt.openregspecs.model.sql_lite.View;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generated Entity SQL</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efbt.openregspecs.model.sql_lite.impl.GeneratedEntitySQLImpl#getGeneratedEntity <em>Generated Entity</em>}</li>
 *   <li>{@link org.eclipse.efbt.openregspecs.model.sql_lite.impl.GeneratedEntitySQLImpl#getView <em>View</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GeneratedEntitySQLImpl extends MinimalEObjectImpl.Container implements GeneratedEntitySQL {
	/**
	 * The cached value of the '{@link #getGeneratedEntity() <em>Generated Entity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneratedEntity()
	 * @generated
	 * @ordered
	 */
	protected GeneratedEntity generatedEntity;

	/**
	 * The cached value of the '{@link #getView() <em>View</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getView()
	 * @generated
	 * @ordered
	 */
	protected EList<View> view;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratedEntitySQLImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Sql_litePackage.Literals.GENERATED_ENTITY_SQL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedEntity getGeneratedEntity() {
		if (generatedEntity != null && generatedEntity.eIsProxy()) {
			InternalEObject oldGeneratedEntity = (InternalEObject)generatedEntity;
			generatedEntity = (GeneratedEntity)eResolveProxy(oldGeneratedEntity);
			if (generatedEntity != oldGeneratedEntity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Sql_litePackage.GENERATED_ENTITY_SQL__GENERATED_ENTITY, oldGeneratedEntity, generatedEntity));
			}
		}
		return generatedEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratedEntity basicGetGeneratedEntity() {
		return generatedEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratedEntity(GeneratedEntity newGeneratedEntity) {
		GeneratedEntity oldGeneratedEntity = generatedEntity;
		generatedEntity = newGeneratedEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Sql_litePackage.GENERATED_ENTITY_SQL__GENERATED_ENTITY, oldGeneratedEntity, generatedEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<View> getView() {
		if (view == null) {
			view = new EObjectResolvingEList<View>(View.class, this, Sql_litePackage.GENERATED_ENTITY_SQL__VIEW);
		}
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Sql_litePackage.GENERATED_ENTITY_SQL__GENERATED_ENTITY:
				if (resolve) return getGeneratedEntity();
				return basicGetGeneratedEntity();
			case Sql_litePackage.GENERATED_ENTITY_SQL__VIEW:
				return getView();
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
			case Sql_litePackage.GENERATED_ENTITY_SQL__GENERATED_ENTITY:
				setGeneratedEntity((GeneratedEntity)newValue);
				return;
			case Sql_litePackage.GENERATED_ENTITY_SQL__VIEW:
				getView().clear();
				getView().addAll((Collection<? extends View>)newValue);
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
			case Sql_litePackage.GENERATED_ENTITY_SQL__GENERATED_ENTITY:
				setGeneratedEntity((GeneratedEntity)null);
				return;
			case Sql_litePackage.GENERATED_ENTITY_SQL__VIEW:
				getView().clear();
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
			case Sql_litePackage.GENERATED_ENTITY_SQL__GENERATED_ENTITY:
				return generatedEntity != null;
			case Sql_litePackage.GENERATED_ENTITY_SQL__VIEW:
				return view != null && !view.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GeneratedEntitySQLImpl