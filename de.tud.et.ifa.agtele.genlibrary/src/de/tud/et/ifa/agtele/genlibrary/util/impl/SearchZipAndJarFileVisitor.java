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

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class SearchZipAndJarFileVisitor extends SimpleFileVisitor<Path> {

	private final List<Path> resources;

	public SearchZipAndJarFileVisitor(List<Path> resources) {
		this.resources = resources;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		String tmp = file.toString();
		tmp = tmp.substring(tmp.length() - 4);
		tmp = tmp.toLowerCase();
		if (tmp.endsWith("zip") || tmp.endsWith("jar")) {
			resources.add(file);
		}
		return FileVisitResult.CONTINUE;
	}

}
