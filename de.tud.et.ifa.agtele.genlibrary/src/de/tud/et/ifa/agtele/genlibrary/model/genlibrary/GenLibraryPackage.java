/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryFactory
 * @model kind="package"
 * @generated
 */
public interface GenLibraryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "genlibrary";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.et.tu-dresden.de/ifa/agtele/genlib";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "genlib";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenLibraryPackage eINSTANCE = de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl <em>Library Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getLibraryEntry()
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
	 * The feature id for the '<em><b>Parameter Description</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__PARAMETER_DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Thumbnail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__THUMBNAIL = 4;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY__AUTHOR = 5;

	/**
	 * The number of structural features of the '<em>Library Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Library Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ENTRY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryImpl
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getLibrary()
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
	 * The number of operations of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ItemImpl <em>Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ItemImpl
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getItem()
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
	 * The number of operations of the '<em>Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryItemImpl <em>Library Item</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryItemImpl
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getLibraryItem()
	 * @generated
	 */
	int LIBRARY_ITEM = 3;

	/**
	 * The number of structural features of the '<em>Library Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ITEM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Library Item</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIBRARY_ITEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ParameterDescriptionImpl <em>Parameter Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ParameterDescriptionImpl
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getParameterDescription()
	 * @generated
	 */
	int PARAMETER_DESCRIPTION = 4;

	/**
	 * The feature id for the '<em><b>Resource Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS = 0;

	/**
	 * The feature id for the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTION__ID = 1;

	/**
	 * The number of structural features of the '<em>Parameter Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTION_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get External Reference Parameters</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTION___GET_EXTERNAL_REFERENCE_PARAMETERS = 0;

	/**
	 * The operation id for the '<em>Get Container Parameters</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTION___GET_CONTAINER_PARAMETERS = 1;

	/**
	 * The operation id for the '<em>Get Attribute Parameters</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTION___GET_ATTRIBUTE_PARAMETERS = 2;

	/**
	 * The number of operations of the '<em>Parameter Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DESCRIPTION_OPERATION_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ResourceParameterImpl <em>Resource Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ResourceParameterImpl
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getResourceParameter()
	 * @generated
	 */
	int RESOURCE_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__NAME = 0;

	/**
	 * The feature id for the '<em><b>New Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER__NEW_PATH = 1;

	/**
	 * The number of structural features of the '<em>Resource Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Resource Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter <em>Abstract External Reference Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getAbstractExternalReferenceParameter()
	 * @generated
	 */
	int ABSTRACT_EXTERNAL_REFERENCE_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTERNAL_REFERENCE_PARAMETER__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTERNAL_REFERENCE_PARAMETER__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Abstract External Reference Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTERNAL_REFERENCE_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Abstract External Reference Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_EXTERNAL_REFERENCE_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter <em>Abstract Container Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getAbstractContainerParameter()
	 * @generated
	 */
	int ABSTRACT_CONTAINER_PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONTAINER_PARAMETER__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONTAINER_PARAMETER__CONTAINER = 1;

	/**
	 * The number of structural features of the '<em>Abstract Container Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONTAINER_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Reference</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONTAINER_PARAMETER___GET_REFERENCE = 0;

	/**
	 * The number of operations of the '<em>Abstract Container Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CONTAINER_PARAMETER_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter <em>Abstract Attribute Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getAbstractAttributeParameter()
	 * @generated
	 */
	int ABSTRACT_ATTRIBUTE_PARAMETER = 8;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATTRIBUTE_PARAMETER__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATTRIBUTE_PARAMETER__NEW_VALUE = 1;

	/**
	 * The number of structural features of the '<em>Abstract Attribute Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATTRIBUTE_PARAMETER_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Attribute</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATTRIBUTE_PARAMETER___GET_ATTRIBUTE = 0;

	/**
	 * The number of operations of the '<em>Abstract Attribute Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ATTRIBUTE_PARAMETER_OPERATION_COUNT = 1;

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry <em>Library Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Entry</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry
	 * @generated
	 */
	EClass getLibraryEntry();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getVersion()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EAttribute getLibraryEntry_Version();

	/**
	 * Returns the meta object for the containment reference '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getLibraryItem <em>Library Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Library Item</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getLibraryItem()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_LibraryItem();

	/**
	 * Returns the meta object for the containment reference '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getParameterDescription <em>Parameter Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter Description</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getParameterDescription()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EReference getLibraryEntry_ParameterDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getDescription()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EAttribute getLibraryEntry_Description();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getThumbnail <em>Thumbnail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Thumbnail</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getThumbnail()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EAttribute getLibraryEntry_Thumbnail();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getAuthor()
	 * @see #getLibraryEntry()
	 * @generated
	 */
	EAttribute getLibraryEntry_Author();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library
	 * @generated
	 */
	EClass getLibrary();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library#getChecksum <em>Checksum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Checksum</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library#getChecksum()
	 * @see #getLibrary()
	 * @generated
	 */
	EAttribute getLibrary_Checksum();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library#getItems <em>Items</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Items</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library#getItems()
	 * @see #getLibrary()
	 * @generated
	 */
	EReference getLibrary_Items();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Item</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item
	 * @generated
	 */
	EClass getItem();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item#getKey()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Key();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item#getPath()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Path();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item#getVersion()
	 * @see #getItem()
	 * @generated
	 */
	EAttribute getItem_Version();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem <em>Library Item</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library Item</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem
	 * @generated
	 */
	EClass getLibraryItem();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription <em>Parameter Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Description</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription
	 * @generated
	 */
	EClass getParameterDescription();

	/**
	 * Returns the meta object for the containment reference list '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getResourceParameters <em>Resource Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resource Parameters</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getResourceParameters()
	 * @see #getParameterDescription()
	 * @generated
	 */
	EReference getParameterDescription_ResourceParameters();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getID <em>ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>ID</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getID()
	 * @see #getParameterDescription()
	 * @generated
	 */
	EAttribute getParameterDescription_ID();

	/**
	 * Returns the meta object for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getExternalReferenceParameters() <em>Get External Reference Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get External Reference Parameters</em>' operation.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getExternalReferenceParameters()
	 * @generated
	 */
	EOperation getParameterDescription__GetExternalReferenceParameters();

	/**
	 * Returns the meta object for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getContainerParameters() <em>Get Container Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Container Parameters</em>' operation.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getContainerParameters()
	 * @generated
	 */
	EOperation getParameterDescription__GetContainerParameters();

	/**
	 * Returns the meta object for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getAttributeParameters() <em>Get Attribute Parameters</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Attribute Parameters</em>' operation.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getAttributeParameters()
	 * @generated
	 */
	EOperation getParameterDescription__GetAttributeParameters();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter <em>Resource Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Parameter</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter
	 * @generated
	 */
	EClass getResourceParameter();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter#getName()
	 * @see #getResourceParameter()
	 * @generated
	 */
	EAttribute getResourceParameter_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter#getNewPath <em>New Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Path</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter#getNewPath()
	 * @see #getResourceParameter()
	 * @generated
	 */
	EAttribute getResourceParameter_NewPath();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter <em>Abstract External Reference Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract External Reference Parameter</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter
	 * @generated
	 */
	EClass getAbstractExternalReferenceParameter();

	/**
	 * Returns the meta object for the containment reference '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter#getSource()
	 * @see #getAbstractExternalReferenceParameter()
	 * @generated
	 */
	EReference getAbstractExternalReferenceParameter_Source();

	/**
	 * Returns the meta object for the reference '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter#getTarget()
	 * @see #getAbstractExternalReferenceParameter()
	 * @generated
	 */
	EReference getAbstractExternalReferenceParameter_Target();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter <em>Abstract Container Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Container Parameter</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter
	 * @generated
	 */
	EClass getAbstractContainerParameter();

	/**
	 * Returns the meta object for the reference '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getSource()
	 * @see #getAbstractContainerParameter()
	 * @generated
	 */
	EReference getAbstractContainerParameter_Source();

	/**
	 * Returns the meta object for the reference '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getContainer <em>Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Container</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getContainer()
	 * @see #getAbstractContainerParameter()
	 * @generated
	 */
	EReference getAbstractContainerParameter_Container();

	/**
	 * Returns the meta object for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getReference() <em>Get Reference</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Reference</em>' operation.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getReference()
	 * @generated
	 */
	EOperation getAbstractContainerParameter__GetReference();

	/**
	 * Returns the meta object for class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter <em>Abstract Attribute Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Attribute Parameter</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter
	 * @generated
	 */
	EClass getAbstractAttributeParameter();

	/**
	 * Returns the meta object for the reference '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter#getSource()
	 * @see #getAbstractAttributeParameter()
	 * @generated
	 */
	EReference getAbstractAttributeParameter_Source();

	/**
	 * Returns the meta object for the attribute '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter#getNewValue()
	 * @see #getAbstractAttributeParameter()
	 * @generated
	 */
	EAttribute getAbstractAttributeParameter_NewValue();

	/**
	 * Returns the meta object for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter#getAttribute() <em>Get Attribute</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Attribute</em>' operation.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter#getAttribute()
	 * @generated
	 */
	EOperation getAbstractAttributeParameter__GetAttribute();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GenLibraryFactory getGenLibraryFactory();

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
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl <em>Library Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getLibraryEntry()
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
		 * The meta object literal for the '<em><b>Parameter Description</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIBRARY_ENTRY__PARAMETER_DESCRIPTION = eINSTANCE.getLibraryEntry_ParameterDescription();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY_ENTRY__DESCRIPTION = eINSTANCE.getLibraryEntry_Description();

		/**
		 * The meta object literal for the '<em><b>Thumbnail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY_ENTRY__THUMBNAIL = eINSTANCE.getLibraryEntry_Thumbnail();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIBRARY_ENTRY__AUTHOR = eINSTANCE.getLibraryEntry_Author();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryImpl
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getLibrary()
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
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ItemImpl <em>Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ItemImpl
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getItem()
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
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryItemImpl <em>Library Item</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryItemImpl
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getLibraryItem()
		 * @generated
		 */
		EClass LIBRARY_ITEM = eINSTANCE.getLibraryItem();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ParameterDescriptionImpl <em>Parameter Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ParameterDescriptionImpl
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getParameterDescription()
		 * @generated
		 */
		EClass PARAMETER_DESCRIPTION = eINSTANCE.getParameterDescription();

		/**
		 * The meta object literal for the '<em><b>Resource Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS = eINSTANCE.getParameterDescription_ResourceParameters();

		/**
		 * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DESCRIPTION__ID = eINSTANCE.getParameterDescription_ID();

		/**
		 * The meta object literal for the '<em><b>Get External Reference Parameters</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER_DESCRIPTION___GET_EXTERNAL_REFERENCE_PARAMETERS = eINSTANCE.getParameterDescription__GetExternalReferenceParameters();

		/**
		 * The meta object literal for the '<em><b>Get Container Parameters</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER_DESCRIPTION___GET_CONTAINER_PARAMETERS = eINSTANCE.getParameterDescription__GetContainerParameters();

		/**
		 * The meta object literal for the '<em><b>Get Attribute Parameters</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PARAMETER_DESCRIPTION___GET_ATTRIBUTE_PARAMETERS = eINSTANCE.getParameterDescription__GetAttributeParameters();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ResourceParameterImpl <em>Resource Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ResourceParameterImpl
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getResourceParameter()
		 * @generated
		 */
		EClass RESOURCE_PARAMETER = eINSTANCE.getResourceParameter();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PARAMETER__NAME = eINSTANCE.getResourceParameter_Name();

		/**
		 * The meta object literal for the '<em><b>New Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_PARAMETER__NEW_PATH = eINSTANCE.getResourceParameter_NewPath();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter <em>Abstract External Reference Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getAbstractExternalReferenceParameter()
		 * @generated
		 */
		EClass ABSTRACT_EXTERNAL_REFERENCE_PARAMETER = eINSTANCE.getAbstractExternalReferenceParameter();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_EXTERNAL_REFERENCE_PARAMETER__SOURCE = eINSTANCE.getAbstractExternalReferenceParameter_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_EXTERNAL_REFERENCE_PARAMETER__TARGET = eINSTANCE.getAbstractExternalReferenceParameter_Target();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter <em>Abstract Container Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getAbstractContainerParameter()
		 * @generated
		 */
		EClass ABSTRACT_CONTAINER_PARAMETER = eINSTANCE.getAbstractContainerParameter();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_CONTAINER_PARAMETER__SOURCE = eINSTANCE.getAbstractContainerParameter_Source();

		/**
		 * The meta object literal for the '<em><b>Container</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_CONTAINER_PARAMETER__CONTAINER = eINSTANCE.getAbstractContainerParameter_Container();

		/**
		 * The meta object literal for the '<em><b>Get Reference</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_CONTAINER_PARAMETER___GET_REFERENCE = eINSTANCE.getAbstractContainerParameter__GetReference();

		/**
		 * The meta object literal for the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter <em>Abstract Attribute Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter
		 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryPackageImpl#getAbstractAttributeParameter()
		 * @generated
		 */
		EClass ABSTRACT_ATTRIBUTE_PARAMETER = eINSTANCE.getAbstractAttributeParameter();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ATTRIBUTE_PARAMETER__SOURCE = eINSTANCE.getAbstractAttributeParameter_Source();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_ATTRIBUTE_PARAMETER__NEW_VALUE = eINSTANCE.getAbstractAttributeParameter_NewValue();

		/**
		 * The meta object literal for the '<em><b>Get Attribute</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation ABSTRACT_ATTRIBUTE_PARAMETER___GET_ATTRIBUTE = eINSTANCE.getAbstractAttributeParameter__GetAttribute();

	}

} //LibraryPackage
