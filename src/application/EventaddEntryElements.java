package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EventaddEntryElements {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(EntryElemList elemList, TextField input, int id, GridPane grid, int counter, int counterMax,
			String type) {
		addEntryElements(elemList, input, id, grid, counter, counterMax, type);
	}

	public void addEntryElements(EntryElemList elemList, TextField input, int id, GridPane grid, int counter,
			int counterMax, String type) {

		if (input.getText().length() < 1) {
			System.out.println("Kein Text eingegeben");
			MyAlerts.infoAlert(2);
		} else {

			counter += 1;
			if (counter < counterMax) {
				EntryElements entryEl = new EntryElements(counter, input.getText());
				elemList.addEntryToList(entryEl, counter, input.getText(), type);
				entryEl.addEntryToRow(grid, elemList.getEntryElemList(type), counter, input.getText(), type, id);

				input.clear();
			} else {
				MyAlerts.infoAlert(3);
			}
		}
		int hashcode = elemList.getEntryElemList(type).get(0).amountTF.getTextField().hashCode();
		System.out.println("tf hashcode: " + hashcode);
	}

}
