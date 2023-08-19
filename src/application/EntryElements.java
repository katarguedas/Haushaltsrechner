package application;

import java.util.ArrayList;

import data.Entry;
import application.EntryElements;
import data.MonthlyBudget;
import events.EventCheckbox;
import events.EventDeleteEntry;
import events.EventaddAmount;
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

/**
 * Contains GUI elements of an Entry.
 * 
 * @author katharina
 *
 */
public class EntryElements {

	int id;
	public MyButton btn;
	public MyLabel label;
	public MyTextField amountTF;
	public MyCheckBox checkbox;

	// **
	// Constructors
	// **
	EntryElements() {

	}

	public EntryElements(int counter, String input) {
		this.id = counter;
		this.btn = new MyButton("X", "btn" + counter);
		this.amountTF = new MyTextField("amount" + counter);
		this.label = new MyLabel(input, "label" + counter, 350, 30, "-fx-background-color: #D9EEF0", "System", 15);
		this.checkbox = new MyCheckBox("isFix", "isFix" + counter);
		this.btn.getBtn().setAlignment(Pos.CENTER);
	}
	
	// **
	// Getter
	// **
	public int getId() {
		return this.id;
	}
	

	@Override
	public String toString() {
		return "EntryElements [id=" + id + ", btn=" + btn.getBtn().toString() + ", label=" + label.getLabel().toString()
				+ ", amountTF=" + amountTF.getTextField().toString() + ", checkbox=" + checkbox.getCheckbox().toString()
				+ "]";
	}

	/**
	 * This Method adds a new Row to the GridPane with data of a new Entry.
	 * 
	 * @param grid           - GridPane
	 * @param elemList
	 * @param counter        - entry counter
	 * @param input
	 * @param type           - specifies whether it is the revenue or expense part. 
	 * @param id             - Represents the xth month.
	 * @param monthlyBudget  - Contains data ióf one months. 
	 * @param sumTF          - TextField which shows the sum of all incomes or expenses
	 * @param loadData       - specifies if the method is called from JSONimport or not
	 */
	public void addEntryToRow(GridPane grid, ArrayList<EntryElements> elemList, Counter counter, String input, String type,
			int id, MonthlyBudget monthlyBudget, TextField sumTF, boolean loadData) {

		int rowNumber = grid.getRowCount();
		// adds events to the elements
		this.amountTF.getTextField().setOnAction(e -> new EventaddAmount().getHandle(e, elemList, grid, id, type,
				 monthlyBudget, sumTF));
		this.btn.getBtn().setOnAction(
				e -> new EventDeleteEntry().getHandle(e, id, type, grid, elemList, counter, sumTF, monthlyBudget));
		this.checkbox.getCheckbox().setOnAction(e -> new EventCheckbox().getHandle(e, elemList, type, monthlyBudget));

		// if the entry comes from the user (and not from the json import): saves the data of the new entry
		if (!loadData) {
			if (type.equals("in"))
				monthlyBudget.addIncome(counter.getCounter(), new Entry(counter.getCounter(),input, 0, false));
			if (type.equals("exp"))
				monthlyBudget.addExpense(counter.getCounter(), new Entry(counter.getCounter(), input, 0, false));
		}

		// finds out an empty row to add there the elements
		int emptyRow = Helper.findLastEmptyRow(rowNumber-1,0, grid);

		// adds the elements to the GridPane
		grid.add(this.btn.getBtn(), 0, emptyRow);
		grid.add(this.label.getLabel(), 1, emptyRow);
		grid.add(this.amountTF.getTextField(), 2, emptyRow);
		grid.add(this.checkbox.getCheckbox(), 3, emptyRow);

		editDesign(grid);

//		// Moves the row with the sum one row down
		int row = Helper.getNodeRow(grid, type + "sum" + id);
		Node nodeLabel = Helper.getNodeFromGridPane(grid, 1, row);
		Node nodeTF = Helper.getNodeFromGridPane(grid, 2, row);
		GridPane.setRowIndex(nodeLabel, row + 1);
		GridPane.setRowIndex(nodeTF, row + 1);
	}

	public void editDesign(GridPane grid) {

		GridPane.setMargin(this.btn.getBtn(), new Insets(2, 0, 0, 12));
		GridPane.setMargin(this.checkbox.getCheckbox(), new Insets(0, 25, 0, 25));
		this.label.getLabel().setPadding(new Insets(5, 15, 5, 15));
		this.label.getLabel().setFont(new Font(15));
		this.btn.getBtn().setFont(new Font(9));
		this.btn.getBtn().setStyle("-fx-text-fill: red");
		this.amountTF.getTextField().setPromptText("Betrag + Enter");
		this.amountTF.getTextField().setAlignment(Pos.CENTER_RIGHT);
	}
}
