package de.tud.et.ifa.agtele.genlibrary.ui.provider;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public class ResultPageTreeViewerLabelProvider extends StyledCellLabelProvider {
	
	private Image containmentRefImage, nonContainmentRefImage;
	private Bundle bundle;
	
	public ResultPageTreeViewerLabelProvider(Bundle bundle) {
		super();
		this.bundle = bundle;
		// create the images used in the tree viewer
		createImages();
	}
	
    @Override
    public void update(ViewerCell cell) {
    	
    	Object element = cell.getElement();
    	StyledString text = new StyledString();
    	
    	if(element instanceof Object[]) {
    		Object[] obj = (Object[]) element; 
    		text.append(((EReference) obj[0]).getName());
    		text.append(" : ");
    		text.append(((EObject) obj[1]).eClass().getName());
    		
    		if(((EReference) obj[0]).isContainment()) {
    			cell.setImage(containmentRefImage);
    		} else {
    			cell.setImage(nonContainmentRefImage);
    		}
    	} else if(element instanceof EObject) {
    		EObject obj = (EObject) element;
    		text.append(obj.eClass().getName());
    	}

    	cell.setText(text.toString());
    	cell.setStyleRanges(text.getStyleRanges());
    	super.update(cell);

    }
    
    @Override
    public void dispose() {
    	containmentRefImage.dispose();
    	nonContainmentRefImage.dispose();
    	super.dispose();
    }
    
    private void createImages() {
	    URL url = FileLocator.find(bundle, new Path("icons/containmentRef.png"), null);
	    ImageDescriptor imageDcr = ImageDescriptor.createFromURL(url);
	    this.containmentRefImage = imageDcr.createImage();
	    url = FileLocator.find(bundle, new Path("icons/nonContainmentRef.png"), null);
	    imageDcr = ImageDescriptor.createFromURL(url);
	    this.nonContainmentRefImage = imageDcr.createImage();
	}
}
