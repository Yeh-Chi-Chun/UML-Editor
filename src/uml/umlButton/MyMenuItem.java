package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public abstract class MyMenuItem extends JMenuItem {
	
	public MyMenuItem(String itemName) {
		super(itemName);
		initButtonActionListener();
	}
	
	public void initButtonActionListener() {
    }

}
