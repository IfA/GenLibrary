package de.tud.et.ifa.agtele.genlibrary.ui.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ComboContentAdapter;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractAttributeParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractContainerParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.AbstractExternalReferenceParameter;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ParameterDescription;
import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.ResourceParameter;
import de.tud.et.ifa.agtele.genlibrary.ui.wizards.AddGenlibraryEntryWizardData;

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
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SaveAsDialog;

public class EditParametersWizardPage extends WizardPage {

	private Composite attributeContainer;
	private AddGenlibraryEntryWizardData data;
	private CTabFolder tabFolder;
	private Composite containerEObjectContainer;
	private Composite resourcesContainer;
	private Composite externalReferencesContainer;
	
	public EditParametersWizardPage(AddGenlibraryEntryWizardData data) {
		super("Edit Library Parameters");
		setTitle("Edit Library Parameters");
		setDescription("Add all necessary information for inserting the library item by editing the Library Parameters...");
		
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
			if (data.getLibEntry().getParameterDescription().getAttributeParameters() != null) {
				for (AbstractAttributeParameter<EObject> attributeParameter : data.getLibEntry().getParameterDescription().getAttributeParameters()) {
					Label lblNewAttributeLabel = new Label(attributeContainer, SWT.NONE);
					lblNewAttributeLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
					lblNewAttributeLabel.setText(attributeParameter.eClass().getName());
					
					Text attributeText = new Text(attributeContainer, SWT.BORDER);
					attributeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
					
					attributeText.addKeyListener(new KeyListener() {
						
						@Override
						public void keyReleased(KeyEvent e) {
							
							String text = attributeText.getText();
							EDataType type = attributeParameter.getAttribute().getEAttributeType();
							
							try {
								type.getEPackage().getEFactoryInstance().createFromString(type, text);
								attributeParameter.setNewValue(text);
							} catch (IllegalArgumentException e1) {
								// no valid attribute value has been entered
								attributeParameter.setNewValue(null);
								//TODO maybe generate an error marker besides the label (use 'ControlDecoration')
							}
							
							getWizard().getContainer().updateButtons();
						}
						
						@Override
						public void keyPressed(KeyEvent e) {}
					});
					
					attributeText.setText(attributeParameter.getSource().eGet(attributeParameter.getAttribute()).toString());
					attributeParameter.setNewValue(attributeText.getText());
				}
			}
			
			// Container
			if (data.getLibEntry().getParameterDescription().getContainerParameters() != null) {
				
				// get a HashMap of (eClass, ArrayList{Mapperinstances}) to allow the creation of groups for each type of mapper
				ContainerMapperHashMap mapperHashMap = new ContainerMapperHashMap(data.getLibEntry().getParameterDescription().getContainerParameters());
				
				// iterate over the different concrete ContainerMapperTypes
				for (EClass key : mapperHashMap.getContainerMapperHashMap().keySet()) {
					Group containerGroup = new Group(containerEObjectContainer, SWT.NONE);
					containerGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
					containerGroup.setText(key.getName());
					containerGroup.setLayout(new GridLayout(2, false));
					
					ArrayList<AbstractContainerParameter<EObject, EObject>> mapperList = mapperHashMap.getContainerMapperHashMap().get(key);
					for (AbstractContainerParameter<EObject, EObject> containerParameter : mapperList) {
						Label lblNewContainerLabel = new Label(containerGroup, SWT.NONE);
						lblNewContainerLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
						lblNewContainerLabel.setText(containerParameter.eClass().getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier().getName());
						
						// a combo box to select the target ePackage
						Combo combo = new Combo(containerGroup, SWT.BORDER);
						{
							GridData data = new GridData();
							data.horizontalAlignment = GridData.FILL;
							data.grabExcessHorizontalSpace = true;
							combo.setLayoutData(data);
						}
						
						// get all eObjects from the target model that have a valid type and add them
						// to both combo boxes
						EClassifier targetClass = containerParameter.eClass().getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier();
						final Map<String, EObject> validContainers = getValidElements(targetClass);
						updateCombo(combo, validContainers);
						
						combo.addModifyListener(new ModifyListener() {
							@Override
							public void modifyText(ModifyEvent e) {

								String text = combo.getText();
								EObject container = validContainers.get(text);
								
								if(container != null) {
									containerParameter.setContainer(container);
								} else {
									// no valid attribute value has been entered
									containerParameter.setContainer(null);
									//TODO maybe generate an error marker besides the label (use 'ControlDecoration')
								}
								
								getWizard().getContainer().updateButtons();
							}
						});
						
						
						// realize auto-completion for both combo viewers
						new AutoCompleteField(combo, new ComboContentAdapter(), combo.getItems());
						
						containerParameter.setContainer(validContainers.get(combo.getText()));
					}
				}
			}
			
			// ExternalReference
			if (data.getLibEntry().getParameterDescription().getExternalReferenceParameters() != null) {
				// get a HashMap of (eClass, ArrayList{Mapperinstances}) to allow the creation of groups for each type of mapper
				ExtRefMapperHashMap mapperHashMap = new ExtRefMapperHashMap(data.getLibEntry().getParameterDescription().getExternalReferenceParameters());
				
				// iterate over the different concrete ContainerMapperTypes
				for (EClass key : mapperHashMap.getExtRefMapperHashMap().keySet()) {
					Group extRefGroup = new Group(externalReferencesContainer, SWT.NONE);
					extRefGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
					extRefGroup.setText(key.getName() + " - " + key.getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier().getName());
					extRefGroup.setLayout(new GridLayout(2, false));
					
					ArrayList<AbstractExternalReferenceParameter<EObject, EObject>> mapperList = mapperHashMap.getExtRefMapperHashMap().get(key);
					for (AbstractExternalReferenceParameter<EObject, EObject> externalReferenceParameter : mapperList) {
						Label lblExtRefLabel = new Label(extRefGroup, SWT.NONE);
						lblExtRefLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
						lblExtRefLabel.setText(getEObjectText(externalReferenceParameter.getSource()));
						
						// a combo box to select the target ePackage
						Combo combo = new Combo(extRefGroup, SWT.BORDER);
						{
							GridData data = new GridData();
							data.horizontalAlignment = GridData.FILL;
							data.grabExcessHorizontalSpace = true;
							combo.setLayoutData(data);
						}
						
						// get all eObjects from the target model that have a valid type and add them
						// to both combo boxes
						EClassifier targetClass = externalReferenceParameter.eClass().getEAllGenericSuperTypes().get(0).getETypeArguments().get(1).getEClassifier();
						final Map<String, EObject> validReferenceTargets = getValidElements(targetClass);
						updateCombo(combo, validReferenceTargets);
						
						combo.addModifyListener(new ModifyListener() {
							@Override
							public void modifyText(ModifyEvent e) {

								String text = combo.getText();
								EObject referenceTarget = validReferenceTargets.get(text);
								
								if(referenceTarget != null) {
									externalReferenceParameter.setTarget(referenceTarget);
								} else {
									// no valid attribute value has been entered
									externalReferenceParameter.setTarget(null);
									//TODO maybe generate an error marker besides the label (use 'ControlDecoration')
								}
								
								getWizard().getContainer().updateButtons();
							}
						});
						
						// realize auto-completion for both combo viewers
						new AutoCompleteField(combo, new ComboContentAdapter(), combo.getItems());
						
						externalReferenceParameter.setTarget(validReferenceTargets.get(combo.getText()));
					}
				}
			}
			
			// Resources
			if (data.getLibEntry().getParameterDescription().getResourceParameters() != null) {
				for (ResourceParameter resourceParameter : data.getLibEntry().getParameterDescription().getResourceParameters()) {
					Label lblNewResLabel = new Label(resourcesContainer, SWT.NONE);
					lblNewResLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1));
					lblNewResLabel.setText(resourceParameter.getName());
					
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
							IFile res = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(data.geteObject().eResource().getURI().toPlatformString(true))).getParent().getFile(new Path(resourceParameter.getName()));
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
					
