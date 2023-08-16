package application;

import java.util.ArrayList;

import data.MonthOfYear;
import javafx.event.ActionEvent;


public class EventDeleteAllData {
	ActionEvent event = new ActionEvent();

	public ActionEvent getEvent() {
		return this.event;
	}

	public void getHandle(ArrayList<TabElements> tablist) {
		deleteAllData(tablist);
	}

	void deleteAllData(ArrayList<TabElements> tablist) {

		for (MonthOfYear month : MonthOfYear.values()) {
			int id = month.getValue();
			EventDelMData event = new EventDelMData();
			event.deleteData(tablist.get(id - 1).getEntryElemList(), id, tablist.get(id - 1).getGridlist(),
					tablist.get(id - 1).getMonthlyBudget());
		}

	}

}
