package de.tud.et.ifa.agtele.movisa.library.libraryprocessor.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryItem;
import de.tud.et.ifa.agtele.movisa.library.model.Library.MetaData;

public interface LibraryPlugin {

	public void init(String libpath, LibraryContext librarycontext, LibraryPathParser parser);

	public boolean elementExists(String path, boolean usehigher);

	public LibraryItem getElement(String path, boolean usehigher);

	public String getResultingElementLibraryPath(String path);

	public LibraryItem getElement(String path, MetaData metadata, boolean usehigher);

	public MetaData getMetaData(String path, boolean usehigher);

	/**
	 * Returns the selected List of {@link LibraryPath} as Strings.
	 * 
	 * @param start
	 *            Index beginning with 0, if smaller then 0 means 0
	 * @param count
	 *            smaller or equal 0 means all
	 * @return empty List if no LibraryPathes available or startIndex too big
	 */
	public List<String> getAllElementLibraryPathAsString(int startIndex, int count);

	public InputStream getResourceInputStream(String path, boolean usehigher, String resourcename) throws IOException;

	public boolean copyResourceTo(String path, boolean usehigher, String resourcename, String pathto);

	public List<String> getElementsResources(String path, boolean usehigher);
}
