package singleElements;

import javafx.scene.control.CheckBox;

public class MyCheckBox {

	private CheckBox checkbox = new CheckBox();
	
	MyCheckBox() {
		
	};
	public MyCheckBox(String name) {
		this.checkbox.setText(name);
	};
	public MyCheckBox(String name, String id) {
		this.checkbox.setText(name);
		this.checkbox.setId(id);
		this.checkbox.setSelected(false);
	};
	
	public CheckBox getCheckbox() {
		return this.checkbox;
	}
	
	public boolean isSelected() {
		return this.checkbox.isSelected();
	}

	public void changeState() {
		boolean state = !this.checkbox.isSelected();
		this.checkbox.setSelected(!state);
	}
}
