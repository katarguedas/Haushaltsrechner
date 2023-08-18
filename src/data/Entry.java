package data;

public class Entry {

	private int id;
	private String name;
	private double amount;
	private boolean fixed;

	public Entry() {
	}

	public Entry(int id, String name, double amount, boolean fixed) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.fixed = fixed;
	}

	public void setId(int id) {
		 this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return this.amount;
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
		return "Entry [id=" + id + ", name=" + name + ", amount=" + amount + ", fixed=" + fixed + "]";
	}

}
