package uml.umlButton;

import uml.App;
import uml.umlAction.RenameAction;
import uml.umlAction.UngroupAction;

public class RenameMenuItem extends MyMenuItem{

	public RenameMenuItem(String itemName) {
		super(itemName);
	}
	
	@Override
	public void initButtonActionListener() {
		this.addActionListener(new RenameAction(App.mainCanvas));
    }

}
