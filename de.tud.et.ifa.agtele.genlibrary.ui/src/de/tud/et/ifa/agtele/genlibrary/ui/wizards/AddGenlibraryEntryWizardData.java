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
package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;

public class AddGenlibraryEntryWizardData {
	private Bundle bundle = Platform.getBundle("de.tud.et.ifa.agtele.genlibrary.ui");
	private EObject eObject;
	private String libPath;
	private LibraryContext libraryContext;
	private LibraryPathParser libraryPathParser;
	private LibraryPluginImpl library;
	private LibraryEntry libEntry;
	private String classPath;
	
	public Bundle getBundle() {
		return bundle;
	}

	public EObject geteObject() {
		return eObject;
	}

	public AddGenlibraryEntryWizardData seteObject(EObject eObject) {
		this.eObject = eObject;
		
		return this;
	}

	public String getLibPath() {
		return libPath;
	}

	public AddGenlibraryEntryWizardData setLibPath(String libPath) {
		this.libPath = libPath;
		
		return this;
	}

	public LibraryContext getLibraryContext() {
		return libraryContext;
	}

	public AddGenlibraryEntryWizardData setLibraryContext(LibraryContext libraryContext) {
		this.libraryContext = libraryContext;
		
		return this;
	}

	public LibraryPathParser getLibraryPathParser() {
		return libraryPathParser;
	}

	public AddGenlibraryEntryWizardData setLibraryPathParser(LibraryPathParser libraryPathParser) {
		this.libraryPathParser = libraryPathParser;
		
		return this;
	}

	public LibraryPluginImpl getLibrary() {
		return library;
	}

	public LibraryPluginImpl setLibrary(LibraryPluginImpl library) {
		this.library = library;
		
		return this.library;
	}

	public LibraryEntry getLibEntry() {
		return libEntry;
	}

	public LibraryEntry setLibEntry(LibraryEntry libEntry) {
		this.libEntry = libEntry;
		
		return libEntry;
	}

	public String getClassPath() {
		return this.classPath;
	}
	
	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}
}
