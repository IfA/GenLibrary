package de.tud.et.ifa.agtele.genlibrary.util.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;

/**
 * LibraryFixer offers tools to avoid adding multiple instances of the same
 * sub-element when adding a library item multiple times.
 * 
 * @author mfreund
 */

public abstract class LibraryFixer {

	/**
	 * Prevents objects from being added multiple times by redirecting the
	 * references to these objects to those already present in the target model.
	 * 
	 * @param libraryItem
	 *            the current library item
	 * @param libObjects
	 *            a list of objects (part of the library item) that shall be
	 *            checked
	 * @param modelObjects
	 *            a list of objects (part of the target model) that shall be
	 *            checked against
	 * @param comparator
	 *            a comparator that compares a libObject to a modelObject and
	 *            decides if existing references to the libObject shall be
	 *            redirected to the modelObject
	 */
	public static <T extends EObject> void fixRedundantElements(LibraryItem libraryItem, List<T> libObjects, List<T> modelObjects, ILibItemComparator<T> comparator) {

		// Collect the objects to be deleted from the lib item
		ArrayList<T> objectsToDelete = new ArrayList<T>();

		// redirect the objects to the ones already existing in the target model
		for (T libObject : libObjects) {

			// check if the object already exists
			for (T modelObject : modelObjects) {

				if (comparator.compare(libObject, modelObject) == true) {

					// find the objects (inside the library item)
					// cross-referencing the object
					Collection<Setting> settings = UsageCrossReferencer.find(libObject, libraryItem);

					for (Iterator<Setting> iter = settings.iterator(); iter.hasNext();) {
						Setting setting = iter.next();
						// redirect the cross-references
						EcoreUtil.replace(setting, libObject, modelObject);
					}

					// add the objects to the list of objects that shall be
					// deleted
					objectsToDelete.add(libObject);

					break;
				}
			}
		}

		// delete all unused objects
		for (T object : objectsToDelete) {
			EcoreUtil.delete(object);
		}
	}

	/**
	 * Interface that should be implemented to compare a library item that
	 * should be added and its possibly corresponding target model element.
	 * 
	 * @author mfreund
	 * 
	 * @param <T>
	 */
	public interface ILibItemComparator<T extends EObject> {

		/**
		 * compares a library object to an object of the target model and
		 * decides whether or not to redirect the references to the library
		 * object to the model object
		 * 
		 * @param libObject
		 *            library element
		 * @param modelObject
		 *            object of the model the library element should be compared
		 *            to
		 * 
		 * @return true if the reference shall be redirected, false otherwise
		 */
		public boolean compare(T libObject, T modelObject);
	}
}
