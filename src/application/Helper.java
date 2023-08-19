package application;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/**
 * Contains some methods which helps to find data and information
 * 
 * @author katharina
 *
 */
public class Helper {

//	https://stackoverflow.com/questions/20655024/javafx-gridpane-retrieve-specific-cell-content
	static public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		ObservableList<Node> children = gridPane.getChildren();
		for (Node node : children) {
			
			Integer columnIndex = GridPane.getColumnIndex(node);
			Integer rowIndex = GridPane.getRowIndex(node);

			if (columnIndex == null)
				columnIndex = 0;
			if (rowIndex == null)
				rowIndex = 0;

			if (columnIndex == col && rowIndex == row) {
				return node;
			}
		}
		return null;
	}

	/**
	 * Looks for a Node with an specific id within a GridPane.
	 * 
	 * @param grid
	 * @param id
	 * 
	 * @return int[] - Position of the Node within the GridPane.
	 *                 pos[0] - Column
	 *                 pos[1] - Row
	 */
	static public int[] getNodePosFromGridPane(GridPane grid, String id) {
		ObservableList<Node> children = grid.getChildren();
		int[] pos = { 0, 0 };
		int flag = 0;
		for (Node node : children) {
			
			Integer columnIndex = GridPane.getColumnIndex(node);
			Integer rowIndex = GridPane.getRowIndex(node);

			if ((node.getId() != null) && (node.getId().equals(id))) {
				pos[0] = columnIndex;
				pos[1] = rowIndex;
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			return pos;
		else
			return null;
	}
	
	/**
	 * Looks for a Node with an specific id within a GridPane.
	 * 
	 * @param grid
	 * @param text
	 * 
	 * @return int row - Number of the row which contains the searched Node.
	 */
	static public int getNodeRow(GridPane grid, String text) {
		int row = 0;
		if (getNodePosFromGridPane(grid, text) != null) {
			row = getNodePosFromGridPane(grid, text)[1];
		} else {
			System.out.println("NIX gefunden mit " + text);
			row=0;
		}
		return row;
	}
	
	/**
	 * Go through the rows and find the first empty row from the top.
	 * 
	 * @param rowNumber
	 * @param firstRow
	 * @param grid
	 * 
	 * @return emptyRow - number of the searched row.
	 */
	static public int findfirstEmptyRow(int rowNumber,int firstRow, GridPane grid) {
		int emptyRow = 999;

		for (int i = firstRow; i < rowNumber; i++) {
			// finde die letzte freie Zeile von unten zählend
			if (Helper.getNodeFromGridPane(grid, 1, i) == null) {
				emptyRow = i;
				break;
			}
		}
		return emptyRow;
	}
	/**
	 * Go through the rows and find the first empty row from the bottom.
	 * 
	 * @param rowNumber
	 * @param firstRow
	 * @param grid
	 * 
	 * @return emptyRow - number of the searched row.
	 */
	static public int findLastEmptyRow(int rowNumber,int firstRow, GridPane grid) {
		int emptyRow = 999;
		
		for (int i = rowNumber; i >firstRow; i--) {
			// finde die erste freie Zeile von oben zählend
			if (Helper.getNodeFromGridPane(grid, 1, i) == null) {
				emptyRow = i;
				break;
			}
		}
		return emptyRow;
	}
	
	/**
	 * Looks for an element with a specific hashcode.
	 * 
	 * @param elemList
	 * @param hashcode
	 * @param property
	 * 
	 * @return index - Index of the searched element within the given ArrayList.
	 */
	static public int findIndex(ArrayList<EntryElements> elemList, int hashcode, String property) {

		int index = 999;
		try {
			for (int i = 0; i < elemList.size(); i++) {
				switch (property) {
				case "amountTF":
					if (elemList.get(i).amountTF.getTextField().hashCode() == hashcode) {
						index = i;
						break;
					}
					break;
				case "btn":
					if (elemList.get(i).btn.getBtn().hashCode() == hashcode) {
						index = i;
						break;
					}
					break;
				case "checkbox":
					if (elemList.get(i).checkbox.getCheckbox().hashCode() == hashcode) {
						index = i;
						break;
					}
					break;
				default:
					System.out.println("Invalid property name.");
					return 999;
				}
			}
			return index;
		} finally {

		}
	}

}
