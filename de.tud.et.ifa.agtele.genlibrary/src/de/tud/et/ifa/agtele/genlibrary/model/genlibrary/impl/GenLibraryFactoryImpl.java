/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GenLibraryFactoryImpl extends EFactoryImpl implements GenLibraryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GenLibraryFactory init() {
		try {
			GenLibraryFactory theGenLibraryFactory = (GenLibraryFactory)EPackage.Registry.INSTANCE.getEFactory(GenLibraryPackage.eNS_URI);
			if (theGenLibraryFactory != null) {
				return theGenLibraryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GenLibraryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenLibraryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GenLibraryPackage.LIBRARY_ENTRY: return createLibraryEntry();
			case GenLibraryPackage.LIBRARY: return createLibrary();
			case GenLibraryPackage.ITEM: return createItem();
			case GenLibraryPackage.LIBRARY_ITEM: return createLibraryItem();
			case GenLibraryPackage.META_DATA: return createMetaData();
			case GenLibraryPackage.RESOURCE: return createResource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryEntry createLibraryEntry() {
		LibraryEntryImpl libraryEntry = new LibraryEntryImpl();
		return libraryEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Item createItem() {
		ItemImpl item = new ItemImpl();
		return item;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryItem createLibraryItem() {
		LibraryItemImpl libraryItem = new LibraryItemImpl();
		return libraryItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetaData createMetaData() {
		MetaDataImpl metaData = new MetaDataImpl();
		return metaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenLibraryPackage getGenLibraryPackage() {
		return (GenLibraryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GenLibraryPackage getPackage() {
		return GenLibraryPackage.eINSTANCE;
	}

} //LibraryFactoryImpl
