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