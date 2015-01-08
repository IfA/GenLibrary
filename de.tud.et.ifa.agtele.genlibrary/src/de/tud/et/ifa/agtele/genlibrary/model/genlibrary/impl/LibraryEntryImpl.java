/**
 */
package de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;

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
 * <ul>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getLibraryItem <em>Library Item</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getMetaData <em>Meta Data</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.LibraryEntryImpl#getThumbnail <em>Thumbnail</em>}</li>
 * </ul>
 * </p>
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
	 * The cached value of the '{@link #getMetaData() <em>Meta Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaData()
	 * @generated
	 * @ordered
	 */
	protected MetaData metaData;

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
	public MetaData getMetaData() {
		return metaData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetaData(MetaData newMetaData, NotificationChain msgs) {
		MetaData oldMetaData = metaData;
		metaData = newMetaData;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__META_DATA, oldMetaData, newMetaData);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetaData(MetaData newMetaData) {
		if (newMetaData != metaData) {
			NotificationChain msgs = null;
			if (metaData != null)
				msgs = ((InternalEObject)metaData).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GenLibraryPackage.LIBRARY_ENTRY__META_DATA, null, msgs);
			if (newMetaData != null)
				msgs = ((InternalEObject)newMetaData).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GenLibraryPackage.LIBRARY_ENTRY__META_DATA, null, msgs);
			msgs = basicSetMetaData(newMetaData, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.LIBRARY_ENTRY__META_DATA, newMetaData, newMetaData));
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenLibraryPackage.LIBRARY_ENTRY__LIBRARY_ITEM:
				return basicSetLibraryItem(null, msgs);
			case GenLibraryPackage.LIBRARY_ENTRY__META_DATA:
				return basicSetMetaData(null, msgs);
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
			case GenLibraryPackage.LIBRARY_ENTRY__META_DATA:
				return getMetaData();
			case GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION:
				return getDescription();
			case GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL:
				return getThumbnail();
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
			case GenLibraryPackage.LIBRARY_ENTRY__META_DATA:
				setMetaData((MetaData)newValue);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL:
				setThumbnail((String)newValue);
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
			case GenLibraryPackage.LIBRARY_ENTRY__META_DATA:
				setMetaData((MetaData)null);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL:
				setThumbnail(THUMBNAIL_EDEFAULT);
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
			case GenLibraryPackage.LIBRARY_ENTRY__META_DATA:
				return metaData != null;
			case GenLibraryPackage.LIBRARY_ENTRY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case GenLibraryPackage.LIBRARY_ENTRY__THUMBNAIL:
				return THUMBNAIL_EDEFAULT == null ? thumbnail != null : !THUMBNAIL_EDEFAULT.equals(thumbnail);
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
		result.append(')');
		return result.toString();
	}

} //LibraryEntryImpl
