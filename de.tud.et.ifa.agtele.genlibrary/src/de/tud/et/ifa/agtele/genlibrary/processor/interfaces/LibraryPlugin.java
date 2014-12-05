package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;

public interface LibraryPlugin {

	/**
	 * This initializes the library by setting the path to the library folder,
	 * the context of the library and the path parser of the library.
	 * Furthermore, it checks an existing/creates a new 'lib.xmi' file that
	 * holds the index of the contents of the library. \n This function has to
	 * be called once before using the library.
	 * 
	 * @param libpath
	 *            The absolute path of the library folder to be used.
	 * @param librarycontext
	 *            The context of the library providing method implementations
	 *            that are custom to the used genlib plugin.
	 * @param parser
	 *            The parser used for library paths.
	 */
	public void init(String libpath, LibraryContext librarycontext, LibraryPathParser parser);

	/**
	 * This function checks if an element exists in the library (resp. in its
	 * index).
	 * 
	 * @param path
	 *            The classpath for the library item to be checked.
	 * @param usehigher
	 *            Whether the algorithm shall check for alternative elements at
	 *            a higher (more abstract) level in the classpath.
	 * @return True if a library element has been found, false, otherwise.
	 */
	public boolean elementExists(String path, boolean usehigher);

	/**
	 * This returns the library item without evaluating the metadata.
	 * 
	 * @param path
	 *            The classpath for the library item to be checked.
	 * @param usehigher
	 *            Whether the algorithm shall check for alternative elements at
	 *            a higher (more abstract) level in the classpath.
	 * @return The library item.
	 */
	public LibraryItem getElement(String path, boolean usehigher);

	/**
	 * For a given library classpath, this returns the resulting path for which
	 * an actual item is found in the library. This is equal to repeatedly
	 * calling 'elementExists(path, false)' and moving to a higher (more
	 * abstract) level in the classpath each time until 'elementExists(...)'
	 * returns true. If no element can be determined along the classpath, this
	 * returns 'null'.
	 * 
	 * @param path
	 *            The classpath for that the resulting path shall be calculated.
	 * @return The resulting classpath; null if no resulting classpath could be
	 *         determined because no element has been found.
	 */
	public String getResultingElementLibraryPath(String path);

	/**
	 * This returns the library item after evaluating the metadata.
	 * 
	 * @param targetModel
	 *            The target model into that the library item shall be inserted.
	 * @param path
	 *            The classpath for the library item to be checked.
	 * @param usehigher
	 *            Whether the algorithm shall check for alternative elements at
	 *            a higher (more abstract) level in the classpath.
	 * @return The library item after evaluating the metadata.
	 */
	@Deprecated
	public LibraryItem getElement(EObject targetModel, String path, MetaData metadata, boolean usehigher);

	/**
	 * Returns the interfaces (the metadata) for a library element represented
	 * by a given classpath.
	 * 
	 * @param path
	 *            The classpath of the library item to be checked.
	 * @param usehigher
	 *            Whether the algorithm shall check for alternative elements at
	 *            a higher (more abstract) level in the classpath.
	 * @return The metadata for the library item if everything worked well, null
	 *         otherwise.
	 */
	public MetaData getMetaData(String path, boolean usehigher);

	/**
	 * Returns the selected List of {@link LibraryPath} as Strings.
	 * 
	 * @param start
	 *            Index beginning with 0, if smaller then 0 means 0
	 * @param count
	 *            smaller or equal 0 means all
	 * @return empty List if no LibraryPathes available or startIndex too big
	 */
	public List<String> getAllElementLibraryPathAsString(int startIndex, int count);

	public InputStream getResourceInputStream(String path, boolean usehigher, String resourcename) throws IOException;

	public boolean copyResourceTo(String path, boolean usehigher, String resourcename, String pathto);

	public List<String> getElementsResources(String path, boolean usehigher);

	/**
	 * This inserts the given library item into the given target model while
	 * taking the given metadata into account. This is done by calling the
	 * function 'insertIntoTargetModel(...)' of the library context passed in
	 * the 'init' function of the library plugin.
	 * 
	 * @param targetModel
	 *            The target model into that the given library item shall be
	 *            inserted.
	 * @param libraryItem
	 *            The library item to be inserted.
	 * @param metaData
	 *            The metadata to take into account while inserting the libary
	 *            item into the target model.
	 * @param path
	 *            The classpath of the library item.
	 */
	public void insertIntoTargetModel(EObject targetModel, LibraryItem libraryItem, MetaData metaData, String path);
}
