package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

/**
 * Instances of this are able to convert a given String representing a path
 * inside a library to an instance of {@link LibraryPath}.
 *
 * @author mfreund
 */
@FunctionalInterface
public interface LibraryPathParser {

	/**
	 * Convert the given String representation of a <em>path</em> inside a
	 * library to an instance of {@link LibraryPath}.
	 *
	 * @param path
	 *            The String representation of a path inside a library.
	 * @return A corresponding {@link LibraryPath}.
	 */
	public LibraryPath parse(String path);

}
