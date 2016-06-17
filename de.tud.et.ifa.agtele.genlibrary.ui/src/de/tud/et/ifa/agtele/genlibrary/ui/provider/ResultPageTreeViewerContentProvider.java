package de.tud.et.ifa.agtele.genlibrary.ui.provider;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class ResultPageTreeViewerContentProvider implements ITreeContentProvider {
    public void inputChanged(Viewer v, Object oldInput, Object newInput) {
    }

    @Override
    public void dispose() {
    }

	@Override
    public Object[] getElements(Object inputElement) {
		
    	// the root object of the model (the library entry)
//    	EObject root = (Object[]) inputElement[0];
    	// the root object shall be displayed in the tree
    	return new Object[]{((Object[]) inputElement)[0]};
    }

    @Override
    public Object[] getChildren(Object parentElement) {
    	ArrayList<Object> ret = new ArrayList<Object>();
    	EObject eObject;
    	
    	if(parentElement instanceof Object[]) {
    		EReference ref = (EReference) ((Object[]) parentElement)[0];
    		if(!ref.isContainment()) {
    			return new Object[]{};
    		}
    		eObject = (EObject) ((Object[]) parentElement)[1];
    	} else {
    		eObject = (EObject) parentElement;
    	}
    	
    	for(EReference ref : eObject.eClass().getEAllReferences()) {
    		Object obj = eObject.eGet(ref);
    		
    		if(obj == null) {
    			continue;
    		} else if(obj instanceof EList) {
    			for(int i=0; i<((EList<?>) obj).size(); i++){
    				ret.add(new Object[]{ref, ((EList<?>) obj).get(i)});
    			}
    		} else {
    			ret.add(new Object[]{ref, obj});
    		}
    	}
    	
    	return ret.toArray();
    }

    @Override
    public Object getParent(Object element) {
    	EObject eObject;
    	if(element instanceof Object[]) {
    		eObject = (EObject) ((Object[]) element)[1];
    	} else {
    		eObject = (EObject) element;
    	}
    	return eObject.eContainer();
    }

    @Override
    public boolean hasChildren(Object element) {
    	EObject eObject;
    	if(element instanceof Object[]) {
    		eObject = (EObject) ((Object[]) element)[1];
    	} else {
    		eObject = (EObject) element;
    	}
    	if (eObject.eContents().isEmpty() && eObject.eClass().getEAllAttributes().isEmpty()) {
    		return false;
    	}
    	return true;
    }

}
