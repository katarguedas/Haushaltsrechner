package data;

public class Entry {

	private String name;
	private double amount;
	private boolean fixed;

	Entry() {
	}

	public Entry(String name, double amount, boolean fixed) {
		this.name = name;
		this.amount = amount;
		this.fixed = fixed;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isFixed() {
		return this.fixed;
	}

	public void setFixed(boolean isFixed) {
		this.fixed = isFixed;
	}

	@Override
	public String toString() {
		return "Entry [name=" + name + ", amount=" + amount + ", fixed=" + fixed + "]";
	}

}
