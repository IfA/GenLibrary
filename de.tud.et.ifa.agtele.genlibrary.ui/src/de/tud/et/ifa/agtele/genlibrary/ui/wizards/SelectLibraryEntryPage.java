package de.tud.et.ifa.agtele.genlibrary.ui.wizards;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.ScrolledComposite;

public class SelectLibraryEntryPage extends WizardPage {

	protected AddGenlibraryEntryWizardData data;
	private TreeViewer treeViewer;
	private Label lblVersionValue, lblNamevalue;
	private Image folderImage, libEntryImage;
	private Label lblDescriptionvalue;
	private Label lblThumb;
	private Image thumbnail;
	private Group grpDetails;
	private Composite thumbContainer;
	private ScrolledComposite scrolledComposite;
	private Composite composite;
	private Composite innerThumbContainer;
	
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
		
		// LibraryEntry Selector starts here
		Composite libEntrySelectionContainer = new Composite(container, SWT.NONE);
		libEntrySelectionContainer.setLayout(new GridLayout(2, false));
		libEntrySelectionContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		treeViewer = new TreeViewer(libEntrySelectionContainer, SWT.BORDER);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));		
		
		// ContentProvider for the LibraryEntry selection TreeViewer
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
				
				return getTreeData(inputElement, "");
			}

			
			@Override
			public Object[] getChildren(Object parentElement) {
								
				return getTreeData(((TreeData) parentElement).getValues(), ((TreeData) parentElement).getClassPath());
			}
			
			/**
			 * Returns an Array of {@link TreeData} that is calculated from a list of classpath strings.
			 * 
			 * @param classpathsList
			 * @return
			 */
			@SuppressWarnings("unchecked")
			private Object[] getTreeData(Object classpathsList, String parentClassPath) {
				LinkedHashMap<String, TreeData> nodes = new LinkedHashMap<String, TreeData>();
				
				for (String element : (List<String>) classpathsList) {
					String[] classPath = element.split("\\.", 2);
					if (!nodes.containsKey(classPath[0])) {
						String newClassPath;
						if (parentClassPath.equals("")) newClassPath = classPath[0];
						else newClassPath = parentClassPath + "." + classPath[0];
						nodes.put(classPath[0], new TreeData(classPath[0], newClassPath));
					}
					if (classPath.length > 1) nodes.get(classPath[0]).addValue(classPath[1]);
					else nodes.get(classPath[0]).setHasLibEntry(true);
				}
				
				return nodes.values().toArray();
			}
		});
		
		// LabelProvider for the LibraryEntry selection TreeViewer
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
		
		// Eventlistener for the LibraryEntry selection TreeViewer
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				lblNamevalue.setText("");
				lblNamevalue.setToolTipText("");
				lblVersionValue.setText("");
				lblDescriptionvalue.setText("");
				lblThumb.setImage(null);
				if (thumbnail != null) thumbnail.dispose();
				if (event.getSelection() instanceof StructuredSelection) {
					if (((StructuredSelection) event.getSelection()).size() == 1) {
						// TODO add some library path checking magic here
						
						TreeData td = ((TreeData) ((StructuredSelection) event.getSelection()).getFirstElement());
						if (td.hasLibEntry()) {
							// show the detailview of the corresponding libraryentry
							
							LibraryEntry libEntry = data.getLibrary().getElement(td.getClassPath(), false);
							
							lblNamevalue.setText(td.getName());
							lblNamevalue.setToolTipText(td.getClassPath());
							lblVersionValue.setText(libEntry.getVersion());
							if (libEntry.getDescription() != null) {
								lblDescriptionvalue.setText(libEntry.getDescription());
							}
							try {
								InputStream thumbInputStream = data.getLibrary().getResourceInputStream(td.getClassPath(), false, libEntry.getThumbnail());
								thumbnail = new Image(Display.getCurrent(), thumbInputStream);								
								thumbInputStream.close();
								thumbnail = resizeImage(thumbnail, 150, 150);
								lblThumb.setSize(thumbnail.getImageData().width, thumbnail.getImageData().height);
								lblThumb.setImage(thumbnail);
							} catch (IllegalArgumentException | IOException e) {
								
							}
							
							composite.layout();
							innerThumbContainer.layout();
							
							scrolledComposite.setMinHeight(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
							
						}
					}
				}
			}
		});
		
		treeViewer.setInput(data.getLibrary().getAllElementLibraryPathAsString(0, 0));
		
		grpDetails = new Group(libEntrySelectionContainer, SWT.NONE);
		grpDetails.setLayout(new GridLayout(1, false));
		GridData gd_grpDetails = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_grpDetails.widthHint = 180;
		grpDetails.setLayoutData(gd_grpDetails);
		grpDetails.setText("Details");
		
		scrolledComposite = new ScrolledComposite(grpDetails, SWT.V_SCROLL);
		scrolledComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		// Details: Name
		Label lblName = new Label(composite, SWT.NONE);
		lblName.setText("Name:");
		
		lblNamevalue = new Label(composite, SWT.NONE);
		lblNamevalue.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		// Details: Version
		Label lblVersion = new Label(composite, SWT.NONE);
		lblVersion.setText("Version:");
		
		lblVersionValue = new Label(composite, SWT.NONE);
		lblVersionValue.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		
		// Details: Description
		Label lblDescription = new Label(composite, SWT.NONE);
		lblDescription.setText("Description:");
		new Label(composite, SWT.NONE);
		
		lblDescriptionvalue = new Label(composite, SWT.WRAP);
		GridData gd = new GridData(SWT.LEFT, SWT.TOP, true, false, 2, 1);
		gd.widthHint = 160;
		lblDescriptionvalue.setLayoutData(gd);
		
		
		thumbContainer = new Composite(composite, SWT.NONE);
		GridData gd_thumbContainer = new GridData(SWT.CENTER, SWT.TOP, true, true, 2, 1);
		gd_thumbContainer.widthHint = 160;
		gd_thumbContainer.heightHint = 160;
		gd_thumbContainer.minimumWidth = 160;
		gd_thumbContainer.minimumHeight = 160;
		thumbContainer.setLayoutData(gd_thumbContainer);
		GridLayout gl_thumbContainer = new GridLayout(1, false);
		gl_thumbContainer.marginHeight = 0;
		gl_thumbContainer.marginWidth = 0;
		gl_thumbContainer.marginTop = 5;
		thumbContainer.setLayout(gl_thumbContainer);
		
		innerThumbContainer = new Composite(thumbContainer, SWT.BORDER);
		GridData gd_innerThumbContainer = new GridData(SWT.CENTER, SWT.FILL, true, false, 1, 1);
		gd_innerThumbContainer.heightHint = 150;
		gd_innerThumbContainer.widthHint = 150;
		gd_innerThumbContainer.minimumWidth = 150;
		gd_innerThumbContainer.minimumHeight = 150;
		innerThumbContainer.setLayoutData(gd_innerThumbContainer);
		GridLayout gl_innerThumbContainer = new GridLayout(1, false);
		gl_innerThumbContainer.marginHeight = 0;
		gl_innerThumbContainer.marginWidth = 0;
		innerThumbContainer.setLayout(gl_innerThumbContainer);
		
		lblThumb = new Label(innerThumbContainer, SWT.CENTER);
		GridData gd_lblThumb = new GridData(SWT.CENTER, SWT.BOTTOM, false, false, 1, 1);
		gd_lblThumb.widthHint = 150;
		gd_lblThumb.heightHint = 150;
		lblThumb.setLayoutData(gd_lblThumb);
		
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		//lblThumb.setSize(120, 120);
		
	}

	/**
	 * loads an image from the bundle
	 * 
	 * @param path
	 * @return
	 */
	private Image loadImage(String path) {
		URL url = FileLocator.find(data.getBundle(), new Path(path), null);
	    ImageDescriptor imageDcr = ImageDescriptor.createFromURL(url);
	    return imageDcr.createImage();
	}
	
	private Image resizeImage(Image image, int width, int height) {
		ImageData oldImageData = image.getImageData();
		int oldWidth = oldImageData.width;
		int oldHeight = oldImageData.height;
		int newWidth = width;
		int newHeight = height;
		
		
		Double ratio = ((double) oldWidth)/((double) oldHeight);
		
		if (ratio >= 1) {
			newHeight = (int) (newHeight/ratio);
		}
		else {
			newWidth = (int) (newWidth*ratio);
		}
		
		ImageData newImageData = oldImageData.scaledTo(newWidth, newHeight);
		
		Image newImage = new Image(Display.getCurrent(), newImageData);
		image.dispose();
		
		return newImage;	
	}

	/**
	 * DataBean containing all necessary information about a node in the library tree
	 * 
	 * @author martin
	 *
	 */
	class TreeData {
		private String name;
		private ArrayList<String> values;
		private Boolean hasLibEntry;
		private String classPath;
		
		public TreeData (String name, String classpath) {
			this.name = name;
			this.values = new ArrayList<String>();
			this.hasLibEntry = false;
			this.classPath = classpath;
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
		
		public String getClassPath() {
			return this.classPath;
		}
	}
	
	@Override
	public void dispose() {
		folderImage.dispose();
		libEntryImage.dispose();
		if (thumbnail != null) thumbnail.dispose();
		
		super.dispose();
	}
}