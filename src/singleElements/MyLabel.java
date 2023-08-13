package singleElements;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class MyLabel {

	private Label label = new Label();

	MyLabel() {

	}

	public MyLabel(String text) {
		this.label.setText(text);
	}

	public MyLabel(String text, String id) {
		this.label.setText(text);
		this.label.setId(id);
	}

	public MyLabel(String text, String id, int wPref, int hPref) {
		this.label.setText(text);
		this.label.setId(id);
		this.label.setPrefSize(wPref, hPref);
	}

	public MyLabel(String text, String id, int wPref, int hPref, String bg) {
		this.label.setText(text);
		this.label.setId(id);
		this.label.setPrefSize(wPref, hPref);
		this.label.setStyle(bg);
	}

	public MyLabel(String text, String id, int wPref, int hPref, String bg, String fontStyle, int fontSize) {
		this.label.setText(text);
		this.label.setId(id);
		this.label.setPrefSize(wPref, hPref);
		this.label.setStyle(bg);
		this.label.setFont(new Font(fontStyle, fontSize));
	}

	public Label getLabel() {
		return this.label;
	}

	public void setLayout( int x, int y) {
		this.label.setLayoutX(x);
		this.label.setLayoutY(y);
	}
	public void setLabelFont( String style, int size) {
		this.label.setFont(new Font(style, size));
	}
}
