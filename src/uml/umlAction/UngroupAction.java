package uml.umlAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import uml.MyCanvas;
import uml.umlPattern.MyShape;

public class UngroupAction implements ActionListener {
	MyCanvas canvas;
	ArrayList<MyShape> removeGroupContainer;
	
	public UngroupAction(MyCanvas canvas) {
		this.canvas = canvas;
		removeGroupContainer = new ArrayList<MyShape>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// find need to remove component
		for(MyShape shape : canvas.getShapes())
			if(shape.getShapeCount() > 0 && shape.getSelected())
				removeGroupContainer.add(shape);
		
		// if no remove group, show message and return
		if(removeGroupContainer.size() == 0)
		{
			return;
		}
		// remove draw panel's shape
		for(MyShape shape : removeGroupContainer)
		{
			canvas.removeShape(shape);
		}
			
		removeGroupContainer.clear();
	}
}
