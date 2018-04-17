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
package de.tud.et.ifa.agtele.genlibrary.processor.impl;

import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPath;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;

/**
 * This class represents a default implementation of the
 * {@link LibraryPathParser} interface that should be sufficient for most
 * applications.
 * 
 * @author mfreund
 *
 */
public class DefaultLibraryPathParser implements LibraryPathParser {

	/**
	 * This default implementation of the
	 * {@link LibraryPathParser#parse(String)} method returns a
	 * {@link LibraryPathImpl} for the given <em>path</em>.
	 */
	@Override
	public LibraryPath parse(String path) {
		return new LibraryPathImpl(path);
	}

}
