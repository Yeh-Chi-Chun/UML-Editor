package uml.umlAction;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import uml.MyCanvas;
import uml.umlAction.umlFactory.ShapeFactory;
import uml.umlAction.umlFactory.ModeManager.CurrentMode;
import uml.umlButton.UseCaseButton;
import uml.umlPattern.AssociationLine;
import uml.umlPattern.ClassShape;
import uml.umlPattern.CompositionLine;
import uml.umlPattern.GeneralizationLine;
import uml.umlPattern.MyShape;
import uml.umlPattern.UseCaseShape;

public class CreateShapeAction extends MouseAdapter{
	private  CurrentMode shapeType = null;
	private  MyCanvas canvas = null;

	public CreateShapeAction(){
		
	}
	
	public CreateShapeAction( MyCanvas canvas,CurrentMode shapeType) {
		this.shapeType = shapeType;
		this.canvas = canvas;
	}
	public void mousePressed(MouseEvent e) {
		MyShape shape = ShapeFactory.createShape(shapeType, e.getPoint());
		canvas.addShape(shape);
	}
}
