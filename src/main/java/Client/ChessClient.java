package Client;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//czy dziala input
public class ChessClient {
    public static void main(String[] args) throws Exception {
        String serverAddress = "127.0.0.1";
        try (Socket socket = new Socket(serverAddress, 59898)) {
            Scanner scanner = new Scanner(System.in);
            Scanner input = new Scanner(socket.getInputStream());
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            boolean isGameOngoing = true;
            while (isGameOngoing) {
                String request = scanner.nextLine();
                output.println(request);

                String serverResponse = input.nextLine();
                switch (serverResponse) {
                    case "MOVE" -> {
                        System.out.println("Move: " + request.substring(1));
                    }
                    case "QUI" -> {
                        System.out.println("See ya sun!");
                        isGameOngoing = false;
                    }
                    case "INVALID_REQUEST" -> {
                        System.out.println("Requested action is invalid! Try again!");
                    }
                }
            }
        }
    }
}
