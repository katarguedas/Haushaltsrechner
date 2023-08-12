package application;

import data.MonthlyBudget;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

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
		monthlyBudget.setTotal(monthlyBudget.calcTotal());

	}
}
