package uml.umlAction;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ListIterator;
import uml.MyCanvas;
import uml.umlAction.Mode.CurrentMode;
import uml.umlPattern.AssociationLine;
import uml.umlPattern.CompositionLine;
import uml.umlPattern.GeneralizationLine;
import uml.umlPattern.MyShape;
import uml.umlPattern.Port;

public class CreateLineAction extends MouseAdapter{
	
	private Port p1, p2;
	private MyShape source, dest;
	private MyCanvas canvas;
	private CurrentMode currentMode;
	
	public CreateLineAction(MyCanvas canvas, CurrentMode currentMode) {
		this.canvas =canvas;
		this.currentMode = currentMode;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// get source component
		source = findMouseEventShape(e.getPoint());
		
		// if source component not null, then get nearest position(north, east, west, south) by pressed position 
		if(source!=null)	{
			p1 = source.getNearestPosition(e.getPoint());
		}
			
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		// get destination component
		dest = findMouseEventShape(e.getPoint());
		
		// if destination component not null, then get nearest position(north, east, west, south) by pressed position 
		if(dest!=null) {
			p2 = dest.getNearestPosition(e.getPoint());
		}
			
		// if p1, p2 not null, source component not equal to destination component, then return
		if(p1==null || p2==null || source == dest) {
			return;
		}
			

		// check line arrow type
		switch(currentMode) {
		
			case ASSOCIATION_LINE: 
				canvas.addLine(new AssociationLine(p1, p2, Color.black));
				break;
			case COMPOSITION_LINE: 
				canvas.addLine(new CompositionLine(p1, p2, Color.black));
				break;
			case GENERALIZATION_LINE: 
				canvas.addLine(new GeneralizationLine(p1, p2, Color.black));
				break;
		default:
			System.out.println("Don't have this line type");
			break;
		}
	}
	
	/**
	 * Find mouse pressed shape
	 * @param p
	 * @return
	 */
	private MyShape findMouseEventShape(Point p) {
		// find shape from the end of canvas shape container, because the shape of the end container have highest z-index
		ListIterator<MyShape> li =canvas.getShapes().listIterator(canvas.getShapes().size());
		while (li.hasPrevious()) {
			MyShape currentShape = (MyShape)li.previous();
	    	if(p.getX()>=currentShape.getX() && p.getX()<=currentShape.getX()+currentShape.getWidth() && p.getY()>=currentShape.getY() && p.getY()<=currentShape.getY()+currentShape.getHeight()){
	    		return currentShape;
	    	}		
		}
		
		return null;
	}

}
