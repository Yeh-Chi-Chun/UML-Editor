package uml.umlAction;

import java.awt.event.MouseAdapter;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;

import uml.App;
import uml.MyCanvas;
import uml.umlAction.Mode.CurrentMode;

public class Mode{
	static private CurrentMode currentMode = null;
	
	
	public enum CurrentMode
	{
		SELECT, ASSOCIATION_LINE, GENERALIZATION_LINE, 
		COMPOSITION_LINE, CLASS, USECASE
	}

	public Mode() {
		
	}
	
	static public void changeMode(CurrentMode mode ) {
		System.out.println("change mode");
		currentMode = mode;
		
		switch (currentMode) {
		case SELECT:
			
			break;
		case ASSOCIATION_LINE:
			
			break;
		case COMPOSITION_LINE:
			
			break;
		case GENERALIZATION_LINE:
			
		case CLASS:
			addAllMouseEvent(App.mainCanvas, new createShapeAction(CurrentMode.CLASS,App.mainCanvas));
			break;
		case USECASE:
			
			break;
		default:System.out.println("no this event");
			break;
		}
	}
	
	public static void addAllMouseEvent(JComponent comp, MouseAdapter mouseAdapter) {
		comp.addMouseListener(mouseAdapter);
		comp.addMouseMotionListener(mouseAdapter);
		comp.addMouseWheelListener(mouseAdapter);
	}
}
