package application;

import java.util.ArrayList;

import data.Entry;
import data.MonthlyBudget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import singleElements.MyButton;
import singleElements.MyCheckBox;
import singleElements.MyLabel;
import singleElements.MyTextField;

public class EntryElements {

	int id;
	MyButton btn;
	MyLabel label;
	MyTextField amountTF;
	MyCheckBox checkbox;

	EntryElements() {

	}

	EntryElements(int counter, String input) {
		this.id = counter;
		this.btn = new MyButton("X", "btn" + counter);
		this.amountTF = new MyTextField("amount" + counter);
		this.label = new MyLabel(input, "label" + counter, 350, 30, "-fx-background-color: #D9EEF0", "System", 15);
		this.checkbox = new MyCheckBox("isFix", "isFix" + counter);

		this.btn.getBtn().setAlignment(Pos.CENTER);

	}

	@Override
	public String toString() {
		return "EntryElements [id=" + id + ", btn=" + btn.getBtn().toString() + ", label=" + label.getLabel().toString()
				+ ", amountTF=" + amountTF.getTextField().toString() + ", checkbox=" + checkbox.getCheckbox().toString()
				+ "]";
	}

	void addEntryToRow(GridPane grid, ArrayList<EntryElements> elemList, Counter counter, String input, String type,
			int id, MonthlyBudget monthlyBudget, TextField sumTF, boolean loadData) {

		int rowNumber = grid.getRowCount();
		//
		this.amountTF.getTextField().setOnAction(e -> new EventaddAmount().getHandle(e, elemList, grid, id, type,
				counter.getCounter(), monthlyBudget, sumTF));
		this.btn.getBtn().setOnAction(
				e -> new EventDeleteEntry().getHandle(e, id, type, grid, elemList, counter, monthlyBudget));
		this.checkbox.getCheckbox().setOnAction(e -> new EventCheckbox().getHandle(e, elemList, type, monthlyBudget));

		if (!loadData) {
			if (type.equals("in"))
				monthlyBudget.addIncome(counter.getCounter(), new Entry(input, 0, false));
			if (type.equals("exp"))
				monthlyBudget.addExpense(counter.getCounter(), new Entry(input, 0, false));
		}

		int firstEmptyRow = findEmptyRow(rowNumber, grid);

		grid.add(this.btn.getBtn(), 0, firstEmptyRow);
		grid.add(this.label.getLabel(), 1, firstEmptyRow);
		grid.add(this.amountTF.getTextField(), 2, firstEmptyRow);
		grid.add(this.checkbox.getCheckbox(), 3, firstEmptyRow);

		editDesign(grid);
//
//		// Zeile mit Summe eine Zeile nach unten verschieben

		int row = Helper.getNodeRow(grid, type + "sum" + id);
		Node nodeLabel = Helper.getNodeFromGridPane(grid, 1, row);
		Node nodeTF = Helper.getNodeFromGridPane(grid, 2, row);
		GridPane.setRowIndex(nodeLabel, row + 1);
		GridPane.setRowIndex(nodeTF, row + 1);
	}

	static public int findEmptyRow(int rowNumber, GridPane grid) {
		int firstEmptyRow = 999;

		for (int i = 0; i < rowNumber; i++) {
			// finde die erste freie Zeile von oben zählend
			if (Helper.getNodeFromGridPane(grid, 1, i) == null) {
				firstEmptyRow = i;
				break;
			}
		}
		return firstEmptyRow;
	}

	public void editDesign(GridPane grid) {

		GridPane.setMargin(this.btn.getBtn(), new Insets(2, 0, 0, 12));
		GridPane.setMargin(this.checkbox.getCheckbox(), new Insets(0, 25, 0, 25));
		this.label.getLabel().setPadding(new Insets(5, 15, 5, 15));
		this.label.getLabel().setFont(new Font(15));
		this.btn.getBtn().setFont(new Font(9));
//		btn.setStyle("-fx-font-weight: bold; -fx-text-fill: red");
		this.btn.getBtn().setStyle("-fx-text-fill: red");
		this.amountTF.getTextField().setPromptText("Betrag + Enter");
		this.amountTF.getTextField().setAlignment(Pos.CENTER_RIGHT);

	}
}
