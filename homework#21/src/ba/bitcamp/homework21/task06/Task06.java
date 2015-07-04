package ba.bitcamp.homework21.task06;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * Task#6 - Countdown
 * 
 * Make a program where the user enters the value of time in seconds. Then the
 * user will press the button to start the countdown. This countdown will be
 * presented in this window. When the counter reaches zero stop the clock and
 * wait to reenter the time.
 * 
 * @author Adis Cehajic
 *
 */
public class Task06 extends JFrame {

	private static final long serialVersionUID = 6661846761469662967L;

	// Declaring main elements.
	private JLabel label = new JLabel();
	private JTextField value = new JTextField();
	private JButton button = new JButton("Start");
	private Timer timer;

	// Declaring variable.
	private int number;

	/**
	 * Constructor
	 */
	public Task06() {

		// Setting the frame layout.
		setLayout(new GridLayout(3, 1));

		// Setting the timer and adding action listener that will countdown the
		// time and stop when time reaches zero.
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (number <= 0) {
					timer.stop();
				} else {
					number--;
					label.setText(String.valueOf(number));
				}
			}
		});

		// Adding the label on the panel and setting the appearance of the
		// label.
		add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Serif", Font.PLAIN, 20));

		// Adding the textfield on the panel and setting the appearance of the
		// textfield.
		add(value);
		value.setHorizontalAlignment(JTextField.CENTER);
		value.setFont(new Font("Serif", Font.PLAIN, 20));

		// Adding the button on the panel, setting the appearance of the
		// button and adding action listener to the button that will start the
		// countdown.
		add(button);
		button.setFont(new Font("Serif", Font.PLAIN, 20));
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					try {
						number = Integer.parseInt(value.getText());
						label.setText(String.valueOf(number));
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(null,
								"You have inputed wrong number format!");
					}
					timer.start();
				}
			}
		});

		// Setting frame appearance.
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 3");
		setVisible(true);
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Task06();
	}

}
