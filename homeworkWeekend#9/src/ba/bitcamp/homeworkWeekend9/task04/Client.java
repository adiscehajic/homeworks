package ba.bitcamp.homeworkWeekend9.task04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Represents the client socket which first sends HTTP server message PUT, so that server knows that he will receive
 * image file from client. Than client sends server image file.
 * 
 * @author Adis Cehajic
 *
 */
public class Client {
	// Declaring constants for host and port.
	public static final int PORT = 8888;
	public static final String HOST = "localhost";

	public static void main(String[] args) {
		try {
			// Declaring client socket that connects to the local server.
			Socket client = new Socket(HOST, PORT);
			// Declaring writer that will send message to the server.
			BufferedWriter write = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
			// Sending message to the client.
			write.write("PUT");
			write.newLine();
			write.flush();
			// Declaring stream that will send selected image to the server.
			OutputStream os = client.getOutputStream();
			// Declaring stream that will read from selected image file.
			FileInputStream fileStream = new FileInputStream(new File("image.jpg"));
			// Declaring an array of bytes that will contain image.
			byte[] array = new byte[1024];
			int readBytes;
			// Reading image file and sending it to the server.
			while ((readBytes = fileStream.read(array, 0, 1024)) > 0) {
				os.write(array, 0, readBytes);
			}
			// Closing streams.
			fileStream.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
