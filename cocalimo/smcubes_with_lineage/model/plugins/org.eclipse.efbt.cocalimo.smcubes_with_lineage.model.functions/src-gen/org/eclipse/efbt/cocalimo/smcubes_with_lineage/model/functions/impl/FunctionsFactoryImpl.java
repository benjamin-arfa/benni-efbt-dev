/**
 */
package org.eclipse.efbt.cocalimo.smcubes_with_lineage.model.functions.impl;

import org.eclipse.efbt.cocalimo.smcubes_with_lineage.model.functions.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionsFactoryImpl extends EFactoryImpl implements FunctionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FunctionsFactory init() {
		try {
			FunctionsFactory theFunctionsFactory = (FunctionsFactory)EPackage.Registry.INSTANCE.getEFactory(FunctionsPackage.eNS_URI);
			if (theFunctionsFactory != null) {
				return theFunctionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FunctionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FunctionsPackage.AGGREGATE_FUNCTION: return createAggregateFunction();
			case FunctionsPackage.AGGREGATE_FUNCTION_SPEC: return createAggregateFunctionSpec();
			case FunctionsPackage.BASIC_FUNCTION: return createBasicFunction();
			case FunctionsPackage.BASIC_FUNCTION_SPEC: return createBasicFunctionSpec();
			case FunctionsPackage.BOOLEAN_FUNCTION: return createBooleanFunction();
			case FunctionsPackage.FUNCTION: return createFunction();
			case FunctionsPackage.FUNCTION_SPEC: return createFunctionSpec();
			case FunctionsPackage.FUNCTION_SPEC_MODULE: return createFunctionSpecModule();
			case FunctionsPackage.PARAMATER_SPEC: return createParamaterSpec();
			case FunctionsPackage.PARAMETER: return createParameter();
			case FunctionsPackage.GET_STRUCT_COLUMN_FUNCTION: return createGetStructColumnFunction();
			case FunctionsPackage.SPECULATIVE_STRUCT_COLUMN_PARAMETER: return createSpeculativeStructColumnParameter();
			case FunctionsPackage.AGGREGATE_COLUMN_FUNCTION: return createAggregateColumnFunction();
			case FunctionsPackage.BASIC_COLUMN_FUNCTION: return createBasicColumnFunction();
			case FunctionsPackage.COLUMN_FUNCTION: return createColumnFunction();
			case FunctionsPackage.COLUMN_FUNCTION_GROUP: return createColumnFunctionGroup();
			case FunctionsPackage.CUBE_COLUMN: return createCubeColumn();
			case FunctionsPackage.SPECULATIVE_CUBE_COLUMN_PARAMETER: return createSpeculativeCubeColumnParameter();
			case FunctionsPackage.MEMBER_PARAMETER: return createMemberParameter();
			case FunctionsPackage.VALUE_PARAMETER: return createValueParameter();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateFunction createAggregateFunction() {
		AggregateFunctionImpl aggregateFunction = new AggregateFunctionImpl();
		return aggregateFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateFunctionSpec createAggregateFunctionSpec() {
		AggregateFunctionSpecImpl aggregateFunctionSpec = new AggregateFunctionSpecImpl();
		return aggregateFunctionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunction createBasicFunction() {
		BasicFunctionImpl basicFunction = new BasicFunctionImpl();
		return basicFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicFunctionSpec createBasicFunctionSpec() {
		BasicFunctionSpecImpl basicFunctionSpec = new BasicFunctionSpecImpl();
		return basicFunctionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanFunction createBooleanFunction() {
		BooleanFunctionImpl booleanFunction = new BooleanFunctionImpl();
		return booleanFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionSpec createFunctionSpec() {
		FunctionSpecImpl functionSpec = new FunctionSpecImpl();
		return functionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionSpecModule createFunctionSpecModule() {
		FunctionSpecModuleImpl functionSpecModule = new FunctionSpecModuleImpl();
		return functionSpecModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParamaterSpec createParamaterSpec() {
		ParamaterSpecImpl paramaterSpec = new ParamaterSpecImpl();
		return paramaterSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GetStructColumnFunction createGetStructColumnFunction() {
		GetStructColumnFunctionImpl getStructColumnFunction = new GetStructColumnFunctionImpl();
		return getStructColumnFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpeculativeStructColumnParameter createSpeculativeStructColumnParameter() {
		SpeculativeStructColumnParameterImpl speculativeStructColumnParameter = new SpeculativeStructColumnParameterImpl();
		return speculativeStructColumnParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregateColumnFunction createAggregateColumnFunction() {
		AggregateColumnFunctionImpl aggregateColumnFunction = new AggregateColumnFunctionImpl();
		return aggregateColumnFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BasicColumnFunction createBasicColumnFunction() {
		BasicColumnFunctionImpl basicColumnFunction = new BasicColumnFunctionImpl();
		return basicColumnFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnFunction createColumnFunction() {
		ColumnFunctionImpl columnFunction = new ColumnFunctionImpl();
		return columnFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ColumnFunctionGroup createColumnFunctionGroup() {
		ColumnFunctionGroupImpl columnFunctionGroup = new ColumnFunctionGroupImpl();
		return columnFunctionGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CubeColumn createCubeColumn() {
		CubeColumnImpl cubeColumn = new CubeColumnImpl();
		return cubeColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpeculativeCubeColumnParameter createSpeculativeCubeColumnParameter() {
		SpeculativeCubeColumnParameterImpl speculativeCubeColumnParameter = new SpeculativeCubeColumnParameterImpl();
		return speculativeCubeColumnParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberParameter createMemberParameter() {
		MemberParameterImpl memberParameter = new MemberParameterImpl();
		return memberParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueParameter createValueParameter() {
		ValueParameterImpl valueParameter = new ValueParameterImpl();
		return valueParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionsPackage getFunctionsPackage() {
		return (FunctionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FunctionsPackage getPackage() {
		return FunctionsPackage.eINSTANCE;
	}

} //FunctionsFactoryImpl