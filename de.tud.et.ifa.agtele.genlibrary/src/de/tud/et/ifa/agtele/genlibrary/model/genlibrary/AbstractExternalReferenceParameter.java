/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract External Reference Parameter</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter#getSource
 * <em>Source</em>}</li>
 * <li>
 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter#getTarget
 * <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getAbstractExternalReferenceParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AbstractExternalReferenceParameter<ExternalReferenceParameterSourceType, ExternalReferenceParameterTargetType> extends EObject {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(Object)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getAbstractExternalReferenceParameter_Source()
	 * @model kind="reference" containment="true" required="true"
	 * @generated
	 */
	ExternalReferenceParameterSourceType getSource();

	/**
	 * Sets the value of the '
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter#getSource
	 * <em>Source</em>}' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ExternalReferenceParameterSourceType value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Object)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getAbstractExternalReferenceParameter_Target()
	 * @model kind="reference"
	 * @generated
	 */
	ExternalReferenceParameterTargetType getTarget();

	/**
	 * Sets the value of the '
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter#getTarget
	 * <em>Target</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ExternalReferenceParameterTargetType value);
} // AbstractExternalReferenceParameter
