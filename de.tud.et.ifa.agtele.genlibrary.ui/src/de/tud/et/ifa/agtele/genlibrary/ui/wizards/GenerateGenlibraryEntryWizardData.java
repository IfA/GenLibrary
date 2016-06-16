package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.osgi.framework.Bundle;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;

public class GenerateGenlibraryEntryWizardData {
	
	private LibraryContext libraryContext;
	private String targetModelPath;
	private String zipFilePath;
	private IPath sourceModelPath;
	private Bundle bundle = Platform.getBundle("de.tud.et.ifa.agtele.genlibrary.ui");
	private EObject eObject;
	private LibraryEntry libItemModel;
	private String version;
	private String author;
	private String description;
	private String thumbnail;
	private String libRelPath;
	private boolean overwriteZipEntry = false;

	public Bundle getBundle() {
		return bundle;
	}

	public EObject geteObject() {
		return eObject;
	}

	public GenerateGenlibraryEntryWizardData seteObject(EObject eObject) {
		this.eObject = eObject;
		
		return this;
	}

	public IPath getSourceModelPath() {
		return sourceModelPath;
	}

	public GenerateGenlibraryEntryWizardData setSourceModelPath(IPath sourceModelPath) {
		this.sourceModelPath = sourceModelPath;
		
		return this;
	}

	public LibraryEntry getLibItemModel() {
		return libItemModel;
	}

	public void setLibItemModel(LibraryEntry libItemModel) {
		this.libItemModel = libItemModel;
	}

	public String getTargetModelPath() {
		return targetModelPath;
	}

	public void setTargetModelPath(String targetModelPath) {
		this.targetModelPath = targetModelPath;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getZipFilePath() {
		return zipFilePath;
	}

	public void setZipFilePath(String zipFilePath) {
		this.zipFilePath = zipFilePath;
	}

	public String getLibRelPath() {
		return libRelPath;
	}

	public void setLibRelPath(String libPath) {
		this.libRelPath = libPath;
	}

	public boolean isOverwriteZipEntry() {
		return overwriteZipEntry;
	}

	public void setOverwriteZipEntry(boolean overwriteZipEntry) {
		this.overwriteZipEntry = overwriteZipEntry;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public LibraryContext getLibraryContext() {
		return libraryContext;
	}

	public void setLibraryContext(LibraryContext libraryContext) {
		this.libraryContext = libraryContext;
	}
}
