/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract External Reference Mapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AbstractExternalReferenceMapperImpl<ExternalReferenceMapperSourceType, ExternalReferenceMapperTargetType> extends AbstractMapperImpl<ExternalReferenceMapperSourceType, ExternalReferenceMapperTargetType> implements AbstractExternalReferenceMapper<ExternalReferenceMapperSourceType, ExternalReferenceMapperTargetType> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractExternalReferenceMapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenLibraryPackage.Literals.ABSTRACT_EXTERNAL_REFERENCE_MAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public NotificationChain basicSetSource(ExternalReferenceMapperSourceType newSource, NotificationChain msgs) {
		return super.basicSetSource(newSource, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setTarget(ExternalReferenceMapperTargetType newTarget) {
		super.setTarget(newTarget);
	}

} //AbstractExternalReferenceMapperImpl
