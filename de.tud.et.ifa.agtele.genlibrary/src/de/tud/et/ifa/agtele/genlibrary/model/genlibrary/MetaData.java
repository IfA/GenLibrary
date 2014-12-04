/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Meta Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData#getResources <em>Resources</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getMetaData()
 * @model
 * @generated
 */
public interface MetaData extends EObject {
	/**
	 * Returns the value of the '<em><b>Resources</b></em>' containment reference list.
	 * The list contents are of type {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Resource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' containment reference list.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getMetaData_Resources()
	 * @model containment="true"
	 * @generated
	 */
	EList<Resource> getResources();

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getMetaData_ID()
	 * @model required="true"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData#getID <em>ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" many="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AbstractExternalReferenceMapper<EObject, EObject>> abstractMappers = \r\n\t\tnew BasicEList<AbstractExternalReferenceMapper<EObject, EObject>>();\r\n\r\n// recursively iterate over all children of the metadata and collect\r\n// all objects that are of type \'AbstractMapper\'\r\nIterator<Object> it = EcoreUtil.getAllContents(this, true);\r\nwhile (it.hasNext()) {\r\n\tObject object = it.next();\r\n\tif (object instanceof AbstractExternalReferenceMapper<?, ?>) {\r\n\t\tabstractMappers.add((AbstractExternalReferenceMapper<EObject, EObject>) object);\r\n\t}\r\n}\r\n\r\nreturn abstractMappers;'"
	 * @generated
	 */
	EList<AbstractExternalReferenceMapper<EObject, EObject>> getExternalReferenceMappers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true" many="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AbstractContainerMapper<EObject, EObject>> abstractMappers = \r\n\t\tnew BasicEList<AbstractContainerMapper<EObject, EObject>>();\r\n\r\n// recursively iterate over all children of the metadata and collect\r\n// all objects that are of type \'AbstractMapper\'\r\nIterator<Object> it = EcoreUtil.getAllContents(this, true);\r\nwhile (it.hasNext()) {\r\n\tObject object = it.next();\r\n\tif (object instanceof AbstractContainerMapper<?, ?>) {\r\n\t\tabstractMappers.add((AbstractContainerMapper<EObject, EObject>) object);\r\n\t}\r\n}\r\n\r\nreturn abstractMappers;'"
	 * @generated
	 */
	EList<AbstractContainerMapper<EObject, EObject>> getContainerMappers();

} // MetaData
