package application;

import java.util.ArrayList;

public class EntryElemList {

	ArrayList<EntryElements> InElemList = new ArrayList<EntryElements>();
	ArrayList<EntryElements> ExpElemList = new ArrayList<EntryElements>();
//	private int counterIn = 0;
//	private int counterExp = 0;
//	private int counterMax = 12;

	EntryElemList() {

	}

	public void addEntryElemToList(EntryElements elements, int counter, String input, String type) {

		if (type.equals("in"))
			this.InElemList.add(elements);
		if (type.equals("exp"))
			this.ExpElemList.add(elements);
	}

	public ArrayList<EntryElements> getEntryElemList(String type) {
		if (type.equals("in"))
			return InElemList;
		if (type.equals("exp"))
			return ExpElemList;
		else
			return null;
	}

	public void removeElemFromList(int id, String type) {
		if (type.equals("in"))
			this.InElemList.remove(id);
		if (type.equals("exp"))
			this.ExpElemList.remove(id);
	}
	
	public EntryElements getEntryElement(int id, String type) {
		if (type.equals("in"))
			return this.InElemList.get(id);
		if (type.equals("exp"))
			return this.ExpElemList.get(id);
		return null;
	}

}
