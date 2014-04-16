/**
 */
package de.tud.et.ifa.agtele.movisa.library.model.Library;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryFactory
 * @model kind="package"
 * @generated
 */
public interface LibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Library";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://lib/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lib";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LibraryPackage eINSTANCE = de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryEntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryEntryImpl
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getLibraryEntry()
	 * @generated
	 */
	int LIBRARY_ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__VERSION = 0;

	/**
	 * The feature id for the '<em><b>Library Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__LIBRARY_ITEM = 1;

	/**
	 * The feature id for the '<em><b>Meta Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__META_DATA = 2;

	/**
	 * The number of structural features of the '<em>Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryImpl
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getLibrary()
	 * @generated
	 */
	int LIBRARY = 1;

	/**
	 * The feature id for the '<em><b>Checksum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__CHECKSUM = 0;

	/**
	 * The feature id for the '<em><b>Items</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY__ITEMS = 1;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.ItemImpl
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getItem()
	 * @generated
	 */
	int ITEM = 2;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__KEY = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__PATH = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM__VERSION = 2;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryItemImpl
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getLibraryItem()
	 * @generated
	 */
	int LIBRARY_ITEM = 3;

	/**
	 * The number of structural features of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ITEM_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.MetaDataImpl <em>Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.MetaDataImpl
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getMetaData()
	 * @generated
	 */
	int META_DATA = 4;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__RESOURCES = 0;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__ID = 1;

	/**
	 * The number of structural features of the '<em>Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.ResourceImpl
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 0;

	/**
	 * The feature id for the '<em><b>New Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NEW_PATH = 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry
	 * @generated
	 */
	EClass getLibraryEntry();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry#getVersion()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EAttribute getLibraryEntry_Version();

	/**
	 * Returns the meta object for the containment reference '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry#getLibraryItem <em>Library Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Library Item</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry#getLibraryItem()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_LibraryItem();

	/**
	 * Returns the meta object for the containment reference '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry#getMetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Meta Data</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryEntry#getMetaData()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_MetaData();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Library#getChecksum <em>Checksum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checksum</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Library#getChecksum()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Checksum();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Library#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Library#getItems()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Items();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Item#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Item#getKey()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Key();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Item#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Item#getPath()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Path();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Item#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Item#getVersion()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Version();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryItem <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryItem
	 * @generated
	 */
	EClass getLibraryItem();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.MetaData
	 * @generated
	 */
	EClass getMetaData();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.MetaData#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.MetaData#getResources()
	 * @see #getMetaData()
	 * @generated
	 */
	EReference getMetaData_Resources();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.MetaData#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.MetaData#getID()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_ID();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resource#getNewPath <em>New Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Path</em>'.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.Resource#getNewPath()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_NewPath();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LibraryFactory getLibraryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryEntryImpl <em>Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryEntryImpl
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getLibraryEntry()
		 * @generated
		 */
		EClass LIBRARY_ENTRY = eINSTANCE.getLibraryEntry();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY_ENTRY__VERSION = eINSTANCE.getLibraryEntry_Version();

		/**
		 * The meta object literal for the '<em><b>Library Item</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__LIBRARY_ITEM = eINSTANCE.getLibraryEntry_LibraryItem();

		/**
		 * The meta object literal for the '<em><b>Meta Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__META_DATA = eINSTANCE.getLibraryEntry_MetaData();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryImpl
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getLibrary()
		 * @generated
		 */
		EClass LIBRARY = eINSTANCE.getLibrary();

		/**
		 * The meta object literal for the '<em><b>Checksum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY__CHECKSUM = eINSTANCE.getLibrary_Checksum();

		/**
		 * The meta object literal for the '<em><b>Items</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY__ITEMS = eINSTANCE.getLibrary_Items();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.ItemImpl
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getItem()
		 * @generated
		 */
		EClass ITEM = eINSTANCE.getItem();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__KEY = eINSTANCE.getItem_Key();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__PATH = eINSTANCE.getItem_Path();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITEM__VERSION = eINSTANCE.getItem_Version();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryItemImpl
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getLibraryItem()
		 * @generated
		 */
		EClass LIBRARY_ITEM = eINSTANCE.getLibraryItem();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.MetaDataImpl <em>Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.MetaDataImpl
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getMetaData()
		 * @generated
		 */
		EClass META_DATA = eINSTANCE.getMetaData();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_DATA__RESOURCES = eINSTANCE.getMetaData_Resources();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__ID = eINSTANCE.getMetaData_ID();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.ResourceImpl
		 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.impl.LibraryPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '<em><b>New Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NEW_PATH = eINSTANCE.getResource_NewPath();

	}

} //LibraryPackage
