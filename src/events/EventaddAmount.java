package events;

import java.util.ArrayList;

import application.EntryElements;
import application.Helper;
import application.MyAlerts;
import data.MonthlyBudget;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EventaddAmount {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(ActionEvent event, ArrayList<EntryElements> elemList, GridPane grid, int id, String type, 
			MonthlyBudget monthlyBudget, TextField sumTF) {
		onEnterAddAmount(event, grid, id, type, elemList, monthlyBudget, sumTF);
	}

	void onEnterAddAmount(ActionEvent event, GridPane grid, int id, String type, ArrayList<EntryElements> elemList,
			MonthlyBudget monthlyBudget, TextField sumTF) {
		//
		int hashcode = event.getSource().hashCode();

		int index = Helper.findIndex(elemList, hashcode, "amountTF");

		if (index != 999) {

			String inputText = elemList.get(index).amountTF.getTextField().getText();
			elemList.get(index).amountTF.getTextField().setAlignment(Pos.CENTER_RIGHT);
			int elemId=elemList.get(index).getId();
			elemList.get(index).checkbox.getCheckbox().requestFocus();

			if (!inputText.isEmpty()) {
				
				try {
					double value = Double.parseDouble(inputText);
					if (type.equals("in")) {
						monthlyBudget.getIncome().getEntry(elemId).setAmount(value);
						sumTF.setText(Double.toString(monthlyBudget.getIncome().sum()));
						sumTF.setAlignment(Pos.CENTER_RIGHT);
						sumTF.setEditable(false);
					}
					if (type.equals("exp")) {
						monthlyBudget.getExpense().getEntry(elemId).setAmount(value);
						sumTF.setText(Double.toString(monthlyBudget.getExpense().sum()));
						sumTF.setAlignment(Pos.CENTER_RIGHT);
						sumTF.setEditable(false);
					}
					monthlyBudget.calcTotal();

				} catch (NumberFormatException e) {
					System.out.println("Es wurde keine Zahl eingegeben.");
					MyAlerts.errorAlert(2);
				}
			}

		}
	}

}
