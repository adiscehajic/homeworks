package ba.bitcamp.homework21.task05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Task#5 - RGB window
 * 
 * Make a program that has three sliders. Each slider is responsible for one of
 * the three RGB colors. During the changing value of the slider should be put
 * paint to give a window (panel) in the selected color.
 * 
 * @author Adis Cehajic
 *
 */
public class Task05 extends JFrame {

	private static final long serialVersionUID = 3989907990592898084L;

	// Declaring main elements.
	private JPanel panel = new JPanel();

	private JLabel redLabel = new JLabel("Red   ");
	private JLabel greenLabel = new JLabel("Green");
	private JLabel blueLabel = new JLabel("Blue  ");

	JSlider redSlider;
	JSlider greenSlider;
	JSlider blueSlider;

	// Declaring variables.
	private int red;
	private int green;
	private int blue;

	/**
	 * Constructor
	 */
	public Task05(int width, int height) {

		// Adding the label on the panel and setting the appearance of the
		// label.
		redLabel.setHorizontalAlignment(JLabel.CENTER);
		redLabel.setFont(new Font("Serif", Font.BOLD, 18));
		greenLabel.setHorizontalAlignment(JLabel.CENTER);
		greenLabel.setFont(new Font("Serif", Font.BOLD, 18));
		blueLabel.setHorizontalAlignment(JLabel.CENTER);
		blueLabel.setFont(new Font("Serif", Font.BOLD, 18));
		
		// Declaring dimension of slider
		int sliderHeigth = height / 4;
		Dimension dimension = new Dimension(width - 90, sliderHeigth);

		// Adding the sliders on the panel, calling method initSlider and
		// setting the appearance of the sliders.
		redSlider = new JSlider(0, 255, red);
		redSlider.setBackground(new Color(red, green, blue));
		initSlider(redSlider, "Red", dimension);
		greenSlider = new JSlider(0, 255, green);
		greenSlider.setBackground(new Color(red, green, blue));
		initSlider(greenSlider, "Green", dimension);
		blueSlider = new JSlider(0, 255, blue);
		blueSlider.setBackground(new Color(red, green, blue));
		initSlider(blueSlider, "Blue", dimension);
		
		// Setting the panel appearance.
		panel.setBackground(new Color(red, green, blue));

		// Adding elements on panelOne and panelTwo
		panel.add(redLabel);
		panel.add(redSlider);

		panel.add(greenLabel);
		panel.add(greenSlider);

		panel.add(blueLabel);
		panel.add(blueSlider);

		// Adding panel on the frame.
		add(panel);

		// Setting frame appearance.
		setTitle("Task 5");
		setSize(600, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	/**
	 * Sets the appearance of the sliders and adds change listener to the
	 * slider.
	 * 
	 * @param slider
	 *            - Slider that user want to set.
	 * @param name
	 *            - Name of the slider.
	 */
	private void initSlider(JSlider slider, String name, Dimension d) {
		// Setting the appearance of the slider.
		slider.setName(name);
		slider.setValue(0);
		slider.setPreferredSize(d);
		slider.setMajorTickSpacing(50);
		slider.setMinorTickSpacing(25);
		slider.setPaintTicks(true);

		// Adding change listener which sets values of the declared variables on
		// the slider values.
		slider.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				JSlider changed = (JSlider) e.getSource();
				
				switch (name) {
				case "Red":
					red = changed.getValue();
					break;
				case "Green":
					green = changed.getValue();
					break;
				case "Blue":
					blue = changed.getValue();
					break;
				}
				updatePanel();
				updateSliderBackground();
			}
		});
		repaint();
	}

	/**
	 * Sets the background color on the selected color.
	 */
	private void updatePanel() {
		panel.setBackground(new Color(red, green, blue));
		redLabel.setForeground(new Color(255 - red, 255 - green, 255 - blue));
		greenLabel.setForeground(new Color(255 - red, 255 - green, 255 - blue));
		blueLabel.setForeground(new Color(255 - red, 255 - green, 255 - blue));
	}

	/**
	 * Sets the background color on the selected color.
	 */
	private void updateSliderBackground(){
		redSlider.setBackground(new Color(red, green, blue));
		greenSlider.setBackground(new Color(red, green, blue));
		blueSlider.setBackground(new Color(red, green, blue));
	}
	
	public static void main(String[] args) {
		// Calling constructor.
		new Task05(600, 300);
	}

}
