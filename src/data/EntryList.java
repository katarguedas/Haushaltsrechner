package data;

import java.util.ArrayList;
import java.util.HashMap;

public class EntryList {

	private ArrayList<Entry> entryList = new ArrayList<Entry>();
	private double sum;

	public void updateSum() {
		this.sum = sum();
	}

	public double sum() {
		double sum = 0.0;
		if (!this.entryList.isEmpty()) {
			for(int i=0; i<this.entryList.size();i++) {
//			for (HashMap.Entry<Integer, Entry> entry : entryList.entrySet()) {
				double value = entryList.get(i).getAmount();
				sum += value;
			}
			return sum;
		} else {
			return 0;
		}
	}

	public ArrayList<Entry> getEntryList() {
		return this.entryList;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public double getSum() {
		return sum;
	}

	public Entry getEntry(int index) {
		
//		for (HashMap.Entry<Integer, Entry> entry : entryList.entrySet()) {
//			if (entry.getKey() == id) {
//				return entry.getValue();
//			}
//		}
		return this.entryList.get(index);
	}

	@Override
	public String toString() {
		return "entryList [entryList=" + entryList + ", sum=" + sum + "]";
	}

}
