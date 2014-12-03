/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Container Mapper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AbstractContainerMapperImpl<ContainerMapperSourceType, ContainerMapperTargetType> extends AbstractMapperImpl<ContainerMapperSourceType, ContainerMapperTargetType> implements AbstractContainerMapper<ContainerMapperSourceType, ContainerMapperTargetType> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractContainerMapperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenLibraryPackage.Literals.ABSTRACT_CONTAINER_MAPPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public NotificationChain basicSetSource(ContainerMapperSourceType newSource, NotificationChain msgs) {
		return super.basicSetSource(newSource, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific type known in this context.
	 * @generated
	 */
	@Override
	public void setTarget(ContainerMapperTargetType newTarget) {
		super.setTarget(newTarget);
	}

} //AbstractContainerMapperImpl
