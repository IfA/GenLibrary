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

	/**
	 * Convert this path to a <em>higher</em> (more abstract) path by moving up
	 * one level in the hierarchy.
	 * <p />
	 * Note: This will {@link #setPath(String) change} the path represented by
	 * this {@link LibraryPath}.
	 *
	 * @return <em>true</em> if there is a higher (more abstract) path and if
	 *         the path that this represents was {@link #setPath(String)
	 *         changed}; <em>false</em> otherwise.
	 */
	public boolean toHigherPath();

}
