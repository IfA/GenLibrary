/**
 */
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

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.GenLibraryPackage;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Resource;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Meta Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.MetaDataImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.impl.MetaDataImpl#getID <em>ID</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetaDataImpl extends EObjectImpl implements MetaData {
	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

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
	protected MetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenLibraryPackage.Literals.META_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<Resource>(Resource.class, this, GenLibraryPackage.META_DATA__RESOURCES);
		}
		return resources;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GenLibraryPackage.META_DATA__ID, oldID, id));
	}

	/**
	 * <!-- begin-user-doc -->This iterates through all direct and indirect
	 * children of this MetaData object and returns all objects that are of type
	 * 'AbstractMapper'.<!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public EList<AbstractMapper<EObject, EObject>> getAbstractMappers() {
		EList<AbstractMapper<EObject, EObject>> abstractMappers = new BasicEList<AbstractMapper<EObject, EObject>>();
		
		// recursively iterate over all children of the metadata and collect
		// all objects that are of type 'AbstractMapper'
		Iterator<Object> it = EcoreUtil.getAllContents(this, true);
		while (it.hasNext()) {
			Object object = it.next();
			if (object instanceof AbstractMapper<?, ?>) {
				abstractMappers.add((AbstractMapper<EObject, EObject>) object);
			}
		}
		
		return abstractMappers;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GenLibraryPackage.META_DATA__RESOURCES:
				return ((InternalEList<?>)getResources()).basicRemove(otherEnd, msgs);
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
			case GenLibraryPackage.META_DATA__RESOURCES:
				return getResources();
			case GenLibraryPackage.META_DATA__ID:
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
			case GenLibraryPackage.META_DATA__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection<? extends Resource>)newValue);
				return;
			case GenLibraryPackage.META_DATA__ID:
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
			case GenLibraryPackage.META_DATA__RESOURCES:
				getResources().clear();
				return;
			case GenLibraryPackage.META_DATA__ID:
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
			case GenLibraryPackage.META_DATA__RESOURCES:
				return resources != null && !resources.isEmpty();
			case GenLibraryPackage.META_DATA__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		}
		return super.eIsSet(featureID);
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

} // MetaDataImpl
