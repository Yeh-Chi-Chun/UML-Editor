package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uml.umlAction.umlFactory.ModeManager.CurrentMode;

public class UseCaseButton extends MyButton{

	public UseCaseButton(String buttonName) {
		super(buttonName);
		this.buttonType = CurrentMode.USECASE;
	}
}
