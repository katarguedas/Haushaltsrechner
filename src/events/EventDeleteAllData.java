package events;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import application.TabElements;
import data.MonthOfYear;
import javafx.event.ActionEvent;

public class EventDeleteAllData {
	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(ArrayList<TabElements> tablist) {
		int input = JOptionPane.showConfirmDialog(null, "Sollen die Daten aller Monate gelöscht werden?");
		// 0=yes, 1=no, 2=cancel
		System.out.println(input);
		if (input == 0)
			deleteAllData(tablist);
	}

	void deleteAllData(ArrayList<TabElements> tablist) {

		for (MonthOfYear month : MonthOfYear.values()) {
			int id = month.getValue();
			EventDelMData event = new EventDelMData();
			event.deleteData(tablist.get(id - 1).getEntryElemList(), id, tablist.get(id - 1).getGridlist(),
					tablist.get(id - 1).getCounter("in"), tablist.get(id - 1).getCounter("exp"),
					tablist.get(id - 1).getMonthlyBudget());
		}

	}

}
