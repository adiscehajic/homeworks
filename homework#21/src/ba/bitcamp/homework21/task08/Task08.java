package ba.bitcamp.homework21.task08;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Task#8 - Register form
 * 
 * Make a program where the user registers. The user needs to enter the username
 * and twice should enter the password. At the bottom of the screen are two
 * buttons, clear and submit. Clear deletes all information entered from the
 * window. Submit should try to register the user. Registration is not
 * successful when (and why should notify users failed) entered passwords are
 * not the same, when the user name is less than 6 characters when the password
 * is less than 6 characters, and when there is no password at least one number
 * and one special character.
 * 
 * @author Adis Cehajic
 *
 */
public class Task08 extends JFrame {

	private static final long serialVersionUID = 1788825113584408633L;

	// Declaring main elements.
	private JPanel panel = new JPanel();
	private JPanel panelOne = new JPanel();
	private JPanel panelTwo = new JPanel();

	private JButton buttonOne = new JButton("Clear");
	private JButton buttonTwo = new JButton("Submit");

	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JPasswordField passwordRetype = new JPasswordField();

	/**
	 * Constructor
	 */
	public Task08() {

		// Setting the panel borders and layout
		panel.setBorder(BorderFactory.createTitledBorder("Register"));
		panel.setLayout(new BorderLayout());

		// Adding the panelOne on the center of panel and setting the panelOne
		// layout and adding elements on the panel.
		panel.add(panelOne, BorderLayout.CENTER);
		panelOne.setLayout(new GridLayout(3, 2));
		panelOne.add(new JLabel("Username: "));
		panelOne.add(username);
		panelOne.add(new JLabel("Password: "));
		panelOne.add(password);
		panelOne.add(new JLabel("Retype password: "));
		panelOne.add(passwordRetype);

		// // Adding the panelTwo on the south of panel and adding buttonOne and
		// buttonTwo on panelTwo.
		panel.add(panelTwo, BorderLayout.SOUTH);
		panelTwo.add(buttonOne);
		panelTwo.add(buttonTwo);

		// Adding action listener to the buttonOne which clears all text inputed
		// in the fields.
		buttonOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonOne) {
					username.setText("");
					password.setText("");
					passwordRetype.setText("");
				}
			}
		});

		// Adding action listener to the buttonTwo
		buttonTwo.addActionListener(new Action());

		// Adding panel on the frame.
		add(panel);

		// Setting frame appearance.
		setSize(300, 180);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 8");
		setVisible(true);
	}

	private class Action implements ActionListener {

		// Declaring counters that will count special and number characters.
		int counterOne = 0;
		int counterTwo = 0;

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonTwo) {
				String passwordText = String.valueOf(password.getPassword());
				String passwordRetypeText = String.valueOf(passwordRetype
						.getPassword());

				// Calculating if there is special and number characters in
				// inputed password.
				for (int i = 0; i < passwordText.length(); i++) {
					// Calculating if there is special characters in inputed
					// password.
					for (int j = 33; j < 48; j++) {
						char c = (char) j;
						if (passwordText.charAt(i) == c) {
							counterOne++;
						}
					}
					// Calculating if there is number characters in inputed
					// password.
					for (int j = 48; j < 58; j++) {
						char c = (char) j;
						if (passwordText.charAt(i) == c) {
							counterTwo++;
						}
					}
					// Calculating if there is special characters in inputed
					// password.
					for (int j = 58; j < 65; j++) {
						char c = (char) j;
						if (passwordText.charAt(i) == c) {
							counterOne++;
						}
					}
				}

				// Checking if the username length is equal or higher than 6.
				if (username.getText().length() < 6) {
					JOptionPane.showMessageDialog(null,
							"Username has less than 6 characters!");
					username.setText("");
					password.setText("");
					passwordRetype.setText("");
					// Checking if the password length is equal or higher than
					// 6.
				} else if (passwordText.length() < 6) {
					JOptionPane.showMessageDialog(null,
							"Password has less than 6 characters!");
					password.setText("");
					passwordRetype.setText("");
					// Checking if there is special and number characters in
					// inputed password.
				} else if (counterOne == 0 && counterTwo == 0) {
					JOptionPane
							.showMessageDialog(null,
									"Password does not have special characters or numbers!");
					password.setText("");
					passwordRetype.setText("");
					// Checking if there is special characters in inputed
					// password.
				} else if (counterOne == 0) {
					JOptionPane.showMessageDialog(null,
							"Password does not have special characters!");
					password.setText("");
					passwordRetype.setText("");
					// Checking if there is number characters in inputed
					// password.
				} else if (counterTwo == 0) {
					JOptionPane.showMessageDialog(null,
							"Password does not have numbers!");
					password.setText("");
					passwordRetype.setText("");
					// Checking if the inputed passwords are equal.
				} else if (!passwordText.equals(passwordRetypeText)) {
					JOptionPane.showMessageDialog(null,
							"Passwords are not same!");
					password.setText("");
					passwordRetype.setText("");
					// If all conditions are true, registering user and exiting
					// program.
				} else {
					JOptionPane.showMessageDialog(null,
							"You have successfully registered!");
					System.exit(0);
				}
			}
		}
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Task08();
	}
}
