package ba.bitcamp.homework31.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents local server that receives message from client. Received message
 * contains URL link and name of the URL link. Afterwards received message is
 * saved in the file.
 * 
 * @author Adis Cehajic
 *
 */
public class Server {

	// Declaring constant for port.
	public static final int PORT = 9999;

	public static void main(String[] args) {

		try {
			// Declaring server socket and starting server.
			System.out.println("Server started.");
			ServerSocket server = new ServerSocket(PORT);
			// Declaring socket client and waiting for the client to connect.
			System.out.println("Listening for a client...");
			Socket client = server.accept();
			System.out.println("Client found.");

			// Declaring reader that will read sent message.
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			// Declaring writer that will write received message into the file.
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					"public/link.txt"), true));

			// Writing received message into the file.
			writer.write(reader.readLine());
			writer.newLine();
			// Closing the writer.
			writer.close();
			// Closing the reader.
			reader.close();
			// Closing the server.
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
