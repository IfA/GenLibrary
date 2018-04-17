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
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryFactory;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class GenLibraryPackageImpl extends EPackageImpl implements GenLibraryPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEntryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceParameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractExternalReferenceParameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractContainerParameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractAttributeParameterEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GenLibraryPackageImpl() {
		super(eNS_URI, GenLibraryFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link GenLibraryPackage#eINSTANCE}
	 * when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GenLibraryPackage init() {
		if (isInited) return (GenLibraryPackage)EPackage.Registry.INSTANCE.getEPackage(GenLibraryPackage.eNS_URI);

		// Obtain or create and register package
		GenLibraryPackageImpl theGenLibraryPackage = (GenLibraryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GenLibraryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GenLibraryPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theGenLibraryPackage.createPackageContents();

		// Initialize created meta-data
		theGenLibraryPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGenLibraryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GenLibraryPackage.eNS_URI, theGenLibraryPackage);
		return theGenLibraryPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLibraryEntry() {
		return libraryEntryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLibraryEntry_Version() {
		return (EAttribute)libraryEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLibraryEntry_LibraryItem() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLibraryEntry_ParameterDescription() {
		return (EReference)libraryEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLibraryEntry_Description() {
		return (EAttribute)libraryEntryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLibraryEntry_Thumbnail() {
		return (EAttribute)libraryEntryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLibraryEntry_Author() {
		return (EAttribute)libraryEntryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLibrary_Checksum() {
		return (EAttribute)libraryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLibrary_Items() {
		return (EReference)libraryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getItem() {
		return itemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getItem_Key() {
		return (EAttribute)itemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getItem_Path() {
		return (EAttribute)itemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getItem_Version() {
		return (EAttribute)itemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLibraryItem() {
		return libraryItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getParameterDescription() {
		return parameterDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getParameterDescription_ResourceParameters() {
		return (EReference)parameterDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getParameterDescription_ID() {
		return (EAttribute)parameterDescriptionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParameterDescription__GetExternalReferenceParameters() {
		return parameterDescriptionEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParameterDescription__GetContainerParameters() {
		return parameterDescriptionEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getParameterDescription__GetAttributeParameters() {
		return parameterDescriptionEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getResourceParameter() {
		return resourceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResourceParameter_Name() {
		return (EAttribute)resourceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getResourceParameter_NewPath() {
		return (EAttribute)resourceParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractExternalReferenceParameter() {
		return abstractExternalReferenceParameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractExternalReferenceParameter_Source() {
		return (EReference)abstractExternalReferenceParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractExternalReferenceParameter_Target() {
		return (EReference)abstractExternalReferenceParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractContainerParameter() {
		return abstractContainerParameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractContainerParameter_Source() {
		return (EReference)abstractContainerParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractContainerParameter_Container() {
		return (EReference)abstractContainerParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractContainerParameter__GetReference() {
		return abstractContainerParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractAttributeParameter() {
		return abstractAttributeParameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractAttributeParameter_Source() {
		return (EReference)abstractAttributeParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAbstractAttributeParameter_NewValue() {
		return (EAttribute)abstractAttributeParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getAbstractAttributeParameter__GetAttribute() {
		return abstractAttributeParameterEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GenLibraryFactory getGenLibraryFactory() {
		return (GenLibraryFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		libraryEntryEClass = createEClass(LIBRARY_ENTRY);
		createEAttribute(libraryEntryEClass, LIBRARY_ENTRY__VERSION);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__LIBRARY_ITEM);
		createEReference(libraryEntryEClass, LIBRARY_ENTRY__PARAMETER_DESCRIPTION);
		createEAttribute(libraryEntryEClass, LIBRARY_ENTRY__DESCRIPTION);
		createEAttribute(libraryEntryEClass, LIBRARY_ENTRY__THUMBNAIL);
		createEAttribute(libraryEntryEClass, LIBRARY_ENTRY__AUTHOR);

		libraryEClass = createEClass(LIBRARY);
		createEAttribute(libraryEClass, LIBRARY__CHECKSUM);
		createEReference(libraryEClass, LIBRARY__ITEMS);

		itemEClass = createEClass(ITEM);
		createEAttribute(itemEClass, ITEM__KEY);
		createEAttribute(itemEClass, ITEM__PATH);
		createEAttribute(itemEClass, ITEM__VERSION);

		libraryItemEClass = createEClass(LIBRARY_ITEM);

		parameterDescriptionEClass = createEClass(PARAMETER_DESCRIPTION);
		createEReference(parameterDescriptionEClass, PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS);
		createEAttribute(parameterDescriptionEClass, PARAMETER_DESCRIPTION__ID);
		createEOperation(parameterDescriptionEClass, PARAMETER_DESCRIPTION___GET_EXTERNAL_REFERENCE_PARAMETERS);
		createEOperation(parameterDescriptionEClass, PARAMETER_DESCRIPTION___GET_CONTAINER_PARAMETERS);
		createEOperation(parameterDescriptionEClass, PARAMETER_DESCRIPTION___GET_ATTRIBUTE_PARAMETERS);

		resourceParameterEClass = createEClass(RESOURCE_PARAMETER);
		createEAttribute(resourceParameterEClass, RESOURCE_PARAMETER__NAME);
		createEAttribute(resourceParameterEClass, RESOURCE_PARAMETER__NEW_PATH);

		abstractExternalReferenceParameterEClass = createEClass(ABSTRACT_EXTERNAL_REFERENCE_PARAMETER);
		createEReference(abstractExternalReferenceParameterEClass, ABSTRACT_EXTERNAL_REFERENCE_PARAMETER__SOURCE);
		createEReference(abstractExternalReferenceParameterEClass, ABSTRACT_EXTERNAL_REFERENCE_PARAMETER__TARGET);

		abstractContainerParameterEClass = createEClass(ABSTRACT_CONTAINER_PARAMETER);
		createEReference(abstractContainerParameterEClass, ABSTRACT_CONTAINER_PARAMETER__SOURCE);
		createEReference(abstractContainerParameterEClass, ABSTRACT_CONTAINER_PARAMETER__CONTAINER);
		createEOperation(abstractContainerParameterEClass, ABSTRACT_CONTAINER_PARAMETER___GET_REFERENCE);

		abstractAttributeParameterEClass = createEClass(ABSTRACT_ATTRIBUTE_PARAMETER);
		createEReference(abstractAttributeParameterEClass, ABSTRACT_ATTRIBUTE_PARAMETER__SOURCE);
		createEAttribute(abstractAttributeParameterEClass, ABSTRACT_ATTRIBUTE_PARAMETER__NEW_VALUE);
		createEOperation(abstractAttributeParameterEClass, ABSTRACT_ATTRIBUTE_PARAMETER___GET_ATTRIBUTE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		ETypeParameter abstractExternalReferenceParameterEClass_ExternalReferenceParameterSourceType = addETypeParameter(abstractExternalReferenceParameterEClass, "ExternalReferenceParameterSourceType");
		ETypeParameter abstractExternalReferenceParameterEClass_ExternalReferenceParameterTargetType = addETypeParameter(abstractExternalReferenceParameterEClass, "ExternalReferenceParameterTargetType");
		ETypeParameter abstractContainerParameterEClass_ContainerParameterSourceType = addETypeParameter(abstractContainerParameterEClass, "ContainerParameterSourceType");
		ETypeParameter abstractContainerParameterEClass_ContainerParameterTargetType = addETypeParameter(abstractContainerParameterEClass, "ContainerParameterTargetType");
		ETypeParameter abstractAttributeParameterEClass_AttributeParameterSourceType = addETypeParameter(abstractAttributeParameterEClass, "AttributeParameterSourceType");

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(libraryEntryEClass, LibraryEntry.class, "LibraryEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLibraryEntry_Version(), ecorePackage.getEString(), "Version", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_LibraryItem(), this.getLibraryItem(), null, "LibraryItem", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibraryEntry_ParameterDescription(), this.getParameterDescription(), null, "parameterDescription", null, 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibraryEntry_Description(), ecorePackage.getEString(), "description", null, 0, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibraryEntry_Thumbnail(), ecorePackage.getEString(), "thumbnail", null, 0, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLibraryEntry_Author(), ecorePackage.getEString(), "author", "unknown", 1, 1, LibraryEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLibrary_Checksum(), ecorePackage.getEString(), "Checksum", null, 1, 1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLibrary_Items(), this.getItem(), null, "Items", null, 0, -1, Library.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(itemEClass, Item.class, "Item", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getItem_Key(), ecorePackage.getEString(), "Key", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getItem_Path(), ecorePackage.getEString(), "Path", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getItem_Version(), ecorePackage.getEString(), "Version", null, 1, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryItemEClass, LibraryItem.class, "LibraryItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterDescriptionEClass, ParameterDescription.class, "ParameterDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterDescription_ResourceParameters(), this.getResourceParameter(), null, "resourceParameters", null, 0, -1, ParameterDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterDescription_ID(), ecorePackage.getEString(), "ID", null, 1, 1, ParameterDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getParameterDescription__GetExternalReferenceParameters(), null, "getExternalReferenceParameters", 1, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEEList());
		EGenericType g2 = createEGenericType(this.getAbstractExternalReferenceParameter());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(ecorePackage.getEObject());
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(ecorePackage.getEObject());
		g2.getETypeArguments().add(g3);
		initEOperation(op, g1);

		op = initEOperation(getParameterDescription__GetContainerParameters(), null, "getContainerParameters", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getAbstractContainerParameter());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(ecorePackage.getEObject());
		g2.getETypeArguments().add(g3);
		g3 = createEGenericType(ecorePackage.getEObject());
		g2.getETypeArguments().add(g3);
		initEOperation(op, g1);

		op = initEOperation(getParameterDescription__GetAttributeParameters(), null, "getAttributeParameters", 1, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEEList());
		g2 = createEGenericType(this.getAbstractAttributeParameter());
		g1.getETypeArguments().add(g2);
		g3 = createEGenericType(ecorePackage.getEObject());
		g2.getETypeArguments().add(g3);
		initEOperation(op, g1);

		initEClass(resourceParameterEClass, ResourceParameter.class, "ResourceParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResourceParameter_Name(), ecorePackage.getEString(), "Name", null, 1, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getResourceParameter_NewPath(), ecorePackage.getEString(), "newPath", null, 1, 1, ResourceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractExternalReferenceParameterEClass, AbstractExternalReferenceParameter.class, "AbstractExternalReferenceParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(abstractExternalReferenceParameterEClass_ExternalReferenceParameterSourceType);
		initEReference(getAbstractExternalReferenceParameter_Source(), g1, null, "source", null, 1, 1, AbstractExternalReferenceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(abstractExternalReferenceParameterEClass_ExternalReferenceParameterTargetType);
		initEReference(getAbstractExternalReferenceParameter_Target(), g1, null, "target", null, 0, 1, AbstractExternalReferenceParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractContainerParameterEClass, AbstractContainerParameter.class, "AbstractContainerParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(abstractContainerParameterEClass_ContainerParameterSourceType);
		initEReference(getAbstractContainerParameter_Source(), g1, null, "source", null, 1, 1, AbstractContainerParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(abstractContainerParameterEClass_ContainerParameterTargetType);
		initEReference(getAbstractContainerParameter_Container(), g1, null, "container", null, 0, 1, AbstractContainerParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAbstractContainerParameter__GetReference(), ecorePackage.getEReference(), "getReference", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(abstractAttributeParameterEClass, AbstractAttributeParameter.class, "AbstractAttributeParameter", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(abstractAttributeParameterEClass_AttributeParameterSourceType);
		initEReference(getAbstractAttributeParameter_Source(), g1, null, "source", null, 1, 1, AbstractAttributeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractAttributeParameter_NewValue(), ecorePackage.getEString(), "newValue", null, 0, 1, AbstractAttributeParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getAbstractAttributeParameter__GetAttribute(), ecorePackage.getEAttribute(), "getAttribute", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // GenLibraryPackageImpl
