package client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
	private static int SERVER_PORT = 7890;

	public static void main(String[] args) {
		BufferedReader br;
		PrintWriter out;
		boolean progIsRunning = true;

		// welcome user
		View view = new View();
		view.welcome();

		while(progIsRunning){
			try {
				//input user
				br = new BufferedReader(new InputStreamReader(System.in));
				String input = br.readLine();

				//TODO validate input user

				// connect to server
				Socket client = new Socket(InetAddress.getLocalHost(), SERVER_PORT);
				System.out.println("Connected to Server...");

				//send data to server
				out = new PrintWriter(client.getOutputStream(), true);
				out.println(input);


				//receive data from Server
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String result = br.readLine();
				System.out.println(result);

				//close connection
				client.close();

				//display result to user
				view.result(result);

			} catch (Exception e) {
				System.out.println("Connection to Server failed.");
			}
		}
		//say goodbye to user
		view.goodbye();
	}

}