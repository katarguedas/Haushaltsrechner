package data;

import java.util.ArrayList;

/**
 * Contains an ArrayList of Entries @see class Entry and their sum.
 * 
 * @author katharina
 *
 */

public class EntryList {

	private ArrayList<Entry> entryList = new ArrayList<Entry>();
	private double sum;

	// **
	// Getters
	// **
	public double getSum() {
		return sum;
	}

	public Entry getEntry(int id) {
		try {
			for (int i = 0; i < this.entryList.size(); i++) {
				if (id == this.entryList.get(i).getId())
					return this.entryList.get(i);
			}
		} catch (Exception e) {
			System.out.println("diese Id gibt es nicht.");
			
		}
		return null;
	}

	public ArrayList<Entry> getEntryList() {
		return this.entryList;
	}

	// **
	// Getters
	// **
	public void setSum(double sum) {
		this.sum = sum;
	}

	public void updateSum() {
		this.sum = sum();
	}

	// **
	// This method calculates the sum of all Entries in the arraylist.
	// **
	public double sum() {
		this.sum = 0.0;
		if (!this.entryList.isEmpty()) {
			for (int i = 0; i < this.entryList.size(); i++) {
				double value = entryList.get(i).getAmount();
				this.sum += value;
			}
			return sum;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "entryList [entryList=" + entryList + ", sum=" + sum + "]";
	}
}
