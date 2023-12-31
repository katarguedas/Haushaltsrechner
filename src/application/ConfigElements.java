package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

/**
 * This abstract class contains some variables and methods to design the GUI Elements.
 * 
 * @author Katharina
 *
 */
public abstract class ConfigElements {

	private String midGreen = "#92B9B5";
	private String darkBlue = "#465B73";
	private String lightGreen = "#D9EEF0";
	private String cream = "#f4f0dd";
	private String bg = "-fx-background-color: ";
	private String border = "-fx-border-color: ";
	private String fontStyle[] = { "System", "System bold" };
	private int fontSize[] = { 14, 15, 16, 18, 20 };

	// **
	// Getters
	// **
	String getBg() {
		return bg;
	}

	String getBorder() {
		return border;
	}

	String getDarkBlue() {
		return darkBlue;
	}

	String getlightGreen() {
		return lightGreen;
	}

	String getMidGreen() {
		return midGreen;
	}

	String getCream() {
		return cream;
	}

	String getfontStyle(int i) {
		return fontStyle[i];
	}

	int getfontSize(int i) {
		return fontSize[i];
	}


	// **
	// Methods
	// **
	public void setDimensions(ScrollPane scroll, Object wmin, Object hmin, Object wpref, Object hpref, Object wmax,
			Object hmax) {
		if (wmin != null)
			scroll.setMinWidth((int) wmin);
		if (hmin != null)
			scroll.setMinHeight((int) hmin);
		if (wpref != null)
			scroll.setPrefWidth((int) wpref);
		if (hpref != null)
			scroll.setPrefHeight((int) hpref);
		if (wmax != null)
			scroll.setMaxWidth((int) wmax);
		if (hmax != null)
			scroll.setMaxHeight((int) hmax);
	}

	public void setDimensions(VBox box, Object wmin, Object hmin, Object wpref, Object hpref, Object wmax,
			Object hmax) {
		if (wmin != null)
			box.setMinWidth((int) wmin);
		if (hmin != null)
			box.setMinHeight((int) hmin);
		if (wpref != null)
			box.setPrefWidth((int) wpref);
		if (hpref != null)
			box.setPrefHeight((int) hpref);
		if (wmax != null)
			box.setMaxWidth((int) wmax);
		if (hmax != null)
			box.setMaxHeight((int) hmax);
	}

	public void setDimensions(GridPane grid, Object wmin, Object hmin, Object wpref, Object hpref, Object wmax,
			Object hmax) {
		if (wmin != null)
			grid.setMinWidth((int) wmin);
		if (hmin != null)
			grid.setMinHeight((int) hmin);
		if (wpref != null)
			grid.setPrefWidth((int) wpref);
		if (hpref != null)
			grid.setPrefHeight((int) hpref);
		if (wmax != null)
			grid.setMaxWidth((int) wmax);
		if (hmax != null)
			grid.setMaxHeight((int) hmax);
	}

	public void setColConstraints(ColumnConstraints cons, Object wmin, Object wpref, Object wmax) {
		if (wmin != null)
			cons.setMinWidth((int) wmin);
		if (wpref != null)
			cons.setPrefWidth((int) wpref);
		if (wmax != null)
			cons.setMaxWidth((int) wmax);
	}

	public void setRowConstraints(RowConstraints cons, Object hmin, Object hpref, Object hmax) {
		if (hmin != null)
			cons.setMinHeight((int) hmin);
		if (hpref != null)
			cons.setPrefHeight((int) hpref);
		if (hmax != null)
			cons.setMaxHeight((int) hmax);
	}

	public void setLayout(VBox box, int x, int y) {
		box.setLayoutX(x);
		box.setLayoutY(y);
	}

	public void setLayout(ScrollPane scroll, int x, int y) {
		scroll.setLayoutX(x);
		scroll.setLayoutY(y);
	}
}
