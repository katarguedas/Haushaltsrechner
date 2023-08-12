package data;

import java.util.HashMap;

public class EntryList {

	private HashMap<Integer, Entry> entryList = new HashMap<>();
	private double sum;

//	public void addItem(int id, Entry item) {
//		this.entryList.put(id, item);
//		this.sum = sum();
//	}

	public void updateSum() {
		this.sum = sum();
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

	public HashMap<Integer, Entry> getEntryList() {
		return entryList;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getSum() {
		return sum;
	}

	public Entry getEntry(int id) {
		for (HashMap.Entry<Integer, Entry> entry : entryList.entrySet()) {

			if (entry.getKey() == id) {
				System.out.println("gefunden" + id + ", " + entry.getKey() + "name: "+ entry.getValue().getName());
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "entryList [entryList=" + entryList + ", sum=" + sum + "]";
	}

}
