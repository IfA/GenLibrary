package de.tud.et.ifa.agtele.movisa.library.utilities.impl;

public class KeyGenerator {

	private static final String PATH_SEPARATOR_FILE_WINDOWS = "\\";
	private static final String PATH_SEPARATOR_FOLDER_LINUX = "/";
	public static final String PATH_SEPARATOR_LIB_CLASS = ".";

	public static String generateKey(String foldername) {
		String tmp = foldername.replace(PATH_SEPARATOR_FOLDER_LINUX, PATH_SEPARATOR_LIB_CLASS).replace(PATH_SEPARATOR_FILE_WINDOWS, PATH_SEPARATOR_LIB_CLASS);

		if (tmp.endsWith(PATH_SEPARATOR_LIB_CLASS)) {
			return tmp.substring(0, tmp.length() - 1);
		}
		return tmp;
	}

}
