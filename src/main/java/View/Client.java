package View;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.*;
import java.net.Socket;

/**
 * Klasa odpowiedzialna za klienta i jego komunikacje z serwerem
 */
public class Client {

    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

    /**
     * Tworzy klienta i jego droge komunikacji
     * @param socket klient
     */
    public Client(Socket socket){
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }catch (IOException e){
            System.out.println("Error creating client");
            e.printStackTrace();
            closeEverything();
        }
    }

    /**
     * Przesylanie wiadomosci do serwera
     * @param messageToServer wiadomosc do serwera
     */
    public void sendMessageToServer(String messageToServer){
        try {
            bufferedWriter.write(messageToServer);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
            closeEverything();
        }
    }

    /**
     * Odbiera i obsluguje wykonanie komendy wyslanej przez serwer
     * @param vb Element GUI na ktory ma wplyw wiadomosc z serwera
     * @param gpCheckerboard Element GUI na ktory ma wplyw wiadomosc z serwera
     */
    public void receiveMessageFromServer(VBox vb, GridPane gpCheckerboard){
        Runnable runnable = () -> {
            while (socket.isConnected()){
                try {
                    String messageFromServer = bufferedReader.readLine();
                    //System.out.println("Server message: " + messageFromServer);
                    if(messageFromServer.startsWith("0")) {
                        CheckersController.drawCheckers(vb, gpCheckerboard, messageFromServer);
                    }
                    else if(messageFromServer.startsWith("M")){
                        CheckersController.printWaitingMSG(vb);
                    }
                    else if(messageFromServer.startsWith("B")){
                        CheckersController.rotateForBlack(gpCheckerboard);
                    }
                    else if(messageFromServer.startsWith("P") || messageFromServer.startsWith("L")){
                        CheckersController.winOrLose(vb, gpCheckerboard, messageFromServer);
                    }
                    else if(messageFromServer.startsWith("E")){
                        CheckersController.opponentLeft(vb);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("Error receiving message from server");
                    closeEverything();
                    break;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Zamyka polaczenie klienta z serwerem
     */
    public void closeEverything(){
        try {
            if(bufferedWriter!=null){
                bufferedWriter.close();
            }
            if(socket!=null){
                socket.close();
            }
            if(bufferedReader!=null){
                bufferedReader.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

