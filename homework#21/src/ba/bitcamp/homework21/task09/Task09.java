package ba.bitcamp.homework21.task09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Task#9 - Import text file
 * 
 * Make a program where the user has the option to enter a location for the file
 * to be loaded. Pressing the Enter key in the center window will appear loaded
 * text from that file. If the program can not read the file, then write it can
 * not.
 * 
 * @author Adis Cehajic
 *
 */
public class Task09 extends JFrame {

	private static final long serialVersionUID = -3677494954146084043L;

	// Declaring main elements.
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel("Open file: ");
	private JTextField file = new JTextField(40);
	private JTextArea area = new JTextArea();

	/**
	 * Constructor
	 */
	public Task09() {

		// Setting the frame layout.
		setLayout(new BorderLayout());

		// Adding label and textfield on the panel.
		panel.add(label);
		panel.add(file);

		// Adding panel on the north position of the frame.
		add(panel, BorderLayout.NORTH);

		// Setting appearance of the textarea and positiong it in the center of
		// the frame.
		area.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		area.setLineWrap(true);
		add(area, BorderLayout.CENTER);

		// Adding key listener to the textfield that will load file.
		file.addKeyListener(new Action());

		// Setting frame appearance.
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 9");
		setVisible(true);
	}

	private class Action extends KeyAdapter {

		// Declaring variable that will contain all text from the file.
		String text = "";

		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);

			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
					// Reading all from the file and adding it to the string
					// variable.
					TextIO.readFile(file.getText());
					while (!TextIO.eof()) {
						text += TextIO.getln() + "\n";
					}
					// Setting the text of the textarea.
					area.setText(text);
					// If the inputed file does not exist prints message.
				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "File does not exist!");
				}
			}
			repaint();
		}
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Task09();
	}

}
