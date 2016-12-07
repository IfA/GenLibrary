package de.tud.et.ifa.agtele.genlibrary.ui.pages;

import org.eclipse.jface.wizard.WizardPage;

import de.tud.et.ifa.agtele.genlibrary.ui.wizards.GenerateGenlibraryEntryWizardData;

public abstract class GenerateGenlibraryEntryPage extends WizardPage {

	protected GenerateGenlibraryEntryWizardData data;

	public GenerateGenlibraryEntryPage(GenerateGenlibraryEntryWizardData data, String title, String description) {
		super(title);
		setTitle(title);
		setDescription(description);

		this.data = data;
	}

}
