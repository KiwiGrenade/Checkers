package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChessServer {
    //trzeba poprawic limit na dwoch klientow(wiem jak zrobic) i dodac identyfikator dla uzytkownika(tic tac toe example)
    private static ExecutorService pool = Executors.newFixedThreadPool(2);
    private static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(12345);
        while(true) {
            Socket socket = server.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clients.add(clientHandler);
            pool.execute(clientHandler);
        }
    }
}
