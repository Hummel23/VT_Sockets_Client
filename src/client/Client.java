package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class Client {
	private static int SERVER_PORT = 7890;

	public static void main(String[] args) throws IOException {
		BufferedReader br, br2;
		PrintWriter out;
		ValidationService validationService = ValidationService.getInstance();

		// welcome user
		View view = new View();
		view.welcome();

		// connect to server
		Socket client = new Socket(InetAddress.getLocalHost(), SERVER_PORT);
		// System.out.println("Connected to Server...");

		//for user input
		br = new BufferedReader(new InputStreamReader(System.in));

		// for receiving data from Server
		br2 = new BufferedReader(new InputStreamReader(client.getInputStream()));

		//for sending data to server
		out = new PrintWriter(client.getOutputStream(), true);

		String input;

		boolean isValidInput, isConnected = true;
		while (isConnected) {
			try {

				isValidInput = false;

				// input and validation user input
				do {
					input = br.readLine();
					if (validationService.checkInput(input).equals("exit")) {
						view.goodbye();
						isConnected=false;
						client.close();
						break;
					}
					if (validationService.checkInput(input).equals("help")) {
						view.help();
					}
					if (validationService.checkInput(input).equals("")) {
						isValidInput = true;
					} else
						System.out.println(validationService.checkInput(input));
				} while (!isValidInput);

				if (isConnected) {

					// send data to server when input is valid
					out.println(input);

					//receive data from Server
					String result = br2.readLine();

					// display result to user
					view.result(result);
				}

			} catch (Exception e) {
				System.out.println("Connection to Server failed.");
			}

		}
		// close connection
		br.close();
		br2.close();
		out.close();
		client.close();
	}

}