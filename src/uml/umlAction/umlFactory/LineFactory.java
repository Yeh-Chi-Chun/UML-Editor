package uml.umlAction.umlFactory;

import java.awt.Color;

import uml.umlAction.umlFactory.ModeManager.CurrentMode;
import uml.umlPattern.AssociationLine;
import uml.umlPattern.CompositionLine;
import uml.umlPattern.GeneralizationLine;
import uml.umlPattern.MyLine;
import uml.umlPattern.Port;

public class LineFactory {
	
	public static MyLine createLine(CurrentMode currentMode,Port p1,Port p2) {
		
		switch(currentMode) {
		
		case ASSOCIATION_LINE: 
			return new AssociationLine(p1, p2, Color.black);
		case COMPOSITION_LINE: 
			return new CompositionLine(p1, p2, Color.black);
		case GENERALIZATION_LINE: 
			return new GeneralizationLine(p1, p2, Color.black);
	default:
		System.out.println("Don't have this line type");
		break;
	}
		return null;
	}
}
