package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChessClient {
    public static void main(String[] args) throws Exception {
        String serverAddress = "127.0.0.1";
        try (Socket socket = new Socket(serverAddress, 59000)) {
            Scanner scanner = new Scanner(System.in);
            Scanner input = new Scanner(socket.getInputStream());
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            while (scanner.hasNextLine()) {
                output.println(scanner.nextLine());
                System.out.println(input.nextLine());
            }
        }
    }
}
