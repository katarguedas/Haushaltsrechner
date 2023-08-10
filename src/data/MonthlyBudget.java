package data;

public class MonthlyBudget {
	

	private EntryList income = new EntryList();
	private EntryList expense = new EntryList();
	private double total;

	public double calcTotal() {
		System.out.println("gesamte Einnahmen: " + this.income.getTotal());
		System.out.println("gesamte Ausgaben: " + this.expense.getTotal());
		return -1 * this.expense.getTotal() + this.income.getTotal();
	}

	public void setIncome(int id, Entry entry) {
		this.income.addItem(id, entry);
		this.total = calcTotal();
	}

	public void setExpense(int id, Entry entry) {
		this.expense.addItem(id, entry);
		this.total = calcTotal();

	}

	public void setTotal(double total) {
		this.total = total;
	}

	public EntryList getExpense() {
		return expense;
	}

	public EntryList getIncome() {
		return income;
	}

	public double getTotal() {
		return this.total;
	}

	public String toString() {
		return "MonthBudget [revenue=" + income + ", expense=" + expense + ", total=" + total + "]";
	}

}
