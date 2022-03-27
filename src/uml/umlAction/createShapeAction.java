package uml.umlAction;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import uml.MyCanvas;
import uml.umlAction.Mode.CurrentMode;
import uml.umlButton.UseCaseButton;
import uml.umlPattern.ClassShape;
import uml.umlPattern.MyShape;
import uml.umlPattern.UseCaseShape;

public class createShapeAction extends MouseAdapter{
	private  CurrentMode shapeType = null;
	private  MyCanvas canvas = null;

	public createShapeAction(){
		
	}
	
	public createShapeAction( MyCanvas canvas,CurrentMode shapeType) {
		this.shapeType = shapeType;
		this.canvas = canvas;
	}
	public void mousePressed(MouseEvent e) {
		MyShape shape = createShape(shapeType, e.getPoint());
		canvas.addShape(shape);
	}
	
	public MyShape createShape(CurrentMode shapeType, Point p) {
		String name = JOptionPane.showInputDialog("enter Name");
		
		if(shapeType.equals(CurrentMode.CLASS)){
			return new ClassShape(p.x,p.y,100,150,5,name);
		}
		if(shapeType.equals(CurrentMode.USECASE)){
			return new UseCaseShape(p.x,p.y,100,50,5,name);
		}
		
		return null;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
