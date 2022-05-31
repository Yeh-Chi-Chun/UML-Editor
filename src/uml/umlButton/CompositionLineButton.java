package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uml.umlAction.ModeManager.CurrentMode;

public class CompositionLineButton extends MyButton {

	public CompositionLineButton(String buttonName) {
		super(buttonName);
		this.buttonType = CurrentMode.COMPOSITION_LINE;
	}
}
