package application;

import data.MonthlyBudget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import singleElements.MyButton;
import singleElements.MyLabel;
import singleElements.MyTextField;

public class ItemTotal extends ConfigElements {
	
	MyLabel label;
	MyButton btn;
	MyTextField tf;

	int labelPrefW = 320;
	int btnPrefW = 100;
	int tfPrefW = 120;
	int prefH = 30;
	String labelBg = getBg() + getMidGreen();
	String labelfontStyle = getfontStyle(1);
	int labelFontSize=  getfontSize(2);
	String btnBg = getBg() + getDarkBlue();
	String btnfontStyle = getfontStyle(1);
	int btnFontSize=  getfontSize(1);
	
	ItemTotal() {
		
	}
	
	ItemTotal(String labelText, String btnText, String id) {
		this.label = new MyLabel(labelText, "", labelPrefW, prefH, labelBg, labelfontStyle, labelFontSize);
		this.btn = new MyButton(btnText, id, btnPrefW, prefH, btnBg, btnfontStyle, btnFontSize);
		this.tf = new MyTextField("tf"+id, "", tfPrefW, prefH);
		
		this.label.getLabel().setAlignment(Pos.CENTER_RIGHT);
		this.label.getLabel().setPadding(new Insets(5, 20, 5, 0));
		this.btn.getBtn().setTextFill(Color.valueOf(getCream()));

		this.tf.getTextField().setAlignment(Pos.CENTER);
	}
	
	public void configTotal(GridPane grid, int prefHeight) {
		grid.setStyle(getBg() + getMidGreen());
		grid.setPrefSize(prefHeight, 46);
		grid.add(this.label.getLabel(), 0, 0);
		grid.add(this.btn.getBtn(), 1, 0);
		grid.add(this.tf.getTextField(), 2, 0);

		GridPane.setMargin(this.btn.getBtn(), new Insets(3, 10, 3, 10));
	};
	
	public void calcTotal() {
		//
	}
	
	public void addEvent(MonthlyBudget monthlyBudget, TextField totalTF) {
		try {
			this.btn.getBtn().setOnAction(e -> new EventCalcTotal().getHandle(monthlyBudget, totalTF));

		} catch (Exception e) {
			System.out.println("Die Summe aller Einträge konnte nicht berechnet werden.");
		}
	}
}
