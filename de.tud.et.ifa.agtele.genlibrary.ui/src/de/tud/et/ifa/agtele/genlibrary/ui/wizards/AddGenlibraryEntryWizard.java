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
package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.wizard.Wizard;

import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;
import de.tud.et.ifa.agtele.genlibrary.ui.pages.EditParametersWizardPage;
import de.tud.et.ifa.agtele.genlibrary.ui.pages.SelectLibraryEntryPage;
import de.tud.et.ifa.agtele.resources.ResourceHelper;

/**
 * This wizard handles the import of an {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry LibraryEntry} into a target model.
 * 
 * @author martin
 *
 */

public class AddGenlibraryEntryWizard extends Wizard {
	
	protected AddGenlibraryEntryWizardData data;	
	protected SelectLibraryEntryPage one;
	protected EditParametersWizardPage two;
	
	
	/**
	 * This wizard handles the import of an {@link de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry LibraryEntry} into a target model.
	 * 
	 * @param data {@link de.tud.et.ifa.agtele.genlibrary.ui.wizards.AddGenlibraryEntryWizardData AddGenlibraryEntryWizardData} Bean containing all necessary information for the wizard
	 */
	public AddGenlibraryEntryWizard(AddGenlibraryEntryWizardData data) {
		super();
		setNeedsProgressMonitor(true);
		
		// create a new library and initialize it
		data.setLibrary(new LibraryPluginImpl())
			.init(data.getLibPath(), data.getLibraryContext(), data.getLibraryPathParser());

		this.data = data;
	}
	
	@Override
	public void addPages() {
		one = new SelectLibraryEntryPage(data);
		addPage(one);
		two = new EditParametersWizardPage(data);
		addPage(two);
	};
	
	@Override
	public boolean performFinish() {

		// insert the library entry
		//
		data.getLibrary().insertIntoTargetModel(
				EcoreUtil.getRootContainer(data.geteObject()), 
				data.getLibEntry(), 
				data.getClassPath());
		
		// refresh the workspace
		//
		ResourceHelper.refresh(ResourcesPlugin.getWorkspace().getRoot());
		
		return true;
	}
	
	@Override
	public boolean canFinish() {
		
		if((getContainer().getCurrentPage() == two) && two.isPageComplete()) {
			return true;
		}
		
		return false;
	}

}
