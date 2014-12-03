package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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

	public String getResultingElementLibraryPath(String path);

	/**
	 * This returns the library item after evaluating the metadata.
	 * 
	 * @param path
	 *            The classpath for the library item to be checked.
	 * @param usehigher
	 *            Whether the algorithm shall check for alternative elements at
	 *            a higher (more abstract) level in the classpath.
	 * @return The library item after evaluating the metadata.
	 */
	public LibraryItem getElement(String path, MetaData metadata, boolean usehigher);

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
}
