package uml.umlAction;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import uml.MyCanvas;
import uml.umlPattern.MyShape;

public class DragShapeAction extends MouseAdapter {
	private MyCanvas canvas;
	private MyShape shape;
	private Point prevPt;
	private Point dropPt;
	
	public DragShapeAction(MyCanvas canvas) {
		this. canvas =  canvas;
	}
	
    public void mousePressed(MouseEvent e) {
    	// reset all component's selected to false
    	Mode.resetComponentSelect(canvas);
    	
    	// set current shape
    	MyShape curShape = (MyShape)e.getSource();
    	
    	// if previous shape != current shape, previous shape set unclicked
    	if(shape != curShape && shape != null)
    	{
    		shape.setSelected(false);
    	}
    	shape  = curShape;
    	shape.setSelected(true);
    	
    	// get mouse press point
    	prevPt = e.getPoint();
    	
    	canvas.repaint();
    }

    public void mouseDragged(MouseEvent e){
    	// get pressed object
    	shape = (MyShape)e.getSource();
    	
    	// get drop point and distance between previous and drop point
    	dropPt = e.getPoint();
    	int diffx = dropPt.x - prevPt.x;
    	int diffy = dropPt.y - prevPt.y;

    	// set shape location
    	shape.setLocation(shape.getX() + diffx, shape.getY() + diffy);
    	
    	// repaint draw panel
    	canvas.repaint();
    }
    
    public void MouseReleased(MouseEvent e) {
    	canvas.repaint();
    }
}
