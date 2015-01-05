package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;

public interface LibraryContext {

	public boolean isValid(LibraryEntry entry, List<String> resources);

	/**
	 * This applies the metadata to a library item that are both part of a
	 * library entry. Implementations of this function have to take the
	 * different mappers into account and are responsible for correctly
	 * inserting the library item into the target model.
	 * 
	 * @param targetModel
	 *            The target model into that the given library item shall be
	 *            inserted.
	 * @param libraryEntry
	 *            The library entry containing the meta data to be applied and
	 *            the library item referenced by the metadata.
	 * @param path
	 *            The classpath of the library item.
	 */
	public void applyMetaData(EObject targetModel, LibraryEntry entry, String path);

	/**
	 * This method is called before 'applyMetaData' and should be used to add
	 * elements to the target model that are not covered by the meta data.
	 * 
	 * @param targetModel
	 *            The target model into that elements from the library entry
	 *            shall be inserted.
	 * @param libraryEntry
	 *            The library entry containing the elements to be inserted.
	 * @param path
	 *            The classpath of the library entry.
	 */
	public void defaultInsertIntoTargetModel(EObject targetModel, LibraryEntry libraryEntry, String path);

	@Deprecated
	public MetaData transformMetaData(LibraryItem libraryitem, MetaData metadata);

	/**
	 * 
	 */
	public void init();

	@Deprecated
	public MetaData getNewMetaData();

}