package Server;

import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChessServer {
    private static ExecutorService pool = Executors.newFixedThreadPool(2);
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(12345);
        while(true) {
            Board board = new Board(8);
            pool.execute(new ClientHandler(server.accept(),board,'W'));
            pool.execute(new ClientHandler(server.accept(),board,'B'));
        }
    }
}
