package application;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class TabElements extends ConfigElements {

	int id;
	private Tab tab = new Tab();
	private AnchorPane anchor = new AnchorPane();
	private ScrollPane scroll = new ScrollPane();
	private VBox gridVbox = new VBox();
	private String[] gridName = { "income", "expense", "total" };
	private String[] mainLabels = { "EINNAHMEN", "AUSGABEN", "GESAMT" };
	private ArrayList<MyLabel> labelList = new ArrayList<MyLabel>();
	private ArrayList<GridPane> gridList = new ArrayList<GridPane>();
	private MyButton delBtn = new MyButton("alle Daten für diesem Monat löschen");
	private String bg = "-fx-background-color: ";
	private int scrollLayoutX = 20;
	private int scrollLayoutY = 50;
	private int vboxLayoutX = 25;
	private int vboxLayoutY = 65;
	private int scrollPrefWidth = 665;
	private int scrollPrefHeight = 650;
	private int vboxMaxHeight = 1000;
	private int vboxMinHeight = 700;
	private int vboxPrefWidth = 700;
	private int delBtnLayoutX = 30;
	private int delBtnLayoutY = 15;
	private String[] gridLabels = { "", "Bezeichnung", "Betrag", "Fixkosten" };
	private int gridRowNumber = 4;
	private int labelMaxW[] = { 280, 480, 160, 200 };
	private int labelMinW[] = { 40, 300, 80, 60 };
	private int labelPrefW[] = { 50, 390, 120, 90 };
	private int labelPrefH[] = { 30, 30, 30, 30 };
	private int labelMaxH[] = { 40, 40, 40, 40 };
	private int totalMaxW[] = { 280, 280, 150, 200 };
	private int totalMinW[] = { 10, 80, 30, 20 };
	private int totalPrefW[] = { 250, 200, 140, 90 };
//	private int totalPrefH[] = { 30, 30, 30, 30 };
	private String[] type = { "in", "exp" };
	private int counterIn = 0;
	private int counterExp = 0;

	TabElements(int id, String month) {
		this.id = id;
		this.tab.setText(month);
		this.tab.setClosable(false);
		this.tab.setContent(this.anchor);
		this.anchor.getChildren().add(this.scroll);
		this.scroll.setContent(this.gridVbox);
		this.anchor.getChildren().add(this.delBtn.getBtn());
		this.delBtn.setBtnLayout(delBtnLayoutX, delBtnLayoutY);

		for (int i = 0; i < gridName.length; i++) {
			this.labelList.add(new MyLabel(mainLabels[i], "", scrollPrefWidth, 20, bg + getDarkBlue(), getfontStyle(1),
					getfontSize(2)));
			this.gridList.add(new GridPane());
			this.gridVbox.getChildren().add(labelList.get(i).getLabel());
			this.gridVbox.getChildren().add(gridList.get(i));
		}

		configScroll();
		configLabel();
		configVbox();
		configGridTypeA(gridList.get(0), mainLabels, type[0]);
		configGridTypeA(gridList.get(1), mainLabels, type[1]);
		configGridTypeB(gridList.get(2));
	}

	public Tab getTab() {
		return this.tab;
	}

	private void configScroll() {
		setLayout(this.scroll, scrollLayoutX, scrollLayoutY);
		setDimensions(this.scroll, null, null, scrollPrefWidth, scrollPrefHeight, null, null);
		scroll.setStyle("-fx-background-color: #D9EEF0;");
	}

	private void configVbox() {
		setDimensions(gridVbox, null, vboxMinHeight, vboxPrefWidth, null, null, vboxMaxHeight);
		setLayout(gridVbox, vboxLayoutX, vboxLayoutY);
		gridVbox.setPrefHeight(650);
		gridVbox.setPrefWidth(scrollPrefHeight);
		gridVbox.setStyle(bg + getlightGreen());
	}

	private void configLabel() {
		int i = 0;
		for (MyLabel label : labelList) {
			label.getLabel().setTextFill(Color.valueOf(getCream()));
			label.getLabel().setPadding(new Insets(4, 10, 4, 10));
			i++;
		}
	}

	private void configGridTypeA(GridPane grid, String[] labels, String type) {

		grid.setPrefWidth(660);

		Image image = new Image("File:tacho.png");
		ImageView imgDelView = new ImageView(image);

		imgDelView.setX(5);
		imgDelView.setY(5);

		imgDelView.setFitHeight(20);
		imgDelView.setFitWidth(20);

		grid.add(imgDelView, 0, 0);

		for (int i = 0; i < gridLabels.length; i++) {
			MyLabel label = new MyLabel(gridLabels[i], "", labelPrefW[i], labelPrefH[i], bg + getMidGreen(),
					getfontStyle(1), getfontSize(2));

			label.getLabel().setMinSize(labelMinW[i], labelPrefH[i]);
			label.getLabel().setMaxSize(labelMaxW[i], labelMaxH[i]);

			grid.add(label.getLabel(), i, 0);

			ColumnConstraints colConstraints = new ColumnConstraints();
			grid.getColumnConstraints().add(colConstraints);
			setColConstraints(colConstraints, labelMinW[i], labelPrefW[i], labelMaxW[i]);
			label.getLabel().setAlignment(Pos.CENTER);

		}
		for (int i = 0; i < gridRowNumber; i++) {
			RowConstraints rowConstraints = new RowConstraints();
			grid.getRowConstraints().add(rowConstraints);
			setRowConstraints(rowConstraints, null, labelPrefH[i], null);
		}

		if (type.equals("in")) {
			setEntryItem(this.type[1], grid, "Betrag eingeben", "hinzufügen");
			setSum(this.type[1], grid, "Summe Einnahmen: ");
		}
		if (type.equals("exp")) {
			setEntryItem(this.type[1], grid, "Betrag eingeben", "hinzufügen");
			setSum(this.type[0], grid, "Summe Ausgaben: ");
		}

	}

	private void configGridTypeB(GridPane grid) {
		for (int i = 0; i < totalPrefW.length; i++) {
			ColumnConstraints colConstraints = new ColumnConstraints();
			setColConstraints(colConstraints, totalMinW[i], totalPrefW[i], totalMaxW[i]);
		}
		grid.setStyle(bg + getMidGreen());
		grid.setPrefSize(scrollPrefHeight, 40);
		setTotal("total" + id, grid, "Gesamt: ", "berechne");
	}

	private void setEntryItem(String type, GridPane grid, String text, String btnName) {
		String elementId = type + this.id;
		MyTextField input = new MyTextField(elementId, text, 120, 28);
		MyButton addBtn = new MyButton(btnName, "addBtn" + id, 100, 26, bg + getDarkBlue(), getfontStyle(1),
				getfontSize(0));

		addBtn.getBtn().setTextFill(Color.valueOf(getCream()));
		addBtn.getBtn().setAlignment(Pos.CENTER);

		Events events = new Events();
		events.getEventAddEntry();
		addBtn.getBtn().setOnAction(e -> events.getHandle(input.getTextField(), this.id, grid, getCounter(type), type));
		grid.add(input.getTextField(), 1, 1);
		grid.add(addBtn.getBtn(), 2, 1);

		GridPane.setMargin(input.getTextField(), new Insets(3, 2, 3, 2));
	}

	private void setSum(String type, GridPane grid, String text) {
		String elementId = type + this.id;
		MyLabel label = new MyLabel(text, elementId, 180, 30, bg + getlightGreen(), getfontStyle(1), getfontSize(2));
		MyTextField tf = new MyTextField();

		tf.getTextField().setAlignment(Pos.CENTER_RIGHT);
		grid.add(label.getLabel(), 1, 4);
		grid.add(tf.getTextField(), 2, 4);

		GridPane.setMargin(tf.getTextField(), new Insets(3, 0, 3, 0));
	}

	private void setTotal(String id, GridPane grid, String text, String btnText) {

		MyLabel label = new MyLabel(text, "", 200, 30, "", getfontStyle(1), getfontSize(2));
		MyButton btn = new MyButton(btnText, id, 100, 28, bg + getDarkBlue() + ";-fx-border-radius: 5", getfontStyle(1),
				getfontSize(1));
		MyTextField tf = new MyTextField("", "", 130, 30);

		label.getLabel().setAlignment(Pos.CENTER);
		btn.getBtn().setTextFill(Color.valueOf(getCream()));

		tf.getTextField().setAlignment(Pos.BASELINE_RIGHT);

		grid.add(label.getLabel(), 0, 0);
		grid.add(btn.getBtn(), 1, 0);
		grid.add(tf.getTextField(), 2, 0);

		GridPane.setMargin(btn.getBtn(), new Insets(3, 2, 3, 2));
	}

	public int getCounter(String type) {
		int counter = 0;
		if (type.equals("in"))
			return this.counterIn;
		else if (type.equals("exp"))
			return this.counterExp;
		else
			return counter;
	}
}