					resText.addKeyListener(new KeyListener() {
						
						@Override
						public void keyReleased(KeyEvent e) {
							
							String text = resText.getText();
							
							if(text.matches("^((.+)/)?([^/]+)$")) {
								resourceParameter.setNewPath(text);
							} else {
								resourceParameter.setNewPath(null);
							}
							
							getWizard().getContainer().updateButtons();
						}
						
						@Override
						public void keyPressed(KeyEvent e) {}
					});
					
					resourceParameter.setNewPath(null);
					
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
				if(object.eGet(attr) != null && !object.eGet(attr).toString().isEmpty())
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
	
	private void updateCombo(Combo combo, Map<String, EObject> hashMap) {
		combo.removeAll();
		for (String o : hashMap.keySet()) {
			combo.add(o);
		}
		combo.select(combo.indexOf(getEObjectText(data.geteObject())));
	}
	
	class ContainerMapperHashMap {
		HashMap<EClass, ArrayList<AbstractContainerParameter<EObject, EObject>>> containerMapperHashMap;
		
		/**
		 * Creates a HashMap of (eClass, ArrayList{Mapperinstances}) for each type of container mapper specified in the meta data
		 * 
		 * @param containerMapperList {@link EList} of container mappers
		 */
		public ContainerMapperHashMap(EList<AbstractContainerParameter<EObject, EObject>> containerMapperList) {
			this.containerMapperHashMap = new HashMap<EClass, ArrayList<AbstractContainerParameter<EObject, EObject>>>();
			
			for (AbstractContainerParameter<EObject, EObject> mapper : containerMapperList) {
				if (!containerMapperHashMap.containsKey(mapper.eClass())) {
					containerMapperHashMap.put(mapper.eClass(), new ArrayList<AbstractContainerParameter<EObject,EObject>>());
				}
				containerMapperHashMap.get(mapper.eClass()).add(mapper);
			}
		}
		
