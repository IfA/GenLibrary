package de.tud.et.ifa.agtele.genlibrary.processor.impl;

import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPath;

public class LibraryPathImpl implements LibraryPath {

	/**
	 * The String representation of the path that this represents.
	 */
	private String path;

	/**
	 * This creates an instance based on the given <em>path</em>.
	 *
	 * @param path
	 *            A String representing a path inside a library. This needs to
	 *            be a relative path where the different parts are separated by
	 *            a '.' (e.g. 'my.path').
	 */
	public LibraryPathImpl(String path) {
		this.path = path;
	}

	@Override
	public String getPath() {
		return path;
	}

	@Override
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public boolean hasHigherPath() {

		if (path == null) {
			return false;
		}

		String[] parts = path.split("\\.");

		return parts.length > 1;

	}

	@Override
	public boolean toHigherPath() {

		if (!hasHigherPath()) {
			return false;
		}

		String newPath = path.substring(0, path.lastIndexOf("."));

		setPath(newPath);

		return true;

	}
}
