package de.tud.et.ifa.agtele.genlibrary.processor.impl;

import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPath;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;

/**
 * This class represents a default implementation of the
 * {@link LibraryPathParser} interface that should be sufficient for most
 * applications.
 * 
 * @author mfreund
 *
 */
public class DefaultLibraryPathParser implements LibraryPathParser {

	/**
	 * This default implementation of the
	 * {@link LibraryPathParser#parse(String)} method returns a
	 * {@link LibraryPathImpl} for the given <em>path</em>.
	 */
	@Override
	public LibraryPath parse(String path) {
		return new LibraryPathImpl(path);
	}

}
