package uml.umlAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import uml.MyCanvas;
import uml.umlPattern.MyShape;

public class RenameAction implements ActionListener{
private MyCanvas canvas;
	
	public RenameAction (MyCanvas canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// input component name
		String name = JOptionPane.showInputDialog("Enter Name");
		
		// if cancel, then class name still not change
		if(name == null)
			return;
		
		// find select name and rename them
		for(MyShape shape : canvas.getShapes()){
			if(shape.getSelected()) {
				shape.setName(name);
			}
		}
			
		
		// repaint draw panel
		canvas.repaint();
	}
}
