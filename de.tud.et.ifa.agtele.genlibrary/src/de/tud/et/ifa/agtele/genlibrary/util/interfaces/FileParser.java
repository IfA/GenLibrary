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
