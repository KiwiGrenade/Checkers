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
            while (scanner.hasNextLine()) {
                output.println(scanner.nextLine());
                switch (input.nextLine())
                {
                    case "WINNER": {
                        System.out.println("You won! Congratulations!");
                        isGameOngoing = false;
                        break;
                    }
                    case "LOSER": {
                        System.out.println("You lost! Game Over!");
                        isGameOngoing = false;
                        break;
                    }
                }
            }
        }
    }
}
