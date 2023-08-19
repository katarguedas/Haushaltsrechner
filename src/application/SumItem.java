package application;

import singleElements.MyLabel;
import singleElements.MyTextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
/**
 * Contains GUIelements to show the sum of incomes or expenses
 * 
 * @author katharina
 *
 */
public class SumItem extends ConfigElements {

	MyLabel label;
	MyTextField tf;

	// **
	// Constructor
	// **
	SumItem(String elementId, String text) {
		this.label = new MyLabel(text, "", 180, 30, getBg() + getlightGreen(), getfontStyle(1), getfontSize(2));
		this.tf = new MyTextField(elementId, "", 100, 30);
	}

	// **
	// Getter
	// **
	public MyLabel getLabel() {
		return this.label;
	}

	public MyTextField getTf() {
		return this.tf;
	}

	// **
	public void configSum(SumItem sumItem, GridPane grid, int initRow) {
		grid.add(sumItem.getLabel().getLabel(), 1, initRow);
		grid.add(sumItem.getTf().getTextField(), 2, initRow);
		GridPane.setMargin(sumItem.getTf().getTextField(), new Insets(10, 0, 10, 0));
		sumItem.getTf().getTextField()
				.setStyle(getBg() + getCream() + ";" + getBorder() + getDarkBlue() + ";" + "-fx-border-radius: 2");
	}

}
