package ba.bitcamp.homework32.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Represents local server that sends message to the client. Message is randomly selected from file that contains
 * messages and than, after creating BitResponse, converted into JSON file. After converting JSON file is sent to the
 * client.
 * 
 * @author Adis Cehajic
 *
 */
public class Server {

	// Declaring constants for port.
	public static final int PORT = 5555;

	public static void main(String[] args) {
		// Declaring variable that will contain random number.
		Random rand = new Random();
		// Declaring the list of strings.
		ArrayList<String> lines = new ArrayList<>();
		// Declaring object mapper.
		ObjectMapper mapper = new ObjectMapper();
		// Declaring server socket.
		ServerSocket server;
		try {
			// Initializing and starting the server socket.
			server = new ServerSocket(PORT);

			while (true) {
				// Declaring socket client and waiting for the client to connect.
				Socket client = server.accept();
				// Declaring reader that will read from file.
				BufferedReader reader = new BufferedReader(new FileReader(new File("files/friendship.txt")));
				// Declaring writer that will send message to the client.
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
				// Declaring string variable.
				String line = "";
				// Reading lines and adding them into file.
				while ((line = reader.readLine()) != null) {
					if (!line.equals("")) {
						lines.add(line);
					}
				}
				// Declaring random number variable and getting one message from list.
				int randomLine = rand.nextInt(lines.size());
				String message = lines.get(randomLine);
				// Creating BitResponse object.
				BitResponse response = new BitResponse(message);
				// Converting and storing BitResponse object into JSON file.
				mapper.writeValue(new File("files/file.json"), response);
				// Declaring reader that will read JSON file.
				BufferedReader readerJson = new BufferedReader(new FileReader(new File("files/file.json")));
				// Sending random message to the client.
				writer.write(readerJson.readLine());
				writer.newLine();
				writer.flush();
				// Closing writer and readers.
				writer.close();
				reader.close();
				readerJson.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
