package events;


import application.JSON_IO;
import data.AnnualBudget;
import javafx.event.ActionEvent;


public class EventSaveAllData extends JSON_IO {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(AnnualBudget annualBudget) {

		exportJSON(annualBudget);
	}

}
