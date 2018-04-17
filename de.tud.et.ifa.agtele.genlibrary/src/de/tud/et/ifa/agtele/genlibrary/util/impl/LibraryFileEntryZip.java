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
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;

public class LibraryFileEntryZip implements LibraryFileEntry {

	private ZipFile file;

	private List<ZipEntry> entries;

	private String key;

	public LibraryFileEntryZip(ZipFile file, List<ZipEntry> entries, String key) {
		super();
		this.file = file;
		this.entries = entries;
		this.key = key;
	}

	public LibraryFileEntryZip() {
	}

	@Override
	public InputStream getXMIFileAsInputStream() throws IOException {
		for (ZipEntry entry : entries) {
			if (entry.getName().endsWith(XMI_FILENAME)) {
				return file.getInputStream(entry);
			}
		}
		return null;
	}

	@Override
	public List<String> getResourceNameList() throws IOException {
		List<String> result = new ArrayList<String>();
		for (ZipEntry entry : entries) {
			if (!entry.getName().endsWith(XMI_FILENAME)) {
				result.add(entry.getName());
			}
		}
		return result;
	}

	@Override
	public InputStream getResourceFileAsInputStream(String name) throws IOException {
		for (ZipEntry entry : entries) {
			if (entry.getName().equals(name)) {
				return file.getInputStream(entry);
			}
		}
		return null;
	}

	@Override
	public ZipFile getFile() {
		return file;
	}

	@Override
	public void setFile(ZipFile file) {
		this.file = file;
	}

	@Override
	public List<ZipEntry> getEntries() {
		return entries;
	}

	@Override
	public void setEntries(List<ZipEntry> entries) {
		this.entries = entries;
	}

	@Override
	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String getKey() {
		return key;
	}

}
