package uml;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


import uml.umlButton.AssociationLineButton;
import uml.umlButton.ClassButton;
import uml.umlButton.CompositionLineButton;
import uml.umlButton.GeneralizationLineButton;
import uml.umlButton.MyButton;
import uml.umlButton.SelectButton;
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

public class App {

	private JFrame frame;
	static public MyCanvas mainCanvas ;
	static ArrayList<MyButton> buttonList = new ArrayList<MyButton>();

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
		
		JPanel panel = new JPanel();
	    frame.getContentPane().add(panel, BorderLayout.WEST);
	    panel.setLayout(new GridLayout(6, 0, 0, 0));
		
		
		SelectButton btnSelect = new SelectButton("select");
		panel.add(btnSelect);
		
		
		AssociationLineButton btnAssociationLine = new AssociationLineButton("association line");
		panel.add(btnAssociationLine);
		
		
		GeneralizationLineButton btnGeneralizationLine = new GeneralizationLineButton("generalization line");
		panel.add(btnGeneralizationLine);
		
		
		CompositionLineButton btnCompositionLine = new CompositionLineButton("composition line");
		panel.add(btnCompositionLine);
		
		
	    ClassButton btnClass = new ClassButton("class");
		panel.add(btnClass);
		
		
		UseCaseButton btnUseCase = new UseCaseButton("use case");
		panel.add(btnUseCase);
		
		mainCanvas = new MyCanvas();
		mainCanvas.setBackground(Color.BLACK);
		mainCanvas .setOpaque(true);
		frame.getContentPane().add(mainCanvas, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenuItem groupMenuItem = new JMenuItem("group");
		editMenu.add(groupMenuItem);
		
		JMenuItem ungroupMenuItem = new JMenuItem("ungroup");
		editMenu.add(ungroupMenuItem);
		
		JMenuItem changeNameMenuItem = new JMenuItem("change name");
		editMenu.add(changeNameMenuItem);
	}
}
