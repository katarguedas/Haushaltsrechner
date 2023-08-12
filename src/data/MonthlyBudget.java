package data;

public class MonthlyBudget {
	

	private EntryList income = new EntryList();
	private EntryList expense = new EntryList();
	private double total;

	public double calcTotal() {
		return -1 * this.expense.getSum() + this.income.getSum();
	}

	public void addIncome(int id, Entry entry) {
		this.income.getEntryList().put(id, entry);
		this.total = calcTotal();
	}
	
	public void removeIncome(int id) {
		this.income.getEntryList().remove(id);
		this.total = calcTotal();
	}

	public void addExpense(int id, Entry entry) {
		this.expense.getEntryList().put(id, entry);
		this.total = calcTotal();
	}
	
	public void removeExpense(int id) {
		this.expense.getEntryList().remove(id);
		this.total = calcTotal();
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public EntryList getExpense() {
		return this.expense;
	}

	public EntryList getIncome() {
		return this.income;
	}

	public double getTotal() {
		return this.total;
	}

	public String toString() {
		return "MonthBudget [income=" + getIncome() + ", expense=" + getExpense() + ", total=" + getTotal() + "]";
	}

}
