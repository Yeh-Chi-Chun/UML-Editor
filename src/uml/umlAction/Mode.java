package uml.umlAction;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventListener;
import javax.swing.JComponent;
import uml.App;
import uml.MyCanvas;
import uml.umlButton.MyButton;
import uml.umlPattern.MyShape;

public class Mode{
	private static  CurrentMode currentMode = null;
	
	public enum CurrentMode
	{
		SELECT, ASSOCIATION_LINE, GENERALIZATION_LINE, 
		COMPOSITION_LINE, CLASS, USECASE
	}

	public Mode() {
		
	}
	
	public static  void changeMode(CurrentMode mode ) {
		
		System.out.println("change mode : "+mode.toString());
		// initial state
		removeAllMouseEvent(new ArrayList<JComponent>(App.mainCanvas.getShapes()));
		removeAllMouseEvent(App.mainCanvas);
		resetComponentSelect(App.mainCanvas);
		resetButtonColor();
		
		currentMode = mode;
		
		switch (currentMode) {
		case SELECT:
			addAllMouseEvent(new ArrayList<JComponent>(App.mainCanvas.getShapes()) ,new DragShapeAction(App.mainCanvas));
			break;
		case ASSOCIATION_LINE:
			addAllMouseEvent(App.mainCanvas, new CreateLineAction(App.mainCanvas,CurrentMode.ASSOCIATION_LINE));
			break;
		case COMPOSITION_LINE:
			addAllMouseEvent(App.mainCanvas, new CreateLineAction(App.mainCanvas,CurrentMode.COMPOSITION_LINE));
			break;
		case GENERALIZATION_LINE:
			addAllMouseEvent(App.mainCanvas, new CreateLineAction(App.mainCanvas,CurrentMode.GENERALIZATION_LINE));
			break;
		case CLASS:
			addAllMouseEvent(App.mainCanvas, new CreateShapeAction(App.mainCanvas,CurrentMode.CLASS));
			break;
		case USECASE:
			addAllMouseEvent(App.mainCanvas, new CreateShapeAction(App.mainCanvas,CurrentMode.USECASE));
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
	
	public static void addAllMouseEvent(ArrayList<JComponent> comps, MouseAdapter mouseAdapter) {
		for (JComponent comp : comps) {
			addAllMouseEvent(comp, mouseAdapter);
		}
	}

	/**
	 * remove component mouse event listener
	 * 
	 * @param comp
	 */
	public static  void removeAllMouseEvent(JComponent comp) {
		ArrayList<EventListener> removeListenerList = new ArrayList<EventListener>();
		removeListenerList.addAll(Arrays.asList(comp.getMouseListeners()));
		removeListenerList.addAll(Arrays.asList(comp.getMouseMotionListeners()));
		removeListenerList.addAll(Arrays.asList(comp.getMouseWheelListeners()));
		for (EventListener listener : removeListenerList) {
			comp.removeMouseListener((MouseListener) listener);
			comp.removeMouseMotionListener((MouseMotionListener) listener);
			comp.removeMouseWheelListener((MouseWheelListener) listener);
		}
	}

	/**
	 * remove components mouse event listener
	 * 
	 * @param comps
	 */
	public static void removeAllMouseEvent(ArrayList<JComponent> comps) {
		for (JComponent comp : comps){
			removeAllMouseEvent(comp);
		}
	}

	public static void resetComponentSelect(MyCanvas canvas) {
		for (MyShape s : canvas.getShapes()){
			s.setSelected(false);
		}
		    canvas.repaint();
	}
	
	public static void resetButtonColor() {
    	for (MyButton button : App.buttonList) {
    		button.setBackground(Color.white);
    		button.setForeground(Color.black);
		}
    	
	}
}
