package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

/**
 * This represents a path inside (!) a library.
 * 
 * @author mfreund
 */
public interface LibraryPath {

	/**
	 * Return a String representation of the path.
	 *
	 * @return A String representation for this LibraryPath.
	 */
	public String getPath();

	/**
	 * Set the String representation of this path.
	 *
	 * @param path
	 *            The String representation of this path to set.
	 */
	public void setPath(String path);

	/**
	 * Whether there is a <em>higher</em> (more abstract) path for this path.
	 *
	 * @return <em>true</em> if there is a higher (more abstract) path;
	 *         <em>false</em> otherwise.
	 */
	public boolean hasHigherPath();

}
