package ba.bitcamp.homeworkWeekend9.task01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents local server that receives message from client. Received message represents path of a file. Afterwards
 * received path of a file is checked. If the file exist server sends client message one, otherwise server sends message
 * zero.
 * 
 * @author Adis Cehajic
 *
 */
public class Server {

	// Declaring constant for port.
	public static final int PORT = 7777;

	public static void main(String[] args) {
		try {
			// Declaring server socket and starting server.
			ServerSocket server = new ServerSocket(PORT);
			// Declaring socket client and waiting for the client to connect.
			Socket client = server.accept();
			// Declaring reader that will read sent message.
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// Declaring writer that will write received message.
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			// Creating file with received path.
			File file = new File(reader.readLine());
			// Checking if the file exist and sending an adequate message.
			if (file.exists()) {
				writer.write("1");
				writer.newLine();
				writer.flush();
			} else {
				writer.write("0");
				writer.newLine();
				writer.flush();
			}
			// Closing writer, client and server.
			writer.close();
			client.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
