/*******************************************************************************
 * Copyright (C) 2018-2018 Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Abstract Container Parameter</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>
 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getSource
 * <em>Source</em>}</li>
 * <li>
 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getContainer
 * <em>Container</em>}</li>
 * </ul>
 *
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getAbstractContainerParameter()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AbstractContainerParameter<ContainerParameterSourceType, ContainerParameterTargetType> extends EObject {

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Object)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getAbstractContainerParameter_Source()
	 * @model kind="reference" required="true"
	 * @generated
	 */
	ContainerParameterSourceType getSource();

	/**
	 * Sets the value of the '
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getSource
	 * <em>Source</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ContainerParameterSourceType value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Container</em>' reference.
	 * @see #setContainer(Object)
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#getAbstractContainerParameter_Container()
	 * @model kind="reference"
	 * @generated
	 */
	ContainerParameterTargetType getContainer();

	/**
	 * Sets the value of the '
	 * {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter#getContainer
	 * <em>Container</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Container</em>' reference.
	 * @see #getContainer()
	 * @generated
	 */
	void setContainer(ContainerParameterTargetType value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" required="true"
	 * @generated
	 */
	EReference getReference();
} // AbstractContainerParameter
