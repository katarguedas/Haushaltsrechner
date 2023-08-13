package application;

import java.time.Month;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import data.EntryList;
import data.MonthlyBudget;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EventDelMData {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(EntryElemList entryElemList,int id, ArrayList<GridPane> gridList, MonthlyBudget monthlyBudget) {
		deleteData(entryElemList,id, gridList, monthlyBudget);
	}

	public void deleteData(EntryElemList entryElemList,int id, ArrayList<GridPane> gridList,
			MonthlyBudget monthlyBudget) {
		

		deleteElements(gridList.get(0), entryElemList.getEntryElemList("in"));
		deleteElements(gridList.get(1), entryElemList.getEntryElemList("exp"));

		deleteEntries(gridList.get(0), entryElemList, "in", "insum"+id, monthlyBudget);
		deleteEntries(gridList.get(1), entryElemList, "exp", "expsum"+id, monthlyBudget);
		
		int pos[] = Helper.getNodePosFromGridPane(gridList.get(2), "tftotal"+id);
		TextField tf = (TextField) Helper.getNodeFromGridPane(gridList.get(2), pos[0], pos[1]);
		tf.setText("0");
	}

	private void deleteElements(GridPane grid, ArrayList<EntryElements> elemList) {

		int rowNumber = grid.getRowCount();

		for (int row = 2; row < rowNumber; row++) {
			if (Helper.getNodeFromGridPane(grid, 0, row) != null) {

				int hashcode = Helper.getNodeFromGridPane(grid, 0, row).hashCode();
				int index = Helper.findIndex(elemList, hashcode, "btn");

				grid.getChildren().removeAll((elemList.get(index).amountTF.getTextField()));
				grid.getChildren().removeAll((elemList.get(index).btn.getBtn()));
				grid.getChildren().removeAll((elemList.get(index).checkbox.getCheckbox()));
				grid.getChildren().removeAll((elemList.get(index).label.getLabel()));
			}
		}
	}

	private void deleteEntries(GridPane grid, EntryElemList entryElemList, String type, String id,
			MonthlyBudget monthlyBudget) {
		entryElemList.getEntryElemList(type).clear();

		if (type.equals("in")) {
			monthlyBudget.getIncome().getEntryList().clear();
			monthlyBudget.getIncome().setSum(0);
		}
		if (type.equals("exp")) {
			monthlyBudget.getExpense().getEntryList().clear();
			monthlyBudget.getExpense().setSum(0);
		}
		monthlyBudget.calcTotal();
		
		int pos[] = Helper.getNodePosFromGridPane(grid, id);
		TextField tf = (TextField) Helper.getNodeFromGridPane(grid, pos[0], pos[1]);
		tf.setText("0");
	}

}
