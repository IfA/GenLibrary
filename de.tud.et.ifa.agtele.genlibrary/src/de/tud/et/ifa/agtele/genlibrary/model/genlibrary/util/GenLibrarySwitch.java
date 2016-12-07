/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary.util;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage
 * @generated
 */
public class GenLibrarySwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GenLibraryPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenLibrarySwitch() {
		if (modelPackage == null) {
			modelPackage = GenLibraryPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GenLibraryPackage.LIBRARY_ENTRY: {
				LibraryEntry libraryEntry = (LibraryEntry)theEObject;
				T result = caseLibraryEntry(libraryEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenLibraryPackage.LIBRARY: {
				Library library = (Library)theEObject;
				T result = caseLibrary(library);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenLibraryPackage.ITEM: {
				Item item = (Item)theEObject;
				T result = caseItem(item);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenLibraryPackage.LIBRARY_ITEM: {
				LibraryItem libraryItem = (LibraryItem)theEObject;
				T result = caseLibraryItem(libraryItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenLibraryPackage.PARAMETER_DESCRIPTION: {
				ParameterDescription parameterDescription = (ParameterDescription)theEObject;
				T result = caseParameterDescription(parameterDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenLibraryPackage.RESOURCE_PARAMETER: {
				ResourceParameter resourceParameter = (ResourceParameter)theEObject;
				T result = caseResourceParameter(resourceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenLibraryPackage.ABSTRACT_EXTERNAL_REFERENCE_PARAMETER: {
				AbstractExternalReferenceParameter<?, ?> abstractExternalReferenceParameter = (AbstractExternalReferenceParameter<?, ?>)theEObject;
				T result = caseAbstractExternalReferenceParameter(abstractExternalReferenceParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenLibraryPackage.ABSTRACT_CONTAINER_PARAMETER: {
				AbstractContainerParameter<?, ?> abstractContainerParameter = (AbstractContainerParameter<?, ?>)theEObject;
				T result = caseAbstractContainerParameter(abstractContainerParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GenLibraryPackage.ABSTRACT_ATTRIBUTE_PARAMETER: {
				AbstractAttributeParameter<?> abstractAttributeParameter = (AbstractAttributeParameter<?>)theEObject;
				T result = caseAbstractAttributeParameter(abstractAttributeParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibraryEntry(LibraryEntry object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibrary(Library object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseItem(Item object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibraryItem(LibraryItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterDescription(ParameterDescription object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceParameter(ResourceParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract External Reference Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract External Reference Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <ExternalReferenceParameterSourceType, ExternalReferenceParameterTargetType> T caseAbstractExternalReferenceParameter(AbstractExternalReferenceParameter<ExternalReferenceParameterSourceType, ExternalReferenceParameterTargetType> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Container Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Container Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <ContainerParameterSourceType, ContainerParameterTargetType> T caseAbstractContainerParameter(AbstractContainerParameter<ContainerParameterSourceType, ContainerParameterTargetType> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Attribute Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Attribute Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <AttributeParameterSourceType> T caseAbstractAttributeParameter(AbstractAttributeParameter<AttributeParameterSourceType> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //LibrarySwitch
