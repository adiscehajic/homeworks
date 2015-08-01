package ba.bitcamp.homeworkWeekend8.task;

import javax.swing.JFrame;

public class Main extends JFrame {

	private static final long serialVersionUID = 3142279124883352376L;

	public Main() {

		FileAllocator panel = new FileAllocator();

		add(panel);

		setSize(1080, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("File Allocator");
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Main();
	}

}
