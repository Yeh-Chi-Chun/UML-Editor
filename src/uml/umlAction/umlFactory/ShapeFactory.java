package uml.umlAction.umlFactory;

import java.awt.Point;

import javax.swing.JOptionPane;

import uml.umlAction.ModeManager.CurrentMode;
import uml.umlPattern.ClassShape;
import uml.umlPattern.MyShape;
import uml.umlPattern.UseCaseShape;

public class ShapeFactory {
	
	public static MyShape createShape(CurrentMode shapeType, Point p) {
		String name = JOptionPane.showInputDialog("enter Name");
		
		switch(shapeType) {
		
		case CLASS: 
			return new ClassShape(p.x,p.y,100,150,1,name);
		case USECASE: 
			return new UseCaseShape(p.x,p.y,100,50,1,name);
		default:
			System.out.println("Don't have this shape type");
			break;
	}
		return null;
	}

}
