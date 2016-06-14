package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import org.eclipse.jface.wizard.Wizard;

import de.tud.et.ifa.agtele.genlibrary.processor.impl.LibraryPluginImpl;

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
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean canFinish() {
		if((getContainer().getCurrentPage() == two) && two.canFlipToNextPage()) {
			return true;
		}
		return false;
//		return (getContainer().getCurrentPage() == two);
	}

}