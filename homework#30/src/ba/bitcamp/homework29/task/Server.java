package ba.bitcamp.homework29.task;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Server extends JFrame {

	private static final long serialVersionUID = 8354060577316470630L;

	// Declaring client and server socket.
	private Socket client;
	private ServerSocket server;

	// Declaring elements of frame.
	private JPanel panel = new JPanel();
	private JPanel areaPanel = new JPanel();
	private JPanel textPanel = new JPanel();
	private JTextArea area = new JTextArea();
	private JScrollPane scroll = new JScrollPane(area);
	private JTextField text = new JTextField();

	/**
	 * Constructor of server that enables server to receive and send message to
	 * the client.
	 */
	public Server() {
		// Setting the layout of main panel.
		panel.setLayout(new BorderLayout());

		// Setting the appearance of the panel that contains text area.
		areaPanel.setLayout(new BorderLayout());
		areaPanel.setBorder(BorderFactory.createTitledBorder("Chat"));
		areaPanel.add(scroll);

		// Setting the scroll pane and text area.
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		area.setEditable(false);
		area.setLineWrap(true);
		area.setFont(new Font("Serif", Font.PLAIN, 18));
		area.setBackground(new Color(252, 229, 255));

		// Setting the appearance of the panel that contains text field.
		textPanel.setLayout(new BorderLayout());
		textPanel.setBorder(BorderFactory.createTitledBorder("Input message"));
		textPanel.add(text);

		// Adding the key listener and border on text field.
		text.addKeyListener(new ServerAction());
		text.setFont(new Font("Serif", Font.PLAIN, 18));
		text.setBackground(new Color(252, 229, 255));

		// Adding elements to the main panel.
		panel.add(areaPanel, BorderLayout.CENTER);
		panel.add(textPanel, BorderLayout.SOUTH);

		// Adding main panel to the frame.
		add(panel);

		// Setting the appearance of the frame.
		setSize(450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(300, 150);
		setTitle("Server Chat");
		setVisible(true);

		// Calling method runServer that creates server socket.
		runServer();
	}

	/**
	 * Inner class that implements key listener. It contains method that enables
	 * user to send message when key ENTER is pressed.
	 * 
	 * @author Adis Cehajic
	 *
	 */
	private class ServerAction implements KeyListener {

		/**
		 * Enables server to send message when key ENTER is pressed.
		 */
		public void keyPressed(KeyEvent e) {
			// Sends inputed message to the client when key ENTER is pressed.
			if (e.getKeyCode() == KeyEvent.VK_ENTER
					&& !text.getText().equals("")) {
				try {
					// Declaring writer that will send message.
					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(client.getOutputStream()));
					// Sending message that is inputed into text field.
					writer.write(text.getText());
					writer.newLine();
					writer.flush();
					// Writing sent message in the chat area.
					area.append("Server: " + text.getText() + "\n");
					text.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		public void keyReleased(KeyEvent e) {
		}

		public void keyTyped(KeyEvent e) {
		}
	}

	/**
	 * Creates server socket and enables server to receive messages from
	 * clients.
	 */
	public void runServer() {
		try {
			// Creating server and client socket.
			server = new ServerSocket(1234);
			client = server.accept();
			// Declaring reader that will read messages sent from client.
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			// Declaring string variable that will contain messages sent from
			// client.
			String areaText = "";

			while (true) {
				// Reading sent messages.
				areaText = "Client: " + reader.readLine();
				// Checking if the inputed message contains command.
				if (areaText.indexOf("/open") != -1) {
					// Selecting file with inputed address.
					File file = new File(getAddress(areaText, "/open", 6));
					// Opening file with inputed address.
					Desktop.getDesktop().open(file);
				} else if (areaText.indexOf("/web") != -1) {
					// Opening browser with inputed address.
					Desktop.getDesktop().browse(
							new URL(getAddress(areaText, "/web", 5)).toURI());
				} else if (areaText.indexOf("/delete") != -1) {
					// Selecting file with inputed address.
					File file = new File(getAddress(areaText, "/delete", 8));
					// Deleting file with inputed address.
					file.delete();
				} else if (areaText.indexOf("/list") != -1) {
					// Selecting file with inputed address.
					File file = new File(getAddress(areaText, "/list", 6));
					// Printing the list of directories that are in file with
					// inputed address.
					area.append("Server: " + directories(file) + "\n");
					// Declaring writer that will send message.
					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(client.getOutputStream()));
					// Sending message that contains the list of directories
					// that are in file with inputed address.
					writer.write(directories(file));
					writer.newLine();
					writer.flush();
				} else {
					// Printing the received text on the text area.
					area.append(areaText + "\n");
					area.setCaretPosition(area.getDocument().getLength());
				}
			}
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints file path if the inputed line contains command.
	 * 
	 * @param areaText
	 * @param command
	 * @param index
	 * @return Path of the file.
	 */
	public String getAddress(String areaText, String command, int index) {
		return areaText.substring(areaText.indexOf(command) + index,
				areaText.length());
	}

	/**
	 * Prints the list of directories that are in inputed file.
	 * 
	 * @param file
	 *            - File that contains directories.
	 * @return Array of directories in the file.
	 */
	private String directories(File file) {
		// Declaring an array of files that are in inputed file.
		String[] directories = file.list(new FilenameFilter() {
			// Checking if the file is directorie.
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		// Returning an array of directories.
		return Arrays.toString(directories);
	}

	public static void main(String[] args) {
		// Calling constructor.
		new Server();
	}

}
