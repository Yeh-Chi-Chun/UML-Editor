package uml.umlAction;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import uml.MyCanvas;
import uml.umlAction.umlFactory.ModeManager;
import uml.umlPattern.MyShape;
import uml.umlPattern.SelectRangeShape;

public class SelectShapesAction extends MouseAdapter  {
	private ArrayList<MyShape> shapeContainer;
	private MyCanvas canvas;
	private Point pressedPoint;
	private Point draggedPoint;
	private MyShape chooseRect;
	
	public SelectShapesAction(MyCanvas canvas) {
		shapeContainer = new ArrayList<MyShape>();
		this.canvas = canvas;
		chooseRect = new SelectRangeShape();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// reset all component's selected to false
    	ModeManager.getInstance().resetComponentSelect(canvas);
    	shapeContainer.clear();
    	
    	// get press point
		pressedPoint = e.getPoint();
		
		// create choose rectangle
		chooseRect.setBounds(pressedPoint.x, pressedPoint.y, 0, 0);
		canvas.addShape(chooseRect);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point leftTopPoint = new Point();
		int width, height;
		
		// get dragged point
		draggedPoint = e.getPoint();
		
		// initial left top point
		leftTopPoint.setLocation(pressedPoint.x<=draggedPoint.x?pressedPoint.x:draggedPoint.x,pressedPoint.y<=draggedPoint.y?pressedPoint.y:draggedPoint.y);
		
		// initial choose rectangle width and height
		width = Math.abs(pressedPoint.x - draggedPoint.x);
		height = Math.abs(pressedPoint.y - draggedPoint.y);
		
		// set choose rectangle position, width and height 
		chooseRect.setBounds(leftTopPoint.x, leftTopPoint.y, width, height);
		
		// check shape inside choose rectangle
		checkShapeInside(canvas.getShapes());
		
		// repaint drawPanel
		canvas.repaint();	
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// group select finish, then remove rectangle
		canvas.removeShape(chooseRect);
	}
	
	/**
	 * check shape inside choose rectangle
	 * @param shapes
	 */
	public void checkShapeInside(ArrayList<MyShape> shapes) {
		for(MyShape shape : shapes) {
			if(shape.getX()>=chooseRect.getX() && shape.getX()+shape.getWidth()<=chooseRect.getX()+chooseRect.getWidth() &&
					shape.getY()>=chooseRect.getY() && shape.getY()+shape.getHeight()<=chooseRect.getY()+chooseRect.getHeight())
			{
				shape.setSelected(true);
			}
			else {
				shape.setSelected(false);
			}
				
		}
	}

}
