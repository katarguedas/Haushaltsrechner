package application;

import java.util.ArrayList;

public class EntryElemList {

	ArrayList<EntryElements> InElemList = new ArrayList<EntryElements>();
	ArrayList<EntryElements> ExpElemList = new ArrayList<EntryElements>();

	EntryElemList() {

	}

	public void addEntryToList(EntryElements elements, int counter, String input, String type) {

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

}
