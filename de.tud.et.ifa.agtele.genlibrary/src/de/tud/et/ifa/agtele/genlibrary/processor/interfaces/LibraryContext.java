package de.tud.et.ifa.agtele.genlibrary.processor.interfaces;

import java.util.List;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;

public interface LibraryContext {

	public boolean isValid(LibraryEntry entry, List<String> resources);

	public LibraryItem transformLibraryItem(LibraryItem libraryitem, MetaData metadata);

	public MetaData transformMetaData(LibraryItem libraryitem, MetaData metadata);

	public void init();

	public MetaData getNewMetaData();

}