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

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getLibraryItem <em>Library Item</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getParameterDescription <em>Parameter Description</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getThumbnail <em>Thumbnail</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getAuthor <em>Author</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LibraryEntryImpl extends EObjectImpl implements LibraryEntry {
	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLibraryItem() <em>Library Item</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraryItem()
	 * @generated
	 * @ordered
	 */
	protected LibraryItem libraryItem;

	/**
	 * The cached value of the '{@link #getParameterDescription() <em>Parameter Description</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterDescription()
	 * @generated
	 * @ordered
	 */
	protected ParameterDescription parameterDescription;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getThumbnail() <em>Thumbnail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnail()
	 * @generated
	 * @ordered
	 */
	protected static final String THUMBNAIL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getThumbnail() <em>Thumbnail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThumbnail()
	 * @generated
	 * @ordered
	 */
	protected String thumbnail = THUMBNAIL_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = "unknown";

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenLibraryPackage.Literals.LIBRARY_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryItem getLibraryItem() {
		return libraryItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLibraryItem(LibraryItem newLibraryItem, NotificationChain msgs) {
		LibraryItem oldLibraryItem = libraryItem;
		libraryItem = newLibraryItem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM, oldLibraryItem, newLibraryItem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLibraryItem(LibraryItem newLibraryItem) {
		if (newLibraryItem != libraryItem) {
			NotificationChain msgs = null;
			if (libraryItem != null)
				msgs = ((InternalEObject)libraryItem).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM, null, msgs);
			if (newLibraryItem != null)
				msgs = ((InternalEObject)newLibraryItem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM, null, msgs);
			msgs = basicSetLibraryItem(newLibraryItem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM, newLibraryItem, newLibraryItem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDescription getParameterDescription() {
		return parameterDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterDescription(ParameterDescription newParameterDescription, NotificationChain msgs) {
		ParameterDescription oldParameterDescription = parameterDescription;
		parameterDescription = newParameterDescription;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION, oldParameterDescription, newParameterDescription);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterDescription(ParameterDescription newParameterDescription) {
		if (newParameterDescription != parameterDescription) {
			NotificationChain msgs = null;
			if (parameterDescription != null)
				msgs = ((InternalEObject)parameterDescription).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION, null, msgs);
			if (newParameterDescription != null)
				msgs = ((InternalEObject)newParameterDescription).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION, null, msgs);
			msgs = basicSetParameterDescription(newParameterDescription, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION, newParameterDescription, newParameterDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getThumbnail() {
		return thumbnail;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThumbnail(String newThumbnail) {
		String oldThumbnail = thumbnail;
		thumbnail = newThumbnail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL, oldThumbnail, thumbnail));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				return basicSetLibraryItem(null, msgs);
			case GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION:
				return basicSetParameterDescription(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenLibraryPackage.LIBRARY_ENTRY__VERSION:
				return getVersion();
			case GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				return getLibraryItem();
			case GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION:
				return getParameterDescription();
			case GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION:
				return getDescription();
			case GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL:
				return getThumbnail();
			case GenLibraryPackage.LIBRARY_ENTRY__AUTHOR:
				return getAuthor();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GenLibraryPackage.LIBRARY_ENTRY__VERSION:
				setVersion((String)newValue);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				setLibraryItem((LibraryItem)newValue);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION:
				setParameterDescription((ParameterDescription)newValue);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL:
				setThumbnail((String)newValue);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__AUTHOR:
				setAuthor((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case GenLibraryPackage.LIBRARY_ENTRY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				setLibraryItem((LibraryItem)null);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION:
				setParameterDescription((ParameterDescription)null);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL:
				setThumbnail(THUMBNAIL_EDEFAULT);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case GenLibraryPackage.LIBRARY_ENTRY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				return libraryItem != null;
			case GenLibraryPackage.LIBRARY_ENTRY__PARAMETER_DESCRIPTION:
				return parameterDescription != null;
			case GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL:
				return THUMBNAIL_EDEFAULT == null ? thumbnail != null : !THUMBNAIL_EDEFAULT.equals(thumbnail);
			case GenLibraryPackage.LIBRARY_ENTRY__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (Version: ");
		result.append(version);
		result.append(", description: ");
		result.append(description);
		result.append(", thumbnail: ");
		result.append(thumbnail);
		result.append(", author: ");
		result.append(author);
		result.append(')');
		return result.toString();
	}

} //LibraryEntryImpl
