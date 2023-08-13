package application;

import singleElements.MyLabel;
import singleElements.MyTextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class SumItem extends ConfigElements {
	
	MyLabel label;
	MyTextField tf;
	
	
	SumItem(String elementId, String text){
		this.label = new MyLabel(text, "", 180, 30, getBg() + getlightGreen(), getfontStyle(1), getfontSize(2));
		this.tf = new MyTextField(elementId, "", 100, 30);
	}
	
	void configItem() {
		this.label.getLabel().setPadding(new Insets(1, 0, 1, 5));
		this.tf.getTextField().setAlignment(Pos.CENTER_RIGHT);
		this.tf.getTextField().setStyle(getBg() + getCream() + ";" + getBorder() + getDarkBlue());
	}

	public MyLabel getLabel() {
		return this.label;
	}

	public MyTextField getTf() {
		return this.tf;
	}
	
	public void configSum(SumItem sumItem, GridPane grid, int initRow) {
		grid.add(sumItem.getLabel().getLabel(), 1, initRow);
		grid.add(sumItem.getTf().getTextField(), 2, initRow);
		GridPane.setMargin(sumItem.getTf().getTextField(), new Insets(10, 0, 10, 0));
	}
	

}
