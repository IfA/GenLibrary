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
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public interface LibraryFileEntry {

	public InputStream getXMIFileAsInputStream() throws IOException;

	public List<String> getResourceNameList() throws IOException;

	public InputStream getResourceFileAsInputStream(String name) throws IOException;

	public ZipFile getFile();

	public void setFile(ZipFile file);

	public List<ZipEntry> getEntries();

	public void setEntries(List<ZipEntry> entries);

	public void setKey(String key);

	public String getKey();

	public final static String XMI_FILENAME = "data.xmi";
}
