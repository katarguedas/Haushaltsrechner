package events;

import java.util.ArrayList;

import application.EntryElements;
import application.Helper;
import data.MonthlyBudget;
import javafx.event.ActionEvent;

public class EventCheckbox {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(ActionEvent event, ArrayList<EntryElements> elemList, String type,
			MonthlyBudget monthlyBudget) {
		switchCheckbox(event, elemList, type, monthlyBudget);
	}

	public void switchCheckbox(ActionEvent event,ArrayList<EntryElements> elemList, String type, MonthlyBudget monthlyBudget) {
		
		int hashcode = event.getSource().hashCode();
		int index = Helper.findIndex(elemList, hashcode, "checkbox");
		
		elemList.get(index).checkbox.changeState();
		int elemId=elemList.get(index).getId();
		
		if(type.equals("in")) {
			boolean check = monthlyBudget.getIncome().getEntry(elemId).isFixed();
			if (check == true)
			monthlyBudget.getIncome().getEntry(elemId).setFixed(false);
			if (check == false)
				monthlyBudget.getIncome().getEntry(elemId).setFixed(true);
		}
	}

}
