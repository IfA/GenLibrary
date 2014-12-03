/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryFactory;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Resource;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class GenLibraryFactoryImpl extends EFactoryImpl implements GenLibraryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public GenLibraryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LibraryEntry createLibraryEntry() {
		LibraryEntryImpl libraryEntry = new LibraryEntryImpl();
		return libraryEntry;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Item createItem() {
		ItemImpl item = new ItemImpl();
		return item;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LibraryItem createLibraryItem() {
		LibraryItemImpl libraryItem = new LibraryItemImpl();
		return libraryItem;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenLibraryPackage getGenLibraryPackage() {
		return (GenLibraryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GenLibraryPackage getPackage() {
		return GenLibraryPackage.eINSTANCE;
	}

	@Override
	public MetaData createMetaData() {
		// TODO Auto-generated method stub
		return null;
	}

} // LibraryFactoryImpl
