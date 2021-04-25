/**
 */
package org.eclipse.efbt.cocalimo.smcubes.model.program;

import org.eclipse.efbt.cocalimo.core.model.test.RegFunctionalityTest;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SM Cubes Reg Functionality Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.efbt.cocalimo.smcubes.model.program.SMCubesRegFunctionalityTest#getInputData <em>Input Data</em>}</li>
 *   <li>{@link org.eclipse.efbt.cocalimo.smcubes.model.program.SMCubesRegFunctionalityTest#getExpectedResults <em>Expected Results</em>}</li>
 * </ul>
 *
 * @see org.eclipse.efbt.cocalimo.smcubes.model.program.ProgramPackage#getSMCubesRegFunctionalityTest()
 * @model
 * @generated
 */
public interface SMCubesRegFunctionalityTest extends RegFunctionalityTest {
	/**
	 * Returns the value of the '<em><b>Input Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The input data
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Input Data</em>' containment reference.
	 * @see #setInputData(SMCubesTestInputData)
	 * @see org.eclipse.efbt.cocalimo.smcubes.model.program.ProgramPackage#getSMCubesRegFunctionalityTest_InputData()
	 * @model containment="true"
	 * @generated
	 */
	SMCubesTestInputData getInputData();

	/**
	 * Sets the value of the '{@link org.eclipse.efbt.cocalimo.smcubes.model.program.SMCubesRegFunctionalityTest#getInputData <em>Input Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Data</em>' containment reference.
	 * @see #getInputData()
	 * @generated
	 */
	void setInputData(SMCubesTestInputData value);

	/**
	 * Returns the value of the '<em><b>Expected Results</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The expected results
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Expected Results</em>' containment reference.
	 * @see #setExpectedResults(SMCubesReportResults)
	 * @see org.eclipse.efbt.cocalimo.smcubes.model.program.ProgramPackage#getSMCubesRegFunctionalityTest_ExpectedResults()
	 * @model containment="true"
	 * @generated
	 */
	SMCubesReportResults getExpectedResults();

	/**
	 * Sets the value of the '{@link org.eclipse.efbt.cocalimo.smcubes.model.program.SMCubesRegFunctionalityTest#getExpectedResults <em>Expected Results</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expected Results</em>' containment reference.
	 * @see #getExpectedResults()
	 * @generated
	 */
	void setExpectedResults(SMCubesReportResults value);

} // SMCubesRegFunctionalityTest
