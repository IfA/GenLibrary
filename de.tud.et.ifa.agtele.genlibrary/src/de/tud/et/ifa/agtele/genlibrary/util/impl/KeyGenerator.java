/*******************************************************************************
 * Copyright (C) 2018-2018 Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.tud.et.ifa.agtele.genlibrary.util.impl;

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
