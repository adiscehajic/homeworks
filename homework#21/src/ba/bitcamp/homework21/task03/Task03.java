package ba.bitcamp.homework21.task03;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Task#3 - Login
 * 
 * Write a program that gives the user the ability to log in. Two information
 * should be entered, such as username and password. The exact combination is
 * "Mujo" and the password "1234". Let the program does not contain a button that
 * the user logs on. Instead let the Enter key (when the user enters a password)
 * is used as a substitute. If the user successfully logs on then exit the
 * application, and if it is wrong then throw a small window that says that we
 * should not or user name or password.
 * 
 * @author Adis Cehajic
 *
 */
public class Task03 extends JFrame {

	private static final long serialVersionUID = 4357290275678898757L;

	// Declaring main elements.
	private JTextField name = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JLabel labelName = new JLabel("Username: ");
	private JLabel labelPassword = new JLabel("Password: ");

	/**
	 * Constructor
	 */
	public Task03() {

		// Setting the frame layout.
		setLayout(new GridLayout(2, 2));

		// Adding key listeners to the textfield and passwordfield
		name.addKeyListener(new Key());
		password.addKeyListener(new Key());

		// Adding elements on the frame.
		add(labelName);
		add(name);
		add(labelPassword);
		add(password);

		// Setting frame appearance.
		setSize(300, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 3");
		setVisible(true);
	}

	private class Key extends KeyAdapter {

		/**
		 * Checks if the inputed username and password are equal to the correct
		 * username and password.
		 */
		public void keyPressed(KeyEvent e) {
			// After the key ENTER is pressed checks if the inputed username and
			// password are correct.
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				// Declaring correct username and password.
				String correctName = "Mujo";
				String correctPassword = "1234";
				String nameString = String.valueOf(name.getText());
				String passwordString = String.valueOf(password.getPassword());

				// Checking are the inputed username and password equal to the
				// correct values.
				if (nameString.equals(correctName)
						&& passwordString.equals(correctPassword)) {
					System.exit(0);
				} else if (!nameString.equals(correctName)
						&& !passwordString.equals(correctPassword)) {
					JOptionPane.showMessageDialog(null,
							"Wrong username and password!");
				} else if (!nameString.equals(correctName)) {
					JOptionPane.showMessageDialog(null, "Wrong username!");
				} else if (!passwordString.equals(correctPassword)) {
					JOptionPane.showMessageDialog(null, "Wrong password!");
				}
			}
		}
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Task03();
	}

}
