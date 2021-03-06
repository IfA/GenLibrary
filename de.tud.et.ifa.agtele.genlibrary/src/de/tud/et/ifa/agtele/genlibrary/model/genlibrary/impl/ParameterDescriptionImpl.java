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

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter;
import java.lang.reflect.InvocationTargetException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Parameter Description</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ParameterDescriptionImpl#getResourceParameters <em>Resource Parameters</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.ParameterDescriptionImpl#getID <em>ID</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterDescriptionImpl extends EObjectImpl implements ParameterDescription {
	/**
	 * The cached value of the '{@link #getResourceParameters()
	 * <em>Resource Parameters</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getResourceParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ResourceParameter> resourceParameters;

	/**
	 * The default value of the '{@link #getID() <em>ID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getID() <em>ID</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getID()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterDescriptionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenLibraryPackage.Literals.PARAMETER_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ResourceParameter> getResourceParameters() {
		if (resourceParameters == null) {
			resourceParameters = new EObjectContainmentEList<ResourceParameter>(ResourceParameter.class, this, GenLibraryPackage.PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS);
		}
		return resourceParameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getID() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setID(String newID) {
		String oldID = id;
		id = newID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.PARAMETER_DESCRIPTION__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractExternalReferenceParameter<EObject, EObject>> getExternalReferenceParameters() {
		EList<AbstractExternalReferenceParameter<EObject, EObject>> abstractParameters = 
				new BasicEList<AbstractExternalReferenceParameter<EObject, EObject>>();
		
		// recursively iterate over all children of the metadata and collect
		// all objects that are of type 'AbstractParameter'
		Iterator<Object> it = EcoreUtil.getAllContents(this, true);
		while (it.hasNext()) {
			Object object = it.next();
			if (object instanceof AbstractExternalReferenceParameter<?, ?>) {
				abstractParameters.add((AbstractExternalReferenceParameter<EObject, EObject>) object);
			}
		}
		
		return abstractParameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractContainerParameter<EObject, EObject>> getContainerParameters() {
		EList<AbstractContainerParameter<EObject, EObject>> abstractParameters = 
				new BasicEList<AbstractContainerParameter<EObject, EObject>>();
		
		// recursively iterate over all children of the metadata and collect
		// all objects that are of type 'AbstractParameter'
		Iterator<Object> it = EcoreUtil.getAllContents(this, true);
		while (it.hasNext()) {
			Object object = it.next();
			if (object instanceof AbstractContainerParameter<?, ?>) {
				abstractParameters.add((AbstractContainerParameter<EObject, EObject>) object);
			}
		}
		
		return abstractParameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AbstractAttributeParameter<EObject>> getAttributeParameters() {
		EList<AbstractAttributeParameter<EObject>> abstractParameters = 
				new BasicEList<AbstractAttributeParameter<EObject>>();
		
		// recursively iterate over all children of the metadata and collect
		// all objects that are of type 'AbstractParameter'
		Iterator<Object> it = EcoreUtil.getAllContents(this, true);
		while (it.hasNext()) {
			Object object = it.next();
			if (object instanceof AbstractAttributeParameter<?>) {
				abstractParameters.add((AbstractAttributeParameter<EObject>) object);
			}
		}
		
		return abstractParameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenLibraryPackage.PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS:
				return ((InternalEList<?>)getResourceParameters()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenLibraryPackage.PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS:
				return getResourceParameters();
			case GenLibraryPackage.PARAMETER_DESCRIPTION__ID:
				return getID();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GenLibraryPackage.PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS:
				getResourceParameters().clear();
				getResourceParameters().addAll((Collection<? extends ResourceParameter>)newValue);
				return;
			case GenLibraryPackage.PARAMETER_DESCRIPTION__ID:
				setID((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GenLibraryPackage.PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS:
				getResourceParameters().clear();
				return;
			case GenLibraryPackage.PARAMETER_DESCRIPTION__ID:
				setID(ID_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GenLibraryPackage.PARAMETER_DESCRIPTION__RESOURCE_PARAMETERS:
				return resourceParameters != null && !resourceParameters.isEmpty();
			case GenLibraryPackage.PARAMETER_DESCRIPTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case GenLibraryPackage.PARAMETER_DESCRIPTION___GET_EXTERNAL_REFERENCE_PARAMETERS:
				return getExternalReferenceParameters();
			case GenLibraryPackage.PARAMETER_DESCRIPTION___GET_CONTAINER_PARAMETERS:
				return getContainerParameters();
			case GenLibraryPackage.PARAMETER_DESCRIPTION___GET_ATTRIBUTE_PARAMETERS:
				return getAttributeParameters();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (ID: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // ParameterDescriptionImpl
