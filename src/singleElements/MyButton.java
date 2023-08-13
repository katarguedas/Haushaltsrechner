package singleElements;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class MyButton {

	private Button btn = new Button();

	MyButton() {

	};

	public MyButton(String name) {
		this.btn.setText(name);
	};

	public MyButton(String name, String id) {
		this.btn.setText(name);
		this.btn.setId(id);
	};

	public MyButton(String name, String id, int wPref, int hPref) {
		this.btn.setText(name);
		this.btn.setId(id);
		this.btn.setPrefSize(wPref, hPref);
	};

	public MyButton(String name, String id, int wPref, int hPref, String bg) {
		this.btn.setText(name);
		this.btn.setId(id);
		this.btn.setPrefSize(wPref, hPref);
		this.btn.setStyle(bg);
	}

	public MyButton(String name, String id, int wPref, int hPref, String bg, String fontStyle, int fontSize) {
		this.btn.setText(name);
		this.btn.setId(id);
		this.btn.setPrefSize(wPref, hPref);
		this.btn.setStyle(bg);
		this.btn.setFont(new Font(fontStyle, fontSize));
	}

	public Button getBtn() {
		return this.btn;
	};

	public void setBtnLayout(int x, int y) {
		this.btn.setLayoutX(x);
		this.btn.setLayoutY(y);
	}

}
