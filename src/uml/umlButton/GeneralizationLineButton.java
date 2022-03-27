package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uml.umlAction.Mode.CurrentMode;

public class GeneralizationLineButton extends MyButton{

	public GeneralizationLineButton(String buttonType) {
		super(buttonType);
		this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	onClick(CurrentMode.GENERALIZATION_LINE);
            }
        });
	}

	

}
