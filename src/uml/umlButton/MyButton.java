package uml.umlButton;
import javax.swing.JButton;

import uml.umlAction.umlFactory.ModeManager;
import uml.umlAction.umlFactory.ModeManager.CurrentMode;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;

public  abstract class  MyButton extends JButton{
	
	protected CurrentMode buttonType ;
	
	public MyButton(String buttonName) {
		super(buttonName);
		initButtonActionListener();
	}
	
    public void changeButtonColor() {
    	this.setBackground(Color.black);
    	this.setForeground(Color.white);
    }
    
    public void onClick(CurrentMode buttonType) {
        ModeManager.changeMode(buttonType);
        changeButtonColor();
	}
    
    public void initButtonActionListener() {
    	this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
            	onClick(buttonType);
            }
        });
    }
    
    
    
    
  
}
