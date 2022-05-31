package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uml.umlAction.ModeManager;
import uml.umlAction.ModeManager.CurrentMode;

public class ClassButton extends MyButton {

	public ClassButton(String buttonName) {
		super(buttonName);
		this.buttonType = CurrentMode.CLASS;
	}
}
