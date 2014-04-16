package de.tud.et.ifa.agtele.movisa.library.libraryprocessor.interfaces;

import java.util.List;

import de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry;
import de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryItem;
import de.tud.et.ifa.agtele.movisa.library.model.Library.MetaData;

public interface LibraryContext {

	public boolean isValid(LibraryEntry entry, List<String> resources);

	public LibraryItem transformLibraryItem(LibraryItem libraryitem, MetaData metadata);

	public MetaData transformMetaData(LibraryItem libraryitem, MetaData metadata);

	public void init();

	public MetaData getNewMetaData();

}