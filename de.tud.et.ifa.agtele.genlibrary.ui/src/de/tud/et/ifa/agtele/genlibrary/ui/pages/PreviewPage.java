package de.tud.et.ifa.agtele.genlibrary.ui.pages;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

import de.tud.et.ifa.agtele.genlibrary.ui.provider.ResultPageTreeViewerContentProvider;
import de.tud.et.ifa.agtele.genlibrary.ui.provider.ResultPageTreeViewerLabelProvider;
import de.tud.et.ifa.agtele.genlibrary.ui.wizards.GenerateGenlibraryEntryWizardData;
import de.tud.et.ifa.agtele.resources.ResourceHelper;

public class PreviewPage extends GenerateGenlibraryEntryPage {

	private Composite container;
	private ContainerCheckedTreeViewer viewer;
	private TableViewer propertiesViewer;
	private HashMap<Integer, TreeItem> treeItems = new HashMap<Integer, TreeItem>();

	public PreviewPage(GenerateGenlibraryEntryWizardData wizardData) {
		super(wizardData, "Preview", "Preview of the library item...");
	}

	/*
	 * try to generate the library item by launching the eol transformation; if
	 * the transformation has not been successful, generate an error message; if
	 * the transformation has been successfull, populate the tree viewer
	 */
	@Override
	public void setVisible(boolean visible) {
		if (visible) {
			this.setPageComplete(false);

			// test if the resource already exists
			if ((new File(data.getTargetModelPath())).exists()) {
				if (data.isOverwriteZipEntry()) {
					// delete the existing resource
					ResourceHelper.deleteFilesInFolder(new File(data.getTargetModelPath()));
				} else {
					this.setErrorMessage("Resource already exists!");
					return;
				}
			}

			try {
				// create the metamodel section
				data.setLibItemModel(data.getLibraryContext().createLibraryEntry(data.geteObject(), data.getAuthor(),
						data.getVersion(), data.getDescription(), data.getThumbnail()));
				this.setMessage("Preview of the library item...");
				this.setPageComplete(true);
				getWizard().getContainer().updateButtons();
			} catch (Exception e) {
				this.setErrorMessage(e.getLocalizedMessage());
				getWizard().getContainer().updateButtons();
			}

			// get the root object of the model
			viewer.setInput(new Object[]{data.getLibItemModel()});
			// expand the tree so that the tree item map can be generated
			viewer.expandAll();
			// create a map of the items in the tree that is later used for
			// jumping to these items
			populateTreeItemMap(viewer.getTree().getItem(0));
			// collapse the tree (NOTE: 'collapseAll()' cannot be used as this
			// disposes the tree items)
			viewer.setExpandedTreePaths(new TreePath[] {});
			// only expand the root element and its direct children
			viewer.expandToLevel(2);
		}

		super.setVisible(visible);
	}

	/*
	 * recursively creates a hashmap HashCode(eObject) -> TreeItem; the hashmap
	 * can later be used to get the corresponding TreeItem for an eObject; note
	 * that only the ONE! TreeItem belonging to an eObject is included in the
	 * hashmap that points to its actual place in the model hierarchie
	 * (non-containment references are not treated)
	 */
	private void populateTreeItemMap(TreeItem obj) {
		EObject eObject;
		if (obj.getData() == null) {
			return;
		}
		// occurs only for the root item
		else if (obj.getData() instanceof EObject) {
			eObject = (EObject) obj.getData();
			// add the item to the hashmap
			treeItems.put(eObject.hashCode(), obj);
		}
		// for all litems beside the root item the data is stored as
		// Array[concerning reference, actual eObject]
		else {
			Object[] data = (Object[]) obj.getData();

			// only add the item to the hashmap if it belongs to a
			// containment reference
			if (((EReference) data[0]).isContainment()) {
				eObject = (EObject) data[1];
				// add the item to the hashmap
				treeItems.put(eObject.hashCode(), obj);
			}

		}

		// iterate further
		for (TreeItem child : obj.getItems()) {
			populateTreeItemMap(child);
		}
	}

	@Override
	public void createControl(Composite parent) {

		GridLayout gl;
		GridData gd;

		// container to host the file selector
		container = new Composite(parent, SWT.NONE);

		// define a grid layout
		gl = new GridLayout(2, false);
		container.setLayout(gl);

		// the viewer field is an already configured TreeViewer
		viewer = new ContainerCheckedTreeViewer(container, SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ResultPageTreeViewerContentProvider());
		viewer.setLabelProvider(new ResultPageTreeViewerLabelProvider(data.getBundle()));

		// the tree that the viewer operates on
		final Tree tree = (Tree) viewer.getControl();

		// add a selection listener that - if a non-containment reference is
		// selected
		// jumps to the referenced item in the tree
		tree.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TreeItem item = (TreeItem) e.item;
				if (item.getData() instanceof Object[]) {

					EReference ref = (EReference) ((Object[]) item.getData())[0];
					// jump to the referenced element only if it is a
					// non-containment reference
					// and if the user did not click on the check-box besides
					// the element
					if (!ref.isContainment() && e.detail != 32) {
						EObject object = (EObject) ((Object[]) item.getData())[1];
						TreeItem referencedItem = treeItems.get(object.hashCode());
						tree.setSelection(referencedItem);
					}
					// populate the attribute view
					else if (ref.isContainment()) {
						EObject object = (EObject) ((Object[]) item.getData())[1];
						List<Object[]> lines = new ArrayList<Object[]>();
						for (EAttribute att : object.eClass().getEAllAttributes()) {
							lines.add(new Object[] { att, object.eGet(att) });
						}
						propertiesViewer.setInput(lines);
					}
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// define layout for the tree viewer
		gd = new GridData(GridData.FILL, GridData.FILL, true, true);
		gd.widthHint = 350;
		gd.heightHint = 400;
		tree.setLayoutData(gd);

		// create the properties viewer
		propertiesViewer = new TableViewer(container, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		createColumns(parent, propertiesViewer);
		// the table that the viewer operates on
		final Table table = propertiesViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		// use a simple array content provider to dipslay the array of attribute
		// and their values
		propertiesViewer.setContentProvider(new ArrayContentProvider());

		// define layout for the table viewer
		table.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

		// fill the wizard page
		setControl(container);
		setPageComplete(true);
	}

	// create the columns for the table
	private void createColumns(final Composite parent, final TableViewer viewer) {
		String[] titles = { "Property", "Value" };
		int[] bounds = { 100, 150 };

		// first column is for the property name
		TableViewerColumn col = createTableViewerColumn(titles[0], bounds[0], 0);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object[] line = (Object[]) element;
				return ((EAttribute) line[0]).getName();
			}
		});

		// second column is for the property value
		col = createTableViewerColumn(titles[1], bounds[1], 1);
		col.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				Object[] line = (Object[]) element;
				if (line[1] == null) {
					return "";
				}
				return line[1].toString();
			}
		});
	}

	private TableViewerColumn createTableViewerColumn(String title, int bound, final int colNumber) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(propertiesViewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setWidth(bound);
		column.setResizable(true);
		column.setMoveable(true);
		return viewerColumn;
	}

}
