package ba.bitcamp.homeworkWeekend9.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Represents client that connects and after input sends message that represents path of the file to the server and
 * waits for the message from the server.
 * 
 * @author Adis Cehajic
 *
 */
public class Client {

	// Declaring constants for host and port.
	public static final int PORT = 7777;
	public static final String HOST = "localhost";

	public static void main(String[] args) {
		try {
			// Declaring client socket that connects to the local server.
			Socket client = new Socket(HOST, PORT);
			// Declaring writer that will send inputed message to the server.
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			// Declaring reader that will read message sent from the server.
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// Creating scanner for input of the message.
			Scanner input = new Scanner(System.in);
			// Inputing message that represents path of a file and sending it to the server.
			System.out.println("Insert path of a file: ");
			writer.write(input.nextLine());
			writer.newLine();
			writer.flush();
			// Reading message sent from the server.
			System.out.println(reader.readLine());
			// Closing writer, scanner and client.
			writer.close();
			input.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
