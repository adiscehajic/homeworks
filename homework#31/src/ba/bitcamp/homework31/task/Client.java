package ba.bitcamp.homework31.task;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;

/**
 * Represents client that connects and after input sends message to the server.
 * Message contains two parts. First part needs to be in form of URL link and
 * second represents the name of the URL link.
 * 
 * @author Adis Cehajic
 *
 */
public class Client {

	// Declaring constants for host and port.
	public static final String HOST = "localhost";
	public static final int PORT = 9999;

	public static void main(String[] args) {

		try {
			// Declaring client socket that connects to the local server.
			Socket client = new Socket(HOST, PORT);
			// Declaring writer that will send inputed message to the server.
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					client.getOutputStream()));
			// Declaring scanner that will enable client to input message.
			Scanner input = new Scanner(System.in);

			while (true) {
				try {
					// Inputing first part of message. If the inputed message is
					// not URL link, client needs again to input message that is
					// URL link.
					System.out
							.println("Please insert link address (eg. http://google.ba or www.google.ba): ");
					// Checking if the inputed message is URL link.
					URL url = validateURL(input.nextLine());
					// Saving first part of message.
					writer.write(url + " ");
					// Inputing and saving second part of message.
					System.out
							.println("Please insert name of link (eg. Google): ");
					writer.write(input.nextLine());
					break;
				} catch (MalformedURLException e) {
					// If the first part of inputed message is not URL link
					// prints message.
					System.out.println("Wrong link address format!");
				}
			}
			// Writing new line.
			writer.newLine();
			// Closing writer and sending message to the server.
			writer.close();
			// Closing client.
			client.close();
			// Closing scanner.
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checking if the inputed string is URL link. String can be in format
	 * http://www.url.com or www.url.com. If the inputed string is validate
	 * returns URL of inputed string otherwise throws exception.
	 * 
	 * @param url
	 *            - String that represents URL link.
	 * @return URL that represents inputed string.
	 * @throws MalformedURLException
	 *             If the inputed string is not validate URL link.
	 */
	public static URL validateURL(String url) throws MalformedURLException {
		URL link;
		if (url.contains("http")) {
			link = new URL(url);
		} else if (url.contains("www")) {
			link = new URL("http://" + url);
		} else {
			link = new URL(url);
		}
		return link;
	}

}