		public HashMap<EClass, ArrayList<AbstractContainerParameter<EObject, EObject>>> getContainerMapperHashMap() {
			return containerMapperHashMap;
		}
	}
	
	class ExtRefMapperHashMap {
		HashMap<EClass, ArrayList<AbstractExternalReferenceParameter<EObject, EObject>>> extRefMapperHashMap;
		
		/**
		 * Creates a HashMap of (eClass, ArrayList{Mapperinstances}) for each type of external reference mapper specified in the meta data
		 * 
		 * @param extRefMapperList {@link EList} of container mappers
		 */
		public ExtRefMapperHashMap(EList<AbstractExternalReferenceParameter<EObject, EObject>> extRefMapperList) {
			this.extRefMapperHashMap = new HashMap<EClass, ArrayList<AbstractExternalReferenceParameter<EObject, EObject>>>();
			
			for (AbstractExternalReferenceParameter<EObject, EObject> mapper : extRefMapperList) {
				if (!extRefMapperHashMap.containsKey(mapper.eClass())) {
					extRefMapperHashMap.put(mapper.eClass(), new ArrayList<AbstractExternalReferenceParameter<EObject,EObject>>());
				}
				extRefMapperHashMap.get(mapper.eClass()).add(mapper);
			}
		}
		
		public HashMap<EClass, ArrayList<AbstractExternalReferenceParameter<EObject, EObject>>> getExtRefMapperHashMap() {
			return extRefMapperHashMap;
		}
	}
	
	@Override
	public boolean isPageComplete() {
		
		if(data.getLibEntry() == null || data.getLibEntry().getParameterDescription() == null) {
			return false;
		}
		
		ParameterDescription parameterDescription = data.getLibEntry().getParameterDescription();
		
		// check if a value has been specified for each attribute parameter
		//
		Optional<AbstractAttributeParameter<EObject>> invalidAttributeParameter = 
				parameterDescription.getAttributeParameters().parallelStream().filter(p -> p.getNewValue() == null).findAny();
		
		if(invalidAttributeParameter.isPresent()) {
			
			setErrorMessage("Please specify a valid value for the AttributeParameter '" + invalidAttributeParameter.get().eClass().getName() + "'!");
			return false;
		}
		
		// check if a value has been specified for each container parameter
		//
		Optional<AbstractContainerParameter<EObject, EObject>> invalidContainerParameter = 
				parameterDescription.getContainerParameters().parallelStream().filter(p -> p.getContainer() == null).findAny();
		
		if(invalidContainerParameter.isPresent()) {
			
			setErrorMessage("Please specify a valid container for the ContainerParameter '" + invalidContainerParameter.get().eClass().getName() + "'!");
			return false;
		}
		
		// check if a value has been specified for each external reference parameter
		//
		Optional<AbstractExternalReferenceParameter<EObject, EObject>> invalidExternalReferenceParameter = 
				parameterDescription.getExternalReferenceParameters().parallelStream().filter(p -> p.getTarget() == null).findAny();
		
		if(invalidExternalReferenceParameter.isPresent()) {
			
			setErrorMessage("Please specify a valid target for the ExternalReferenceParameter '" + invalidExternalReferenceParameter.get().eClass().getName() + "'!");
			return false;
		}
		
		// check if a value has been specified for each resource parameter
		//
		Optional<ResourceParameter> invalidResourceParameter = 
				parameterDescription.getResourceParameters().parallelStream().filter(p -> p.getNewPath() == null).findAny();
		
		if(invalidResourceParameter.isPresent()) {
			
			setErrorMessage("Please specify a valid path for the ResourceParameter '" + invalidResourceParameter.get().eClass().getName() + "'!");
			return false;
		}
		
		setErrorMessage(null);
		return true;
	}
	
}
