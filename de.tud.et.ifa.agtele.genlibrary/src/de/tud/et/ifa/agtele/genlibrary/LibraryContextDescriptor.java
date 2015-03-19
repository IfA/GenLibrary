package de.tud.et.ifa.agtele.genlibrary;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;

/**
 * This class represents a POJO for the description of a library context.
 * 
 * @author mfreund
 *
 */
public class LibraryContextDescriptor {

	/**
	 * This keeps track of the full path to the folder that holds the library to
	 * be used.
	 */
	private final String libraryPath;

	/**
	 * This is the public getter for the {@link #libraryPath} field.
	 * 
	 * @return The {@link #libraryPath}.
	 */
	public String getLibraryPath() {
		return libraryPath;
	}

	/**
	 * This keeps track of the concrete implementation of {@link LibraryContext}
	 * that shall be used to instantiate library entries.
	 */
	private final Class<LibraryContext> libraryContextClass;

	/**
	 * This is the public getter for the {@link #libraryContextClass} field.
	 * 
	 * @return The {@link #libraryContextClass}.
	 */
	public Class<LibraryContext> getLibraryContextClass() {
		return this.libraryContextClass;
	}

	/**
	 * This keeps track of the concrete implementation of
	 * {@link LibraryPathParser} that shall be used to parse classpaths of the
	 * library.
	 */
	private final Class<LibraryPathParser> libraryPathParserClass;

	/**
	 * This is the public getter for the {@link #libraryPathParserClass} field.
	 * 
	 * @return The {@link #libraryPathParserClass}.
	 */
	public Class<LibraryPathParser> getLibraryPathParserClass() {
		return this.libraryPathParserClass;
	}

	/**
	 * This is the public constructor for the library context.
	 * 
	 * @param libraryPath
	 *            The full path to the folder that holds the library to be used.
	 * @param libraryContextClass
	 *            The concrete implementation of {@link LibraryContext} that
	 *            shall be used to instantiate library entries.
	 * @param libraryPathParserClass
	 *            The concrete implementation of {@link LibraryPathParser} that
	 *            shall be used to parse classpaths of the library.
	 */
	public LibraryContextDescriptor(String libraryPath, Class<LibraryContext> libraryContextClass, Class<LibraryPathParser> libraryPathParserClass) {

		this.libraryPath = libraryPath;
		this.libraryContextClass = libraryContextClass;
		this.libraryPathParserClass = libraryPathParserClass;
	}

	/**
	 * This is the public constructor for the library context.
	 * 
	 * @param libraryPath
	 *            The full path to the folder that holds the library to be used.
	 * @param libraryBundle
	 *            The fully qualified name of the bundle (plug-in) that holds
	 *            the given libraryContextClass and libraryPathParserClass.
	 * @param libraryContextClass
	 *            The fully qualified name of the concrete implementation of
	 *            {@link LibraryContext} that shall be used to instantiate
	 *            library entries. If this is <em>null</em> or empty, the
	 *            {@link #libraryContextClass} will be set to <em>null</em>.
	 * @param libraryPathParserClass
	 *            The fully qualified name of the concrete implementation of
	 *            {@link LibraryPathParser} that shall be used to parse
	 *            classpaths of the library. If this is <em>null</em> or empty,
	 *            the {@link #libraryPathParserClass} will be set to
	 *            <em>null</em>.
	 * @throws RuntimeException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public LibraryContextDescriptor(String libraryPath, String libraryBundle, String libraryContextClass, String libraryPathParserClass) throws RuntimeException, ClassNotFoundException,
			ClassCastException {

		this.libraryPath = libraryPath;

		Bundle bundle = Platform.getBundle(libraryBundle);
		if (bundle == null) {
			throw new RuntimeException("Bundle '" + libraryBundle + "' cannot be resolved!");
		}
		if (libraryContextClass == null || libraryContextClass.isEmpty()) {
			this.libraryContextClass = null;
		} else {
			Class<?> contextClass = bundle.loadClass(libraryContextClass);
			this.libraryContextClass = (Class<LibraryContext>) contextClass.asSubclass(LibraryContext.class);
		}
		if (libraryPathParserClass == null || libraryPathParserClass.isEmpty()) {
			this.libraryPathParserClass = null;
		} else {
			Class<?> parserClass = bundle.loadClass(libraryPathParserClass);
			this.libraryPathParserClass = (Class<LibraryPathParser>) parserClass.asSubclass(LibraryPathParser.class);
		}
	}
}
