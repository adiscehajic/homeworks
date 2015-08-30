package ba.bitcamp.homework33.task02;

import javax.swing.JFrame;

/**
 * Represents JFrame that contains main panel on which are image and button. Image is opened in positive form. By
 * clicking on the button image is changed in negative form. And by clicking again image is returned to the positive
 * form.
 * 
 * @author Adis Cehajic
 *
 */
public class PictureChanger extends JFrame {

	private static final long serialVersionUID = 8216337552924827342L;

	/**
	 * Constructor that opens main JFrame.
	 */
	public PictureChanger() {

		// Declaring panel that contains main elements.
		ChangerGui panel = new ChangerGui();

		// Adding panel to the frame.
		add(panel);

		// Setting the appearance of the frame.
		setSize(panel.getImage().getWidth(), panel.getImage().getHeight());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Picture changer");
		setResizable(false);
		setVisible(true);
	}

	public static void main(String[] args) {
		// Calling constructor.
		new PictureChanger();
	}
}
