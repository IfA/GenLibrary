package de.tud.et.ifa.agtele.genlibrary.processor.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;

/**
 * This is an abstract base class for the implementation of the 'LibraryContext'
 * interface. Classes wishing to implement the 'LibraryContext' interface should
 * consider to extend this class instead.
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

	/**
	 * This default implementation of the 'init' function does nothing. Clients
	 * should override this if a special initialization (e.g. for package
	 * loading) is necessary.
	 */
	@Override
	public void init() {
		// do nothing
	}

	/**
	 * This default implementation of the 'defaultInsertIntoTargetModel'
	 * function does nothing. Clients should override if elements that are not
	 * covered by metadata need to be inserted into the target model.
	 */
	@Override
	public void defaultInsertIntoTargetModel(EObject targetModel, LibraryEntry libraryEntry, String path) {
		// do nothing
	}

	/**
	 * This default implementation of the 'applyMetaData' function handles all
	 * 'AbstractContainerMappers', 'AbstractExternalReferenceMappers' and
	 * 'AbstractAttributeMappers'. Clients may override this function to add
	 * special behavior but should call 'super.applyMetaData' to reuse the base
	 * functionality.
	 */
	@Override
	public void applyMetaData(EObject targetModel, LibraryEntry libraryEntry, String path) {

		// handle the container mappers
		applyContainerMappers(libraryEntry.getMetaData().getContainerMappers());

		// handle the external reference mappers
		applyExternalReferenceMappers(libraryEntry.getMetaData().getExternalReferenceMappers(), targetModel, libraryEntry);

		// handle the attribute mappers
		applyAttributeMappers(libraryEntry.getMetaData().getAttributeMappers());

	}

	/**
	 * This function handles the abstract container mappers in a way that all
	 * mappers are applied in a serial manner. Clients may override this e.g. in
	 * order to introduce a special behavior for certain types of mappers.
	 * 
	 * @param containerMappers
	 *            The container mappers to be applied.
	 */
	protected void applyContainerMappers(EList<AbstractContainerMapper<EObject, EObject>> containerMappers) {

		for (AbstractContainerMapper<EObject, EObject> containerMapper : containerMappers) {

			applyContainerMapper(containerMapper);
		}
	}

	/**
	 * This function handles the abstract external reference mappers in a way
	 * that all mappers are applied in a serial manner. Clients may override
	 * this e.g. to introduce a special behavior for certain types of mappers.
	 * 
	 * @param referenceMappers
	 *            The external reference mappers to be applied.
	 * @param targetModel
	 *            The target model to be used.
	 * @param libraryEntry
	 *            The library entry.
	 */
	protected void applyExternalReferenceMappers(EList<AbstractExternalReferenceMapper<EObject, EObject>> referenceMappers, EObject targetModel, LibraryEntry libraryEntry) {

		for (AbstractExternalReferenceMapper<EObject, EObject> referenceMapper : referenceMappers) {

			applyExternalReferenceMapper(targetModel, libraryEntry, referenceMapper);
		}
	}

	/**
	 * This function handles the attribute mappers in a way that all mappers are
	 * applied in a serial manner. Clients may override this e.g. to introduce a
	 * special behavior for certain types of mappers.
	 * 
	 * @param attributeMappers
	 *            The attribute mappers to be applied.
	 */
	protected void applyAttributeMappers(EList<AbstractAttributeMapper<EObject>> attributeMappers) {

		for (AbstractAttributeMapper<EObject> attributeMapper : attributeMappers) {

			applyAttributeMapper(attributeMapper);
		}
	}

	/**
	 * This function applies a single container mapper, i.e. it inserts part of
	 * a library item into a target model.
	 * 
	 * @param containerMapper
	 *            The container mapper to be applied.
	 */
	final protected void applyContainerMapper(AbstractContainerMapper<EObject, EObject> containerMapper) {
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
			@SuppressWarnings("unchecked")
			EList<EObject> existing = new BasicEList<EObject>((EList<EObject>) container.eGet(reference));
			existing.add(source);
			container.eSet(reference, existing);
		} else {
			throw new RuntimeException("The reference could not be set for the container!");
		}
	}

	/**
	 * This function applies a single external reference mapper, i.e. it
	 * redirects a reference from a metadata element to an element of the target
	 * model.
	 * 
	 * @param targetModel
	 *            The target model into that the library element is inserted.
	 * @param libraryEntry
	 *            The library entry that is inserted.
	 * @param referenceMapper
	 *            The reference mapper to be applied.
	 */
	final protected void applyExternalReferenceMapper(EObject targetModel, LibraryEntry libraryEntry, AbstractExternalReferenceMapper<EObject, EObject> referenceMapper) {
		// this is the object that we want to use as new target
		EObject target = referenceMapper.getTarget();

		// this is the old source object
		EObject source = referenceMapper.getSource();

		// now, search for cross references to the old source object from
		// the library item as well as from the target model (in case
		// something has been added to the target model before)
		Collection<Setting> crossReferences = EcoreUtil.UsageCrossReferencer.find(source, libraryEntry.getLibraryItem());
		crossReferences.addAll(EcoreUtil.UsageCrossReferencer.find(source, targetModel));

		// last, redirect the references from the source object to the
		// target object
		for (Setting setting : crossReferences) {
			EcoreUtil.replace(setting, source, target);
		}
	}

	/**
	 * This function applies a single attribute mapper, i.e. it changes a
	 * default attribute value inside a library item to a new value.
	 * 
	 * @param attributeMapper
	 *            The attribute mapper to be applied.
	 */
	final protected void applyAttributeMapper(AbstractAttributeMapper<EObject> attributeMapper) {
		// this is the new attribute value to be set
		String newValue = attributeMapper.getNewValue();

		// this is the source object
		EObject source = attributeMapper.getSource();

		// this is the attribute to set
		EAttribute attribute = attributeMapper.getAttribute();

		// now, convert the new value to the necessary type and set it
		source.eSet(attribute, EcoreUtil.createFromString(attribute.getEAttributeType(), newValue));
	}
}
