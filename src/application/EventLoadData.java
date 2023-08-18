package application;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONObject;

import data.AnnualBudget;
import data.EntryList;
import data.MonthOfYear;
import data.MonthlyBudget;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class EventLoadData extends JSON_IO {

	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(AnnualBudget annualBudget, ArrayList<TabElements> tablist) {

		if (dataExists(annualBudget)) {
			System.out.println("Es gibt bereits Daten");
			MyAlerts.infoAlert(1);
		} else {
			importJSON(annualBudget);
			setValuesFromImport(annualBudget, tablist);
		}
	}

	public boolean dataExists(AnnualBudget annualBudget) {
		for (MonthOfYear month : MonthOfYear.values()) {
			int id = month.getValue();
			
			if ((!annualBudget.getMonthlyBudget(id).getIncome().getEntryList().isEmpty())
					|| (!annualBudget.getMonthlyBudget(id).getExpense().getEntryList().isEmpty()))
				return true;
		}
		return false;
	}

	private void setValuesFromImport(AnnualBudget annualBudget, ArrayList<TabElements> tablist) {

		for (MonthOfYear month : MonthOfYear.values()) {
			int id = month.getValue();

			int pos[] = Helper.getNodePosFromGridPane(tablist.get(id - 1).getGridlist().get(2), "tftotal"+id);
			TextField tftotal = (TextField) Helper.getNodeFromGridPane(tablist.get(id - 1).getGridlist().get(2), pos[0],
					pos[1]);
			tftotal.setText(Double.toString(annualBudget.getMonthlyBudget(id).getTotal()));

			setGridAElements(tablist.get(id - 1).getGridlist().get(0), id, tablist.get(id - 1).getCounter("in"), "in",
					tablist.get(id - 1).getEntryElemList(), annualBudget.getMonthlyBudget(id).getIncome(),
					annualBudget.getMonthlyBudget(id));
			setGridAElements(tablist.get(id - 1).getGridlist().get(1), id, tablist.get(id - 1).getCounter("exp"), "exp",
					tablist.get(id - 1).getEntryElemList(), annualBudget.getMonthlyBudget(id).getExpense(),
					annualBudget.getMonthlyBudget(id));
		}
	}

	private void setGridAElements(GridPane grid, int id, Counter counter, String type, EntryElemList elemList,
			EntryList entryList, MonthlyBudget monthlyBudget) {

		int length = entryList.getEntryList().size();
		if (length > 0) {
			for (int i = 1; i <= length; i++) {

				// Text des Eintrags
				int entryId = entryList.getEntry(i).getId();
				String input = entryList.getEntry(i).getName();
				Double amount = entryList.getEntry(i).getAmount();
				boolean state = entryList.getEntry(i).isFixed();

				// Summe der Einträge
				int pos1[] = Helper.getNodePosFromGridPane(grid, type + "sum" + id);
				TextField sum = (TextField) Helper.getNodeFromGridPane(grid, pos1[0], pos1[1]);
				sum.setText(Double.toString(entryList.getSum()));

				EventaddEntryElements.addEntryElements(elemList, new TextField(input), id, grid, counter, 13, type,
						monthlyBudget, sum, true);

				setAmount(grid, "amount" + counter.getCounter(), amount);
				setBox(grid, "isFix" + counter.getCounter(), state);
			}
		}
	}

	private void setAmount(GridPane grid, String id, Double amount) {

		int posA[] = Helper.getNodePosFromGridPane(grid, id);
		TextField amountTF = (TextField) Helper.getNodeFromGridPane(grid, posA[0], posA[1]);
		amountTF.setText(Double.toString(amount));
	}

	private void setBox(GridPane grid, String id, boolean state) {
		int pos[] = Helper.getNodePosFromGridPane(grid, id);
		CheckBox checkbox = (CheckBox) Helper.getNodeFromGridPane(grid, pos[0], pos[1]);
		checkbox.setSelected(state);
	}
}
