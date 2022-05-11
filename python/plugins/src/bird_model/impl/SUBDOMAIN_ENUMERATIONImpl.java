/**
 */
package bird_model.impl;

import bird_model.Bird_modelPackage;
import bird_model.MEMBER;
import bird_model.SUBDOMAIN_ENUMERATION;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SUBDOMAIN ENUMERATION</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link bird_model.impl.SUBDOMAIN_ENUMERATIONImpl#getMember_id <em>Member id</em>}</li>
 *   <li>{@link bird_model.impl.SUBDOMAIN_ENUMERATIONImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link bird_model.impl.SUBDOMAIN_ENUMERATIONImpl#getValid_from <em>Valid from</em>}</li>
 *   <li>{@link bird_model.impl.SUBDOMAIN_ENUMERATIONImpl#getValid_to <em>Valid to</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SUBDOMAIN_ENUMERATIONImpl extends MinimalEObjectImpl.Container implements SUBDOMAIN_ENUMERATION {
	/**
	 * The cached value of the '{@link #getMember_id() <em>Member id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember_id()
	 * @generated
	 * @ordered
	 */
	protected MEMBER member_id;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getValid_from() <em>Valid from</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValid_from()
	 * @generated
	 * @ordered
	 */
	protected static final Date VALID_FROM_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValid_from() <em>Valid from</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValid_from()
	 * @generated
	 * @ordered
	 */
	protected Date valid_from = VALID_FROM_EDEFAULT;

	/**
	 * The default value of the '{@link #getValid_to() <em>Valid to</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValid_to()
	 * @generated
	 * @ordered
	 */
	protected static final Date VALID_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValid_to() <em>Valid to</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValid_to()
	 * @generated
	 * @ordered
	 */
	protected Date valid_to = VALID_TO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SUBDOMAIN_ENUMERATIONImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Bird_modelPackage.Literals.SUBDOMAIN_ENUMERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MEMBER getMember_id() {
		if (member_id != null && member_id.eIsProxy()) {
			InternalEObject oldMember_id = (InternalEObject)member_id;
			member_id = (MEMBER)eResolveProxy(oldMember_id);
			if (member_id != oldMember_id) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Bird_modelPackage.SUBDOMAIN_ENUMERATION__MEMBER_ID, oldMember_id, member_id));
			}
		}
		return member_id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MEMBER basicGetMember_id() {
		return member_id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMember_id(MEMBER newMember_id) {
		MEMBER oldMember_id = member_id;
		member_id = newMember_id;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bird_modelPackage.SUBDOMAIN_ENUMERATION__MEMBER_ID, oldMember_id, member_id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bird_modelPackage.SUBDOMAIN_ENUMERATION__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getValid_from() {
		return valid_from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid_from(Date newValid_from) {
		Date oldValid_from = valid_from;
		valid_from = newValid_from;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_FROM, oldValid_from, valid_from));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getValid_to() {
		return valid_to;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValid_to(Date newValid_to) {
		Date oldValid_to = valid_to;
		valid_to = newValid_to;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_TO, oldValid_to, valid_to));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__MEMBER_ID:
				if (resolve) return getMember_id();
				return basicGetMember_id();
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__ORDER:
				return getOrder();
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_FROM:
				return getValid_from();
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_TO:
				return getValid_to();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__MEMBER_ID:
				setMember_id((MEMBER)newValue);
				return;
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__ORDER:
				setOrder((Integer)newValue);
				return;
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_FROM:
				setValid_from((Date)newValue);
				return;
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_TO:
				setValid_to((Date)newValue);
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
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__MEMBER_ID:
				setMember_id((MEMBER)null);
				return;
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_FROM:
				setValid_from(VALID_FROM_EDEFAULT);
				return;
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_TO:
				setValid_to(VALID_TO_EDEFAULT);
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
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__MEMBER_ID:
				return member_id != null;
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__ORDER:
				return order != ORDER_EDEFAULT;
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_FROM:
				return VALID_FROM_EDEFAULT == null ? valid_from != null : !VALID_FROM_EDEFAULT.equals(valid_from);
			case Bird_modelPackage.SUBDOMAIN_ENUMERATION__VALID_TO:
				return VALID_TO_EDEFAULT == null ? valid_to != null : !VALID_TO_EDEFAULT.equals(valid_to);
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
		result.append(" (order: ");
		result.append(order);
		result.append(", valid_from: ");
		result.append(valid_from);
		result.append(", valid_to: ");
		result.append(valid_to);
		result.append(')');
		return result.toString();
	}

} //SUBDOMAIN_ENUMERATIONImpl