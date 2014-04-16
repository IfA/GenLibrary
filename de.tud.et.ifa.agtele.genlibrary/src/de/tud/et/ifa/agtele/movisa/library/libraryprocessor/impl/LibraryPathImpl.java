package de.tud.et.ifa.agtele.movisa.library.libraryprocessor.impl;

import de.tud.et.ifa.agtele.movisa.library.libraryprocessor.interfaces.LibraryPath;

public class LibraryPathImpl implements LibraryPath {

	private String path;

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
	public int toHigherPath() {
		int result = 0;
		if (path != null) {
			String[] parts = path.split("\\.");
			if (parts.length > 0) {
				String tmp = "";
				for (int i = 0; i < parts.length - 1; i++) {
					if (tmp.length() != 0) {
						tmp += ".";
					}
					tmp += parts[i];
				}
				path = tmp;

				result = tmp.split("\\.").length;
				if (tmp.length() == 0) {
					result = 0;
				}
			}
		}
		return result;
	}
}
