package ba.bitcamp.homeworkWeekend6.task02;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Task02 extends JFrame {

	private static final long serialVersionUID = 6579172959932296051L;

	// Creating 2 buttons and 2 labels.
	JButton button1 = new JButton("First name");
	JButton button2 = new JButton("Last name");
	JLabel label1 = new JLabel("Name ");
	JLabel label2 = new JLabel(" Last Name");

	// Creating 2 strings that will represent a text of the labels.
	private static String label1Text = "";
	private static String label2Text = "";

	// Creating 2 counters that will count a names and last names.
	private static int counterName = 0;
	private static int counterLastName = 0;

	// Creating a constructor
	public Task02() {

		// Setting the layout
		setLayout(new BorderLayout());

		// Adding the labels on positions in center of borderlayout
		label1.setHorizontalAlignment(JLabel.RIGHT);
		label1.setVerticalAlignment(JLabel.CENTER);
		label2.setHorizontalAlignment(JLabel.LEFT);
		label2.setVerticalAlignment(JLabel.CENTER);
		JPanel p = new JPanel(new GridLayout(1, 2));
		p.add(label1);
		p.add(label2);
		add(p, BorderLayout.CENTER);

		// Adding one button left and one button right
		add(button1, BorderLayout.WEST);
		add(button2, BorderLayout.EAST);

		// Adding action listener to the buttons
		button1.addActionListener(new Action());
		button2.addActionListener(new Action());

		// Setting the frame
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setLocationRelativeTo(null);
		setTitle("Task 2");

	}

	public static void main(String[] args) {
		// Calling constructor
		new Task02();
	}

	/**
	 * Inner class
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class Action implements ActionListener {

		// Creating objects
		Name n = new Name();
		LastName l = new LastName();

		public void actionPerformed(ActionEvent e) {
			// If the user press left button it changes names
			if (e.getSource() == button1) {
				label1.setText(n.generateName());
				counterName++;
				// If the user press right button it changes last names
			} else if (e.getSource() == button2) {
				label2.setText(l.generateLastName());
				counterLastName++;
			}
		}
	}

	/**
	 * Inner class
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private static class Name {

		// Declaring an array of names
		private String[] names = { "Adis ", "Gordan ", "Kerim ", "Zeljko ",
				"Zaid ", "Ajla ", "Medina ", "Mladen " };

		/**
		 * Prints one name from an array of names.
		 * 
		 * @return One name from an array of names.
		 */
		public String generateName() {
			// If the counter of names is equal to the number of names in the
			// array of names it resets the counter to zero.
			if (counterName == names.length) {
				counterName = 0;
			}
			// Going through an array of names and selecting one.
			for (int i = 0; i < names.length; i++) {
				if (i == counterName) {
					label1Text = names[i];
				}
			}
			return label1Text;
		}

		/**
		 * Prints an array of names.
		 */
		public String toString() {
			return String.format("%s", Arrays.toString(names));
		}
	}

	/**
	 * Inner class
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private static class LastName {

		// Declaring an array of last names
		private String[] lastNames = { " Cehajic", " Masic", " Dragolj",
				" Miljovic", " Zerdo", " Mulic", " Banjic", " Teofilovic" };

		/**
		 * Prints one last name from an array of last names.
		 * 
		 * @return One last name from an array of last names.
		 */
		public String generateLastName() {
			// If the counter of last names is equal to the number of last names
			// in the array of last names it resets the counter to zero.
			if (counterLastName == lastNames.length) {
				counterLastName = 0;
			}
			// Going through an array of last names and selecting one.
			for (int i = 0; i < lastNames.length; i++) {
				if (i == counterLastName) {
					label2Text = lastNames[i];
				}
			}
			return label2Text;
		}

		/**
		 * Prints an array of last names.
		 */
		public String toString() {
			return String.format("%s", Arrays.toString(lastNames));
		}

	}

}
