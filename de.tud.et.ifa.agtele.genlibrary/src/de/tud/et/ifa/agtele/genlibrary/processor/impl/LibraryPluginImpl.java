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
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
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

	private Library lib;

	private LibraryPathParser parser;

	private LibraryPathParser libpathparser;

	private final int version = 18;

	private FileParser fileparser;

	public LibraryPluginImpl() {

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
		this.parser = parser;

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

		this.fileparser = new FileParserImpl();

		basicInit(librarycontext, parser);

		GenLibraryFactoryImpl lf = (GenLibraryFactoryImpl) GenLibraryFactoryImpl.eINSTANCE;

		libpathparser = new LibraryPathParserImpl();
		LibraryPath librarypath = libpathparser.parse(libpath);
		Path pathToLibrary = new File(librarypath.getPath()).toPath();

		URI libXMI = URI.createFileURI(librarypath.getPath() + File.separator + "lib.xmi");
		XMIResource resource = new XMIResourceImpl(libXMI);
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

		String libcheck = getLibraryChecksum(pathToLibrary);

		if (!libcheck.equals(lib.getChecksum())) {
			// System.out.println("Checksum File: " + lib.getChecksum());
			// System.out.println("Checksum All: " + libcheck);
			// System.out.println("Checksum not correct, creating new Index");
			lib.getItems().clear();
			lib.setChecksum(libcheck);
			buildLibrary(pathToLibrary);
			try {
				resource.save(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Initialisation complete...");
	}

	@Override
	public boolean elementExists(String path, boolean usehigher) {
		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, usehigher);
		if (item == null) {
			return false;
		}
		return true;
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
				copyResourceTo(item, fileitem, res.getName(), newrespath);
			}

		}
	}

	@Override
	@Deprecated
	public LibraryItem getElement(EObject targetModel, String path, ParameterDescription parameterDescription, boolean usehigher) {
		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, usehigher);
		if (item == null) {
			return null;
		}
		LibraryEntry entry = getLibraryEntry(item);
		if (entry == null) {
			return null;
		}
		LibraryItem libitem = entry.getLibraryItem();

		LibraryFileEntry fileitem = getLibraryFileEntry(item);

		libraryContext.applyParameters(libitem, entry, path);

		List<ResourceParameter> resourceParameters = parameterDescription.getResourceParameters();

		for (ResourceParameter res : resourceParameters) {
			if (res.getNewPath() != null && !res.getNewPath().isEmpty()) {
				LibraryPath newrespath = libpathparser.parse(res.getNewPath());
				copyResourceTo(item, fileitem, res.getName(), newrespath);
			}

		}

		return libitem;

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
	@Deprecated
	public ParameterDescription getMetaData(String path, boolean usehigher) {
		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, usehigher);
		if (item == null) {
			return null;
		}
		LibraryEntry entry = getLibraryEntry(item);
		if (entry == null) {
			return null;
		}

		ParameterDescription md = entry.getParameterDescription();

		if (md != null) {
			md.getResourceParameters().clear();
		} else {
			md = libraryContext.getNewMetaData();
		}
		LibraryFileEntry fileentry = getLibraryFileEntry(item);

		GenLibraryFactoryImpl lf = (GenLibraryFactoryImpl) GenLibraryFactoryImpl.eINSTANCE;
		try {
			List<String> respathes = fileentry.getResourceNameList();
			for (int i = 0; i < respathes.size(); i++) {

				ResourceParameter resourceParameter = lf.createResourceParameter();

				resourceParameter.setName(getFilename(respathes.get(i), getResultingElementLibraryPath(item.getKey())));

				md.getResourceParameters().add(resourceParameter);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return libraryContext.transformMetaData(entry.getLibraryItem(), md);
	}

	@Override
	public List<String> getAllElementLibraryPathAsString(int startIndex, int count) {
		List<String> tmp = new ArrayList<String>();
		if (startIndex < 0) {
			startIndex = 0;
		}
		if (count <= 0) {
			count = lib.getItems().size();
		}

		for (int i = startIndex; i < lib.getItems().size(); i++) {

			if (tmp.size() < count) {
				tmp.add(lib.getItems().get(i).getKey());
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

	@Override
	public boolean copyResourceTo(String path, boolean usehigher, String resourcename, String pathto) {
		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, usehigher);
		if (item == null) {
			return false;
		}
		LibraryFileEntry libfileentry = getLibraryFileEntry(item);
		if (libfileentry == null) {
			return false;
		}

		LibraryPath filepath = libpathparser.parse(pathto);

		return copyResourceTo(item, libfileentry, resourcename, filepath);
	}

	@Override
	public List<String> getElementsResources(String path, boolean usehigher) {
		LibraryPath libpath = parser.parse(path);
		Item item = getItem(libpath, usehigher);
		if (item == null) {
			return null;
		}
		LibraryFileEntry libfileentry = getLibraryFileEntry(item);
		if (libfileentry == null) {
			return null;
		}

		try {

			List<String> list = libfileentry.getResourceNameList();
			List<String> result = new ArrayList<String>();
			for (String str : list) {
				result.add(getFilename(str, getResultingElementLibraryPath(item.getKey())));
			}
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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

			File outputfile = new File(pathTo.getPath());

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
		Item item = null;
		while (item == null) {
			for (int k = 0; k < lib.getItems().size(); k++) {
				Item tmpitem = lib.getItems().get(k);
				if (tmpitem.getKey().equals(path.getPath())) {
					// item with highest value
					if (item == null || Long.valueOf(item.getVersion()) < Long.valueOf(tmpitem.getVersion())) {
						item = tmpitem;
					}
				}
			}

			// get Element of higher Class
			if (item != null || !usehigher) {
				break;
			}

			if (path.toHigherPath() == 0) {
				break;
			}
		}

		return item;
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

				lib.getItems().add(item);

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
