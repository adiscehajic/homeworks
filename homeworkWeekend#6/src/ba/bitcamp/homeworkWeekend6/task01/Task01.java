package ba.bitcamp.homeworkWeekend6.task01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task01 extends JFrame {

	private static final long serialVersionUID = -4271314583804769289L;

	// Creating 10 buttons that have numbers from 0 to 9.
	JButton button1 = new JButton("0");
	JButton button2 = new JButton("1");
	JButton button3 = new JButton("2");
	JButton button4 = new JButton("3");
	JButton button5 = new JButton("4");
	JButton button6 = new JButton("5");
	JButton button7 = new JButton("6");
	JButton button8 = new JButton("7");
	JButton button9 = new JButton("8");
	JButton button10 = new JButton("9");

	// Creating an array of buttons
	JButton[] jbuttonArray = new JButton[] { button1, button2, button3,
			button4, button5, button6, button7, button8, button9, button10 };

	// Declaration of a counter that will count pressed buttons
	private static int counter = 0;

	// Declaration of a message that will be shown on JOptionPane
	private static String label = "Number:  ";

	// Creating constructor
	public Task01() {

		// Setting the layout
		setLayout(new GridLayout(10, 1));

		// Adding buttons in the frame
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		add(button10);

		// Adding action listener to the buttons
		button1.addActionListener(new Action());
		button2.addActionListener(new Action());
		button3.addActionListener(new Action());
		button4.addActionListener(new Action());
		button5.addActionListener(new Action());
		button6.addActionListener(new Action());
		button7.addActionListener(new Action());
		button8.addActionListener(new Action());
		button9.addActionListener(new Action());
		button10.addActionListener(new Action());

		// Setting the frame
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(650, 200);
		setSize(150, 500);
		setTitle("Task 1");
	}

	public static void main(String[] args) {

		// Calling the constructor
		new Task01();
	}

	/**
	 * Inner class
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			// Selecting the button from an array of buttons.
			for (int i = 0; i < jbuttonArray.length; i++) {
				// Setting the selected button not visible and adding the text
				// of a button to declared string.
				if (e.getSource() == jbuttonArray[i] && counter < 3) {
					jbuttonArray[i].setEnabled(false);
					label += jbuttonArray[i].getText();
					counter++;
				}
			}

			// If the number of pressed buttons is 3 prints the number.
			if (counter == 3) {
				JOptionPane.showMessageDialog(null, label);
				System.exit(0);
			}
		}
	}
}
