package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

/**
 * This represents a path inside (!) a library.
 * 
 * @author mfreund
 */
public interface LibraryPath {

	public String getPath();

	public void setPath(String path);

	public int toHigherPath();

}
