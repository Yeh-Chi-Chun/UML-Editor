package uml.umlButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.event.ActionEvent;

public  abstract class  MyButton extends JButton{
	Boolean isSelectd = false;
	
	public MyButton(String buttonType) {
		super(buttonType);
		setImg("src/imgs"+buttonType+".png");
		this.setBackground(Color.BLACK);
        this.setForeground(Color.white);
		// TODO Auto-generated constructor stub
	}
	
	
	private void setImg(String imgPath) {
		try {
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public abstract void onClicked();
	
	

}
