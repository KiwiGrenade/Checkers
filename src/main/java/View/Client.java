package View;

import javafx.scene.layout.GridPane;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket socket;
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;

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

    public void receiveMessageFromServer(GridPane gpCheckerboard){
        Runnable runnable = () -> {
            while (socket.isConnected()){
                try {
                    String messageFromServer = bufferedReader.readLine();
                    System.out.println("Server message: " + messageFromServer);
                    if(messageFromServer.startsWith("0")) {
                        CheckersController.drawCheckers(gpCheckerboard, messageFromServer);
                    }
                    else if(messageFromServer.startsWith("B")){
                        CheckersController.rotateForBlack(gpCheckerboard);
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

