/**
 */
package de.tud.et.ifa.agtele.movisa.library.model.Library;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resource#getName <em>Name</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resource#getNewPath <em>New Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryPackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryPackage#getResource_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resource#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>New Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Path</em>' attribute.
	 * @see #setNewPath(String)
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryPackage#getResource_NewPath()
	 * @model required="true"
	 * @generated
	 */
	String getNewPath();

	/**
	 * Sets the value of the '{@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resource#getNewPath <em>New Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Path</em>' attribute.
	 * @see #getNewPath()
	 * @generated
	 */
	void setNewPath(String value);

} // Resource
