import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static int SERVER_PORT = 8080;
    
    public static void main(String[] args) {
        BufferedReader in;
        PrintWriter out;
        
        try {
            // connect to server
            Socket client = new Socket(InetAddress.getLocalHost(), SERVER_PORT);
            System.out.println("Connected to Server...");
            
            //send data to Server
            out = new PrintWriter(client.getOutputStream(), true);
            out.println("hello");
            
            //receive data from Server
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Server sends: " + in.readLine());
            System.out.println("Thanks for the conversation. Bye, bye!");
            
            
        } catch (Exception e) {
            System.out.println("Connection to Server failed.");
        }
    }

}