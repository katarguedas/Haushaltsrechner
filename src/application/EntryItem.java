package application;

import data.MonthlyBudget;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import singleElements.MyButton;
import singleElements.MyTextField;

public class EntryItem extends ConfigElements {

	private MyTextField input;
	private MyButton addBtn;

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

	public void addEvents(EntryElemList entryElemList, int id, GridPane grid, String type, Counter counter, int counterMax,
			MonthlyBudget monthlyBudget, TextField sumTF) {

		try {
			this.addBtn.getBtn().setOnAction(e -> new EventaddEntryElements().getHandle(entryElemList,
					this.input.getTextField(), id, grid, counter, counterMax, type, monthlyBudget, sumTF));

//			counter++;

			GridPane.setMargin(input.getTextField(), new Insets(6, 5, 6, 2));
		} catch (Exception e) {
			System.out.println("Neuer Eintrag konnte nicht hinzugefügt werden");
		}
		try {
			input.getTextField().setOnAction(e -> new EventaddEntryElements().getHandle(entryElemList,
					this.input.getTextField(), id, grid, counter, counterMax, type, monthlyBudget, sumTF));

//				counter++;

		} catch (Exception e) {
			System.out.println("Neuer Eintrag konnte nicht hinzugefügt werden");
		}

	}
}
