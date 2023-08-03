package data;

import java.util.HashMap;

public class AnnualBudget {

	private HashMap<MonthOfYear, MonthlyBudget> yearsBudget = new HashMap<>();

	public AnnualBudget() {

		for (MonthOfYear month : MonthOfYear.values()) {
			this.yearsBudget.put(month, new MonthlyBudget());
		}
	}
}
