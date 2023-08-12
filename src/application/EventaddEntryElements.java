package application;

import data.Entry;
import data.MonthlyBudget;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EventaddEntryElements {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(EntryElemList elemList, TextField input, int id, GridPane grid, Counter counter, int maxRowNumber,
			String type, MonthlyBudget monthlyBudget, TextField sumTF) {
		addEntryElements(elemList, input, id, grid, counter, maxRowNumber, type, monthlyBudget, sumTF);
	}

	public void addEntryElements(EntryElemList elemList, TextField input, int id, GridPane grid, Counter counter,
			int maxRowNumber, String type, MonthlyBudget monthlyBudget, TextField sumTF) {
		if (input.getText().length() < 1) {
			System.out.println("Kein Text eingegeben");
			MyAlerts.infoAlert(2);
		} else {

			counter.increment();

			if (elemList.getEntryElemList(type).size() < maxRowNumber) {
				
				// GUI-Elements of the new Entry
				EntryElements entryEl = new EntryElements(counter.getCounter(), input.getText());
				elemList.addEntryElemToList(entryEl, counter.getCounter(), input.getText(), type);
				entryEl.addEntryToRow(grid, elemList.getEntryElemList(type), counter.getCounter(), input.getText(), type, id, monthlyBudget, sumTF );
				
				input.clear();
			} else {
				MyAlerts.infoAlert(3);
			}
		}
	}

}
