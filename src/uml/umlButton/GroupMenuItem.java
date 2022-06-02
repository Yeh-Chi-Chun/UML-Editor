package uml.umlButton;

import uml.App;
import uml.umlAction.GroupAction;

public class GroupMenuItem extends MyMenuItem{
	
	public GroupMenuItem(String itemName)
	{
		super(itemName);
		
	}
	
	@Override
	public void initButtonActionListener() {
		this.addActionListener(new GroupAction(App.mainCanvas));
    }

}
