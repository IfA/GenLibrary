package de.tud.et.ifa.agtele.movisa.library.utilities.interfaces;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import de.tud.et.ifa.agtele.movisa.library.model.Library.Item;

public interface FileParser {

	public List<LibraryFileEntry> parseFile(Path file) throws IOException;

	public LibraryFileEntry parseFile(Item item) throws IOException;

}
