package ba.bitcamp.homework29.task;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Class EditorPanel extends JPanel. Panel contains menu with menu items NEW,
 * OPEN and SAVE that enables selected file to be imported into text area.
 * 
 * @author Adis Cehajic
 *
 */
public class EditorPanel extends JPanel {

	private static final long serialVersionUID = 766095043096420580L;

	// Declaring main elements.
	private JMenuBar bar = new JMenuBar();
	private JMenu menu = new JMenu("File");
	private JMenuItem openItem = new JMenuItem("Open");
	private JMenuItem saveItem = new JMenuItem("Save");
	private JMenuItem newItem = new JMenuItem("New");
	private JTextArea area = new JTextArea();
	private JScrollPane scroll = new JScrollPane(area);

	/**
	 * Constructor.
	 */
	public EditorPanel() {

		// Setting the panel layout.
		setLayout(new BorderLayout());

		// Adding the elements on the panel and setting the elements options.
		add(bar, BorderLayout.NORTH);
		bar.add(menu);
		menu.add(newItem);
		menu.add(openItem);
		menu.add(saveItem);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(scroll, BorderLayout.CENTER);

		// Adding action listener to the menu item that creates new text
		// document.
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				area.setText("");
			}
		});

		// Adding action listener to the menu item that opens text document.
		openItem.addActionListener(new OpenAction());

		// Adding action listener to the menu item that saves the text document.
		saveItem.addActionListener(new SaveAction());
	}

	/**
	 * Inner class that sets action listener for menu item open. When menu item
	 * open is clicked it enables user to chose file to be opened.
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class OpenAction implements ActionListener {

		/**
		 * Enables selecting of file and opening of the selected file into text
		 * editor.
		 */
		public void actionPerformed(ActionEvent e) {
			// Setting the look of JFileChooser on system look.
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e2) {
				e2.printStackTrace();
			}

			// Declaring reader, file chooser and name extension filter.
			BufferedReader reader = null;
			JFileChooser open = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					".txt", "txt");

			// Adding extensions to the JFileChooser.
			open.addChoosableFileFilter(filter);
			open.setFileFilter(filter);

			int option = open.showOpenDialog(null);

			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					// Importing selected file into reader.
					reader = new BufferedReader(new FileReader(
							open.getSelectedFile()));
					// Declaring string variable that will contain text of
					// selected file
					String text = "";
					// Reading selected file line by line.
					while (reader.ready()) {
						text += reader.readLine() + "\n";
					}
					// Adding text from the selected file into the area.
					area.setText(text);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * Inner class that sets action listener for menu item save. When menu item
	 * save is clicked it enables user to chose location where to save file and
	 * name of the file.
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class SaveAction implements ActionListener {

		/**
		 * Enables to chose where to save file and to input name of the file.
		 */
		public void actionPerformed(ActionEvent e) {
			// Setting the look of JFileChooser on system look.
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException | UnsupportedLookAndFeelException e2) {
				e2.printStackTrace();
			}

			// Declaring file chooser and extension filter.
			JFileChooser save = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					".txt", "txt");

			// Adding extension filter to the file chooser.
			save.addChoosableFileFilter(filter);
			save.setFileFilter(filter);

			int option = save.showSaveDialog(null);

			if (option == JFileChooser.APPROVE_OPTION) {
				// Declaring string variable that contain text inputed into text
				// area.
				String text = area.getText();
				text = text.replaceAll("(?!\\r)\\n", "\r\n");

				try {
					// Declaring writer that will input text into named file.
					BufferedWriter writer = new BufferedWriter(new FileWriter(
							new File(save.getCurrentDirectory(), save
									.getSelectedFile().getName())
									+ ""
									+ filter.getDescription()));
					// Writing text into file and closing writer.
					writer.write(text);
					writer.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
