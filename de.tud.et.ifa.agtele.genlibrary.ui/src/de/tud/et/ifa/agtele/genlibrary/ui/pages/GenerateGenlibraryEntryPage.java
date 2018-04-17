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

import org.eclipse.jface.wizard.WizardPage;

import de.tud.et.ifa.agtele.genlibrary.ui.wizards.GenerateGenlibraryEntryWizardData;

public abstract class GenerateGenlibraryEntryPage extends WizardPage {

	protected GenerateGenlibraryEntryWizardData data;

	public GenerateGenlibraryEntryPage(GenerateGenlibraryEntryWizardData data, String title, String description) {
		super(title);
		setTitle(title);
		setDescription(description);

		this.data = data;
	}

}
