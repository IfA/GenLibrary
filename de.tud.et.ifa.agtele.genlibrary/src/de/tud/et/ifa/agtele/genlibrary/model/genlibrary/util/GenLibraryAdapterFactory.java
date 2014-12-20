/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary.util;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage
 * @generated
 */
public class GenLibraryAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GenLibraryPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GenLibraryAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GenLibraryPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenLibrarySwitch<Adapter> modelSwitch =
		new GenLibrarySwitch<Adapter>() {
			@Override
			public Adapter caseLibraryEntry(LibraryEntry object) {
				return createLibraryEntryAdapter();
			}
			@Override
			public Adapter caseLibrary(Library object) {
				return createLibraryAdapter();
			}
			@Override
			public Adapter caseItem(Item object) {
				return createItemAdapter();
			}
			@Override
			public Adapter caseLibraryItem(LibraryItem object) {
				return createLibraryItemAdapter();
			}
			@Override
			public Adapter caseMetaData(MetaData object) {
				return createMetaDataAdapter();
			}
			@Override
			public Adapter caseResource(Resource object) {
				return createResourceAdapter();
			}
			@Override
			public <ExternalReferenceMapperSourceType, ExternalReferenceMapperTargetType> Adapter caseAbstractExternalReferenceMapper(AbstractExternalReferenceMapper<ExternalReferenceMapperSourceType, ExternalReferenceMapperTargetType> object) {
				return createAbstractExternalReferenceMapperAdapter();
			}
			@Override
			public <ContainerMapperSourceType, ContainerMapperTargetType> Adapter caseAbstractContainerMapper(AbstractContainerMapper<ContainerMapperSourceType, ContainerMapperTargetType> object) {
				return createAbstractContainerMapperAdapter();
			}
			@Override
			public <AttributeMapperSourceType> Adapter caseAbstractAttributeMapper(AbstractAttributeMapper<AttributeMapperSourceType> object) {
				return createAbstractAttributeMapperAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry <em>Library Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry
	 * @generated
	 */
	public Adapter createLibraryEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Library
	 * @generated
	 */
	public Adapter createLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Item
	 * @generated
	 */
	public Adapter createItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem <em>Library Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem
	 * @generated
	 */
	public Adapter createLibraryItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData
	 * @generated
	 */
	public Adapter createMetaDataAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Resource
	 * @generated
	 */
	public Adapter createResourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceMapper <em>Abstract External Reference Mapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceMapper
	 * @generated
	 */
	public Adapter createAbstractExternalReferenceMapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerMapper <em>Abstract Container Mapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerMapper
	 * @generated
	 */
	public Adapter createAbstractContainerMapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeMapper <em>Abstract Attribute Mapper</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeMapper
	 * @generated
	 */
	public Adapter createAbstractAttributeMapperAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LibraryAdapterFactory
