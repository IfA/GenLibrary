/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getVersion <em>Version</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getLibraryItem <em>Library Item</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getMetaData <em>Meta Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getLibraryEntry()
 * @model
 * @generated
 */
public interface LibraryEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getLibraryEntry_Version()
	 * @model required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Library Item</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Library Item</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Library Item</em>' containment reference.
	 * @see #setLibraryItem(LibraryItem)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getLibraryEntry_LibraryItem()
	 * @model containment="true" required="true"
	 * @generated
	 */
	LibraryItem getLibraryItem();

	/**
	 * Sets the value of the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getLibraryItem <em>Library Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Library Item</em>' containment reference.
	 * @see #getLibraryItem()
	 * @generated
	 */
	void setLibraryItem(LibraryItem value);

	/**
	 * Returns the value of the '<em><b>Meta Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Data</em>' containment reference.
	 * @see #setMetaData(MetaData)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getLibraryEntry_MetaData()
	 * @model containment="true" required="true"
	 * @generated
	 */
	MetaData getMetaData();

	/**
	 * Sets the value of the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry#getMetaData <em>Meta Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Meta Data</em>' containment reference.
	 * @see #getMetaData()
	 * @generated
	 */
	void setMetaData(MetaData value);

} // LibraryEntry
