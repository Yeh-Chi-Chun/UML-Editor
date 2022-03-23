package uml.umlButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;

public  abstract class  MyButton extends JButton{
	
	
	public MyButton(String buttonType) {
		super(buttonType);
		this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
		
	}
	
	/*
	private void setImg(String imgPath) {
		try {
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	*/
	
	
	
	

}
