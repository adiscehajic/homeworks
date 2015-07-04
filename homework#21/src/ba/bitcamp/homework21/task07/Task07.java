package ba.bitcamp.homework21.task07;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Task#7 - Circle drawer
 * 
 * Make a program where the user clicking the mouse chooses where to place the
 * circle. Mouse click represents coordinates of the center of the circle. Size
 * of the circle is set over the slider which is at the bottom of the window.
 * When a user increases the value of the slider, then the circle (which is set
 * in the window) increases. At the beginning of the circle is nowhere placed
 * and increasing slider is doing anything.
 * 
 * @author Adis Cehajic
 *
 */
public class Task07 extends JFrame {

	private static final long serialVersionUID = 7599656446076786632L;

	// Declaring main elements and variables.
	private int size = 0;
	private int coordX = -100;
	private int coordY = -100;

	private JPanel panel = new MyPanel();
	private JSlider slider = new JSlider(0, 100, size);

	/**
	 * Constructor
	 */
	public Task07() {

		// Adding mouse listener to the panel that will when mouse is clicked
		// set the coordX and coordY values.
		panel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				coordX = e.getX();
				coordY = e.getY();
			}
		});

		// Adding the slider on the panel.
		panel.add(slider);

		// Adding change listener to the slider that will by changing values set
		// the value of the circle.
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				size = slider.getValue();
			}
		});

		// Adding panel on the frame.
		add(panel);

		// Setting frame appearance.
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Task 7");
		setVisible(true);
	}

	private class MyPanel extends JPanel {

		private static final long serialVersionUID = 4882299690698008303L;

		/**
		 * Draws the circle on the panel.
		 */
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(coordX - size / 2, coordY - size / 2, size, size);
			repaint();
		}
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Task07();
	}
}
