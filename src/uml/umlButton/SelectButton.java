package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uml.umlAction.umlFactory.ModeManager.CurrentMode;

public class SelectButton extends MyButton{

	public SelectButton(String buttonName) {
		super(buttonName);
		this.buttonType = CurrentMode.SELECT;
	}
}
