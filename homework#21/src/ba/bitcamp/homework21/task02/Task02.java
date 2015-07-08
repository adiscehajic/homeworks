package ba.bitcamp.homework21.task02;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Task#2 - Adjustable font style
 * 
 * Write a program that has two check boxes that represent whether the font is
 * bold and whether the font is italic. In addition, some program includes a
 * button that updates the (refresh) the selected option to a text shown above
 * the check boxes.
 * 
 * @author Adis Cehajic
 *
 */
public class Task02 extends JFrame {

	private static final long serialVersionUID = -2396697234139864843L;

	// Declaring main elements.
	private JLabel label = new JLabel("Font check!");
	private JCheckBox boxOne = new JCheckBox("Bold");
	private JCheckBox boxTwo = new JCheckBox("Italic");
	private JButton button = new JButton("Refresh");

	/**
	 * Constructor
	 */
	public Task02() {

		// Setting the frame layout.
		setLayout(new GridLayout(4, 1));

		// Adding the label on the panel and setting the appearance of the
		// label.
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Serif", Font.PLAIN, 30));

		// Adding the checkboxes on the panel and setting the appearance of the
		// checkboxes.
		boxOne.setHorizontalAlignment(JCheckBox.CENTER);
		boxOne.setFont(new Font("Serif", Font.PLAIN, 20));

		boxTwo.setHorizontalAlignment(JCheckBox.CENTER);
		boxTwo.setFont(new Font("Serif", Font.PLAIN, 20));

		// Adding the button on the panel and setting the appearance of the
		// button.
		button.setHorizontalAlignment(JButton.CENTER);
		button.setFont(new Font("Serif", Font.PLAIN, 20));

		// Adding action listener to the button that changes the label text
		// appearance, depending on selected checkbox.
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					if (boxOne.isSelected() && boxTwo.isSelected()) {
						label.setFont(new Font("Serif",
								Font.ITALIC | Font.BOLD, 30));
					} else if (boxOne.isSelected()) {
						label.setFont(new Font("Serif", Font.BOLD, 30));
					} else if (boxTwo.isSelected()) {
						label.setFont(new Font("Serif", Font.ITALIC, 30));
					} else {
						label.setFont(new Font("Serif", Font.PLAIN, 30));
					}
				}
			}
		});

		// Adding elements on the frame.
		add(label);
		add(boxOne);
		add(boxTwo);
		add(button);

		// Setting frame appearance.
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 2");
		setVisible(true);
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Task02();
	}
}
