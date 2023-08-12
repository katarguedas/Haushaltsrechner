package data;

import java.util.HashMap;

public class AnnualBudget {

	private HashMap<MonthOfYear, MonthlyBudget> annualBudget = new HashMap<>();

	public AnnualBudget() {
		for (MonthOfYear month : MonthOfYear.values()) {
			this.annualBudget.put(month, new MonthlyBudget());
		}
	}

	public MonthlyBudget getMonthlyBudget(int id) {
		for (HashMap.Entry<MonthOfYear, MonthlyBudget> set : annualBudget.entrySet()) {

			if (set.getKey().getValue() == id) {
				System.out.println("gefunden" + id + ", " + set.getKey());
				return set.getValue();
			}
		}
		return null;
	}
}
