package uml;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import uml.umlButton.GroupMenuItem;
import uml.umlButton.MyMenuItem;
import uml.umlButton.RenameMenuItem;
import uml.umlButton.UngroupMenuItem;

public class MenuBar extends JMenuBar{
	
	public MenuBar(JFrame frame) {
		super();
		initMenuBar(frame);
	}
	
	private void initMenuBar(JFrame frame) {
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

}
