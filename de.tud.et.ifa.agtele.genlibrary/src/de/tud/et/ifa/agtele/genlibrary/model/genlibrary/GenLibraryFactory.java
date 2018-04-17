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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage
 * @generated
 */
public interface GenLibraryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GenLibraryFactory eINSTANCE = de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.GenLibraryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Library Entry</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library Entry</em>'.
	 * @generated
	 */
	LibraryEntry createLibraryEntry();

	/**
	 * Returns a new object of class '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library</em>'.
	 * @generated
	 */
	Library createLibrary();

	/**
	 * Returns a new object of class '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Item</em>'.
	 * @generated
	 */
	Item createItem();

	/**
	 * Returns a new object of class '<em>Library Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Library Item</em>'.
	 * @generated
	 */
	LibraryItem createLibraryItem();

	/**
	 * Returns a new object of class '<em>Parameter Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Description</em>'.
	 * @generated
	 */
	ParameterDescription createParameterDescription();

	/**
	 * Returns a new object of class '<em>Resource Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Parameter</em>'.
	 * @generated
	 */
	ResourceParameter createResourceParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GenLibraryPackage getGenLibraryPackage();

} //LibraryFactory
