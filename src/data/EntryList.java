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
		this.sum = 0.0;
		if (!this.entryList.isEmpty()) {
			for (int i = 0; i < this.entryList.size(); i++) {
//			for (HashMap.Entry<Integer, Entry> entry : entryList.entrySet()) {
				double value = entryList.get(i).getAmount();
				this.sum += value;
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

	public Entry getEntry(int id) {
		if (id <= this.entryList.size()) {
			for (int i = 0; i < this.entryList.size(); i++) {
				if (id == this.entryList.get(i).getId())
					return this.entryList.get(i);
			}
		}
		System.out.println("diese Id gibt es nicht.");
		return null;
	}

	@Override
	public String toString() {
		return "entryList [entryList=" + entryList + ", sum=" + sum + "]";
	}

}
