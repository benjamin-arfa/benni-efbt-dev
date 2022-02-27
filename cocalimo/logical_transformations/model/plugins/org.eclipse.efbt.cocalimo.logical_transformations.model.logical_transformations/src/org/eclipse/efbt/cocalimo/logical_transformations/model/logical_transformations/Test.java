/**
 */
package org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Test#getInputData <em>Input Data</em>}</li>
 *   <li>{@link org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Test#getExpectedResult <em>Expected Result</em>}</li>
 *   <li>{@link org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Test#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Test#getScope <em>Scope</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Logical_transformationsPackage#getTest()
 * @model
 * @generated
 */
public interface Test extends EObject {
	/**
	 * Returns the value of the '<em><b>Input Data</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Data</em>' reference list.
	 * @see org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Logical_transformationsPackage#getTest_InputData()
	 * @model
	 * @generated
	 */
	EList<EObject> getInputData();

	/**
	 * Returns the value of the '<em><b>Expected Result</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected Result</em>' reference list.
	 * @see org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Logical_transformationsPackage#getTest_ExpectedResult()
	 * @model
	 * @generated
	 */
	EList<EObject> getExpectedResult();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Logical_transformationsPackage#getTest_Name()
	 * @model id="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Test#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' containment reference.
	 * @see #setScope(TestScope)
	 * @see org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Logical_transformationsPackage#getTest_Scope()
	 * @model containment="true"
	 * @generated
	 */
	TestScope getScope();

	/**
	 * Sets the value of the '{@link org.eclipse.efbt.cocalimo.logical_transformations.model.logical_transformations.Test#getScope <em>Scope</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' containment reference.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(TestScope value);

} // Test