package ba.bitcamp.homework24.task01;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * Class that extends JPanel, where circle will be drawn.
 * 
 * @author Adis Cehajic
 *
 */
public class MyPanel extends JPanel {

	private static final long serialVersionUID = -3197572062930670423L;

	// Drawing circle.
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillOval(Window.x, Window.y, 50, 50);
	}
}
