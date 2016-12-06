package de.tud.et.ifa.agtele.genlibrary.processor.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryFactoryImpl;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPath;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;
import de.tud.et.ifa.agtele.genlibrary.util.impl.FileParserImpl;
import de.tud.et.ifa.agtele.genlibrary.util.impl.SearchZipAndJarFileVisitor;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.FileParser;
import de.tud.et.ifa.agtele.genlibrary.util.interfaces.LibraryFileEntry;

public class LibraryPluginImpl implements LibraryPlugin {

	private LibraryContext libraryContext;

	/**
	 * The current list of libraries that are managed by this plugin associated
	 * with their location.
	 */
	private final Map<String, Library> libs;

	private LibraryPathParser parser;

	private LibraryPathParser libpathparser;

	private final int version = 18;

	private FileParser fileparser;

	/**
	 * This creates an instance.
	 *
	 */
	public LibraryPluginImpl() {
		libs = new HashMap<>();

	}

	/**
	 * This holds the initialization algorithms that are common to
	 * {@link #init(LibraryContext, LibraryPathParser)} and
	 * {@link #init(String, LibraryContext, LibraryPathParser)}.
	 * 
	 * @param librarycontext
	 *            The context of the library providing method implementations
	 *            that are custom to the used genlib plugin.
	 * @param parser
	 *            The parser used for library paths.
	 */
	private void basicInit(LibraryContext librarycontext, LibraryPathParser parser) {

		this.libraryContext = librarycontext;
		this.parser = parser != null ? parser : new DefaultLibraryPathParser();
		this.fileparser = new FileParserImpl();

		GenLibraryPackageImpl.init();
		GenLibraryFactoryImpl.init();

		this.libraryContext.init();
	}

	@Override
	public void init(LibraryContext librarycontext, LibraryPathParser parser) {
		System.out.println("Init Library without a LibraryPath! ");
		System.out.println("Version: " + version);

		basicInit(librarycontext, parser);

		System.out.println("Initialisation complete...");
	}

	@Override
	public void init(String libpath, LibraryContext librarycontext, LibraryPathParser parser) {
		System.out.println("Init Library! " + libpath);
		System.out.println("Version: " + version);

		basicInit(librarycontext, parser);

		setLibPath(libpath);

		System.out.println("Initialisation complete...");
	}

	@Override
	public void setLibPath(String libpath) {

		if (libs.size() == 1 && libs.containsKey(libpath)) {
			return;
		}

		// Clear the existing list libraries
		//
		libs.clear();

		// Add the new library
		//
		addLibPath(libpath);

	}

	@Override
	public void setLibPaths(List<String> libpaths) {

		if (libs.size() == 1 && libpaths.stream().allMatch(libpath -> libs.containsKey(libpath))) {
			return;
		}

		// Clear the existing list libraries
		//
		libs.clear();

		// Add the new library
		//
		addLibPaths(libpaths);

	}

