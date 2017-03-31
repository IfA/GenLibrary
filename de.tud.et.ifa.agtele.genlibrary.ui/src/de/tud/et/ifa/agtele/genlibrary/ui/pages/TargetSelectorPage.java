package de.tud.et.ifa.agtele.genlibrary.ui.pages;

import java.io.File;

import org.eclipse.core.runtime.Path;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.tud.et.ifa.agtele.genlibrary.ui.wizards.GenerateGenlibraryEntryWizardData;

public class TargetSelectorPage extends GenerateGenlibraryEntryPage {
	
	private Composite container, fileFieldEditorComp, directoryFieldEditorComp, relLibPathComp;
	private Text versionTextField, libPathTextfield;
	private Label libPathLabel;
	private Button folderButton, zipFileButton, overwriteButton;
	private FileFieldEditor fileFieldEditor;
	private DirectoryFieldEditor directoryFieldEditor; 
	private ControlDecoration libPathLabelDecorator, versionLabelDecorator;
	private Image errorIcon = 
				FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry .DEC_ERROR).getImage();
	private IWizardContainer wizContainer;
	private Label authorLabel;
	private Text authorTextField;
	private GridData gd_1;
	private Label descriptionLabel;
	private Text descriptionTextField;
	private FileFieldEditor thumbnailSelector;
	
	public TargetSelectorPage(GenerateGenlibraryEntryWizardData data) {
		super(data, "Select Target", "Specify the folder/archive file where the library item shall be stored...");
	}

	@Override
	public void createControl(Composite parent) {
		
		// set the wizard container that can be used e.g. to update the buttons
		wizContainer = getWizard().getContainer();
		
		Composite comp, comp2;
		GridLayout gl;
		GridData gd;
		
		// container to host all other widgets
		container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout());
		
		// composite to host the two radio buttons and the selectors
		comp = new Composite(container, SWT.NONE);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		gl = new GridLayout(2, false);
		gl.horizontalSpacing = 0;
		comp.setLayout(gl);
		
		// create a radio button
		folderButton = new Button(comp, SWT.RADIO);
		folderButton.setText("Select directory...");
		
		// composite to host the directory field editor
		directoryFieldEditorComp = new Composite(comp, SWT.NONE);
		directoryFieldEditorComp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		
		// create a directory selector
		directoryFieldEditor = new DirectoryFieldEditor("dirSelect", "", directoryFieldEditorComp);
		// set the initial browse path
		directoryFieldEditor.setFilterPath(
				data.getSourceModelPath().removeLastSegments(1).toFile());
		
		// set listener that is triggered when the user has selected a folder
		directoryFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				
				if(event.getNewValue().equals("")) {
					return;
				}
				
				// reset the UI
				setErrorMessage(null);
				setPageComplete(false);
				
				// get the selected file
				Object file = event.getNewValue();
				
				if(file instanceof String) {
					try {
						// set the resource of the new model
						data.setTargetModelPath(((String) file) + File.separator + "data.xmi");
						// unset the zip file resource
						data.setZipFilePath("");
						// load the new model
						checkPath(data.getTargetModelPath());
						
					} catch (Exception e) {
						setErrorMessage(e.getMessage());
						data.setLibItemModel(null);
					}
					
					wizContainer.updateButtons();
				}
				
			}
		});
		
		// create a radio button
		zipFileButton = new Button(comp, SWT.RADIO);
		zipFileButton.setText("Select archive file...");
		
		// composite to host the file field editor
		fileFieldEditorComp = new Composite(comp, SWT.NONE);
		fileFieldEditorComp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		
		// create a file selector
		fileFieldEditor = new FileFieldEditor("zipFileSelect", "", fileFieldEditorComp);
		fileFieldEditor.setEnabled(false, fileFieldEditorComp);
		// set the allowed file extensions
		fileFieldEditor.setFileExtensions(new String[]{"*.zip", "*.jar"});
		// set the initial browse path
		fileFieldEditor.setFilterPath(
				data.getSourceModelPath().removeLastSegments(1).toFile());
		
		// set listener that is triggered when the user has selected a folder
		fileFieldEditor.setPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				
				if(event.getNewValue().equals("")) {
					return;
				}
				
				// reset the UI
				setErrorMessage(null);
				setPageComplete(false);
				
				// get the selected file
				Object file = event.getNewValue();
				
				if(file instanceof String) {
					try {
						// check if a datatype is given, otherwise set it to zip
						if (!(((String) file).endsWith(".zip") || ((String) file).endsWith(".jar"))) {
							file = file + ".zip";
							fileFieldEditor.setStringValue((String) file);
						}
						
						// set the resource of the new model (only for temporary use until zipped)
						data.setTargetModelPath(data.getSourceModelPath().removeLastSegments(1).append(new Path("temp")).toFile() + File.separator + "data.xmi");
						// set the zip file resource
						data.setZipFilePath((String) file);
						// load the new model
						checkPath(data.getTargetModelPath());
						
					} catch (Exception e) {
						setErrorMessage(e.getMessage());
						data.setLibItemModel(null);
					}
					
					wizContainer.updateButtons();
				}
				
			}
		});
		
		// composite to host the library relative path label and textfield
		relLibPathComp = new Composite(container, SWT.NONE);
		relLibPathComp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		gl = new GridLayout(2, false);
		gl.horizontalSpacing = 10;
		relLibPathComp.setLayout(gl);
		
		// create a label for the library path
		libPathLabel = new Label(relLibPathComp, SWT.NONE);
		libPathLabel.setText("Library Path:");
		libPathLabel.setEnabled(false);
		
		// create a text field for the library path
		libPathTextfield = new Text(relLibPathComp, SWT.BORDER);
		libPathTextfield.setMessage("The relative path inside the archive file...");
		libPathTextfield.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				data.setLibRelPath(libPathTextfield.getText());
				wizContainer.updateButtons();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		// add the verify listener that displays an error if a wrong syntax has been used to enter the path
		libPathLabelDecorator = new ControlDecoration(libPathLabel, SWT.TOP|SWT.RIGHT);
		libPathLabelDecorator.setImage(errorIcon);
		libPathLabelDecorator.setDescriptionText("Please enter the path in the following form: 'my/relative/path'!");
		libPathLabelDecorator.hide();
		libPathTextfield.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent e) {
				String temp = libPathTextfield.getText() + e.text;
				boolean matches = temp.matches("[a-zA-Z0-9_]+(/[a-zA-Z0-9_]*)*");
				if(matches) {
					libPathLabelDecorator.hide();
				} else {
					libPathLabelDecorator.show();
				}
				e.doit = matches; 
			}
		});
		
		// separator
		Label separator = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		separator.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		
		// create a check box
		overwriteButton = new Button(container, SWT.CHECK);
		overwriteButton.setText("Overwrite existing");
		overwriteButton.setSelection(false);
		gd = new GridData();
		gd.horizontalIndent = 5;
		overwriteButton.setLayoutData(gd);
		overwriteButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(overwriteButton.getSelection()) {
					data.setOverwriteZipEntry(true);
				} else {
					data.setOverwriteZipEntry(false);
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		// composite to host the version label and textfield
		comp2 = new Composite(container, SWT.NONE);
		comp2.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		gl = new GridLayout(3, false);
		gl.horizontalSpacing = 10;
		comp2.setLayout(gl);
		
		// create a label for the version
		Label versionLabel = new Label(comp2, SWT.NONE);
		versionLabel.setText("Version:");
		
		// create a text filed for the version
		versionTextField = new Text(comp2, SWT.BORDER);
		gd_1 = new GridData();
		gd_1.horizontalSpan = 2;
		gd_1.horizontalAlignment = SWT.FILL;
		gd_1.widthHint = 50;
		versionTextField.setLayoutData(gd_1);
		String version = "1.0";
		versionTextField.setText(version);
		data.setVersion(version);
		versionTextField.setMessage("The version of the library item to be created...");
		versionTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				data.setVersion(versionTextField.getText());
				wizContainer.updateButtons();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		versionTextField.addVerifyListener(new VerifyListener() {
			
			@Override
			public void verifyText(VerifyEvent e) {
				String temp = versionTextField.getText() + e.text;
				boolean matches = temp.matches("([0-9]+\\.)*[0-9]*");
				if(matches) {
					versionLabelDecorator.hide();
				} else {
					versionLabelDecorator.show();
				}
				e.doit = matches; 
			}
		});
		
		// add the verify listener that displays an error if a wrong syntax has been used to enter the version
		versionLabelDecorator = new ControlDecoration(versionLabel, SWT.TOP|SWT.RIGHT);
		versionLabelDecorator.setImage(errorIcon);
		versionLabelDecorator.setDescriptionText("Please use only numbers and dots to enter the version!");
		versionLabelDecorator.hide();
		
		authorLabel = new Label(comp2, SWT.NONE);
		authorLabel.setText("Author:");
		
		authorTextField = new Text(comp2, SWT.BORDER);
		authorTextField.setMessage("The author of the library item to be created...");
		authorTextField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		authorTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				data.setAuthor(authorTextField.getText());
				wizContainer.updateButtons();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		descriptionLabel = new Label(comp2, SWT.NONE);
		descriptionLabel.setText("Description:");
		
		descriptionTextField = new Text(comp2, SWT.BORDER);
		descriptionTextField.setMessage("The description of the library item to be created...");
		descriptionTextField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		descriptionTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				data.setDescription(descriptionTextField.getText());
				wizContainer.updateButtons();
			}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
		
		thumbnailSelector = new FileFieldEditor("thumbnail", "Thumbnail:", comp2);
		thumbnailSelector.setFileExtensions(new String[]{"*.png", "*.jpg", "*.bmp"});
		thumbnailSelector.getTextControl(comp2).setMessage("The thumbnail image of the library item to be created...");
		thumbnailSelector.setPropertyChangeListener(new IPropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				if(event.getNewValue().equals("")) {
					return;
				}
				
				// get the selected file
				Object file = event.getNewValue();
				if(file instanceof String) {
					// set the resource of the new model
					data.setThumbnail((String) file);
				}
			}
		});
		
		
		// after all controls have been created, add a selection listener to both radio buttons
		folderButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// enable/disable the concerned widgets
				directoryFieldEditor.setEnabled(true, directoryFieldEditorComp);
				fileFieldEditor.setEnabled(false, fileFieldEditorComp);
				libPathTextfield.setEnabled(false);
				libPathLabel.setEnabled(false);
				// update the data and reload the model
				data.setTargetModelPath(directoryFieldEditor.getStringValue());					
				data.setZipFilePath("");
				if(!directoryFieldEditor.getStringValue().isEmpty()) {
					checkPath(data.getTargetModelPath());
				}
				wizContainer.updateButtons();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		zipFileButton.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// enable/disable the concerned widgets
				fileFieldEditor.setEnabled(true, fileFieldEditorComp);
				libPathTextfield.setEnabled(true);
				libPathLabel.setEnabled(true);
				directoryFieldEditor.setEnabled(false, directoryFieldEditorComp);
				// update the data and reload the model
				try {
					data.setTargetModelPath(data.getSourceModelPath().removeLastSegments(1).append(new Path("temp")).toFile() + File.separator + "data.xmi");
				} catch (Exception e1) {
					setErrorMessage(e1.getMessage());
				}
				data.setZipFilePath(fileFieldEditor.getStringValue());
				if(!fileFieldEditor.getStringValue().isEmpty()) {
					checkPath(data.getTargetModelPath());
				}
				wizContainer.updateButtons();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		// fill the wizard page
		setControl(container);
		setPageComplete(false);
	}
	
//	@Override
//	public void setVisible(boolean visible) {
//		wizContainer.updateButtons();
//		super.setVisible(visible);
//	}
	
	@Override
	public boolean canFlipToNextPage() {
		/* one can flip to the next page if:
		 * 1.: a version is entered
		 * 2.: a model has been loaded
		 * 3.: a relative path has been entered if a zip file is to be used
		 */
		//TODO validate the current path instead of the libItemModel
		if(data.getVersion() != null && data.getVersion().isEmpty() == false && data.getTargetModelPath() != null && !data.getTargetModelPath().isEmpty()) {
			if(zipFileButton.getSelection() == true && 
					(data.getZipFilePath() == null || data.getZipFilePath().isEmpty() ||
					data.getLibRelPath() == null || data.getLibRelPath().isEmpty())) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

	// Checks if a valid path has been set
	private void checkPath(String targetModelPath) {
		//TODO validate the current path
	}
	
}
