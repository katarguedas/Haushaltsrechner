package application;

import java.util.ArrayList;

import data.AnnualBudget;
import data.MonthOfYear;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

public class GUI {

	private Pane root = new Pane();
	private TabPane tabpane = new TabPane();
	private ArrayList<TabElements> tablist = new ArrayList<>();
	private FileHandling fileHandling = new FileHandling();

	private AnnualBudget annualBudget = new AnnualBudget();

	GUI() {
		this.root.getChildren().add(this.tabpane);
		this.root.getChildren().add(fileHandling.getBox());
		
		this.fileHandling.getBtn("delete").setOnAction(e->new EventDeleteAllData().getHandle(tablist));
		this.fileHandling.getBtn("load").setOnAction(e->new EventLoadData().getHandle(annualBudget, tablist));
		this.fileHandling.getBtn("save").setOnAction(e->new EventSaveAllData().getHandle(annualBudget));

		for (MonthOfYear month : MonthOfYear.values()) {
			int id = month.getValue();
			this.tablist.add(new TabElements(id, month.toString(), annualBudget.getMonthlyBudget(id)));
			this.tabpane.getTabs().add(tablist.get(id - 1).getTab());

			setTabPane();
		}
	}

	private void setTabPane() {
		this.tabpane.setPrefHeight(740);
		this.tabpane.setPrefWidth(700);
		this.tabpane.setLayoutX(15);
		this.tabpane.setLayoutY(70);
	}

	public Pane getRoot() {
		return this.root;
	}

}
