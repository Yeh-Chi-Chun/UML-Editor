package uml.umlButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uml.umlAction.Mode.CurrentMode;

public class SelectButton extends MyButton{

	public SelectButton(String buttonType) {
		super(buttonType);
		this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	onClick(CurrentMode.SELECT);
            }
        });
	}

	

}
