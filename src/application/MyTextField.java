package application;


import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class MyTextField {
	
	TextField tf = new TextField();

	MyTextField() {

	}

	MyTextField(String id) {
		this.tf.setId(id);
	}
	
	MyTextField(String id, String prompText) {
		this.tf.setId(id);
		this.tf.setPromptText(prompText);
	}

	MyTextField(String id, String prompText, int wPref, int hPref) {
		this.tf.setId(id);
		this.tf.setPromptText(prompText);
		this.tf.setPrefSize(wPref, hPref);
	}

	MyTextField(String id,  String prompText, int wPref, int hPref, String fontStyle, int fontSize) {
		this.tf.setId(id);
		this.tf.setPromptText(prompText);
		this.tf.setPrefSize(wPref, hPref);
		this.tf.setFont(new Font(fontStyle, fontSize));
	}

	public TextField getTextField() {
		return this.tf;
	}

	public void setLayout(int x, int y) {
		this.tf.setLayoutX(x);
		this.tf.setLayoutY(y);
	}

}
