package data;

import java.util.HashMap;

public class EntryList {

	private HashMap<Integer, Entry> entryList = new HashMap<>();
	private double total;

	public void addItem(int id, Entry item) {
		this.entryList.put(id, item);
		this.total = sum();
	}

	public void updateTotal() {
		this.total = sum();
	}

	public double sum() {
		double sum = 0.0;
		if (!this.entryList.isEmpty()) {
			for (HashMap.Entry<Integer, Entry> entry : entryList.entrySet()) {
				double value = entry.getValue().getAmount();
				sum += value;
			}
			return sum;
		} else {
			return 0;
		}
	}

	public HashMap<Integer, Entry> getItemGroup() {
		return entryList;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "ItemGroup [itemGroup=" + entryList + ", total=" + total + "]";
	}
	
}
