package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;

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
}
