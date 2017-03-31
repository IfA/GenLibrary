package de.tud.et.ifa.agtele.genlibrary.util.interfaces;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item;

public interface FileParser {

	/**
	 * This returns the library entries inside a library (represented by a
	 * Zip/Jar file).
	 * 
	 * @param file
	 *            A path pointing to a library file (Zip/Jar).
	 * @return A list of entries inside the library.
	 * @throws IOException
	 */
	public List<LibraryFileEntry> parseFile(Path file) throws IOException;

	public LibraryFileEntry parseFile(Item item) throws IOException;

}
