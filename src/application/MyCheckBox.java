package application;

import javafx.scene.control.CheckBox;

public class MyCheckBox {

	private CheckBox checkbox = new CheckBox();
	
	MyCheckBox() {
		
	};
	MyCheckBox(String name) {
		this.checkbox.setText(name);
	};
	MyCheckBox(String name, String id) {
		this.checkbox.setText(name);
		this.checkbox.setId(id);
	};
	
	public CheckBox getCheckbox() {
		return this.checkbox;
	}
}
