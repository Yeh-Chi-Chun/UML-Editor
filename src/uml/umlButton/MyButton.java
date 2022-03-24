package uml.umlButton;
import javax.swing.JButton;

import uml.umlAction.Mode;
import uml.umlAction.Mode.CurrentMode;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;

public  abstract class  MyButton extends JButton{
	
	
	public MyButton(String buttonType) {
		super(buttonType);
	}
	
    public void changeButtonColor() {
    	this.setBackground(Color.black);
    	this.setForeground(Color.white);
    }
    
    public void onClick(CurrentMode buttonType) {
        Mode.changeMode(buttonType);
        changeButtonColor();
	}

}
