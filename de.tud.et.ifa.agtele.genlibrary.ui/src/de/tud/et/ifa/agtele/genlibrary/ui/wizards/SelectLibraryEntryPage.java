package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;

public class SelectLibraryEntryPage extends WizardPage {

	protected AddGenlibraryEntryWizardData data;
	private TreeViewer treeViewer;
	private Image folderImage, libEntryImage;
	
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
		
		this.folderImage = loadImage("icons/folder.gif");
		this.libEntryImage = loadImage("icons/libentry.gif");
		
		container.setLayout(new GridLayout(1, false));
		
		// LibraryPath Directory Selector
		Composite DirectorySelectorContainer = new Composite(container, SWT.NONE);
		DirectorySelectorContainer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		DirectorySelectorContainer.setBounds(0, 0, 64, 64);
		DirectorySelectorContainer.setLayout(new GridLayout(3, false));
		
		DirectoryFieldEditor libPathSelector = new DirectoryFieldEditor("libPathSelector", "Library Path", DirectorySelectorContainer);
		libPathSelector.setFilterPath(new File(data.getLibPath()));
		libPathSelector.setStringValue(data.getLibPath());
		
		libPathSelector.setPropertyChangeListener(new IPropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent event) {
				// get new value, refresh the library entries and redraw the tree
				if (!(event.getNewValue().toString().equals(event.getOldValue().toString()))) {
					data.setLibPath(event.getNewValue().toString());
					
					data.getLibrary().init(data.getLibPath(), data.getLibraryContext(), data.getLibraryPathParser());
					
					treeViewer.setInput(data.getLibrary().getAllElementLibraryPathAsString(0, 0));
				}
			}
		});
		
		Composite libEntrySelectionContainer = new Composite(container, SWT.NONE);
		libEntrySelectionContainer.setLayout(new GridLayout(1, false));
		libEntrySelectionContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		treeViewer = new TreeViewer(libEntrySelectionContainer, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		treeViewer.setContentProvider(new ITreeContentProvider() {
			
			@Override
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
				
			}
			
			@Override
			public void dispose() {
				
			}
			
			@Override
			public boolean hasChildren(Object element) {
				
				return ((TreeData) element).getValues().size() > 0;
			}
			
			@Override
			public Object getParent(Object element) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object[] getElements(Object inputElement) {
				
				return getTreeData(inputElement);
			}

			
			@Override
			public Object[] getChildren(Object parentElement) {
								
				return getTreeData(((TreeData) parentElement).getValues());
			}
			
			/**
			 * Returns an Array of {@link TreeData} that is calculated from a list of classpath strings.
			 * 
			 * @param classpathsList
			 * @return
			 */
			@SuppressWarnings("unchecked")
			private Object[] getTreeData(Object classpathsList) {
				LinkedHashMap<String, TreeData> nodes = new LinkedHashMap<String, TreeData>();
				
				for (String element : (List<String>) classpathsList) {
					String[] classPath = element.split("\\.", 2);
					if (!nodes.containsKey(classPath[0])) {
						nodes.put(classPath[0], new TreeData(classPath[0]));
					}
					if (classPath.length > 1) nodes.get(classPath[0]).addValue(classPath[1]);
					else nodes.get(classPath[0]).setHasLibEntry(true);
				}
				
				return nodes.values().toArray();
			}
		});
		
		treeViewer.setLabelProvider(new StyledCellLabelProvider() {
			
			@Override
			public void update(ViewerCell cell) {
				cell.setText(((TreeData) cell.getElement()).getName());
				if (!((TreeData) cell.getElement()).hasLibEntry()) cell.setImage(folderImage);
				else cell.setImage(libEntryImage);
				
				super.update(cell);
			}
			
			@Override
			public void dispose() {
				super.dispose();
			}
		});
		
		treeViewer.setInput(data.getLibrary().getAllElementLibraryPathAsString(0, 0));
	}

	private Image loadImage(String path) {
		URL url = FileLocator.find(data.getBundle(), new Path(path), null);
	    ImageDescriptor imageDcr = ImageDescriptor.createFromURL(url);
	    return imageDcr.createImage();
	}

	class TreeData {
		private String name;
		private ArrayList<String> values;
		private Boolean hasLibEntry;
		
		public TreeData (String name) {
			this.name = name;
			this.values = new ArrayList<String>();
			this.hasLibEntry = false;
		}
		
		public String getName() {
			return name;
		}
		
		public ArrayList<String> getValues() {
			return values;
		}
		
		public void addValue(String value) {
			this.values.add(value);
		}
		
		public void setHasLibEntry(Boolean hasLibEntry) {
			this.hasLibEntry = hasLibEntry;
		}
		
		public boolean hasLibEntry() {
			return this.hasLibEntry;
		}
	}
	
	@Override
	public void dispose() {
		folderImage.dispose();
		libEntryImage.dispose();
		
		super.dispose();
	}
}
