package uml;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLayeredPane;

import uml.umlPattern.MyLine;
import uml.umlPattern.MyShape;

public class MyCanvas extends JLayeredPane{
	private ArrayList<MyShape> shapes = new ArrayList<MyShape>();
	private ArrayList<MyLine> lines = new ArrayList<MyLine>();
	
	
	public MyCanvas() {
		super();
		this.setLayout(null);;
	}
	
	
	public void addShape(MyShape shape) {
		shapes.add(shape);
		this.add(shape, Integer.valueOf(shapes.size()-1));
		repaint();
	}
	
	
	public void addLine(MyLine line) {
		lines.add(line);
		//this.add(line, 0);
		repaint();
	}

	
	public void removeShape(MyShape shape) {
		// remove component
		shapes.remove(shape);
		
		// remove all component in JLayerPanel, to reset z-order
		this.removeAll();
		
		// reset all component z-order
		for(int i=0; i<shapes.size(); i++)
			this.add(shapes.get(i), Integer.valueOf(i));

		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(MyShape shape : shapes)
			shape.draw(g);
		
	}
	
	/**
	 * get MyShapes in this Panel
	 * @return
	 */
	public ArrayList<MyShape> getShapes(){
		return shapes;
	}
	
	
}
