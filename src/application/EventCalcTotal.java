package application;

import data.MonthlyBudget;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;

public class EventCalcTotal {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle( MonthlyBudget monthlyBudget, TextField totalTF) {
		calcTotal( monthlyBudget, totalTF);
	}
	
	public void calcTotal(MonthlyBudget monthlyBudget, TextField totalTF) {
		
		totalTF.setText(Double.toString(monthlyBudget.calcTotal()));
		totalTF.setStyle("-fx-border-color: #000");
		totalTF.setAlignment(Pos.CENTER_RIGHT);
		monthlyBudget.setTotal(monthlyBudget.calcTotal());

	}
}
