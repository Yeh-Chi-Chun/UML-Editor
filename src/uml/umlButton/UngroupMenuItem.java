package uml.umlButton;

import uml.App;
import uml.MyCanvas;
import uml.umlAction.GroupAction;
import uml.umlAction.UngroupAction;

public class UngroupMenuItem extends MyMenuItem{

	public UngroupMenuItem(String itemName) {
		super(itemName);
	}
	
	@Override
	public void initButtonActionListener() {
		this.addActionListener(new UngroupAction(MyCanvas.getInstance()));
    }

}
