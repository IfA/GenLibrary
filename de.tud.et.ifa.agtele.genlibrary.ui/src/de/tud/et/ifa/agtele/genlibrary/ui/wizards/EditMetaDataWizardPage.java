package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Resource;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;

public class EditMetaDataWizardPage extends WizardPage {

	private Composite attributeContainer;
	private AddGenlibraryEntryWizardData data;
	private CTabFolder tabFolder;
	private Composite containerEObjectContainer;
	private Composite resourcesContainer;
	private Composite externalReferencesContainer;
	
	protected EditMetaDataWizardPage(AddGenlibraryEntryWizardData data) {
		super("Edit Library Meta Data");
		setTitle("Edit Library Meta Data");
		setDescription("Add all necessary information for inserting the library item by editing the MetaData...");
		
		this.data = data;
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
		
		attributeContainer = createScrolledTabContainer(tbtmAttributes);
		
		// ContainerMapperTab
		CTabItem tbtmContainer = new CTabItem(tabFolder, SWT.NONE);
		tbtmContainer.setText("Container");
		
		containerEObjectContainer = createScrolledTabContainer(tbtmContainer);
		
		// ExternalReferenceMapperTab
		CTabItem tbtmExternalreferences = new CTabItem(tabFolder, SWT.NONE);
		tbtmExternalreferences.setText("ExternalReferences");
		
		externalReferencesContainer = createScrolledTabContainer(tbtmExternalreferences);
		
		// ResourceMapperTab
		CTabItem tbtmResources = new CTabItem(tabFolder, SWT.NONE);
		tbtmResources.setText("Resources");
		
		resourcesContainer = createScrolledTabContainer(tbtmResources);
		
		//tabFolder.setSelection(0);
	}

	/**
	 * @param tabItem
	 */
	private Composite createScrolledTabContainer(CTabItem tabItem) {
		ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		tabItem.setControl(scrolledComposite);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite container = new Composite(scrolledComposite, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		
		scrolledComposite.setContent(container);
		scrolledComposite.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		return container;
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
			// Container
			if (data.getLibEntry().getMetaData().getContainerMappers() != null) {
				
				// get a HashMap of (eClass, ArrayList{Mapperinstances}) to allow the creation of groups for each type of mapper
				ContainerMapperHashMap mapperHashMap = new ContainerMapperHashMap(data.getLibEntry().getMetaData().getContainerMappers());
				
				// iterate over the different concrete ContainerMapperTypes
				for (EClass key : mapperHashMap.getContainerMapperHashMap().keySet()) {
					Group containerGroup = new Group(containerEObjectContainer, SWT.NONE);
					containerGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
					containerGroup.setText(key.getName());
					containerGroup.setLayout(new GridLayout(2, false));
					
					ArrayList<AbstractContainerMapper<EObject, EObject>> mapperList = mapperHashMap.getContainerMapperHashMap().get(key);
					for (AbstractContainerMapper<EObject, EObject> mapper : mapperList) {
						Label lblNewContainerLabel = new Label(containerGroup, SWT.NONE);
						lblNewContainerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
	//					lblNewContainerLabel.setText(containerMapper.eClass().getName());
						lblNewContainerLabel.setText(mapper.eClass().getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier().getName());
						
						// TODO change this to a Combo Box with proposals
						Text containerText = new Text(containerGroup, SWT.BORDER);
						containerText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
					}
				}
			}
			// ExternalReference
			if (data.getLibEntry().getMetaData().getExternalReferenceMappers() != null) {
				// TODO create the same weird stuff that has been started for the ContainerMapper
			}
			
			// Resources
			if (data.getLibEntry().getMetaData().getResources() != null) {
				for (Resource resMapper : data.getLibEntry().getMetaData().getResources()) {
					Label lblNewResLabel = new Label(resourcesContainer, SWT.NONE);
					lblNewResLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
					lblNewResLabel.setText(resMapper.getName());
					
					// TODO insert predifined locations in the project and create project folder selector
					Text resText = new Text(resourcesContainer, SWT.BORDER);
					resText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
				}
			}
			
			attributeContainer.layout();
			containerEObjectContainer.layout();
			externalReferencesContainer.layout();
			resourcesContainer.layout();
			tabFolder.setSelection(0);
		}
		else {
			disposeChildren(attributeContainer);
			disposeChildren(containerEObjectContainer);
			disposeChildren(externalReferencesContainer);
			disposeChildren(resourcesContainer);
		}
		
		super.setVisible(visible);
	}
	
	private void disposeChildren(Composite container) {
		for (Control c : container.getChildren()) {
			c.dispose();
		}
	}
	
	class ContainerMapperHashMap {
		HashMap<EClass, ArrayList<AbstractContainerMapper<EObject, EObject>>> containerMapperHashMap;
		
		/**
		 * Creates a HashMap of (eClass, ArrayList{Mapperinstances}) for each type of container mapper specified in the meta data
		 * 
		 * @param containerMapperList {@link EList} of container mappers
		 */
		public ContainerMapperHashMap(EList<AbstractContainerMapper<EObject, EObject>> containerMapperList) {
			this.containerMapperHashMap = new HashMap<EClass, ArrayList<AbstractContainerMapper<EObject, EObject>>>();
			
			for (AbstractContainerMapper<EObject, EObject> mapper : containerMapperList) {
				if (!containerMapperHashMap.containsKey(mapper.eClass())) {
					containerMapperHashMap.put(mapper.eClass(), new ArrayList<AbstractContainerMapper<EObject,EObject>>());
				}
				containerMapperHashMap.get(mapper.eClass()).add(mapper);
			}
		}
		
		public HashMap<EClass, ArrayList<AbstractContainerMapper<EObject, EObject>>> getContainerMapperHashMap() {
			return containerMapperHashMap;
		}
	}
}
