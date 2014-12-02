package de.tud.et.ifa.agtele.genlibrary.util.impl;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class SearchZipAndJarFileVisitor extends SimpleFileVisitor<Path> {

	private final List<Path> resources;

	public SearchZipAndJarFileVisitor(List<Path> resources) {
		this.resources = resources;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
		String tmp = file.toString();
		tmp = tmp.substring(tmp.length() - 4);
		tmp = tmp.toLowerCase();
		if (tmp.endsWith("zip") || tmp.endsWith("jar")) {
			resources.add(file);
		}
		return FileVisitResult.CONTINUE;
	}

}
