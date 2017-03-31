package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;

/**
 * This represents one concrete runtime instance of a GenLibrary implementation
 * that uses a certain {@link LibraryContext} and a certain
 * {@link LibraryPathParser}.
 * <p />
 * It can manage the contents of one or multiple libraries identified via their
 * <em>libPath</em>.
 * 
 * @author mfreund
 */
public interface LibraryPlugin {

	/**
	 * This performs a basic initialization of the library by setting the
	 * {@link LibraryContext} of the library and its {@link LibraryPathParser}.
	 * <p />
	 * Note: This or {@link #init(String, LibraryContext, LibraryPathParser)}
	 * needs to be called before any useful interaction with the library is
	 * possible.
	 * <p />
	 * Note: Before elements can be retrieved, at least one library needs to be
	 * registered (e.g. via {@link #setLibPath(String)} or
	 * {@link #addLibPath(String)}).
	 * 
	 * @param librarycontext
	 *            The context of the library providing method implementations
	 *            that are custom to the used genlib plugin.
	 * @param parser
	 *            The parser used for library paths.
	 * 
	 * @see #init(String, LibraryContext, LibraryPathParser)
	 */
	public void init(LibraryContext librarycontext, LibraryPathParser parser);

	/**
	 * This performs a complete initialization of the library by
	 * {@link #setLibPath(String)} a library path to be used, the
	 * {@link LibraryContext} of the library and its {@link LibraryPathParser}.
	 * <p />
	 * Note: This or {@link #init(String, LibraryContext, LibraryPathParser)}
	 * needs to be called before any useful interaction with the library is
	 * possible.
	 * 
	 * A call to this function is equal to subsequent calls of
	 * {@link #init(LibraryContext, LibraryPathParser)} and
	 * {@link #setLibPath(String)}.
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
	 * This sets the active path to the library folder. In contrast to
	 * {@link #addLibPath(String)}, this will delete all other active paths.
	 * <p />
	 * Furthermore, it checks an existing/creates a new 'lib.xmi' file that
	 * holds the index of the contents of the library.</br>
	 * </br>
	 * 
	 * @param libpath
	 *            The absolute path of the library folder to be used.
	 * 
	 * @see #setLibPaths(List)
	 * @see #addLibPath(String)
	 * @see #addLibPaths(List)
	 */
	public void setLibPath(String libpath);

	/**
	 * This sets the active paths to the library folders. In contrast to
	 * {@link #addLibPath(String)}, this will delete all other active paths.
	 * <p />
	 * Furthermore, it checks an existing/creates a new 'lib.xmi' file that
	 * holds the index of the contents of the library.</br>
	 * </br>
	 * 
	 * @param libpaths
	 *            The list of absolute paths of the library folders to be used.
	 * 
	 * @see #setLibPath(String)
	 * @see #addLibPath(String)
	 * @see #addLibPaths(List)
	 */
	public void setLibPaths(List<String> libpaths);

	/**
	 * This adds an active path to a library folder. In contrast to
	 * {@link #setLibPath(String)}, this does not delete all other paths.
	 * <p />
	 * Furthermore, it checks an existing/creates a new 'lib.xmi' file that
	 * holds the index of the contents of the library.</br>
	 * </br>
	 * 
	 * @param libpath
	 *            The absolute path of the library folder to be added.
	 * 
	 * @see #setLibPath(String)
	 * @see #setLibPaths(List)
	 * @see #addLibPaths(List)
	 */
	public void addLibPath(String libpath);

	/**
	 * This adds a list of active paths to a library folder. In contrast to
	 * {@link #setLibPaths(List)}, this does not delete all other paths.
	 * <p />
	 * Furthermore, it checks an existing/creates a new 'lib.xmi' file that
	 * holds the index of the contents of the library.</br>
	 * </br>
	 * 
	 * @param libpaths
	 *            The list of absolute paths of the library folders to be added.
	 * 
	 * @see #setLibPath(String)
	 * @see #setLibPaths(List)
	 * @see #addLibPath(String)
	 */
	public void addLibPaths(List<String> libpaths);

	/**
	 * This function checks if an element exists in the libraries currently
	 * managed by this plugin.
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
	 * This returns the library entry without evaluating the Parameters.
	 * 
	 * @param path
	 *            The classpath for the library entry to be checked.
	 * @param usehigher
	 *            Whether the algorithm shall check for alternative elements at
	 *            a higher (more abstract) level in the classpath.
	 * @return The library entry.
	 */
	public LibraryEntry getElement(String path, boolean usehigher);

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
	 * Returns the selected List of {@link LibraryPath} as Strings.
	 * 
	 * @param startIndex
	 *            Index beginning with 0, if smaller then 0 means 0
	 * @param count
	 *            smaller or equal 0 means all
	 * @return empty List if no LibraryPathes available or startIndex too big
	 */
	public List<String> getAllElementLibraryPathAsString(int startIndex, int count);

	/**
	 * Returns an {@link InputStream} of a resource contained in a library
	 * entry.
	 * 
	 * @param path
	 *            classpath of the {@link LibraryEntry} the resource is
	 *            contained in
	 * @param usehigher
	 *            determines whether the algorithm shall check for alternative
	 *            elements at a higher (more abstract) level in the classpath.
	 * @param resourcename
	 *            name of the desired resource
	 * @return {@link InputStream} of the resource
	 * @throws IOException
	 */
	public InputStream getResourceInputStream(String path, boolean usehigher, String resourcename) throws IOException;

	/**
	 * This inserts the given library item into the given target model while
	 * taking the given Parameters into account. This is done by calling the
	 * function 'insertIntoTargetModel(...)' of the library context passed in
	 * the 'init' function of the library plugin.
	 * 
	 * @param targetModel
	 *            The target model into that the given library item shall be
	 *            inserted.
	 * @param libraryEntry
	 *            The library entry that includes the libary item to be inserted
	 *            into the target model and the Parameters that shall be taken
	 *            into account.
	 * @param path
	 *            The classpath of the library item.
	 */
	public void insertIntoTargetModel(EObject targetModel, LibraryEntry libraryEntry, String path);
}
