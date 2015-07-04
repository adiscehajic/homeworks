package ba.bitcamp.homeworkWeekend6.task03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task03 extends JFrame {

	private static final long serialVersionUID = 5464598901954365584L;

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

	// Creating an array of buttons.
	JButton[] jbuttonArray = new JButton[] { button1, button2, button3,
			button4, button5, button6, button7, button8, button9, button10 };

	// Declaring a an array strings that will be printed in JOptionPane.
	private static String[] array = new String[5];

	// Declaring a counter that will count selected buttons.
	private static int counter = 0;

	// Creating a constructor
	public Task03() {

		// Setting the layout.
		setLayout(new GridLayout(2, 5));

		// Adding buttons in the frame.
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

		// Adding action listener to the buttons.
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
		setLocation(450, 300);
		setTitle("Task 3");
		setSize(500, 150);

	}

	public static void main(String[] args) {
		// Calling constructor
		new Task03();
	}

	/**
	 * Inner class
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// Going through an array of buttons
			for (int i = 0; i < jbuttonArray.length; i++) {
				// If the position of the pressed button in the array is higher
				// or equal than 5 than the text of the button is added to the
				// counter position in string array, the pressed button is
				// disabled and the button in the button array that is 5
				// position before pressed button is disabled.
				if (e.getSource() == jbuttonArray[i] && i >= 5) {
					jbuttonArray[i].setEnabled(false);
					jbuttonArray[i - 5] = null;
					array[counter] = jbuttonArray[i].getText();
					counter++;
					// If the position of the pressed button in the array is
					// lower than 5 than the text of the button is added to the
					// counter position in string array, the pressed button is
					// disabled and the button in the button array that is 5
					// position after pressed button is disabled.
				} else if (e.getSource() == jbuttonArray[i] && i < 5) {
					jbuttonArray[i].setEnabled(false);
					jbuttonArray[i + 5] = null;
					array[counter] = jbuttonArray[i].getText();
					counter++;
				}
			}
			// If the all places in array are filled it prints array.
			if (counter == 5) {
				JOptionPane.showMessageDialog(null, Arrays.toString(array));
				System.exit(0);
			}
		}
	}
}
