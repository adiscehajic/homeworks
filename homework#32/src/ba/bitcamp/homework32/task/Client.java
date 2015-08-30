package ba.bitcamp.homework32.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Represents client that connects to the local server and after connecting receives message from the server. Received
 * message is in form of JSON and after receiving is stored in client JSON file. Than received message is converted into
 * BitResponse object and added to the list.
 * 
 * @author Adis Cehajic
 *
 */
public class Client {

	// Declaring constants for host and port.
	public static final String HOST = "localhost";
	public static final int PORT = 5555;

	public static void main(String[] args) {
		// Declaring object mapper.
		ObjectMapper mapper = new ObjectMapper();
		// Declaring the list of BitResponse objects.
		ArrayList<BitResponse> responses = new ArrayList<>();

		try {
			// Declaring client socket that connects to the local server.
			Socket client = new Socket(HOST, PORT);
			// Declaring a reader that will read received messages from server.
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// Declaring writer that will save received message into JSON file.
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("files/received.json"), true));
			// Writing into JSON file and closing writer.
			writer.write(reader.readLine());
			writer.newLine();
			writer.close();
			// Declaring reader that will read received JSON file.
			BufferedReader readerJson = new BufferedReader(new FileReader(new File("files/received.json")));
			// Reading JSON file.
			while (readerJson.ready()) {
				// Creating BitResponse object from read JSON file line and adding it to list of BitResponse objects.
				BitResponse response = mapper.readValue(readerJson.readLine(), BitResponse.class);
				responses.add(response);
			}
			// Closing reader and client.
			readerJson.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
