package application;

import java.util.ArrayList;

import data.MonthlyBudget;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import singleElements.MyButton;
import singleElements.MyLabel;

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
	private MyButton delBtn = new MyButton("alle Daten für diesem Monat löschen", "delMData");
	private String bg = "-fx-background-color: ";
	private EntryElemList entryElemList = new EntryElemList();
	private MonthlyBudget monthlyBudget;
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
	private int labelMaxW[] = { 280, 480, 160, 200 };
	private int labelMinW[] = { 40, 300, 80, 60 };
	private int labelPrefW[] = { 50, 390, 120, 90 };
	private int labelPrefH[] = { 30, 30, 30, 30 };
	private int labelMaxH[] = { 40, 40, 40, 40 };
	private int totalMaxW[] = { 280, 280, 150, 200 };
	private int totalMinW[] = { 120, 120, 120, 20 };
	private int totalPrefW[] = { 220, 200, 180, 90 };
	private String[] type = { "in", "exp" };
	private Counter counterIn = new Counter();
	private Counter counterExp = new Counter();
	private int maxRowNumber = 12;
	final static int sumInitRow = 3;

	TabElements(int id, String month, MonthlyBudget monthlyBudget) {
		this.id = id;
		this.tab.setText(month);
		this.tab.setClosable(false);
		this.tab.setContent(this.anchor);
		this.anchor.getChildren().add(this.scroll);
		this.scroll.setContent(this.gridVbox);
		this.anchor.getChildren().add(this.delBtn.getBtn());
		this.delBtn.getBtn().setId("delMData" + this.id);

		for (int i = 0; i < gridName.length; i++) {
			this.labelList.add(new MyLabel(mainLabels[i], "", scrollPrefWidth, 20, bg + getDarkBlue(), getfontStyle(1),
					getfontSize(2)));
			this.gridList.add(new GridPane());
			this.gridVbox.getChildren().add(labelList.get(i).getLabel());
			this.gridVbox.getChildren().add(gridList.get(i));
		}

		this.monthlyBudget = monthlyBudget;

		configScroll();
		configLabel();
		configVbox();
		configDelBtn();
		configGridTypeA(gridList.get(0), mainLabels, type[0]);
		configGridTypeA(gridList.get(1), mainLabels, type[1]);
		configGridTypeB(gridList.get(2));

	}

	public Tab getTab() {
		return this.tab;
	}

	public ArrayList<GridPane> getGridlist() {
		return this.gridList;
	}

	public AnchorPane getAnchorPane() {
		return this.anchor;
	}

	public EntryElemList getEntryElemList() {
		return this.entryElemList;
	}

	public MonthlyBudget getMonthlyBudget() {
		return this.monthlyBudget;
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

	private void configDelBtn() {
		this.delBtn.setBtnLayout(delBtnLayoutX, delBtnLayoutY);
		this.delBtn.getBtn().setOnAction(e -> new EventDelMData().getHandle(this.entryElemList, this.id, this.gridList,
				this.counterIn, this.counterExp, this.monthlyBudget));
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

		if (type.equals("in")) {
			SumItem sumItem = new SumItem(this.type[0] + "sum" + id, "Summe Einnahmen: ");
			sumItem.configSum(sumItem, grid, sumInitRow);

			EntryItem entryItem = new EntryItem(this.type[0], "Bezeichnung eingeben", "hinzufügen", this.id, grid);
			entryItem.addEvents(entryElemList, this.id, grid, this.type[0], getCounter(this.type[0]), this.maxRowNumber,
					monthlyBudget, sumItem.getTf().getTextField());
		}

		if (type.equals("exp")) {
			SumItem sumItem = new SumItem(this.type[1] + "sum" + id, "Summe Ausgaben: ");
			sumItem.configSum(sumItem, grid, sumInitRow);

			EntryItem entryItem = new EntryItem(this.type[1], "Bezeichnung eingeben", "hinzufügen", this.id, grid);
			entryItem.addEvents(entryElemList, this.id, grid, this.type[1], getCounter(this.type[1]), this.maxRowNumber,
					monthlyBudget, sumItem.getTf().getTextField());
		}
	}

	private void configGridTypeB(GridPane grid) {

		for (int i = 0; i < totalPrefW.length; i++) {
			ColumnConstraints colConstraints = new ColumnConstraints();
			setColConstraints(colConstraints, totalMinW[i], totalPrefW[i], totalMaxW[i]);
		}
		ItemTotal itemTotal = new ItemTotal("Gesamt: ", "berechne", "total" + id);
		itemTotal.configTotal(grid, scrollPrefHeight);
		itemTotal.addEvent(monthlyBudget, itemTotal.tf.getTextField());
	}

	public Counter getCounter(String type) {

		if (type.equals("in"))
			return this.counterIn;
		else if (type.equals("exp"))
			return this.counterExp;
		else
			return null;
	}

}
