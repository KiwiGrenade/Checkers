package Server;

import Model.Model;

import java.io.*;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChessServer {
    private static final ExecutorService pool = Executors.newFixedThreadPool(2);
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(12345);
        while(true) {
            new Model(8, args[0]);
            pool.execute(new ClientHandler(server.accept(),'W'));
            pool.execute(new ClientHandler(server.accept(),'B'));
        }
    }
}
