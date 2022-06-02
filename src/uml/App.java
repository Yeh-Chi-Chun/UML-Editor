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
	public static  MyCanvas mainCanvas ;
	public static ArrayList<MyButton> buttonList = new ArrayList<MyButton>();

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
	    
	    App.mainCanvas = initMainCanvas(frame);
	    initButton(panel);
	    initMenu(frame);
	    
	}
	
	private void initButton(JPanel panel) {
		MyButton btnSelect = new SelectButton("select");
		btnSelect.setBackground(Color.WHITE);
		panel.add(btnSelect);
		buttonList.add(btnSelect);
		
		
		MyButton btnAssociationLine = new AssociationLineButton("association line");
		btnAssociationLine.setBackground(Color.WHITE);
		panel.add(btnAssociationLine);
		buttonList.add(btnAssociationLine);
		
		
		MyButton btnGeneralizationLine = new GeneralizationLineButton("generalization line");
		btnGeneralizationLine.setBackground(Color.WHITE);
		panel.add(btnGeneralizationLine);
		buttonList.add(btnGeneralizationLine);
		
		
		MyButton btnCompositionLine = new CompositionLineButton("composition line");
		btnCompositionLine.setBackground(Color.WHITE);
		panel.add(btnCompositionLine);
		buttonList.add(btnCompositionLine);
		
		
		MyButton btnClass = new ClassButton("class");
	    btnClass.setBackground(Color.WHITE);
		panel.add(btnClass);
		buttonList.add(btnClass);
		
		
		MyButton btnUseCase = new UseCaseButton("use case");
		btnUseCase.setBackground(Color.WHITE);
		panel.add(btnUseCase);
		buttonList.add(btnUseCase);
	}
	
	private void initMenu(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		MyMenuItem groupMenuItem = new GroupMenuItem("group");
		editMenu.add(groupMenuItem);
		
		MyMenuItem ungroupMenuItem = new UngroupMenuItem("ungroup");
		editMenu.add(ungroupMenuItem);
		
		MyMenuItem changeNameMenuItem = new RenameMenuItem("change name");
		editMenu.add(changeNameMenuItem);
	}
	
	private MyCanvas initMainCanvas(JFrame frame) {
		mainCanvas = new MyCanvas();
		mainCanvas.setBackground(Color.LIGHT_GRAY);
		mainCanvas .setOpaque(true);
		frame.getContentPane().add(mainCanvas, BorderLayout.CENTER);
		
		return mainCanvas;
	}
	
}
