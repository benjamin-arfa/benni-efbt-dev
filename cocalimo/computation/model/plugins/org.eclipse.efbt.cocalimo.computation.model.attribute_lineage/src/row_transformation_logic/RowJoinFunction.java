/**
 */
package row_transformation_logic;

import functions.BooleanFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Row Join Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A RowCreationApproach which describes how single rows are created by joining single rows from 2 source cubes according to a join condition
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link row_transformation_logic.RowJoinFunction#getJoinFunction <em>Join Function</em>}</li>
 * </ul>
 *
 * @see row_transformation_logic.Row_transformation_logicPackage#getRowJoinFunction()
 * @model extendedMetaData="name='RowJoinFunction' kind='elementOnly'"
 * @generated
 */
public interface RowJoinFunction extends RowCreationApproach {
	/**
	 * Returns the value of the '<em><b>Join Function</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The function that defines the join condition
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Join Function</em>' containment reference.
	 * @see #setJoinFunction(BooleanFunction)
	 * @see row_transformation_logic.Row_transformation_logicPackage#getRowJoinFunction_JoinFunction()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='joinFunction'"
	 * @generated
	 */
	BooleanFunction getJoinFunction();

	/**
	 * Sets the value of the '{@link row_transformation_logic.RowJoinFunction#getJoinFunction <em>Join Function</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Function</em>' containment reference.
	 * @see #getJoinFunction()
	 * @generated
	 */
	void setJoinFunction(BooleanFunction value);

} // RowJoinFunction
