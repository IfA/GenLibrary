package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.ui.pages.PreviewPage;
import de.tud.et.ifa.agtele.genlibrary.ui.pages.TargetSelectorPage;
import de.tud.et.ifa.agtele.resources.ResourceHelper;

public class GenerateGenlibraryEntryWizard extends Wizard {
	
	protected TargetSelectorPage one;
	protected PreviewPage two;
	protected GenerateGenlibraryEntryWizardData data;
	
	public GenerateGenlibraryEntryWizard(GenerateGenlibraryEntryWizardData data) {
		super();
		setNeedsProgressMonitor(true);
		this.data = data;
	}

	@Override
	public void addPages() {
		one = new TargetSelectorPage(data);
		addPage(one);
		two = new PreviewPage(data);
		addPage(two);
	}
	
	@Override
	public boolean canFinish() {
		// the wizard can finish if the last page is active and complete
		return (getContainer().getCurrentPage().equals(two) && two.isPageComplete());
	}
	
	@Override
	public boolean performFinish() {
		boolean createZip = (data.getZipFilePath() != null && data.getZipFilePath() != ""); 
		String tempFolder = "";
		
		if(createZip) {
			// if the specified zip file already exists, unzip it
			tempFolder = (new Path(data.getTargetModelPath())).removeLastSegments(1).toString();
			if((new File(data.getZipFilePath()).exists())) {
				ResourceHelper.unzipFolder(data.getZipFilePath(), tempFolder);
			}
			
			// show an error message if the relative path inside the zip file already exists and
			// 'overwrite' is set to false
			if(!data.isOverwriteZipEntry() && new File(tempFolder + File.separator + data.getLibRelPath()).exists()) {
				cleanup(new File[]{(new Path(data.getTargetModelPath())).removeLastSegments(1).toFile()});
				MessageDialog.openError(getShell(), "Error", "The relative path already exists inside the archive file...");
				return true;
			}
		}
		
		// store the model into a file
		saveModel(data.getLibItemModel(), data.getTargetModelPath());
		
		// if a zip file is to be created, copy the created model and related files to the relative path
		if(createZip) {
			(new File(tempFolder + File.separator + data.getLibRelPath())).mkdirs();
			for(File file : (new File(tempFolder)).listFiles()) {
				// move all created files but not the existing directories of the other library items
				if(!file.isDirectory()) {
					try {
						ResourceHelper.copyFile(file, 
								tempFolder + File.separator + data.getLibRelPath());
						file.delete();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		// if a zip file is to be created, zip the model and delete it afterwards
		if(createZip) {
			ResourceHelper.zipFolder(tempFolder, data.getZipFilePath());			
			cleanup(new File[]{(new Path(data.getTargetModelPath())).removeLastSegments(1).toFile()});
		} else {
			cleanup(null);
		}
		
		MessageDialog.openInformation(getShell(), "Success", "The library item has been created successfully!");
		return true;
	}

	private void saveModel(LibraryEntry libraryEntry, String targetModelPath) {
	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();

	    // create a resource
	    Resource resource = resSet.createResource(URI
	        .createFileURI(targetModelPath));
	    // Get the first model element and cast it to the right type, in my
	    // example everything is hierarchical included in this first node
	    resource.getContents().add(libraryEntry);

	    // now save the content.
	    try {
	      resource.save(Collections.emptyMap());
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	}
	
	@Override
	public boolean performCancel() {
		
		cleanup(null);
		
		return true;
	}
	
	public void cleanup(File[] filesToDelete) {
		
		//TODO delete the models as they are no longer used
		
		if(filesToDelete != null) {
			// delete all necessary files/folders
			for(File file : filesToDelete) {
				if(!file.exists()) {
					continue;
				}
				if(file.isDirectory()) {
					ResourceHelper.deleteFolder(file);
					
				} else {
					file.delete();
				}
			}			
		}

	}
	
	
}
