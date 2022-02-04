/**
 */
package org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.Ecore_plus_logicFactory;
import org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.Ecore_plus_logicPackage;
import org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.RowCreationApproach;

import org.eclipse.efbt.cocalimo.computation.model.ecore_plus_structure.Ecore_plus_structureFactory;

import org.eclipse.efbt.cocalimo.computation.model.ecore_plus_structure.provider.Ecore_plusEditPlugin;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.provider.EOperationItemProvider;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.RowCreationApproach} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RowCreationApproachItemProvider extends EOperationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RowCreationApproachItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Ecore_plus_logicPackage.Literals.ROW_CREATION_APPROACH__CREATED_CUBE_COLUMNS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns RowCreationApproach.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RowCreationApproach"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((RowCreationApproach)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_RowCreationApproach_type") :
			getString("_UI_RowCreationApproach_type") + " " + label;
	}


	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(RowCreationApproach.class)) {
			case Ecore_plus_logicPackage.ROW_CREATION_APPROACH__CREATED_CUBE_COLUMNS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createBasicOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createBooleanOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createMemberParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createEntityParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createValueParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createBasicScenarioOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createFeatureParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createOperationParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createProxyOperationParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createAggregateOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createEntityFromSourceOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createAttributeFromEntityOperation()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createCellsParameter()));

		newChildDescriptors.add
			(createChildParameter
				(EcorePackage.Literals.EOPERATION__EPARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createBasicOperationScenarioSet()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.ROW_CREATION_APPROACH__CREATED_CUBE_COLUMNS,
				 Ecore_plus_structureFactory.eINSTANCE.createBaseEntityFeature()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.ROW_CREATION_APPROACH__CREATED_CUBE_COLUMNS,
				 EcoreFactory.eINSTANCE.createEAttribute()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == EcorePackage.Literals.ETYPED_ELEMENT__EGENERIC_TYPE ||
			childFeature == EcorePackage.Literals.EOPERATION__EGENERIC_EXCEPTIONS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Ecore_plusEditPlugin.INSTANCE;
	}

}