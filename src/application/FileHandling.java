package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import singleElements.MyButton;

/**
 * Contains variables and elements to generate the three buttons which can be used to delete, load or save the data into a JSON file.
 * 
 * @author Katharina
 *
 */
public class FileHandling extends ConfigElements {

	private HBox box = new HBox();
	private ArrayList<MyButton> btnList = new ArrayList<MyButton>();
	private String[] btnName = { "Daten löschen", "Daten laden", "Daten speichern" };
	private String[] btnId = { "delete", "load", "save" };
	private String bg = "-fx-background-color: ";
	private int[] btnPrefWidth = { 140, 140, 150 };
	private int[] btnPrefHeight = { 25, 25, 25 };

	// **
	// Constructor
	// **
	FileHandling() {
		for (int i = 0; i < btnName.length; i++) {
			this.btnList.add(new MyButton(btnName[i], btnId[i], btnPrefWidth[i], btnPrefHeight[i], bg + getMidGreen(),
					getfontStyle(1), getfontSize(2)));
			HBox.setMargin(this.btnList.get(i).getBtn(), new Insets(5, 5, 5, 5));
		}
		HBox.setMargin(this.btnList.get(0).getBtn(), new Insets(5, 5, 5, 200));

		for (MyButton button : btnList) {
			this.box.getChildren().add(button.getBtn());
		}
	}

	// **
	// Getters
	// **
	public Button getBtn(String id) {
		switch (id) {
		case "delete":
			return btnList.get(0).getBtn();
		case "load":
			return btnList.get(1).getBtn();
		case "save":
			return btnList.get(2).getBtn();
		}
		return null;
	}

	public HBox getBox() {
		return box;
	}

}
