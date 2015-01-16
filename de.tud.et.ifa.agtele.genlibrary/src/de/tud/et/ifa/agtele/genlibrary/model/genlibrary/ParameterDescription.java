/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Meta Data</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getResourceParameters
 * <em>Resource Parameters</em>}</li>
 * <li>
 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getID
 * <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getParameterDescription()
 * @model
 * @generated
 */
public interface ParameterDescription extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource Parameters</b></em>'
	 * containment reference list. The list contents are of type
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter}
	 * . <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' containment reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Resource Parameters</em>' containment
	 *         reference list.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getParameterDescription_ResourceParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<ResourceParameter> getResourceParameters();

	/**
	 * Returns the value of the '<em><b>ID</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ID</em>' attribute isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>ID</em>' attribute.
	 * @see #setID(String)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getParameterDescription_ID()
	 * @model required="true"
	 * @generated
	 */
	String getID();

	/**
	 * Sets the value of the '
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription#getID
	 * <em>ID</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>ID</em>' attribute.
	 * @see #getID()
	 * @generated
	 */
	void setID(String value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" required="true" many="false" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='EList<AbstractExternalReferenceParameter<EObject, EObject>> abstractParameters = \r\n\t\tnew BasicEList<AbstractExternalReferenceParameter<EObject, EObject>>();\r\n\r\n// recursively iterate over all children of the parameters and collect\r\n// all objects that are of type \'AbstractParameter\'\r\nIterator<Object> it = EcoreUtil.getAllContents(this, true);\r\nwhile (it.hasNext()) {\r\n\tObject object = it.next();\r\n\tif (object instanceof AbstractExternalReferenceParameter<?, ?>) {\r\n\t\tabstractParameters.add((AbstractExternalReferenceParameter<EObject, EObject>) object);\r\n\t}\r\n}\r\n\r\nreturn abstractParameters;'"
	 * @generated
	 */
	EList<AbstractExternalReferenceParameter<EObject, EObject>> getExternalReferenceParameters();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" required="true" many="false" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='EList<AbstractContainerParameter<EObject, EObject>> abstractParameters = \r\n\t\tnew BasicEList<AbstractContainerParameter<EObject, EObject>>();\r\n\r\n// recursively iterate over all children of the parameters and collect\r\n// all objects that are of type \'AbstractParameter\'\r\nIterator<Object> it = EcoreUtil.getAllContents(this, true);\r\nwhile (it.hasNext()) {\r\n\tObject object = it.next();\r\n\tif (object instanceof AbstractContainerParameter<?, ?>) {\r\n\t\tabstractParameters.add((AbstractContainerParameter<EObject, EObject>) object);\r\n\t}\r\n}\r\n\r\nreturn abstractParameters;'"
	 * @generated
	 */
	EList<AbstractContainerParameter<EObject, EObject>> getContainerParameters();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" required="true" many="false" annotation=
	 *        "http://www.eclipse.org/emf/2002/GenModel body='EList<AbstractAttributeParameter<EObject>> abstractParameters = \r\n\t\tnew BasicEList<AbstractAttributeParameter<EObject>>();\r\n\r\n// recursively iterate over all children of the parameters and collect\r\n// all objects that are of type \'AbstractParameter\'\r\nIterator<Object> it = EcoreUtil.getAllContents(this, true);\r\nwhile (it.hasNext()) {\r\n\tObject object = it.next();\r\n\tif (object instanceof AbstractAttributeParameter<?>) {\r\n\t\tabstractParameters.add((AbstractAttributeParameter<EObject>) object);\r\n\t}\r\n}\r\n\r\nreturn abstractParameters;'"
	 * @generated
	 */
	EList<AbstractAttributeParameter<EObject>> getAttributeParameters();

} // ParameterDescription
