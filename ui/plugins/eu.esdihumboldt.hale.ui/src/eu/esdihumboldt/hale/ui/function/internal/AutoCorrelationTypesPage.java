/*
 * Copyright (c) 2014 Data Harmonisation Panel
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution. If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Data Harmonisation Panel <http://www.dhpanel.eu>
 */

package eu.esdihumboldt.hale.ui.function.internal;

import java.util.Set;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import eu.esdihumboldt.hale.common.align.model.EntityDefinition;
import eu.esdihumboldt.hale.common.align.model.Type;
import eu.esdihumboldt.hale.common.align.model.impl.DefaultType;
import eu.esdihumboldt.hale.common.align.model.impl.TypeEntityDefinition;
import eu.esdihumboldt.hale.ui.HaleWizardPage;
import eu.esdihumboldt.hale.ui.selection.SchemaSelection;
import eu.esdihumboldt.hale.ui.selection.SchemaSelectionHelper;

/**
 * Page to select/set the source of the auto correlation function
 * 
 * @author Yasmina Kammeyer
 */
public class AutoCorrelationTypesPage extends HaleWizardPage<AutoCorrelationFunctionWizard> {

	private Composite pageComposite;
	private Button processEntireSchema;
	// private ListMultimap<String, Type> source;
	private Set<EntityDefinition> source;
	// private ListMultimap<String, Type> target;
	private Set<EntityDefinition> target;
	private Label targetType;
	private Text sourceType;
	private List listOfSourceTypes;
	private List listOfTargetTypes;

	/**
	 * @param pageName The name of the page
	 */
	protected AutoCorrelationTypesPage(String pageName) {
		super(pageName);

		setTitle(pageName);
		setDescription("Please choose/confirm your desired source types.");
	}

	/**
	 * Check if the page is valid and set the
	 * 
	 * @return true, if the page's state is valid
	 */
	private boolean isValid() {
		if (processEntireSchema.getSelection()) {
			setPageComplete(true);
			return true;
		}

		else if (source != null && !source.isEmpty() && target != null && !target.isEmpty()) {
			setPageComplete(true);
			return true;
		}

		setPageComplete(false);
		return false;
	}

	/**
	 * @see eu.esdihumboldt.hale.ui.HaleWizardPage#onShowPage(boolean)
	 */
	@Override
	protected void onShowPage(boolean firstShow) {
		super.onShowPage(firstShow);

		// set the source and target types to the selection if firstShow
		if (firstShow) {
			SchemaSelection selection = SchemaSelectionHelper.getSchemaSelection();
			source = selection.getSourceItems();
			target = selection.getTargetItems();

			if (isValid()) {
				for (EntityDefinition entity : source) {
					listOfSourceTypes.add(entity.getType().getDisplayName());
				}
				for (EntityDefinition entity : target) {
					listOfTargetTypes.add(entity.getType().getDisplayName());
				}
			}
			else {
				listOfSourceTypes.add("<Please click here!>");
				listOfTargetTypes.add("<Please click here!>");
			}

		}

		pageComposite.layout();
		pageComposite.pack();
	}

	/**
	 * @see eu.esdihumboldt.hale.ui.HaleWizardPage#createContent(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	protected void createContent(Composite page) {
		pageComposite = page;

		GridLayout layout = new GridLayout(1, false);
		page.setLayout(layout);
		GridDataFactory.fillDefaults().grab(true, false).applyTo(page);

		Group typeSelectorSpace = new Group(page, SWT.NONE);
		typeSelectorSpace.setText("Types");
		typeSelectorSpace.setLayout(new GridLayout(2, false));
		GridDataFactory.fillDefaults().grab(false, true).applyTo(typeSelectorSpace);

		// Types
		Label sourceLabel = new Label(typeSelectorSpace, SWT.NONE);
		sourceLabel.setText("Source Type: ");
		Label targetLabel = new Label(typeSelectorSpace, SWT.NONE);
		targetLabel.setText("Target Type: ");

		listOfSourceTypes = new List(typeSelectorSpace, SWT.BORDER | SWT.V_SCROLL | SWT.FILL);
		GridDataFactory.swtDefaults().grab(true, true).applyTo(listOfSourceTypes);
		listOfTargetTypes = new List(typeSelectorSpace, SWT.BORDER | SWT.V_SCROLL | SWT.FILL);
		GridDataFactory.swtDefaults().grab(true, true).applyTo(listOfTargetTypes);

		// Checkbox entire Schema
		processEntireSchema = new Button(page, SWT.CHECK);
		processEntireSchema.setText("Process Entire Schema");
		processEntireSchema.setSelection(false);
		processEntireSchema.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (processEntireSchema.getSelection()) {
					// TODO disable type selector
				}
				else {
					// TODO enable type selector
				}
				isValid();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				if (processEntireSchema.getSelection()) {
					// TODO disable type selector
				}
				else {
					// TODO enable type selector
				}
				isValid();
			}
		});
		GridDataFactory.swtDefaults().grab(true, false).applyTo(processEntireSchema);

		setPageComplete(false);
		page.layout();
		page.pack();
	}

	/**
	 * 
	 */
	private void createField(Composite parent) {
		// , String text) {

		// Add the items, one by one

//		ScrolledComposite sc = new ScrolledComposite(parent, SWT.V_SCROLL);
//
//		// Create a child composite to hold the controls
//		Composite control = new Composite(sc, SWT.NONE);
//		control.setLayout(new GridLayout(1, false));
//		GridDataFactory.fillDefaults().grab(true, false).applyTo(control);
//		control.setSize(300, 100);
//
//		Label name = new Label(control, SWT.NONE);
//		name.setText(text);
//		name.setLayoutData(GridDataFactory.swtDefaults().create());
//		/*
//		 * // Set the absolute size of the child child.setSize(400, 400);
//		 */
//		// Set the child as the scrolled content of the ScrolledComposite
//		sc.setContent(control);
//
//		// Set the minimum size
//		// sc.setMinSize(400, 400);
//
//		// Expand both horizontally and vertically
//		sc.setExpandHorizontal(false);
//		sc.setExpandVertical(true);
	}

	/**
	 * 
	 * @return The page's result - source types to be processed
	 */
	public Set<EntityDefinition> getSourceTypes() {
		return source;// convertEntityToType(source);
	}

	/**
	 * 
	 * @return The page's result - target types to be processed
	 */
	public Set<EntityDefinition> getTargetTypes() {
		return target;// convertEntityToType(target);
	}

	private ListMultimap<String, Type> convertEntityToType(Set<EntityDefinition> list) {
		ListMultimap<String, Type> result = ArrayListMultimap.create();

		for (EntityDefinition entity : list) {
			if (entity instanceof TypeEntityDefinition) {
				Type type = new DefaultType((TypeEntityDefinition) entity);

				result.put(null, type);
			}
		}

		return result;
	}
}
