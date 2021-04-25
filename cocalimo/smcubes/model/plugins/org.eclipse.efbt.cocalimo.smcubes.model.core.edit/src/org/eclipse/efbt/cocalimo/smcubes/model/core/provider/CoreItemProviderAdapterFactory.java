/**
 */
package org.eclipse.efbt.cocalimo.smcubes.model.core.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.efbt.cocalimo.smcubes.model.core.util.CoreAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreItemProviderAdapterFactory extends CoreAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.DOMAIN} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DOMAINItemProvider domainItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.DOMAIN}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDOMAINAdapter() {
		if (domainItemProvider == null) {
			domainItemProvider = new DOMAINItemProvider(this);
		}

		return domainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.FACET_COLLECTION} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FACET_COLLECTIONItemProvider faceT_COLLECTIONItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.FACET_COLLECTION}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFACET_COLLECTIONAdapter() {
		if (faceT_COLLECTIONItemProvider == null) {
			faceT_COLLECTIONItemProvider = new FACET_COLLECTIONItemProvider(this);
		}

		return faceT_COLLECTIONItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.FACET_ENUMERATION} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FACET_ENUMERATIONItemProvider faceT_ENUMERATIONItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.FACET_ENUMERATION}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFACET_ENUMERATIONAdapter() {
		if (faceT_ENUMERATIONItemProvider == null) {
			faceT_ENUMERATIONItemProvider = new FACET_ENUMERATIONItemProvider(this);
		}

		return faceT_ENUMERATIONItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.facet_type} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected facet_typeItemProvider facet_typeItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.facet_type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createfacet_typeAdapter() {
		if (facet_typeItemProvider == null) {
			facet_typeItemProvider = new facet_typeItemProvider(this);
		}

		return facet_typeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.MAINTENANCE_AGENCY} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MAINTENANCE_AGENCYItemProvider maintenancE_AGENCYItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.MAINTENANCE_AGENCY}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMAINTENANCE_AGENCYAdapter() {
		if (maintenancE_AGENCYItemProvider == null) {
			maintenancE_AGENCYItemProvider = new MAINTENANCE_AGENCYItemProvider(this);
		}

		return maintenancE_AGENCYItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.MEMBER} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MEMBERItemProvider memberItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.MEMBER}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMEMBERAdapter() {
		if (memberItemProvider == null) {
			memberItemProvider = new MEMBERItemProvider(this);
		}

		return memberItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.MEMBER_HIERARCHY} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MEMBER_HIERARCHYItemProvider membeR_HIERARCHYItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.MEMBER_HIERARCHY}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMEMBER_HIERARCHYAdapter() {
		if (membeR_HIERARCHYItemProvider == null) {
			membeR_HIERARCHYItemProvider = new MEMBER_HIERARCHYItemProvider(this);
		}

		return membeR_HIERARCHYItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.MEMBER_HIERARCHY_NODE} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MEMBER_HIERARCHY_NODEItemProvider membeR_HIERARCHY_NODEItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.MEMBER_HIERARCHY_NODE}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMEMBER_HIERARCHY_NODEAdapter() {
		if (membeR_HIERARCHY_NODEItemProvider == null) {
			membeR_HIERARCHY_NODEItemProvider = new MEMBER_HIERARCHY_NODEItemProvider(this);
		}

		return membeR_HIERARCHY_NODEItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.SUBDOMAIN} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SUBDOMAINItemProvider subdomainItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.SUBDOMAIN}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSUBDOMAINAdapter() {
		if (subdomainItemProvider == null) {
			subdomainItemProvider = new SUBDOMAINItemProvider(this);
		}

		return subdomainItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.SUBDOMAIN_ENUMERATION} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SUBDOMAIN_ENUMERATIONItemProvider subdomaiN_ENUMERATIONItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.SUBDOMAIN_ENUMERATION}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSUBDOMAIN_ENUMERATIONAdapter() {
		if (subdomaiN_ENUMERATIONItemProvider == null) {
			subdomaiN_ENUMERATIONItemProvider = new SUBDOMAIN_ENUMERATIONItemProvider(this);
		}

		return subdomaiN_ENUMERATIONItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.VARIABLE} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VARIABLEItemProvider variableItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.VARIABLE}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVARIABLEAdapter() {
		if (variableItemProvider == null) {
			variableItemProvider = new VARIABLEItemProvider(this);
		}

		return variableItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.VARIABLE_SET} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VARIABLE_SETItemProvider variablE_SETItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.VARIABLE_SET}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVARIABLE_SETAdapter() {
		if (variablE_SETItemProvider == null) {
			variablE_SETItemProvider = new VARIABLE_SETItemProvider(this);
		}

		return variablE_SETItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.eclipse.efbt.cocalimo.smcubes.model.core.VARIABLE_SET_ENUMERATION} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VARIABLE_SET_ENUMERATIONItemProvider variablE_SET_ENUMERATIONItemProvider;

	/**
	 * This creates an adapter for a {@link org.eclipse.efbt.cocalimo.smcubes.model.core.VARIABLE_SET_ENUMERATION}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVARIABLE_SET_ENUMERATIONAdapter() {
		if (variablE_SET_ENUMERATIONItemProvider == null) {
			variablE_SET_ENUMERATIONItemProvider = new VARIABLE_SET_ENUMERATIONItemProvider(this);
		}

		return variablE_SET_ENUMERATIONItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void dispose() {
		if (domainItemProvider != null) domainItemProvider.dispose();
		if (faceT_COLLECTIONItemProvider != null) faceT_COLLECTIONItemProvider.dispose();
		if (faceT_ENUMERATIONItemProvider != null) faceT_ENUMERATIONItemProvider.dispose();
		if (facet_typeItemProvider != null) facet_typeItemProvider.dispose();
		if (maintenancE_AGENCYItemProvider != null) maintenancE_AGENCYItemProvider.dispose();
		if (memberItemProvider != null) memberItemProvider.dispose();
		if (membeR_HIERARCHYItemProvider != null) membeR_HIERARCHYItemProvider.dispose();
		if (membeR_HIERARCHY_NODEItemProvider != null) membeR_HIERARCHY_NODEItemProvider.dispose();
		if (subdomainItemProvider != null) subdomainItemProvider.dispose();
		if (subdomaiN_ENUMERATIONItemProvider != null) subdomaiN_ENUMERATIONItemProvider.dispose();
		if (variableItemProvider != null) variableItemProvider.dispose();
		if (variablE_SETItemProvider != null) variablE_SETItemProvider.dispose();
		if (variablE_SET_ENUMERATIONItemProvider != null) variablE_SET_ENUMERATIONItemProvider.dispose();
	}

}
