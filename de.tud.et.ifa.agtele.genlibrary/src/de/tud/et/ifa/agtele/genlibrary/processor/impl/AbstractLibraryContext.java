package de.tud.et.ifa.agtele.genlibrary.processor.impl;

import java.io.File;
import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;
import de.tud.et.ifa.agtele.genlibrary.processor.interfaces.LibraryContext;

/**
 * This is an abstract base class for the implementation of the 'LibraryContext'
 * interface. Classes wishing to implement the 'LibraryContext' interface should
 * consider to extend this class instead.
 * 
 * This class only provides a default implementation for the 'applyParameters'
 * function that handles all 'AbstractParameters'. Implementing classes should
 * call 'super.applyParameters' in order to not having to handle this by
 * themselves. Before or after this call, custom changes may have to be
 * performed, e.g. things that are not covered by a 'ContainerParameter' need to
 * be inserted into the target model.
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
	 * covered by parameters need to be inserted into the target model.
	 */
	@Override
	public void defaultInsertIntoTargetModel(EObject targetModel, LibraryEntry libraryEntry, String path) {
		// do nothing
	}

	/**
	 * This default implementation of the 'applyParameter' function handles all
	 * 'AbstractContainerParameters', 'AbstractExternalReferenceParameters' and
	 * 'AbstractAttributeParameters'. Clients may override this function to add
	 * special behavior but should call 'super.applyParameter' to reuse the base
	 * functionality.
	 */
	@Override
	public void applyParameters(EObject targetModel, LibraryEntry libraryEntry, String path) {

		// handle the container Parameters
		applyContainerParameters(libraryEntry.getParameterDescription().getContainerParameters());

		// handle the external reference Parameters
		applyExternalReferenceParameters(libraryEntry.getParameterDescription().getExternalReferenceParameters(), targetModel, libraryEntry);

		// handle the attribute Parameters
		applyAttributeParameters(libraryEntry.getParameterDescription().getAttributeParameters());

	}

	@Override
	public String getDefaultResourcePath(String resourcePathInsideLibrary) {
		return "res" + File.separator + resourcePathInsideLibrary.replace("/", "_");
	}

	/**
	 * This function handles the abstract container Parameters in a way that all
	 * Parameters are applied in a serial manner. Clients may override this e.g.
	 * in order to introduce a special behavior for certain types of Parameters.
	 * 
	 * @param containerParameters
	 *            The container Parameters to be applied.
	 */
	protected void applyContainerParameters(EList<AbstractContainerParameter<EObject, EObject>> containerParameters) {

		for (AbstractContainerParameter<EObject, EObject> containerParameter : containerParameters) {

			applyContainerParameter(containerParameter);
		}
	}

	/**
	 * This function handles the abstract external reference Parameters in a way
	 * that all Parameters are applied in a serial manner. Clients may override
	 * this e.g. to introduce a special behavior for certain types of
	 * Parameters.
	 * 
	 * @param referenceParameters
	 *            The external reference Parameters to be applied.
	 * @param targetModel
	 *            The target model to be used.
	 * @param libraryEntry
	 *            The library entry.
	 */
	protected void applyExternalReferenceParameters(EList<AbstractExternalReferenceParameter<EObject, EObject>> referenceParameters, EObject targetModel, LibraryEntry libraryEntry) {

		for (AbstractExternalReferenceParameter<EObject, EObject> referenceParameter : referenceParameters) {

			applyExternalReferenceParameter(targetModel, libraryEntry, referenceParameter);
		}
	}

	/**
	 * This function handles the attribute Parameters in a way that all
	 * Parameters are applied in a serial manner. Clients may override this e.g.
	 * to introduce a special behavior for certain types of Parameters.
	 * 
	 * @param attributeParameters
	 *            The attribute Parameters to be applied.
	 */
	protected void applyAttributeParameters(EList<AbstractAttributeParameter<EObject>> attributeParameters) {

		for (AbstractAttributeParameter<EObject> attributeParameter : attributeParameters) {

			applyAttributeParameter(attributeParameter);
		}
	}

	/**
	 * This function applies a single container Parameter, i.e. it inserts part
	 * of a library item into a target model.
	 * 
	 * @param containerParameter
	 *            The container Parameter to be applied.
	 */
	final protected void applyContainerParameter(AbstractContainerParameter<EObject, EObject> containerParameter) {
		// this is the object that we want to use as new container
		EObject container = containerParameter.getContainer();

		// this is the object that we want to add to the new container
		EObject source = containerParameter.getSource();

		if (container == null) {
			throw new RuntimeException("The containerParameter for element '" + source + "' does not specify a container!");
		}

		// this is the feature that shall be used as container reference
		EReference reference = containerParameter.getReference();
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
	 * This function applies a single external reference Parameter, i.e. it
	 * redirects a reference from a {@link ParameterDescription} element to an
	 * element of the target model.
	 * 
	 * @param targetModel
	 *            The target model into that the library element is inserted.
	 * @param libraryEntry
	 *            The library entry that is inserted.
	 * @param referenceParameter
	 *            The reference Parameter to be applied.
	 */
	final protected void applyExternalReferenceParameter(EObject targetModel, LibraryEntry libraryEntry, AbstractExternalReferenceParameter<EObject, EObject> referenceParameter) {
		// this is the object that we want to use as new target
		EObject target = referenceParameter.getTarget();

		// this is the old source object
		EObject source = referenceParameter.getSource();

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
	 * This function applies a single attribute Parameter, i.e. it changes a
	 * default attribute value inside a library item to a new value.
	 * 
	 * @param attributeParameter
	 *            The attribute Parameter to be applied.
	 */
	final protected void applyAttributeParameter(AbstractAttributeParameter<EObject> attributeParameter) {
		// this is the new attribute value to be set
		String newValue = attributeParameter.getNewValue();

		// this is the source object
		EObject source = attributeParameter.getSource();

		// this is the attribute to set
		EAttribute attribute = attributeParameter.getAttribute();

		// now, convert the new value to the necessary type and set it
		source.eSet(attribute, EcoreUtil.createFromString(attribute.getEAttributeType(), newValue));
	}
}
