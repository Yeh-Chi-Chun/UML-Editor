import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		frame.setBounds(100, 100, 800, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnClass = new JButton("class");
		btnClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClass.setBounds(0, 427, 125, 40);
		frame.getContentPane().add(btnClass);
		
		JButton btnSelect = new JButton("select");
		btnSelect.setBounds(0, 227, 125, 40);
		frame.getContentPane().add(btnSelect);
		
		JButton btnAssociationLine = new JButton("association \r\nline");
		btnAssociationLine.setBounds(0, 277, 125, 40);
		frame.getContentPane().add(btnAssociationLine);
		
		JButton btnGeneralizationLine = new JButton("generalization line");
		btnGeneralizationLine.setBounds(0, 327, 125, 40);
		frame.getContentPane().add(btnGeneralizationLine);
		
		JButton btnCompositionLine = new JButton("composition line");
		btnCompositionLine.setBounds(0, 377, 125, 40);
		frame.getContentPane().add(btnCompositionLine);
		
		JButton btnUseCase = new JButton("use case");
		btnUseCase.setBounds(0, 477, 125, 40);
		frame.getContentPane().add(btnUseCase);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		JMenu editMenu = new JMenu("Edit");
		menuBar.add(editMenu);
		
		JMenuItem groupMenuItem = new JMenuItem("group / ungroup");
		editMenu.add(groupMenuItem);
		
		JMenuItem changeNameMenuItem = new JMenuItem("change name");
		editMenu.add(changeNameMenuItem);
	}
}
