package uml.umlAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import uml.MyCanvas;
import uml.umlPattern.GroupShape;
import uml.umlPattern.MyShape;

public class GroupAction implements ActionListener{
	MyCanvas canvas;
	MyShape groupShape;
	
	public GroupAction(MyCanvas canvas) {
		this.canvas = canvas;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// reset selected shape container
		ArrayList<MyShape> selectedShapeContainer = new ArrayList<MyShape>();
		
		// check select shape, and add to container
		for(MyShape shape : canvas.getShapes())
			if(shape.getSelected()) {
				shape.setSelected(false);
				selectedShapeContainer.add(shape);
			}
				
		// check selected item count, if ==0 || ==1, return
		if(selectedShapeContainer.size() == 0 || selectedShapeContainer.size() == 1) {
			return;
		}
		
		
		// group create
		groupShape = new GroupShape();
		for(MyShape shape : selectedShapeContainer) 
		{
			groupShape.addShape(shape);
		}
			
		ModeManager.addAllMouseEvent(groupShape, new DragShapeAction(canvas));
		
		// add group shape to draw panel
		canvas.addShape(groupShape);
	}
}
