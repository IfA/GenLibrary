package de.tud.et.ifa.agtele.genlibrary.processor.impl;

import java.io.File;

import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPath;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;

public class LibraryPathParserImpl implements LibraryPathParser {

	@Override
	public LibraryPath parse(String path) {
		return new LibraryPathImpl(path.replace("#", File.separator));
	}

}
