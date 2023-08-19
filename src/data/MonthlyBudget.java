package data;

/**
 * Contains all entered data for one month. Income entries and expense entries
 * in separated ArrayLists. Contains also the sum (total) of all entries.
 * 
 * @author katharina
 *
 */
public class MonthlyBudget {

	private EntryList income = new EntryList();
	private EntryList expense = new EntryList();
	private double total;

	// **
	// Getters
	// **
	public EntryList getExpense() {
		return this.expense;
	}

	public EntryList getIncome() {
		return this.income;
	}

	public double getTotal() {
		return this.total;
	}

	// **
	// Setters
	// **
	public void setTotal(double total) {
		this.total = total;
	}

	// **
	// Methods
	// **

	// Calculates the sum of all entries.
	public double calcTotal() {
		return -1 * this.expense.getSum() + this.income.getSum();
	}

	public void addIncome(int id, Entry entry) {
		this.income.getEntryList().add(entry);
		this.total = calcTotal();
	}

	public void removeIncome(int id) {
		this.income.getEntryList().remove(id);
		this.total = calcTotal();
	}

	public void addExpense(int id, Entry entry) {
		this.expense.getEntryList().add(entry);
		this.total = calcTotal();
	}

	public void removeExpense(int id) {
		this.expense.getEntryList().remove(id);
		this.total = calcTotal();
	}

	public String toString() {
		return "MonthlyBudget [income=" + getIncome() + ", expense=" + getExpense() + ", total=" + getTotal() + "]";
	}

}
