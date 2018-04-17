/*******************************************************************************
 * Copyright (C) 2018-2018 Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.tud.et.ifa.agtele.genlibrary;

import java.util.Arrays;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.tud.et.ifa.agtele.genlibrary.LibraryImplementationRegistry.DuplicateImplementationException;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The identifier for the 'genlibrary.implementation' extension point.
	 */
	private static final String GENLIBRARY_IMPLEMENTATION_EXTENSION_POINT = "de.tud.et.ifa.agtele.genlibrary.implementation";

	// The plug-in ID
	public static final String PLUGIN_ID = "de.tud.et.ifa.agtele.genlibrary"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.
	 * BundleContext )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		registerLibraryImplementations();
	}

	/**
	 * Register all concrete implementations of the GenLibrary that implement
	 * the extension point 'de.tud.et.ifa.agtele.genlibrary.provider' in the
	 * global {@link LibraryImplementationRegistry#getInstance()
	 * LibraryImplementationRegistry}.
	 */
	private void registerLibraryImplementations() {

		final IExtensionPoint point = RegistryFactory.getRegistry().getExtensionPoint(GENLIBRARY_IMPLEMENTATION_EXTENSION_POINT);

		if (point == null) {
			return;
		}

		IConfigurationElement[] elements = point.getConfigurationElements();

		Arrays.asList(elements).stream().forEach(this::registerLibraryImplementation);

	}

	/**
	 * Register a concrete implementations of the GenLibrary that implements the
	 * extension point 'de.tud.et.ifa.agtele.genlibrary.provider' in the global
	 * {@link LibraryImplementationRegistry#getInstance()
	 * LibraryImplementationRegistry}.
	 * 
	 * @param element
	 *            An {@link IConfigurationElement} for the extension point
	 *            'de.tud.et.ifa.agtele.genlibrary.provider'.
	 */
	@SuppressWarnings("unchecked")
	private void registerLibraryImplementation(IConfigurationElement element) {

		String ePackageURI = element.getAttribute("ePackageURI");

		if (ePackageURI == null) {
			System.out.println("Error evaluating extension for extension point 'de.tud.et.ifa.agtele.genlibrary.provider': Attribute 'ePackageURI' not found!");
			return;
		}

		LibraryContext context = null;
		try {
			Object o = element.createExecutableExtension("context");
			if (o instanceof LibraryContext) {
				context = (LibraryContext) o;
			}
		} catch (CoreException e) {
			System.out.println("Error evaluating extension for extension point 'de.tud.et.ifa.agtele.genlibrary.provider': Attribute 'context' not found!");
			return;
		}

		LibraryPathParser parser = null;
		try {
			Object o = element.createExecutableExtension("parser");
			if (o instanceof LibraryPathParser) {
				parser = (LibraryPathParser) o;
			}
		} catch (CoreException e) {
			System.out.println("Error evaluating extension for extension point 'de.tud.et.ifa.agtele.genlibrary.provider': Attribute 'parser' not found!");
			return;
		}

		String liraryItemClass = element.getAttribute("libraryItemType");
		if (liraryItemClass == null) {
			System.out.println("Error evaluating extension for extension point 'de.tud.et.ifa.agtele.genlibrary.provider': Attribute 'parser' not found!");
			return;
		}

		try {
			LibraryImplementationRegistry.getInstance().registerImplementation(ePackageURI, context, parser, liraryItemClass);
		} catch (DuplicateImplementationException e) {
			if (e.getExistingContext() != null) {
				System.out.println("Cannot register two separate LibraryContext implementations for the namespace URI '" + ePackageURI + "'!");
			} else {
				System.out.println("Cannot register two separate LibraryPathParser implementations for the namespace URI '" + ePackageURI + "'!");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.
	 * BundleContext )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
