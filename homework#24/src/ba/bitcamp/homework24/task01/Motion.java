package ba.bitcamp.homework24.task01;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Class that implements KeyListener, which will enable motion of circle around
 * the JFrame.
 * 
 * @author Adis Cehajic
 *
 */
public class Motion extends JFrame implements KeyListener {

	private static final long serialVersionUID = 7266563173420529875L;

	// Declaring constants.
	private static final int RIGHT = 5;
	private static final int LEFT = -5;
	private static final int UP = -5;
	private static final int DOWN = 5;

	/**
	 * Enables motion of circle.
	 */
	public void keyPressed(KeyEvent e) {
		// Moves right.
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (Window.x < Window.width - 60) {
				Window.x += RIGHT;
			}
			// Moves left.
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			if (Window.x > 5) {
				Window.x += LEFT;
			}
			// Moves up.
		} else if (e.getKeyCode() == KeyEvent.VK_UP) {
			if (Window.y > 15) {
				Window.y += UP;
			}
			// Moves down.
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if (Window.y < Window.height - 85) {
				Window.y += DOWN;
			}
		}
		Window.panel.repaint();
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

}
