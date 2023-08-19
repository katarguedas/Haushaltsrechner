package events;

import java.util.ArrayList;

import application.Counter;
import application.EntryElements;
import application.Helper;
import data.MonthlyBudget;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EventDeleteEntry {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(ActionEvent event, int id, String type, GridPane grid, ArrayList<EntryElements> elemList,
			Counter counter, TextField sumTF, MonthlyBudget monthlyBudget) {
		deleteEntry(event, id, type, grid, elemList, counter, sumTF, monthlyBudget);
	}

	void deleteEntry(ActionEvent event, int id, String type, GridPane grid, ArrayList<EntryElements> elemList,
			Counter counter, TextField sumTF, MonthlyBudget monthlyBudget) {

		int hashcode = event.getSource().hashCode();

		int index = Helper.findIndex(elemList, hashcode, "btn");

		grid.getChildren().removeAll((elemList.get(index).amountTF.getTextField()));
		grid.getChildren().removeAll((elemList.get(index).btn.getBtn()));
		grid.getChildren().removeAll((elemList.get(index).checkbox.getCheckbox()));
		grid.getChildren().removeAll((elemList.get(index).label.getLabel()));

		elemList.remove(index);
//		counter.decrement();
		
		if (type.equals("in")) {
			monthlyBudget.getIncome().getEntryList().remove(index);
			sumTF.setText(Double.toString(monthlyBudget.getIncome().sum()));
		}
		if (type.equals("exp")) {
			monthlyBudget.getExpense().getEntryList().remove(index);
			sumTF.setText(Double.toString(monthlyBudget.getExpense().sum()));
		}

	}

}
