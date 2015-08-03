package ba.bitcamp.homeworkWeekend9.task04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Represents HTTP server socket that can receive image file from client and can print HTML file on browser. When client sends
 * image file HTTP server saves image file and puts link to received image file on browser. When client clicks link it
 * opens image file in browser.
 * 
 * @author Adis Cehajic
 *
 */
public class HttpServer {

	// Declaring constant that represents http server port.
	public static final int PORT = 8888;

	public static void main(String[] args) {
		// Declaring list of files.
		ArrayList<File> files = new ArrayList<File>();
		// Declaring server socket.
		ServerSocket server;
		try {
			// Initializing server socket.
			server = new ServerSocket(PORT);

			while (true) {
				// Declaring client socket.
				Socket client = server.accept();
				// Declaring reader that reads message from client.
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				// Declaring string variable that will save first received line from client.
				String line = "";

				try {
					// Reading first line and saving it in string variable.
					line = reader.readLine();
					// Checking if the read line contains GET. If the line contains word GET it means that client wants
					// to access
					// HTML server from browser.
					if (line.contains("GET")) {
						// Declaring array of strings that contains all words from string variable.
						String[] get = line.split(" ");
						// Declaring string variable that contains clients requested route in browser.
						String requestRoute = get[1];
						// If the requested route is / opening main page.
						if (requestRoute.equals("/") || requestRoute.equals("/favicon.ico")) {
							// Declaring reader that reads HTML file.
							BufferedReader htmlReader = new BufferedReader(new FileReader(new File("index.html")));
							// Declaring writer that will write string variable on local WEB site.
							BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(
									client.getOutputStream()));
							// Declaring string that will contain all read HTML data.
							String htmlText = "";
							// Reading from HTML file.
							while (htmlReader.ready()) {
								htmlText += htmlReader.readLine();
							}
							// Going trough list of received files and adding them to web page.
							for (File f : files) {
								htmlText += "<h3 align='center'><a href = /" + f.toString() + ">"
										+ f.getName().substring(0, 11) + "</a></h3>";
							}
							// Adding the HTML code to the string variable.
							htmlText += "</body></html>";
							// Writing string variable on local WEB site and closing writer.
							htmlWriter.write(htmlText);
							htmlWriter.newLine();
							htmlWriter.close();
							htmlReader.close();
							// If the requested route is equal to the name of the image file, opens wanted image file in
							// browser.
						} else {
							// Declaring variable that will contain name of the wanted file.
							String fileName = requestRoute.substring(1);
							// Declaring stream that will send selected image on browser.
							OutputStream clientWriter = client.getOutputStream();
							// Declaring stream that will read from selected image file.
							FileInputStream clientReader = new FileInputStream(new File(fileName));
							// Declaring an array of bytes that will contain image.
							byte[] buffer = new byte[1024];
							int readBytes1;
							// Reading image file and sending it on browser.
							while ((readBytes1 = clientReader.read(buffer, 0, buffer.length)) > 0) {
								clientWriter.write(buffer, 0, readBytes1);
							}
							// Closing streams.
							clientWriter.close();
							clientReader.close();
						}
						// Checking if the read line contains PUT. If the line contains word PUT it means that client
						// wants to send
						// HTML server image file.
					} else if (line.contains("PUT")) {
						// Declaring string variables that contain present date and time.
						String date = Calendar.getInstance().getTime() + "";
						String time = date.split(" ")[3];
						// Declaring string variable that represents name of received file.
						String name = "image" + time.split(":")[0] + time.split(":")[1] + time.split(":")[2];
						// Declaring stream that will receive stream from client.
						InputStream is = client.getInputStream();
						// Creating new file.
						File file = new File(name + ".jpg");
						// Declaring stream that will put received streams into file.
						FileOutputStream fileSave = new FileOutputStream(file);
						// Declaring an array of bytes that will contain image file.
						byte[] array = new byte[1024];
						int readBytes;
						// Reading received streams and saving them into image file.
						while ((readBytes = is.read(array, 0, 1024)) > 0) {
							fileSave.write(array, 0, readBytes);
						}
						// Closing stream.
						is.close();
						fileSave.close();
						// Adding the received image file into an list of files.
						files.add(file);
					}
				} catch (NullPointerException e) {
					System.out.println("Null");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
