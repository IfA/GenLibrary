/**
 */
package de.tud.et.ifa.agtele.movisa.library.model.Library;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Library#getChecksum <em>Checksum</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Library#getItems <em>Items</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends EObject {
	/**
	 * Returns the value of the '<em><b>Checksum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Checksum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Checksum</em>' attribute.
	 * @see #setChecksum(String)
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryPackage#getLibrary_Checksum()
	 * @model required="true"
	 * @generated
	 */
	String getChecksum();

	/**
	 * Sets the value of the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Library#getChecksum <em>Checksum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Checksum</em>' attribute.
	 * @see #getChecksum()
	 * @generated
	 */
	void setChecksum(String value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link de.tud.et.ifa.agtele.movisa.library.model.Library.Item}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryPackage#getLibrary_Items()
	 * @model containment="true"
	 * @generated
	 */
	EList<Item> getItems();

} // Library
