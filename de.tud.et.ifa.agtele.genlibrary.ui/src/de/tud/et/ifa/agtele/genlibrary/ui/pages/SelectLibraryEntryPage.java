/*******************************************************************************
 * Copyright (C) 2018-2018 Institute of Automation, TU Dresden
 * 
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *   Institute of Automation, TU Dresden - Initial API and implementation
 * 
 * SPDX-License-Identifier: EPL-2.0
 ******************************************************************************/
package de.tud.et.ifa.agtele.genlibrary.ui.pages;

import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import de.tud.et.ifa.agtele.genlibrary.model.genlibrary.LibraryEntry;
import de.tud.et.ifa.agtele.genlibrary.ui.widgets.GenlibraryViewer;
import de.tud.et.ifa.agtele.genlibrary.ui.widgets.GenlibraryViewer.TreeData;
import de.tud.et.ifa.agtele.genlibrary.ui.wizards.AddGenlibraryEntryWizardData;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class SelectLibraryEntryPage extends WizardPage {

	protected AddGenlibraryEntryWizardData data;
	private GenlibraryViewer genlibViewer;
	private LibraryEntry selectedLibraryEntry;
	
	public SelectLibraryEntryPage(AddGenlibraryEntryWizardData data) {
		super("Select LibraryEntry");
		setTitle("Select LibraryEntry");
		setDescription("Select the library entry that should be added to the target model...");
		
		this.data = data;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		genlibViewer = new GenlibraryViewer(container, SWT.NONE, data.getLibPath(), data.getLibrary(), data.getLibraryContext(), data.getLibraryPathParser());
		genlibViewer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		
		genlibViewer.addTreeViewerSelectionListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				
				if (event.getSelection() instanceof StructuredSelection) {
					if (((StructuredSelection) event.getSelection()).size() == 1) {						
						TreeData td = ((TreeData) ((StructuredSelection) event.getSelection()).getFirstElement());
						if (td.hasLibEntry()) {
							data.setClassPath(td.getClassPath());
							selectedLibraryEntry = data.setLibEntry(data.getLibrary().getElement(td.getClassPath(), false));
							getWizard().getContainer().updateButtons();
						}
					}
				}
			}
		});
	}
	
	@Override
	public boolean canFlipToNextPage() {
		/* WizardPage is allowed to flip to the next page, when those conditions are met:
		 * 1. a valid LibPath was selected
		 * 2. a valid LibraryEntry was selected
		 */
		
		if((genlibViewer.getLibPath() != "") && (selectedLibraryEntry != null)) {
			if ((selectedLibraryEntry.getParameterDescription() != null) && (selectedLibraryEntry.getLibraryItem() != null)) {
				return true;
			}
		}
		
		return false;
	}
	
	public LibraryEntry getSelectedLibraryEntry() {
		
		return selectedLibraryEntry;
	}
}
