package Server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ChessServer {
    public static void main(String[] args) throws Exception {
        try (ServerSocket listener = new ServerSocket(59898)){
            Executor pool = Executors.newFixedThreadPool(2);
            while (true) {
                pool.execute(new Game(listener.accept()));
            }
        }
    }

    private static class Game implements Runnable {
        private Socket socket;

        Game(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Connected: " + socket);
            try {
                Scanner input = new Scanner(socket.getInputStream());
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                while (input.hasNextLine()) {
                    //output command from client
                    System.out.println(input.nextLine());
                    switch(input.nextLine())
                    {
                        case "w": {
                            output.print("WINNER");
                            break;
                        }
                        case "l": {
                            output.print("LOSER");
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + socket);
            } finally {
                try {
                    socket.close();
                } catch (Exception e) {}
                System.out.println("Closed: " + socket);
            }
        }
    }
}
