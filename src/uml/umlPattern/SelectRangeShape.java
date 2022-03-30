package uml.umlPattern;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;

public class SelectRangeShape extends MyShape{
	public SelectRangeShape() {
		super();
	}
	
	public SelectRangeShape(int x, int y, int width, int height) {
		super(x, y, width, height, 1, "SelectRectangle");
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	@Override
	public void draw(Graphics g) {
		drawCustomShape(g);
	}
	
	@Override
	public void drawCustomShape(Graphics g) {
		Rectangle2D rectangle = new Rectangle2D.Double(getX(), getY(), getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(Color.black);
		g2d.draw(rectangle);
	}

}
