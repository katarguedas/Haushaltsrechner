package application;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import singleElements.MyButton;

public class FileHandling extends ConfigElements {

	private HBox box = new HBox();
	private ArrayList<MyButton> btnList = new ArrayList<MyButton>();
	private String[] btnName = { "Daten löschen", "Daten laden", "Daten speichern" };
	private String[] btnId = { "delete", "load", "save" };
	private int[] btnPrefWidth = { 140, 140, 140 };
	private int[] btnPrefHeight = { 30, 30, 30 };
	private int[] btnLayoutX = { 350, 450, 550 };
	private int[] btnLayoutY = { 30, 30, 30 };
	private String bg = "-fx-background-color: ";

	FileHandling() {
		for (int i = 0; i < btnName.length; i++) {
			this.btnList.add(new MyButton(btnName[i], btnId[i], btnPrefWidth[i], btnPrefHeight[i], bg + getMidGreen(),
					getfontStyle(1), getfontSize(2)));

		}
		for (MyButton button : btnList) {
			int i = btnList.indexOf(button);
			setLayout(button.getBtn(), btnLayoutX[i], btnLayoutY[i]);
		}
		for (MyButton button : btnList) {
			this.box.getChildren().add(button.getBtn());
		}
	}

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
