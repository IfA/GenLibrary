package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;

public interface LibraryContext {

	public boolean isValid(LibraryEntry entry, List<String> resources);

	/**
	 * This applies the given metadata to a given library item. Implementations
	 * of this function have to take the different mappers into account and are
	 * responsible for correctly inserting the library item into the target
	 * model.
	 * 
	 * @param targetModel
	 *            The target model into that the given library item shall be
	 *            inserted.
	 * @param libraryItem
	 *            The library item to be inserted.
	 * @param metaData
	 *            The metadata to apply.
	 * @param path
	 *            The classpath of the library item.
	 */
	public LibraryItem applyMetaData(EObject targetModel, LibraryItem libraryitem, MetaData metadata, String path);

	public MetaData transformMetaData(LibraryItem libraryitem, MetaData metadata);

	public void init();

	public MetaData getNewMetaData();

}