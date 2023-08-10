package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EventaddAmount {
	
	ActionEvent event = new ActionEvent();


	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(ActionEvent event, ArrayList<EntryElements> elemList, GridPane grid, int id, String type) {
		onEnterAddAmount(event, grid, id, type, elemList);
	}

	void onEnterAddAmount(ActionEvent event, GridPane grid, int id, String type, ArrayList<EntryElements> elemList) {
		//
		int hashcode = event.getSource().hashCode();

		if (type.equals("in")) {
			addAmount(event, elemList);
		}
	}

	void addAmount(ActionEvent event, ArrayList<EntryElements> elemList) {
		int hashcode = event.getSource().hashCode();
		int index = Helper.findIndex(elemList, hashcode, "amountTF");

		if (index != 999) {
//			System.out.println(elemList.get(index).amountTF.getTextField().getText());

			String inputText = elemList.get(index).amountTF.getTextField().getText();

			if (!inputText.isEmpty()) {
				try {
					double value = Double.parseDouble(inputText);
					int id = elemList.get(index).id;

//						itemgroup.getItemGroup().get(id).setAmount(value);
//						itemgroup.updateTotal();
//						groupTotal.setText(Double.toString(itemgroup.getTotal()));
//						input.getInputElement(index).amountTF.setAlignment(Pos.CENTER_RIGHT);
				} catch (NumberFormatException e) {
					System.out.println("Es uwrde keine Zahl eingegeben.");
					MyAlerts.errorAlert(2);
				}
			}

		}
	}

	

}
