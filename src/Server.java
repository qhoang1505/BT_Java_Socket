import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Server started.");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMsg;
                while ((clientMsg = in.readLine()) != null) {
                    System.out.println("Client: " + clientMsg);

                    BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
                    System.out.print("Server: ");
                    String serverMsg = userInput.readLine();
                    out.println(serverMsg);

                    System.out.println("Sent message to client: " + serverMsg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
