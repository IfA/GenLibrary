/**
 * 
 */
package de.tud.et.ifa.agtele.genlibrary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EPackage;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.processor.impl.DefaultLibraryPathParser;
import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPlugin;

/**
 * A registry for concrete implementations of the GenLibrary.
 * <p />
 * This can be used to obtain concrete implementations of {@link LibraryContext}
 * and {@link LibraryPathParser} for a certain {@link EPackage} respectively its
 * namespace URI.
 * <p />
 * Note: This registry is populated automatically during
 * {@link Activator#registerLibraryImplementations() startup} of this plug-in by
 * all extensions implementing the 'de.tud.et.ifa.agtele.genlibrary.provider'
 * extension point but implementations can also be
 * {@link #registerImplementation(String, LibraryContext, LibraryPathParser, Class)
 * registered} manually.
 * 
 * @author mfreund
 */
public class LibraryImplementationRegistry {

	/**
	 * The singleton instance of this registry.
	 */
	private static LibraryImplementationRegistry INSTANCE;

	/**
	 * The map storing the registered {@link LibraryContext LibraryContexts}.
	 */
	private final Map<String, LibraryContext> contextRegistry;

	/**
	 * The map storing the registered {@link LibraryPathParser
	 * LibraryPathParsers}.
	 */
	private final Map<String, LibraryPathParser> pathParserRegistry;

	/**
	 * The map storing the registered concrete types of {@link LibraryItem
	 * LibraryItems}.
	 */
	private final Map<String, String> libraryItemTypeRegistry;

	/**
	 * This creates an instance.
	 */
	private LibraryImplementationRegistry() {
		contextRegistry = new HashMap<>();
		pathParserRegistry = new HashMap<>();
		libraryItemTypeRegistry = new HashMap<>();
	}

