package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import de.tud.et.ifa.agtele.genlibrary.ui.widgets.GenlibraryViewer;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class SelectLibraryEntryPage extends WizardPage {

	protected AddGenlibraryEntryWizardData data;
	private GenlibraryViewer genlibViewer;
	
	protected SelectLibraryEntryPage(AddGenlibraryEntryWizardData data) {
		super("Select LibraryEntry");
		setTitle("Select LibraryEntry");
		setDescription("Select the library entry that should be added to target model...");
		
		this.data = data;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		genlibViewer = new GenlibraryViewer(container, SWT.NONE, data.getLibPath(), data.getLibrary(), data.getLibraryContext(), data.getLibraryPathParser());
		genlibViewer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	}
}
