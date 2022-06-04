package uml;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import uml.umlButton.AssociationLineButton;
import uml.umlButton.ClassButton;
import uml.umlButton.CompositionLineButton;
import uml.umlButton.GeneralizationLineButton;
import uml.umlButton.MyButton;
import uml.umlButton.SelectButton;
import uml.umlButton.UseCaseButton;

public class ButtonsPanel extends JPanel{
	private static ButtonsPanel uniqueInstance;
	private ArrayList<MyButton> buttonList;
	
	public ButtonsPanel() {
		super();
		initButtons();
		this.setLayout(new GridLayout(6, 0, 0, 0));
		for(MyButton button : buttonList)
		{
			button.setBackground(Color.WHITE);
			this.add(button);
		}
			
	}
	
	public static ButtonsPanel getInstance() {
		if(uniqueInstance == null)
		{
			uniqueInstance = new ButtonsPanel();
		}
		return uniqueInstance;
	}
	
	private void initButtons() {
		this.buttonList = new ArrayList<MyButton>();
		this.buttonList.add(new SelectButton("select"));
		this.buttonList.add(new AssociationLineButton("association line"));
		this.buttonList.add(new GeneralizationLineButton("generalization line"));
		this.buttonList.add(new CompositionLineButton("composition line"));
		this.buttonList.add(new ClassButton("class"));
		this.buttonList.add(new UseCaseButton("use case"));
	}
	
	public void resetButtonColor() {
    	for (MyButton button : this.buttonList) {
    		button.setBackground(Color.white);
    		button.setForeground(Color.black);
		}
	}

}
