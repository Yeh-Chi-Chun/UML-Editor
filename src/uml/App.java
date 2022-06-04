package uml;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uml.umlAction.GroupAction;
import uml.umlAction.RenameAction;
import uml.umlAction.UngroupAction;
import uml.umlButton.AssociationLineButton;
import uml.umlButton.ClassButton;
import uml.umlButton.CompositionLineButton;
import uml.umlButton.GeneralizationLineButton;
import uml.umlButton.GroupMenuItem;
import uml.umlButton.MyButton;
import uml.umlButton.MyMenuItem;
import uml.umlButton.RenameMenuItem;
import uml.umlButton.SelectButton;
import uml.umlButton.UngroupMenuItem;
import uml.umlButton.UseCaseButton;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JLayeredPane;
import javax.swing.UIManager;

public class App {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 715, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new MenuBar(frame);
	    frame.getContentPane().add(ButtonsPanel.getInstance(), BorderLayout.WEST);
	    frame.getContentPane().add(MyCanvas.getInstance(), BorderLayout.CENTER);
	    
	}
}
