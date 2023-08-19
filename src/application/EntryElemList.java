package application;

import java.util.ArrayList;

/**
 * Contains the ArrayLists which collect the GUI elements for incomes and
 * expenses.
 * 
 * @author katharina
 *
 */
public class EntryElemList {

	private ArrayList<EntryElements> InElemList = new ArrayList<EntryElements>();
	private ArrayList<EntryElements> ExpElemList = new ArrayList<EntryElements>();

	EntryElemList() {

	}

	// **
	// Getters
	// **
	public ArrayList<EntryElements> getEntryElemList(String type) {
		if (type.equals("in"))
			return InElemList;
		if (type.equals("exp"))
			return ExpElemList;
		else
			return null;
	}

	public EntryElements getEntryElement(int id, String type) {
		if (type.equals("in"))
			return this.InElemList.get(id);
		if (type.equals("exp"))
			return this.ExpElemList.get(id);
		return null;
	}

	// **
	// Methods
	// **

	public void addEntryElemToList(EntryElements elements, int counter, String input, String type) {
		if (type.equals("in"))
			this.InElemList.add(elements);
		if (type.equals("exp"))
			this.ExpElemList.add(elements);
	}

	public void removeElemFromList(int id, String type) {
		if (type.equals("in"))
			this.InElemList.remove(id);
		if (type.equals("exp"))
			this.ExpElemList.remove(id);
	}

}
