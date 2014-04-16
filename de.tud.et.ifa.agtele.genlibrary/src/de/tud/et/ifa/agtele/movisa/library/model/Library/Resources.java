/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.tud.et.ifa.agtele.movisa.library.model.Library;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Resources</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resources#getResources
 * <em>Resources</em>}</li>
 * </ul>
 * </p>
 * 
 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryPackage#getResources()
 * @model
 * @generated
 */
public interface Resources extends EObject {
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment
	 * reference list. The list contents are of type
	 * {@link de.tud.et.ifa.agtele.movisa.library.model.Library.Resource}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see de.tud.et.ifa.agtele.movisa.library.model.Library.LibraryPackage#getResources_Resources()
	 * @model type="de.tud.et.ifa.agtele.movisa.library.model.Library.Resource"
	 *        containment="true"
	 * @generated
	 */
	EList getResources();

} // Resources