	@Override
	public void addLibPath(String libpath) {

		if (libs.keySet().parallelStream().anyMatch(l -> l.equals(libpath))) {
			return;
		}

		// Parse the new lib path and collect all entries
		//
		GenLibraryFactoryImpl lf = (GenLibraryFactoryImpl) GenLibraryFactoryImpl.eINSTANCE;

		libpathparser = new LibraryPathParserImpl();
		LibraryPath librarypath = libpathparser.parse(libpath);
		Path pathToLibrary = new File(librarypath.getPath()).toPath();

		URI libXMI = URI.createFileURI(librarypath.getPath() + File.separator + "lib.xmi");
		XMIResource resource = new XMIResourceImpl(libXMI);
		Library lib = null;
		try {
			resource.load(null);
			lib = (Library) resource.getContents().get(0);

		} catch (IOException e) {
			System.out.println("no Library-XMI found, creating a new one");
			try {
				lib = lf.createLibrary();
				resource.getContents().add(lib);
				resource.save(null);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		libs.put(libpath, lib);

		String libcheck = getLibraryChecksum(pathToLibrary);

		if (!libcheck.equals(lib.getChecksum())) {

			lib.getItems().clear();
			lib.setChecksum(libcheck);
			buildLibrary(pathToLibrary);
			try {
				resource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addLibPaths(List<String> libpaths) {

		libpaths.stream().forEach(this::addLibPath);
	}

	@Override
	public boolean elementExists(String path, boolean usehigher) {

		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, usehigher);
		return item != null;
	}

	@Override
	public LibraryEntry getElement(String path, boolean usehigher) {
		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, usehigher);
		if (item == null) {
			return null;
		}
		LibraryEntry entry = getLibraryEntry(item);
		if (entry == null) {
			return null;
		}

		// fix the name/path of the resources
		entry.getParameterDescription().getResourceParameters().clear();
		LibraryFileEntry fileentry = getLibraryFileEntry(item);
		GenLibraryFactoryImpl lf = (GenLibraryFactoryImpl) GenLibraryFactoryImpl.eINSTANCE;
		try {
			List<String> respathes = fileentry.getResourceNameList();
			for (int i = 0; i < respathes.size(); i++) {

				ResourceParameter resourceParameter = lf.createResourceParameter();

				resourceParameter.setName(getFilename(respathes.get(i), getResultingElementLibraryPath(item.getKey())));
				resourceParameter.setNewPath(libraryContext.getDefaultResourcePath(respathes.get(i)));

				entry.getParameterDescription().getResourceParameters().add(resourceParameter);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return entry;
	}

	@Override
	public void insertIntoTargetModel(EObject targetModel, LibraryEntry libraryEntry, String path) {

		// At first, we give clients the chance to insert anything that is not
		// covered by Parameters into the target model.
		libraryContext.defaultInsertIntoTargetModel(targetModel, libraryEntry, path);

		// Second, we apply the ParameterDescription so that all parameters are
		// evaluated.
		libraryContext.applyParameters(targetModel, libraryEntry, path);

		// Last, the resource are handled.
		// TODO This might have to be moved to 'applyParameters'
		ParameterDescription parameterDescription = libraryEntry.getParameterDescription();
		List<ResourceParameter> resourceParameters = parameterDescription.getResourceParameters();

		Item item = getItem(parser.parse(path), false);
		LibraryFileEntry fileitem = getLibraryFileEntry(item);
		for (ResourceParameter res : resourceParameters) {
			if (res.getNewPath() != null && !res.getNewPath().isEmpty()) {
				LibraryPath newrespath = libpathparser.parse(res.getNewPath());
				if (!new org.eclipse.core.runtime.Path(newrespath.getPath()).isAbsolute()) {
					newrespath.setPath((new org.eclipse.core.runtime.Path(targetModel.eResource().getURI().trimSegments(1).toString())) + File.separator + newrespath.getPath());
				}
				copyResourceTo(item, fileitem, res.getName(), newrespath);
			}

		}
	}

	@Override
	public String getResultingElementLibraryPath(String path) {
		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, true);
		if (item == null) {
			return null;
		} else {
			return item.getKey();
		}
	}

	@Override
	public List<String> getAllElementLibraryPathAsString(int startIndex, int count) {

		List<String> tmp = new ArrayList<>();

		List<Item> libItems = libs.values().stream().flatMap(lib -> lib.getItems().stream()).collect(Collectors.toList());

		for (int i = startIndex < 0 ? 0 : startIndex; i < libItems.size(); i++) {

			if (tmp.size() < (count <= 0 ? libItems.size() : count)) {
				tmp.add(libItems.get(i).getKey());
			} else {
				break;
			}
		}

		return tmp;
	}

	@Override
	public InputStream getResourceInputStream(String path, boolean usehigher, String resourcename) throws IOException, IllegalArgumentException {
		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, usehigher);
		if (item == null) {
			return null;
		}
		LibraryFileEntry libfileentry = getLibraryFileEntry(item);
		if (libfileentry == null) {
			return null;
		}

		return getResourceInputStream(item, libfileentry, resourcename);
	}

	private InputStream getResourceInputStream(Item item, LibraryFileEntry libfileentry, String resourcename) throws IOException, IllegalArgumentException {
		String fullrespath = getFullResourcePath(item.getKey(), resourcename);

		boolean exists = false;
		for (String file : libfileentry.getResourceNameList()) {
			if (file.equals(fullrespath)) {
				exists = true;
				break;
			}
		}

		if (!exists)
			throw new IllegalArgumentException("File does not exists: " + resourcename);

		return libfileentry.getResourceFileAsInputStream(fullrespath);
	}

	private boolean copyResourceTo(Item item, LibraryFileEntry libfileentry, String resourcename, LibraryPath pathTo) {
		InputStream is = null;
		FileOutputStream fos = null;
		try {

			URI uri = URI.createURI(pathTo.getPath());
			String fileString;
			if (uri.isPlatformResource()) {
				fileString = CommonPlugin.asLocalURI(uri).toFileString();
			} else if (uri.isFile() || uri.hasAbsolutePath()) {
				fileString = pathTo.getPath();
			} else {
				throw new RuntimeException("Unknown URI scheme: " + pathTo.getPath());
			}
			File outputfile = new File(fileString);

			File parent = outputfile.getParentFile();
			if (!parent.exists()) {
				parent.mkdirs();
			}

			is = getResourceInputStream(item, libfileentry, resourcename);
			fos = new FileOutputStream(outputfile);

			int read = 0;
			byte[] bytes = new byte[0xFFFF];

			while ((read = is.read(bytes)) != -1) {
				fos.write(bytes, 0, read);
			}

			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return false;
	}

	private LibraryEntry getLibraryEntry(Item item) {
		if (item == null)
			return null;
		XMIResource resource = getXMIResource(item);

		if (resource == null)
			return null;
		return (LibraryEntry) resource.getContents().get(0);
	}

	private Item getItem(LibraryPath path, boolean usehigher) {

		List<Item> libItems = libs.values().stream().flatMap(lib -> lib.getItems().stream()).collect(Collectors.toList());

		Item item = null;

		while (item == null) {
			for (int k = 0; k < libItems.size(); k++) {
				Item tmpitem = libItems.get(k);
				if (tmpitem.getKey().equals(path.getPath())) {
					// item with highest value
					if (item == null || versionCompare(item.getVersion(), tmpitem.getVersion()) < 0) {
						item = tmpitem;
					}
				}
			}

			// get Element of higher Class
			if (item != null || !usehigher || !path.hasHigherPath()) {
				break;
			}
		}

		return item;
	}

	/**
	 * Compares two version strings.
	 * 
	 * Use this instead of String.compareTo() for a non-lexicographical
	 * comparison that works for version strings. e.g. "1.10".compareTo("1.6").
	 * 
	 * @see http://stackoverflow.com/questions/6701948/efficient-way-to-compare-
	 *      version-strings-in-java/6702029#6702029
	 * 
	 * @note It does not work if "1.10" is supposed to be equal to "1.10.0".
	 * 
	 * @param str1
	 *            a string of ordinal numbers separated by decimal points.
	 * @param str2
	 *            a string of ordinal numbers separated by decimal points.
	 * @return The result is a negative integer if str1 is _numerically_ less
	 *         than str2. The result is a positive integer if str1 is
	 *         _numerically_ greater than str2. The result is zero if the
	 *         strings are _numerically_ equal.
	 */
	private static int versionCompare(String str1, String str2) {
		String[] vals1 = str1.split("\\.");
		String[] vals2 = str2.split("\\.");
		int i = 0;
		// set index to first non-equal ordinal or length of shortest version
		// string
		while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) {
			i++;
		}
		// compare first non-equal ordinal number
		if (i < vals1.length && i < vals2.length) {
			int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
			return Integer.signum(diff);
		}
		// the strings are equal or one string is a substring of the other
		// e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
		return Integer.signum(vals1.length - vals2.length);
	}

	private XMIResource getXMIResource(Item item) {
		if (item != null) {
			LibraryFileEntry libfileentry = getLibraryFileEntry(item);
			XMIResource resource = new XMIResourceImpl();
			try {
				resource.load(libfileentry.getXMIFileAsInputStream(), null);
				return resource;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	private void buildLibrary(Path path) {
		System.out.println("building Library...");
		List<Path> res = getAllArchives(path);
		List<LibraryFileEntry> entries = getLibraryFileEntries(res);
		GenLibraryFactoryImpl lf = (GenLibraryFactoryImpl) GenLibraryFactoryImpl.eINSTANCE;

		for (LibraryFileEntry entry : entries) {
			XMIResource resource = new XMIResourceImpl();
			try {
				resource.load(entry.getXMIFileAsInputStream(), null);
				LibraryEntry libentry = (LibraryEntry) resource.getContents().get(0);

				if (!libraryContext.isValid(libentry, entry.getResourceNameList())) {
					throw new IllegalArgumentException("Library element: " + entry.getKey() + " is not consistent");
				}

				Item item = lf.createItem();

				item.setVersion(libentry.getVersion());

				item.setKey(entry.getKey());
				item.setPath(entry.getFile().getName());

				libs.get(path.toString()).getItems().add(item);

			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
				System.err.println("Zip-File: " + entry.getFile().getName());
				System.err.println("Entry: " + entry.getKey());
			}

		}
		System.out.println("building Library complete...");
	}

	/**
	 * Die Funktion gibt alle Zip und Jar Archive in dem angegebenem Ordner
	 * zurück. Es werden Unterordner berücksichtigt und symbolischen Links wird
	 * gefolgt.
	 * 
	 * @param path
	 * @return alle ZIP und JAR Archive aus dem Ordner
	 */
	private List<Path> getAllArchives(Path path) {
		System.out.println("getAllArchives Path: " + path);
		List<Path> result = new ArrayList<Path>();
		if (path.toFile().exists()) {
			try {
				Files.walkFileTree(path, new SearchZipAndJarFileVisitor(result));
			} catch (IOException e) {
				System.out.println("ERROR: " + e.getLocalizedMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("Path to Library does not exists!!");
		}
		return result;
	}

	private List<LibraryFileEntry> getLibraryFileEntries(List<Path> resources) {
		System.out.println("getListOfLibraryFileEntries Number of Resources: " + resources.size());
		List<LibraryFileEntry> entries = new ArrayList<LibraryFileEntry>();
		for (Path res : resources) {
			try {
				entries.addAll(fileparser.parseFile(res));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("getListOfLibraryFileEntries Number of Entrys: " + entries.size());
		return entries;
	}

	private LibraryFileEntry getLibraryFileEntry(Item item) {
		try {
			return fileparser.parseFile(item);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	private String getLibraryChecksum(Path path) {
		List<Path> resources = getAllArchives(path);
		System.out.println("getLibraryChecksum Number of Resources: " + resources.size());
		String checksum = getChecksum(resources);
		System.out.println("getLibraryChecksum Checksum: " + checksum);
		return checksum;
	}

	private String getChecksum(List<Path> resources) {
		System.out.println("getChecksum Number of Resources: " + resources.size());
		List<String> temp = new ArrayList<String>();

		for (Path path : resources) {

			try {
				temp.add(generateChecksumOfFile(new FileInputStream(path.toString())));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		Collections.sort(temp);

		String result = "";
		for (int i = 0; i < temp.size(); i++) {

			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update((result + temp.get(i)).getBytes());

				result = new BigInteger(1, md.digest()).toString(16);

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		System.out.println("getChecksum Checksum: " + result);
		return result;
	}

	private String generateChecksumOfFile(InputStream in) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] buffer = new byte[0xFFFF];

			for (int n = 0; (n = in.read(buffer)) > -1;)
				md.update(buffer, 0, n);

			byte[] result = md.digest();

			String strresult = new BigInteger(1, result).toString(16);
			return strresult;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("generating Checksum ending with errors.");
		return null;
	}

	private String getFullResourcePath(String path, String resourcename) {
		return path.replace(".", "/") + "/" + resourcename;
	}

	private String getFilename(String res, String libraryPath) {
		String parsedLibPath = libraryPath.replaceAll("\\.", "/") + "/";
		String resName = res.replace(parsedLibPath, "");
		return resName;
	}

}
