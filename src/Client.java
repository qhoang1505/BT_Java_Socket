import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5555);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String serverMsg;
            while (true) {
                System.out.print("Client: ");
                String clientMsg = userInput.readLine();
                out.println(clientMsg);

                serverMsg = in.readLine();
                System.out.println("Server: " + serverMsg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
