package ba.bitcamp.homeworkWeekend6.task04;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task04 extends JFrame {

	private static final long serialVersionUID = 809713437341485242L;

	// Creating buttons and label
	JButton buttonLeft = new JButton("<");
	JButton buttonRight = new JButton(">");
	JButton buttonInsert = new JButton("Insert");
	JButton buttonCharacter = new JButton("Char: ");
	JLabel label = new JLabel("_");

	Random rand = new Random();

	// Creating constructor
	public Task04() {

		// Setting the layout.
		setLayout(new BorderLayout());

		// Adding buttons in the frame.
		add(buttonLeft, BorderLayout.WEST);
		add(buttonRight, BorderLayout.EAST);
		add(buttonInsert, BorderLayout.SOUTH);
		add(buttonCharacter, BorderLayout.NORTH);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);

		// Adding action listener to the buttons.
		buttonCharacter.addActionListener(new Action());
		buttonInsert.addActionListener(new Action());
		buttonLeft.addActionListener(new Action());
		buttonRight.addActionListener(new Action());

		// Setting the frame
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500, 300);
		setTitle("Task 4");
		setSize(400, 200);
	}

	public static void main(String[] args) {
		// Calling constructor
		new Task04();
	}

	private class Action implements ActionListener {

		int min = 97;
		int max = 122;
		private int counter = -1;

		public void actionPerformed(ActionEvent e) {

			// Finding in which place is "_"
			for (int i = 0; i < label.getText().length(); i++) {
				if (label.getText().charAt(i) == '_') {
					counter = i;
				}
			}

			// Setting buttonCharacter
			if (e.getSource() == buttonCharacter) {
				// Putting random letters in the buttonCharacter
				buttonCharacter.setText("Char: "
						+ (char) (rand.nextInt((max - min) + 1) + min));
				// Setting buttonInsert
			} else if (e.getSource() == buttonInsert) {
				if (counter > 0) {
					// If "_" is not on the first place dividing the label text
					// in two parts and adding new letter and then adding all to
					// label text.
					label.setText(label.getText().substring(0, counter)
							+ buttonCharacter.getText().charAt(6)
							+ "_"
							+ label.getText().substring(counter + 1,
									label.getText().length()));
				} else {
					// If "_" is on the first place adding new character on the
					// first place and then adding all to label text.
					label.setText(buttonCharacter.getText().charAt(6)
							+ "_"
							+ label.getText().substring(counter + 1,
									label.getText().length()));
				}
				// Setting buttonLeft
			} else if (e.getSource() == buttonLeft) {
				// Moving "_" left through the label text
				if (counter == label.getText().length() - 1) {
					label.setText(label.getText().substring(0, counter - 1)
							+ "_"
							+ String.valueOf(label.getText().charAt(
									label.getText().length() - 2)));
				} else if (counter > 0) {
					label.setText(label.getText().substring(0, counter - 1)
							+ "_"
							+ String.valueOf(label.getText()
									.charAt(counter - 1))
							+ label.getText().substring(counter + 1,
									label.getText().length()));
				}
				// Setting buttonRight
			} else if (e.getSource() == buttonRight) {
				// Moving "_" right through the label text
				if (counter == 0) {
					label.setText(String.valueOf(label.getText().charAt(1))
							+ "_"
							+ label.getText().substring(counter + 2,
									label.getText().length()));

				} else if (counter < label.getText().length() - 1) {
					label.setText(label.getText().substring(0, counter)
							+ String.valueOf(label.getText()
									.charAt(counter + 1))
							+ "_"
							+ label.getText().substring(counter + 2,
									label.getText().length()));
				}
			}
		}
	}
}
