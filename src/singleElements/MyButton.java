package singleElements;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

/**
 * own class for a button element. Offers some constructors to specify the element and its design.
 * 
 * @author katharina
 *
 */
public class MyButton {

	private Button btn = new Button();

	// **
	// Constructors
	// **
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

	// **
	// Getters
	// **
	public Button getBtn() {
		return this.btn;
	};

	// **
	public void setBtnLayout(int x, int y) {
		this.btn.setLayoutX(x);
		this.btn.setLayoutY(y);
	}

}
