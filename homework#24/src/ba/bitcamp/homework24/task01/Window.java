package ba.bitcamp.homework24.task01;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = -8667280382202077472L;

	// Declaring element JPanel.
	public static JPanel panel = new MyPanel();

	// Declaring variables that represent coordinates of circle and size of
	// JFrame.
	public static int x = 20;
	public static int y = 20;
	public static int width = 800;
	public static int height = 600;

	/**
	 * Constructor.
	 */
	public Window() {

		// Adding JPanel to the JFrame and setting appearance.
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Moving space"));

		// Adding key listener that moves circle.
		addKeyListener(new Motion());

		// Setting JFrame appearance.
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Task 1");
		setVisible(true);
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Window();
	}

}
