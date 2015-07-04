package ba.bitcamp.homework21.task01;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Task#1 - Adjustable font size
 * 
 * Write a program that has one slider which is the font size. The higher value
 * of the slider corresponds to a larger font. To be presented by the font may
 * have the program printed some letters that are presented in this font.
 * 
 * @author Adis Cehajic
 *
 */
public class Task01 extends JFrame {

	private static final long serialVersionUID = -7683707428503398793L;

	// Declaring main elements.
	private JSlider slider = new JSlider(0, 100, 0);
	private JLabel label = new JLabel("Font check!");
	private int fontSize;

	/**
	 * Constructor
	 */
	public Task01() {

		// Setting the frame layout.
		setLayout(new BorderLayout());

		// Adding the label on the panel and setting the appearance of the
		// label.
		add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Serif", Font.BOLD, fontSize));

		// Adding the slider on the panel and setting the slider.
		add(slider, BorderLayout.SOUTH);

		// Adding change listener on the slider that will set the font size of
		// the label text.
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				fontSize = slider.getValue();
				label.setFont(new Font("Serif", Font.BOLD, fontSize));
			}
		});

		// Setting frame appearance.
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 1");
		setVisible(true);

	}

	public static void main(String[] args) {
		// Calling constructor.
		new Task01();
	}

}
