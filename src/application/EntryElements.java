package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

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
		return "EntryElements [id=" + id + ", btn=" + btn.getBtn().toString() + ", label=" + label.getLabel().toString() + ", amountTF=" + amountTF.getTextField().toString()
				+ ", checkbox=" + checkbox.getCheckbox().toString() + "]";
	}

	void addEntryToRow(GridPane grid, ArrayList<EntryElements> elemList, int counter, String input, String type,
			int id) {

		System.out.println("elemList in addEntryToRow aus EntryElements:\n" + elemList.get(0));

		int rowNumber = grid.getRowCount();
		String sumLabel = type + counter;

//		setActions(btn, id, type, grid, newLabel, sum, sumLabel, total, amountTF, checkbox);
//
//		EventaddAmount event = new EventaddAmount();

//		this.amountTF.getTextField().setOnAction(e -> onEnterAddAmount(e, grid, id, type, elemList));
		this.amountTF.getTextField().setOnAction(e -> new EventaddAmount().getHandle(e, elemList, grid, id, type));
		this.btn.getBtn().setOnAction(e -> new EventDeleteEntry().getHandle(e, id, type, grid, elemList));
//		this.checkbox.getCheckbox().setOnAction(e -> new );
//
		int firstEmptyRow = findEmptyRow(rowNumber, grid);
		System.out.println("firstEmptyRow: " + firstEmptyRow);
//
//		SupportFXML.changeLayout(btn, label, checkbox, amountTF);

		grid.add(this.btn.getBtn(), 0, firstEmptyRow);
		grid.add(this.label.getLabel(), 1, firstEmptyRow);
		grid.add(this.amountTF.getTextField(), 2, firstEmptyRow);
		grid.add(this.checkbox.getCheckbox(), 3, firstEmptyRow);
		
		editDesign(grid);
//
//		addRow(grid, btn.getBtn(), label.getLabel(), amountTF.getTextField(), checkbox.getCheckbox(), firstEmptyRow);
//		newLabel.clear();
		System.out.println("Anzahl Zeilen nach dem Einfuegen eines Elements: " + grid.getRowCount());
//
//		// Zeile mit Summe eine Zeile nach unten verschieben

		int row = Helper.getNodeRow(grid, type + "sum" + id);
		Node nodeLabel = Helper.getNodeFromGridPane(grid, 1, row);
		Node nodeTF = Helper.getNodeFromGridPane(grid, 2, row);
//		System.out.println("Zeile vorher: " + row);
		GridPane.setRowIndex(nodeLabel, row + 1);
		GridPane.setRowIndex(nodeTF, row + 1);

//	System.out.println("Anzahl Zeilen nach dem Einfügen eines Elements: " + gridRevenues.getRowCount());
	}

//	private void setActions(Button btn, int id, String type, GridPane grid, TextField labelNew, TextField sum,
//			Label sumLabel, TextField total, TextField amountTF, CheckBox checkbox) {
//
//		btn.setOnAction(e -> deleteItem(e, id, type, grid, sum, total));
//		checkbox.setOnAction(e -> handleIsFix(e, id, type));
//}

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
//		GridPane.setMargin(this.btn.getBtn(), new Insets(3, 2, 3, 2));
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
