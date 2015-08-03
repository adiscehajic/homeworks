package ba.bitcamp.homeworkWeekend9.task03;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 * This class represents GUI application that has one button and one label. Label is at the beginning empty and after
 * each second it receives one letter. Process can be stopped by clicking the button.
 * 
 * @author Adis Cehajic
 *
 */
public class LabelLetters extends JFrame {

	private static final long serialVersionUID = 6315242522137906114L;

	// Declaring main elements.
	private JPanel panel = new JPanel();
	private JLabel label = new JLabel();
	private JButton button = new JButton("Stop");
	private JScrollPane pane = new JScrollPane(label);

	// Declaring thread.
	private FirstThread t;
	// Declaring boolean variable that will determine if the thread is started or stopped.
	private boolean isRunning = true;

	// Declaring constants that represent first and last letter.
	public static final int A_LETTER = 97;
	public static final int Z_LETTER = 123;

	/**
	 * Constructor.
	 */
	public LabelLetters() {
		// Initializing thread.
		t = new FirstThread();
		// Starting the thread.
		t.start();

		// Adding the action listener to the button. If the button is clicked it changes the value of boolean variable
		// to false.
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isRunning = false;
			}
		});

		// Setting the layout of the panel.
		panel.setLayout(new BorderLayout());
		// Setting the label.
		label.setHorizontalAlignment(SwingConstants.CENTER);
		// Adding label and button on the panel.
		panel.add(pane);
		panel.add(button, BorderLayout.SOUTH);
		// Adding panel on the frame.
		add(panel);

		// Setting the appearance of the frame.
		setSize(300, 150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Label Letters");
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// Calling constructor.
		new LabelLetters();
	}

	/**
	 * Inner class that extends thread class. When the thread is started it adds on label one letter after one second.
	 * If the added letter is last letter it starts from the beginning.
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class FirstThread extends Thread {

		public void run() {
			// Declaring string variable that will contain letters.
			String s = "";
			// Declaring variable that represent first letter.
			int letter = A_LETTER;
			// Adding one letter to the string variable and changing the letter while boolean variable is true.
			while (isRunning && letter <= Z_LETTER) {
				s += (char) letter++;
				// Setting the string variable as the text of the label.
				label.setText(s);
				// Checking if the letter is last letter.
				if (letter == Z_LETTER) {
					letter = A_LETTER;
				}
				// Stopping thread for one second.
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
