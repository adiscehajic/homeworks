package ba.bitcamp.homework31.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Represents HTTP server that reads HTML code from the HTML file and URL links
 * and their names from the TXT file and prints it on local WEB site.
 * 
 * @author Adis Cehajic
 *
 */
public class HttpServer {

	// Declaring constant for port.
	public static final int PORT = 7777;

	public static void main(String[] args) {

		// Declaring server socket.
		ServerSocket server;
		try {
			// Initializing server socket.
			server = new ServerSocket(PORT);

			while (true) {
				// Declaring client socket.
				Socket client = server.accept();
				// Declaring reader that reads HTML file.
				BufferedReader reader = new BufferedReader(new FileReader(
						new File("public/index.html")));
				// Declaring string that will contain all read data.
				String fileText = "";
				// Reading from HTML file.
				while (reader.ready()) {
					fileText += reader.readLine();
				}
				// Declaring reader that reads TXT file that contains all URL
				// links.
				BufferedReader fileReader = new BufferedReader(new FileReader(
						new File("public/link.txt")));

				while (fileReader.ready()) {
					// Reading TXT file and saving it into created string
					// variable.
					String line = fileReader.readLine();
					fileText += "<h3 align='center'><a href = "
							+ line.split(" ")[0] + ">" + line.split(" ")[1]
							+ "</a></h3>";
				}
				// Adding the HTML code to the string variable.
				fileText += "</body></html>";

				// Declaring writer that will write string variable on local WEB
				// site.
				BufferedWriter writer = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));

				// Writing string variable on local WEB site and closing
				// writer..
				writer.write(fileText);
				writer.newLine();
				writer.close();
				// Closing readers.
				reader.close();
				fileReader.close();
				// Closing client.
				client.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
