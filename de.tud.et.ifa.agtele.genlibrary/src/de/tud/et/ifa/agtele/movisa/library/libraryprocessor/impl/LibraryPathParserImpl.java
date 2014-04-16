package de.tud.et.ifa.agtele.movisa.library.libraryprocessor.impl;

import java.io.File;

import de.tud.et.ifa.agtele.movisa.library.libraryprocessor.interfaces.LibraryPath;
import de.tud.et.ifa.agtele.movisa.library.libraryprocessor.interfaces.LibraryPathParser;

public class LibraryPathParserImpl implements LibraryPathParser {

	@Override
	public LibraryPath parse(String path) {
		return new LibraryPathImpl(path.replace("#", File.separator));
	}

}
