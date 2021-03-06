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

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.FileParser;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;

public class FileParserImpl implements FileParser {

	@Override
	public List<LibraryFileEntry> parseFile(Path file) throws IOException {
		List<LibraryFileEntry> result = new ArrayList<LibraryFileEntry>();

		ZipFile zip = new ZipFile(file.toString());
		@SuppressWarnings("unchecked")
		ArrayList<ZipEntry> zipentries = (ArrayList<ZipEntry>) Collections.list(zip.entries());

		for (ZipEntry zipentry : zipentries) {
			if (!zipentry.isDirectory() && zipentry.getName().endsWith(LibraryFileEntry.XMI_FILENAME)) {
				result.add(getLibraryFileEntry(zip, zipentries, zipentry));
			}
		}
		return result;
	}

	@Override
	public LibraryFileEntry parseFile(Item item) throws IOException {
		ZipFile zip = new ZipFile(item.getPath());
		@SuppressWarnings("unchecked")
		ArrayList<ZipEntry> zipentries = (ArrayList<ZipEntry>) Collections.list(zip.entries());

		for (ZipEntry zipentry : zipentries) {
			if (!zipentry.isDirectory() && zipentry.getName().endsWith(LibraryFileEntry.XMI_FILENAME)) {
				String entryaskey = KeyGenerator.generateKey(zipentry.getName().replace(LibraryFileEntry.XMI_FILENAME, ""));
				if (entryaskey.equals(item.getKey())) {
					return getLibraryFileEntry(zip, zipentries, zipentry);
				}
			}
		}
		zip.close();
		return null;
	}

	private LibraryFileEntry getLibraryFileEntry(ZipFile zip, ArrayList<ZipEntry> zipentries, ZipEntry zipentry) {
		String entryName;
		LibraryFileEntry libraryfileentry = new LibraryFileEntryZip();
		libraryfileentry.setFile(zip);

		// replace \ with / in order to also work in some weird windows
		// situations, e.g., in the amino-ui editor
		String parent = getParent(zipentry.getName().replace("\\", "/"));
		libraryfileentry.setKey(KeyGenerator.generateKey(parent));

		List<ZipEntry> zipentrylist = new ArrayList<ZipEntry>();
		for (ZipEntry ze : zipentries) {
			entryName = ze.getName().replace("\\", "/");
			if (getParent(entryName).equals(parent) && !ze.isDirectory()) {
				zipentrylist.add(ze);
			} else if ((entryName.contains("/_files/")) && !ze.isDirectory()) {
				if (entryName.substring(0, entryName.indexOf("/_files/")).equals(parent)) {
					zipentrylist.add(ze);
				}
			}
		}
		libraryfileentry.setEntries(zipentrylist);
		return libraryfileentry;
	}

	private String getParent(String zipentryname) {
		int pos = zipentryname.lastIndexOf("/");

		if (pos < 0) {
			return "";
		}
		return zipentryname.substring(0, pos);
	}

}
