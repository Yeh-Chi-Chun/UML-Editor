package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uml.umlAction.umlFactory.ModeManager.CurrentMode;

public class AssociationLineButton  extends MyButton  {

	public AssociationLineButton(String buttonName) {
		super(buttonName);
		this.buttonType = CurrentMode.ASSOCIATION_LINE;
	}
}
