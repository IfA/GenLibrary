/**
 * 
 */
package de.tud.et.ifa.agtele.genlibrary;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import de.tud.et.ifa.agtele.genlibrary.processor.impl.DefaultLibraryPathParser;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryPathParser;

/**
 * A registry for concrete implementations of the GenLibrary.
 * <p />
 * This can be used to obtain concrete implementations of {@link LibraryContext}
 * and {@link LibraryPathParser} for a certain {@link EPackage} respectively its
 * namespace URI.
 * <p />
 * Note: This registry is populated automatically during
 * {@link Activator#createLibraryImplementationRegistry() startup} of this
 * plug-in by all extensions implementing the
 * 'de.tud.et.ifa.agtele.genlibrary.provider' extension point but
 * implementations can also be
 * {@link #registerImplementation(String, Class, Class) registered} manually.
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
	 * This creates an instance.
	 */
	private LibraryImplementationRegistry() {
		contextRegistry = new HashMap<>();
		pathParserRegistry = new HashMap<>();
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
	 *            <em>libraryPathParser</em> shall be registered..
	 * @param libraryPathParser
	 *            The instance of {@link LibraryPathParser} to be registered for
	 *            the given <em>nsURI</em>. This may be <em>null</em> if only a
	 *            <em>libraryContext</em> shall be registered.
	 * @throws DuplicateImplementationException
	 */
	public void registerImplementation(String nsURI, LibraryContext libraryContext, LibraryPathParser libraryPathParser) throws DuplicateImplementationException {

		if (contextRegistry.containsKey(nsURI)) {
			throw new DuplicateImplementationException(nsURI, contextRegistry.get(nsURI), null);
		} else if (libraryContext != null) {
			contextRegistry.put(nsURI, libraryContext);
		}

		if (pathParserRegistry.containsKey(nsURI)) {
			throw new DuplicateImplementationException(nsURI, null, pathParserRegistry.get(nsURI));
		} else if (libraryPathParser != null) {
			pathParserRegistry.put(nsURI, libraryPathParser);
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
	 */
	public LibraryPathParser getLibraryPathParserImplementation(String nsURI) {

		return pathParserRegistry.containsKey(nsURI) ? pathParserRegistry.get(nsURI) : new DefaultLibraryPathParser();
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
		 * This creates an instance.
		 *
		 */
		DuplicateImplementationException(String nsURI, LibraryContext existingContext, LibraryPathParser existingParser) {
			this.nsURI = nsURI;
			this.existingContext = existingContext;
			this.existingParser = existingParser;
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

	}
}
