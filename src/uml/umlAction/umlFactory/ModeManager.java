package uml.umlAction.umlFactory;

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
import uml.ButtonsPanel;
import uml.MyCanvas;
import uml.umlAction.CreateLineAction;
import uml.umlAction.CreateShapeAction;
import uml.umlAction.DragShapeAction;
import uml.umlAction.SelectShapesAction;
import uml.umlButton.MyButton;
import uml.umlPattern.MyShape;

public class ModeManager{
	private  static MyCanvas mainCanvas = MyCanvas.getInstance();
	
	public enum CurrentMode
	{
		SELECT, ASSOCIATION_LINE, GENERALIZATION_LINE, 
		COMPOSITION_LINE, CLASS, USECASE
	}

	public ModeManager() {
		
	}
	
	public static  void changeMode(CurrentMode mode ) {
		
		System.out.println("change mode : "+mode.toString());
		// initial state
		removeAllMouseEvent(new ArrayList<JComponent>(mainCanvas.getShapes()));
		removeAllMouseEvent(mainCanvas);
		resetComponentSelect(mainCanvas);
		ButtonsPanel.getInstance().resetButtonColor();
		
		
		switch (mode) {
		case SELECT:
			addAllMouseEvent(new ArrayList<JComponent>(mainCanvas.getShapes()) ,new DragShapeAction(mainCanvas));
			addAllMouseEvent(mainCanvas, new SelectShapesAction(mainCanvas));
			break;
		case ASSOCIATION_LINE:
			addAllMouseEvent(mainCanvas, new CreateLineAction(mainCanvas,CurrentMode.ASSOCIATION_LINE));
			break;
		case COMPOSITION_LINE:
			addAllMouseEvent(mainCanvas, new CreateLineAction(mainCanvas,CurrentMode.COMPOSITION_LINE));
			break;
		case GENERALIZATION_LINE:
			addAllMouseEvent(mainCanvas, new CreateLineAction(mainCanvas,CurrentMode.GENERALIZATION_LINE));
			break;
		case CLASS:
			addAllMouseEvent(mainCanvas, new CreateShapeAction(mainCanvas,CurrentMode.CLASS));
			break;
		case USECASE:
			addAllMouseEvent(mainCanvas, new CreateShapeAction(mainCanvas,CurrentMode.USECASE));
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

    //remove component mouse event listener
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

	//remove components mouse event listener
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
	
	
}