	/**
	 * This returns the singleton instance of this registry.
	 *
	 * @return The singleton instance of this
	 *         {@link LibraryImplementationRegistry}.
	 */
	public static LibraryImplementationRegistry getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new LibraryImplementationRegistry();
		}

		return INSTANCE;
	}

	/**
	 * Register a new concrete implementation for the given ePackage URI.
	 *
	 * @param nsURI
	 *            The namespace URI of the {@link EPackage} for which an
	 *            implementation shall be registered.
	 * @param libraryContext
	 *            The instance of {@link LibraryContext} to be registered for
	 *            the given <em>nsURI</em>. This may be <em>null</em> if only a
	 *            <em>libraryItemType</em> and/or <em>libraryPathParser</em>
	 *            shall be registered..
	 * @param libraryPathParser
	 *            The instance of {@link LibraryPathParser} to be registered for
	 *            the given <em>nsURI</em>. This may be <em>null</em> if only a
	 *            <em>libraryContext</em> and/or <em>libraryItemType</em> shall
	 *            be registered.
	 * @param liraryItemClass
	 *            The concrete type of {@link LibraryItem} to be registered for
	 *            the given <em>nsURI</em>. This may be <em>null</em> if only a
	 *            <em>libraryContext</em> and/or <em>libraryPathParser</em>
	 *            shall be registered.
	 * @throws DuplicateImplementationException
	 */
	public void registerImplementation(String nsURI, LibraryContext libraryContext, LibraryPathParser libraryPathParser, String liraryItemClass) throws DuplicateImplementationException {

		if (contextRegistry.containsKey(nsURI)) {
			throw new DuplicateImplementationException(nsURI, contextRegistry.get(nsURI), null, null);
		} else if (libraryContext != null) {
			contextRegistry.put(nsURI, libraryContext);
		}

		if (pathParserRegistry.containsKey(nsURI)) {
			throw new DuplicateImplementationException(nsURI, null, pathParserRegistry.get(nsURI), null);
		} else if (libraryPathParser != null) {
			pathParserRegistry.put(nsURI, libraryPathParser);
		}

		if (libraryItemTypeRegistry.containsKey(nsURI)) {
			throw new DuplicateImplementationException(nsURI, null, null, libraryItemTypeRegistry.get(nsURI));
		} else if (liraryItemClass != null) {
			libraryItemTypeRegistry.put(nsURI, liraryItemClass);
		}
	}

	/**
	 * Get a concrete {@link LibraryContext} implementation for the given
	 * <em>nsURI</em>.
	 *
	 * @param nsURI
	 *            The namespace URI of an {@link EPackage} for which the
	 *            implementation shall be returned.
	 * @return The registered {@link LibraryContext} or <em>null</em> if no
	 *         implementation has been registered.
	 * 
	 * @see #createLibraryPlugin(String)
	 */
	public LibraryContext getLibraryContextImplementation(String nsURI) {

		return contextRegistry.get(nsURI);
	}

	/**
	 * Get a concrete {@link LibraryPathParser} implementation for the given
	 * <em>nsURI</em>.
	 *
	 * @param nsURI
	 *            The namespace URI of an {@link EPackage} for which the
	 *            implementation shall be returned.
	 * @return The registered {@link LibraryPathParser} or an instance of
	 *         {@link DefaultLibraryPathParser} if no implementation has been
	 *         registered.
	 * 
	 * @see #createLibraryPlugin(String)
	 */
	public LibraryPathParser getLibraryPathParserImplementation(String nsURI) {

		return pathParserRegistry.containsKey(nsURI) ? pathParserRegistry.get(nsURI) : new DefaultLibraryPathParser();
	}

	/**
	 * This can be used to determine the namespace URI for which the library
	 * located at the given <em>libraryPath</em> defines entries for.
	 * 
	 * @param libraryPath
	 *            The path of a library.
	 * @return The namespace URI of an {@link EPackage} that the library located
	 *         at the given <em>libraryPath</em> defines entries for or
	 *         <em>null</em> if no namespace URI could be determined.
	 */
	public String getNamespaceForLibrary(String libraryPath) {

		Optional<String> namespaceOptional = contextRegistry.keySet().stream().filter(nsURI -> isNamespaceForLibrary(nsURI, libraryPath)).findAny();

		return namespaceOptional.isPresent() ? namespaceOptional.get() : null;

	}

	/**
	 * This can be used to determine if the library located at the given
	 * <em>libraryPath</em> defines entries for the given EPackage identified by
	 * the given <em>nsURI</em>.
	 * 
	 * @param nsURI
	 *            The namespace URI of an EPackage.
	 * @param libraryPath
	 *            The path of a library.
	 * @return Whether the library located at the given <em>libraryPath</em>
	 *         defines entries for the {@link EPackage} identified by the given
	 *         <em>nsURI</em>.
	 */
	public boolean isNamespaceForLibrary(String nsURI, String libraryPath) {

		if (!libraryItemTypeRegistry.containsKey(nsURI)) {
			return false;
		}

		LibraryPlugin plugin = new LibraryPluginImpl();
		plugin.init(libraryPath, contextRegistry.get(nsURI), pathParserRegistry.get(nsURI));

		List<String> entries = plugin.getAllElementLibraryPathAsString(0, 1);

		if (entries.isEmpty()) {
			return false;
		}

		LibraryEntry entry = plugin.getElement(entries.get(0), false);

		return entry != null && entry.getLibraryItem() != null && libraryItemTypeRegistry.get(nsURI).equals(entry.getLibraryItem().getClass().getName());
	}

	/**
	 * Create and {@link LibraryPlugin#init(LibraryContext, LibraryPathParser)
	 * initialize} a new {@link LibraryPlugin} for the given <em>nsURI</em>.
	 *
	 * @param nsURI
	 *            The namespace URI of an {@link EPackage} for which the
	 *            LibraryPlugin shall be returned.
	 * @return The created {@link LibraryPlugin} or <em>null</em> if no library
	 *         plugin could be created.
	 */
	public LibraryPlugin createLibraryPlugin(String nsURI) {

		if (getLibraryContextImplementation(nsURI) == null) {
			return null;
		}

		LibraryPlugin plugin = new LibraryPluginImpl();
		plugin.init(getLibraryContextImplementation(nsURI), getLibraryPathParserImplementation(nsURI));
		return plugin;
	}

	/**
	 * An Exception indicating that a implementation could not be registered
	 * because a previous implementation already exists.
	 *
	 * @author mfreund
	 */
	public class DuplicateImplementationException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = -267974894757788318L;

		/**
		 * The namespace URI for which a previous implementation was already
		 * registered.
		 */
		private final String nsURI;

		/**
		 * The previously registered {@link LibraryContext}.
		 */
		private final LibraryContext existingContext;

		/**
		 * The previously registered {@link LibraryPathParser}.
		 */
		private final LibraryPathParser existingParser;

		/**
		 * The previously registered concrete type of {@link LibraryItem}.
		 */
		private final String existingLibraryItemType;

		/**
		 * This creates an instance.
		 *
		 */
		DuplicateImplementationException(String nsURI, LibraryContext existingContext, LibraryPathParser existingParser, String existingLibraryItemType) {
			this.nsURI = nsURI;
			this.existingContext = existingContext;
			this.existingParser = existingParser;
			this.existingLibraryItemType = existingLibraryItemType;
		}

		/**
		 * This is the getter for the {@link #nsURI}.
		 *
		 * @return the {@link #nsURI}.
		 */
		public String getNsURI() {
			return this.nsURI;
		}

		/**
		 * This is the getter for the {@link #existingContext}.
		 *
		 * @return the {@link #existingContext}.
		 */
		public LibraryContext getExistingContext() {
			return this.existingContext;
		}

		/**
		 * This is the getter for the {@link #existingParser}.
		 *
		 * @return the {@link #existingParser}.
		 */
		public LibraryPathParser getExistingParser() {
			return this.existingParser;
		}

		/**
		 * This is the getter for the {@link #existingLibraryItemType}.
		 *
		 * @return the {@link #existingLibraryItemType}.
		 */
		public String getExistingLibraryItemType() {
			return this.existingLibraryItemType;
		}

	}
}
