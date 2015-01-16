package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceMapper;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.Resource;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SaveAsDialog;

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
		resourcesContainer.setLayout(new GridLayout(3, false));
		
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
					lblNewAttributeLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
					lblNewAttributeLabel.setText(attrMapper.eClass().getName());
					
					Text attributeText = new Text(attributeContainer, SWT.BORDER);
					attributeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
					
					attributeText.setText(attrMapper.getSource().eGet(attrMapper.getAttribute()).toString());
				}
			}
			// Container
			if (data.getLibEntry().getMetaData().getContainerMappers() != null) {
				
				// get a HashMap of (eClass, ArrayList{Mapperinstances}) to allow the creation of groups for each type of mapper
				ContainerMapperHashMap mapperHashMap = new ContainerMapperHashMap(data.getLibEntry().getMetaData().getContainerMappers());
				
				// iterate over the different concrete ContainerMapperTypes
				for (EClass key : mapperHashMap.getContainerMapperHashMap().keySet()) {
					Group containerGroup = new Group(containerEObjectContainer, SWT.NONE);
					containerGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
					containerGroup.setText(key.getName());
					containerGroup.setLayout(new GridLayout(2, false));
					
					ArrayList<AbstractContainerMapper<EObject, EObject>> mapperList = mapperHashMap.getContainerMapperHashMap().get(key);
					for (AbstractContainerMapper<EObject, EObject> mapper : mapperList) {
						Label lblNewContainerLabel = new Label(containerGroup, SWT.NONE);
						lblNewContainerLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
						lblNewContainerLabel.setText(mapper.eClass().getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier().getName());
						
						// a combo box to select the target ePackage
						Combo combo = new Combo(containerGroup, SWT.BORDER);
						{
							GridData data = new GridData();
							data.horizontalAlignment = GridData.FILL;
							data.grabExcessHorizontalSpace = true;
							combo.setLayoutData(data);
						}
						
						combo.addModifyListener(new ModifyListener() {
							@Override
							public void modifyText(ModifyEvent e) {
								// TODO save the selected stuff to the metadata of the libentry
								getWizard().getContainer().updateButtons();
							}
						});
						
						// get all eObjects from the target model that have a valid type and add them
						// to both combo boxes
						EClassifier targetClass = mapper.eClass().getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier();
						updateCombo(combo, getValidElements(targetClass));
						
						// realize auto-completion for both combo viewers
						new AutoCompleteField(combo, new ComboContentAdapter(), combo.getItems());
					}
				}
			}
			// ExternalReference
			if (data.getLibEntry().getMetaData().getExternalReferenceMappers() != null) {
				// get a HashMap of (eClass, ArrayList{Mapperinstances}) to allow the creation of groups for each type of mapper
				ExtRefMapperHashMap mapperHashMap = new ExtRefMapperHashMap(data.getLibEntry().getMetaData().getExternalReferenceMappers());
				
				// iterate over the different concrete ContainerMapperTypes
				for (EClass key : mapperHashMap.getExtRefMapperHashMap().keySet()) {
					Group extRefGroup = new Group(externalReferencesContainer, SWT.NONE);
					extRefGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
					extRefGroup.setText(key.getName() + " - " + key.getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier().getName());
					extRefGroup.setLayout(new GridLayout(2, false));
					
					ArrayList<AbstractExternalReferenceMapper<EObject, EObject>> mapperList = mapperHashMap.getExtRefMapperHashMap().get(key);
					for (AbstractExternalReferenceMapper<EObject, EObject> mapper : mapperList) {
						Label lblExtRefLabel = new Label(extRefGroup, SWT.NONE);
						lblExtRefLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
						lblExtRefLabel.setText(getEObjectText(mapper.getSource()));
						
						// a combo box to select the target ePackage
						Combo combo = new Combo(extRefGroup, SWT.BORDER);
						{
							GridData data = new GridData();
							data.horizontalAlignment = GridData.FILL;
							data.grabExcessHorizontalSpace = true;
							combo.setLayoutData(data);
						}
						
						combo.addModifyListener(new ModifyListener() {
							@Override
							public void modifyText(ModifyEvent e) {
								// TODO save the selected stuff to the metadata of the libentry
								getWizard().getContainer().updateButtons();
							}
						});
						
						// get all eObjects from the target model that have a valid type and add them
						// to both combo boxes
						EClassifier targetClass = mapper.eClass().getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier();
						updateCombo(combo, getValidElements(targetClass));
						
						// realize auto-completion for both combo viewers
						new AutoCompleteField(combo, new ComboContentAdapter(), combo.getItems());
					}
				}
			}
			
			// Resources
			if (data.getLibEntry().getMetaData().getResources() != null) {
				for (Resource resMapper : data.getLibEntry().getMetaData().getResources()) {
					Label lblNewResLabel = new Label(resourcesContainer, SWT.NONE);
					lblNewResLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
					lblNewResLabel.setText(resMapper.getName());
					
					// TODO insert predefined locations in the project and create project folder selector
					Text resText = new Text(resourcesContainer, SWT.BORDER);
					resText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
					
					Button selectDir = new Button(resourcesContainer, SWT.PUSH);
					selectDir.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
					selectDir.setText("Select Dir...");
					
					selectDir.addSelectionListener(new SelectionListener() {
						
						@Override
						public void widgetSelected(SelectionEvent e) {
							SaveAsDialog dirDialog = new SaveAsDialog(getShell());
//							dirDialog.setOriginalName(resMapper.getName());
							IFile res = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(data.geteObject().eResource().getURI().toPlatformString(true))).getParent().getFile(new Path(resMapper.getName()));
							dirDialog.setOriginalFile(res);
							
							if(dirDialog.open() == Window.OK){
								IPath path= dirDialog.getResult();
								resText.setText(path.toString());
							}
						}
						
						@Override
						public void widgetDefaultSelected(SelectionEvent e) {
							// TODO Auto-generated method stub
							
						}
					});
					
//					DirectoryFieldEditor selectDir = new DirectoryFieldEditor("selectDir", resMapper.getName(), resourcesContainer);
//					File source = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(data.geteObject().eResource().getURI().toPlatformString(true))).getParent().getLocation().toFile();
//					selectDir.setFilterPath(source);

					
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
	
	private HashMap<String, EObject> getValidElements(EClassifier eClassifier) {
		HashMap<String, EObject> map = new HashMap<String, EObject>();
		
		// get valid Elements
		TreeIterator<EObject> it = data.geteObject().eResource().getAllContents();

		
		while (it.hasNext()) {
			EObject object = (EObject) it.next();
			if (eClassifier.isInstance(object)) {
				// add {generatedName, eobject} to the map of valid elements
				map.put(getEObjectText(object), object);
			}
		}
		
		return map;
	}

	private String getEObjectText(EObject object) {
		for (EAttribute attr : object.eClass().getEAllAttributes()) {
			if(attr.getName().equalsIgnoreCase("name") || attr.getName().equalsIgnoreCase("id")) {
				return object.eGet(attr).toString();
			}
		}
		
		return object.toString();
	}

	private void disposeChildren(Composite container) {
		for (Control c : container.getChildren()) {
			c.dispose();
		}
	}
	
	private void updateCombo(Combo combo, HashMap<String, EObject> hashMap) {
		combo.removeAll();
		for (String o : hashMap.keySet()) {
			combo.add(o);
		}
		combo.select(combo.indexOf(getEObjectText(data.geteObject())));
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
	
	class ExtRefMapperHashMap {
		HashMap<EClass, ArrayList<AbstractExternalReferenceMapper<EObject, EObject>>> extRefMapperHashMap;
		
		/**
		 * Creates a HashMap of (eClass, ArrayList{Mapperinstances}) for each type of external reference mapper specified in the meta data
		 * 
		 * @param extRefMapperList {@link EList} of container mappers
		 */
		public ExtRefMapperHashMap(EList<AbstractExternalReferenceMapper<EObject, EObject>> extRefMapperList) {
			this.extRefMapperHashMap = new HashMap<EClass, ArrayList<AbstractExternalReferenceMapper<EObject, EObject>>>();
			
			for (AbstractExternalReferenceMapper<EObject, EObject> mapper : extRefMapperList) {
				if (!extRefMapperHashMap.containsKey(mapper.eClass())) {
					extRefMapperHashMap.put(mapper.eClass(), new ArrayList<AbstractExternalReferenceMapper<EObject,EObject>>());
				}
				extRefMapperHashMap.get(mapper.eClass()).add(mapper);
			}
		}
		
		public HashMap<EClass, ArrayList<AbstractExternalReferenceMapper<EObject, EObject>>> getExtRefMapperHashMap() {
			return extRefMapperHashMap;
		}
	}
}
