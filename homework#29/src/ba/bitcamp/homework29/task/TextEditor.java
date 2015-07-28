package ba.bitcamp.homework29.task;

import javax.swing.JFrame;

/**
 * Class TextEditor represents text editor that enables user to open and edit a
 * file and to create new file.
 * 
 * @author Adis Cehajic
 *
 */
public class TextEditor extends JFrame {

	private static final long serialVersionUID = -1028731968947571328L;

	/**
	 * Constructor.
	 */
	public TextEditor() {

		// Declaring object panel.
		EditorPanel panel = new EditorPanel();

		// Adding panel to the frame.
		add(panel);

		// Setting the appearance of the frame.
		setSize(600, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Text Editor");
		setVisible(true);
	}

	public static void main(String[] args) {
		// Calling constructor.
		new TextEditor();
	}

}
