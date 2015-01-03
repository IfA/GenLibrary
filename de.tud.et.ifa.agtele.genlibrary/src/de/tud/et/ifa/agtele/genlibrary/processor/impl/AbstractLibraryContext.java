package de.tud.et.ifa.agtele.genlibrary.processor.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryItem;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.MetaData;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;

/**
 * This is an abstract base class for the implementation of the 'LibraryContext'
 * interface. Classes wishing to implement the 'LibraryContext' interface may
 * choose to extend this class instead.
 * 
 * This class only provides a default implementation for the 'applyMetaData'
 * function that handles all 'AbstractMappers'. Implementing classes should call
 * 'super.applyMetaData' in order to not having to handle this by themselves.
 * Before or after this call, custom changes may have to be performed, e.g.
 * things that are not covered by a 'ContainerMapper' need to be inserted into
 * the target model.
 * 
 * @author mfreund
 */
public abstract class AbstractLibraryContext implements LibraryContext {

	@Override
	public LibraryItem applyMetaData(EObject targetModel, LibraryItem libraryitem, MetaData metadata, String path) {

		// handle the container mappers
		applyContainerMappers(targetModel, libraryitem, metadata, path);

		// handle th external reference mappers
		applyExternalReferenceMappers(targetModel, libraryitem, metadata, path);

		return libraryitem;
	}

	/**
	 * This function handles the abstract container mappers and may be
	 * overriden.
	 * 
	 * @param targetModel
	 * @param libraryitem
	 * @param metadata
	 * @param path
	 */
	@SuppressWarnings("unchecked")
	protected void applyContainerMappers(EObject targetModel, LibraryItem libraryitem, MetaData metadata, String path) {

		EList<AbstractContainerMapper<EObject, EObject>> containerMappers = metadata.getContainerMappers();

		for (AbstractContainerMapper<EObject, EObject> containerMapper : containerMappers) {

			// this is the object that we want to use as new container
			EObject container = containerMapper.getContainer();

			// this is the object that we want to add to the new container
			EObject source = containerMapper.getSource();

			// this is the feature that shall be used as container reference
			EReference reference = containerMapper.getReference();
			if (!reference.isContainment()) {
				throw new RuntimeException("The reference must be a containment reference!");
			}
			if (!reference.isMany()) {
				throw new RuntimeException("The reference must be multi-valued!");
			}
			if (!reference.getEReferenceType().isSuperTypeOf(source.eClass())) {
				throw new RuntimeException("The type of the source object does not match the reference!");
			}
			if (container.eClass().getEAllContainments().contains(reference)) {
				EList<EObject> existing = new BasicEList<EObject>((EList<EObject>) container.eGet(reference));
				existing.add(source);
				container.eSet(reference, existing);
			} else {
				throw new RuntimeException("The reference could not be set for the container!");
			}
		}
	}

	/**
	 * This function handles the abstract external reference mappers and may be
	 * overriden.
	 * 
	 * @param targetModel
	 * @param libraryitem
	 * @param metadata
	 * @param path
	 */
	protected void applyExternalReferenceMappers(EObject targetModel, LibraryItem libraryitem, MetaData metadata, String path) {

		EList<AbstractExternalReferenceMapper<EObject, EObject>> referenceMappers = metadata.getExternalReferenceMappers();

		for (AbstractExternalReferenceMapper<EObject, EObject> referenceMapper : referenceMappers) {

			// this is the object that we want to use as new target
			EObject target = referenceMapper.getTarget();

			// this is the old source object
			EObject source = referenceMapper.getSource();

			// this is the feature that shall be used as reference
			EReference reference = referenceMapper.getReference();
			if (reference.isContainment()) {
				throw new RuntimeException("The reference must not be a containment reference!");
			}
			if (!reference.isMany()) {
				throw new RuntimeException("The reference must be multi-valued!");
			}

			Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(source, libraryitem);

			// TODO check if this works
			for (Setting setting : crossReferences) {
				EcoreUtil.replace(setting, source, target);
			}
		}
	}

}
