/**
 */
package org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.Ecore_plus_logicFactory;
import org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.Ecore_plus_logicPackage;
import org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.Function;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.efbt.cocalimo.computation.model.ecore_plus_logic.Function} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class FunctionItemProvider extends ParameterItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionItemProvider(AdapterFactory adapterFactory) {
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

			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Function_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Function_name_feature", "_UI_Function_type"),
				 Ecore_plus_logicPackage.Literals.FUNCTION__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS);
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
	 * This returns Function.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Function"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Function)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Function_type") :
			getString("_UI_Function_type") + " " + label;
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

		switch (notification.getFeatureID(Function.class)) {
			case Ecore_plus_logicPackage.FUNCTION__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Ecore_plus_logicPackage.FUNCTION__PARAMETERS:
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
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createAggregateFunction()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createBasicFunction()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createBooleanFunction()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createMemberParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createValueParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createFeatureParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createProxyFeatureParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Ecore_plus_logicPackage.Literals.FUNCTION__PARAMETERS,
				 Ecore_plus_logicFactory.eINSTANCE.createProxyAttributeFromEntityParameter()));
	}

}
