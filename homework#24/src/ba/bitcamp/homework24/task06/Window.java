package ba.bitcamp.homework24.task06;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {

	private static final long serialVersionUID = 6054081356029392845L;

	// Declaring element JPanel.
	private JPanel panel = new MyPanel();

	// Declaring static field.
	private static KeyListener keyList;

	// Declaring variables that represent coordinates of circle.
	private int x = 20;
	private int y = 20;

	// Declaring constants.
	private static final int RIGHT = 5;
	private static final int LEFT = -5;
	private static final int UP = -5;
	private static final int DOWN = 5;

	/**
	 * Constructor
	 */
	public Window() {

		// Adding JPanel to the JFrame and setting appearance.
		add(panel);
		panel.setBorder(BorderFactory.createTitledBorder("Moving space"));

		// Creating and adding key listener that moves circle.
		keyList = new KeyListener() {

			/**
			 * Enables motion of circle.
			 */
			public void keyPressed(KeyEvent e) {
				// Moves right.
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					if (x < getWidth() - 75) {
						x += RIGHT;
					}
					// Moves left.
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					if (x > 5) {
						x += LEFT;
					}
					// Moves up.
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (y > 15) {
						y += UP;
					}
					// Moves down.
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (y < getHeight() - 95) {
						y += DOWN;
					}
				}
				panel.repaint();
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}

		};

		addKeyListener(keyList);

		// Setting JFrame appearance.
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 6");
		setVisible(true);
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Window();
	}

	/**
	 * Inner class that extends JPanel, where circle will be drawn.
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class MyPanel extends JPanel {

		private static final long serialVersionUID = -1214772869247474779L;

		// Drawing circle.
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.fillOval(x, y, 50, 50);
		}
	}

}
