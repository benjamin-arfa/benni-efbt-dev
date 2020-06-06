package org.eclipse.efbt.aorta.component.exporter;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.xtext.resource.IResourceFactory;

/**
 * @author Neil Mackenzie
 *
 */
@SuppressWarnings("restriction")
public class FreeBirdToolsResourceFactory extends XMLResourceFactoryImpl implements IResourceFactory {


	/**
	 * Creates an instance of the resource. we set the defaultSaveOptions
	 * and defaultLoadOptions also to be the sam as we use elsewhere.
	 * 
	 * 
	 */
	@Override
	public Resource createResource(URI uri) {
		XMLResource result = (XMLResource) super.createResource(uri);
		result.getDefaultSaveOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		result.getDefaultLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);

		result.getDefaultSaveOptions().put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);

		result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
		result.getDefaultSaveOptions().put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);

		result.getDefaultLoadOptions().put(XMLResource.OPTION_USE_LEXICAL_HANDLER, Boolean.TRUE);
		return result;
	}
}
