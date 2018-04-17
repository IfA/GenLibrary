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
