package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Resource;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Point;

public class EditMetaDataWizardPage extends WizardPage {

	private LibraryEntry libEntry;
	private Composite attributeContainer;
	private AddGenlibraryEntryWizardData data;
	private CTabFolder tabFolder;
	
	protected EditMetaDataWizardPage(AddGenlibraryEntryWizardData data) {
		super("Edit Library Meta Data");
		setTitle("Edit Library Meta Data");
		setDescription("Add all necessary information for inserting the library item by editing the MetaData...");
		
		this.data = data;
		this.libEntry = data.getLibEntry();
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		tabFolder = new CTabFolder(container, SWT.BORDER);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		// AttributeMapperTab
		CTabItem tbtmAttributes = new CTabItem(tabFolder, SWT.NONE);
		tbtmAttributes.setText("Attributes");
		
		ScrolledComposite scrolledAttributeComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tbtmAttributes.setControl(scrolledAttributeComposite);
		scrolledAttributeComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledAttributeComposite.setExpandHorizontal(true);
		scrolledAttributeComposite.setExpandVertical(true);
		
		attributeContainer = new Composite(scrolledAttributeComposite, SWT.NONE);
		attributeContainer.setLayout(new GridLayout(2, false));
		
		scrolledAttributeComposite.setContent(attributeContainer);
		scrolledAttributeComposite.setMinSize(attributeContainer.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		// ContainerMapperTab
		CTabItem tbtmContainer = new CTabItem(tabFolder, SWT.NONE);
		tbtmContainer.setText("Container");
		
		// ExternalReferenceMapperTab
		CTabItem tbtmExternalreferences = new CTabItem(tabFolder, SWT.NONE);
		tbtmExternalreferences.setText("ExternalReferences");
		
		// ResourceMapperTab
		CTabItem tbtmResources = new CTabItem(tabFolder, SWT.NONE);
		tbtmResources.setText("Resources");
		
		//tabFolder.setSelection(0);
	}

	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			// Attributes
			if (data.getLibEntry().getMetaData().getAttributeMappers() != null) {
				for (AbstractAttributeMapper<EObject> attrMapper : data.getLibEntry().getMetaData().getAttributeMappers()) {
					Label lblNewAttributeLabel = new Label(attributeContainer, SWT.NONE);
					lblNewAttributeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
					lblNewAttributeLabel.setText(attrMapper.eClass().getName());
					
					Text attributeText = new Text(attributeContainer, SWT.BORDER);
					attributeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				}
			}
			// Resources
			if (data.getLibEntry().getMetaData().getResources() != null) {
				for (Resource resMapper : data.getLibEntry().getMetaData().getResources()) {
					Label lblNewResLabel = new Label(attributeContainer, SWT.NONE);
					lblNewResLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
					lblNewResLabel.setText(resMapper.getName());
					
					Text resText = new Text(attributeContainer, SWT.BORDER);
					resText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				}
			}
			
			tabFolder.setSelection(0);
		}
		
		super.setVisible(visible);
	}
	
	
}
