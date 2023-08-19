package singleElements;

import javafx.scene.control.TextField;
import javafx.scene.text.Font;

/**
 * own class for a TextField element. Offers some constructors to specify the
 * element and its design.
 * 
 * @author katharina
 *
 */
public class MyTextField {

	TextField tf = new TextField();

	// **
	// Constructors
	// **
	MyTextField() {

	}

	public MyTextField(String id) {
		this.tf.setId(id);
	}

	public MyTextField(String id, String prompText) {
		this.tf.setId(id);
		this.tf.setPromptText(prompText);
	}

	public MyTextField(String id, String prompText, int wPref, int hPref) {
		this.tf.setId(id);
		this.tf.setPromptText(prompText);
		this.tf.setPrefSize(wPref, hPref);
	}

	public MyTextField(String id, String prompText, int wPref, int hPref, String fontStyle, int fontSize) {
		this.tf.setId(id);
		this.tf.setPromptText(prompText);
		this.tf.setPrefSize(wPref, hPref);
		this.tf.setFont(new Font(fontStyle, fontSize));
	}

	// **
	// Getters
	// **
	public TextField getTextField() {
		return this.tf;
	}

	// **
	public void setLayout(int x, int y) {
		this.tf.setLayoutX(x);
		this.tf.setLayoutY(y);
	}

}
