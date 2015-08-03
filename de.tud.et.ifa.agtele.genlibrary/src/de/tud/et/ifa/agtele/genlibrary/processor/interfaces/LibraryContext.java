package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter;

public interface LibraryContext {

	/**
	 * This method is called once during the initialization of the library
	 * plugin. Special initialization routines (e.g. for package loading) should
	 * be placed here.
	 */
	public void init();

	/**
	 * This method is called once for every library element during the
	 * initialization of the library plugin for a given library path. This
	 * checks if a given library entry is consistent. Implementations should
	 * check if all resources that are to be copied during the insertion of the
	 * item exist under the given path.
	 * 
	 * @param entry
	 *            The library entry to be inserted into the model later on.
	 * @param resources
	 *            The list of resources to be checked.
	 * @return True if the library entry is valid, false otherwise.
	 */
	public boolean isValid(LibraryEntry entry, List<String> resources);

	/**
	 * This applies the parameters to a library item that are both part of a
	 * library entry. Implementations of this function have to take the
	 * different parameters into account and are responsible for correctly
	 * inserting the library item into the target model.
	 * 
	 * @param targetModel
	 *            The target model into that the given library item shall be
	 *            inserted.
	 * @param libraryEntry
	 *            The library entry containing the meta data to be applied and
	 *            the library item referenced by the parameters.
	 * @param path
	 *            The classpath of the library item.
	 */
	public void applyParameters(EObject targetModel, LibraryEntry entry, String path);

	/**
	 * This method is called before 'applyParameters' and should be used to add
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
	public ParameterDescription transformMetaData(LibraryItem libraryitem, ParameterDescription metadata);

	@Deprecated
	public ParameterDescription getNewMetaData();

	/**
	 * This returns a default value for the path where all resource that are
	 * referenced by a {@link ResourceParameter} shall be stored.
	 * 
	 * @param resourcePathInsideLibrary
	 *            The path inside a library to the file for which the path shall
	 *            be returned.
	 * @return A relative path where the resource shall be stored.
	 */
	public String getDefaultResourcePath(String resourcePathInsideLibrary);

}