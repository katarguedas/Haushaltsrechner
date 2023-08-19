package application;

import data.MonthlyBudget;
import events.EventaddEntryElements;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import singleElements.MyButton;
import singleElements.MyTextField;

/**
 * Contains a TextField and a Button which are used to entry new data by user.
 * 
 * @author katharina
 *
 */
public class EntryItem extends ConfigElements {

	private MyTextField input;
	private MyButton addBtn;

	// **
	// Constructor
	// **
	EntryItem(String type, String text, String btnName, int id, GridPane grid) {
		this.input = new MyTextField(type + id, text, 120, 28);
		this.addBtn = new MyButton(btnName, "addBtn" + id, 100, 26, getBg() + getDarkBlue(), getfontStyle(1),
				getfontSize(0));
		configItem(grid);
	}

	public void configItem(GridPane grid) {
		this.addBtn.getBtn().setTextFill(Color.valueOf(getCream()));
		GridPane.setMargin(addBtn.getBtn(), new Insets(5, 10, 5, 10));
		grid.add(input.getTextField(), 1, 1);
		grid.add(addBtn.getBtn(), 2, 1);
	}


	/**
	 * This method adds events to the TextField and the Button to be able to add a new Entry.
	 * @param entryElemList
	 * 
	 * @param id -          Represents the xth month.
	 * @param grid -        GridPane
	 * @param type -        specifies whether it is the revenue or expense part.   
	 * @param counter -     Entry counter. 
	 * @param counterMax-   maximal number of entries that can be added to the GUI.
	 * @param monthlyBudget
	 * @param sumTF -       TextField which shows the sum of all incomes or expenses
	 */
	public void addEvents(EntryElemList entryElemList, int id, GridPane grid, String type, Counter counter, int counterMax,
			MonthlyBudget monthlyBudget, TextField sumTF) {

		try {
			this.addBtn.getBtn().setOnAction(e -> new EventaddEntryElements().getHandle(entryElemList,
					this.input.getTextField(), id, grid, counter, counterMax, type, monthlyBudget, sumTF, false));

			GridPane.setMargin(input.getTextField(), new Insets(6, 5, 6, 2));
			
		} catch (Exception e) {
			System.out.println("Neuer Eintrag konnte nicht hinzugefügt werden");
		}
		try {
			input.getTextField().setOnAction(e -> new EventaddEntryElements().getHandle(entryElemList,
					this.input.getTextField(), id, grid, counter, counterMax, type, monthlyBudget, sumTF, false));

		} catch (Exception e) {
			System.out.println("Neuer Eintrag konnte nicht hinzugefügt werden");
		}

	}
}
