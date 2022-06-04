package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uml.umlAction.umlFactory.ModeManager.CurrentMode;

public class GeneralizationLineButton extends MyButton{

	public GeneralizationLineButton(String buttonName) {
		super(buttonName);
		this.buttonType = CurrentMode.GENERALIZATION_LINE;
	}
}
