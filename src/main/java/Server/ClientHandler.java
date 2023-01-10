package Server;

import Model.Model;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final char mark;
    private ClientHandler opponent;
    private final BufferedReader input;
    private final PrintWriter output;

    public ClientHandler(Socket socket, char mark) throws IOException {
        this.mark = mark;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try{
            setupGame();
            processRequest();
        }catch (IOException e){
            System.err.println("IO in client handler(client left)");
        }
        finally {
            try {
                output.close();
                input.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setupGame() throws IOException{
        output.println(mark);
        if(mark == 'W'){
            Model.setCurrentPlayer(this);
            output.println("MSG waiting for opponent");
            output.println(Model.fieldsToString());//do gracza
        }
        else {
            opponent = Model.getCurrentPlayer();
            opponent.opponent = this;
            output.println(Model.fieldsToString());//do gracza
        }
    }

    private void processRequest() throws IOException {
        while (true) {
            String request = input.readLine();
            if (request.startsWith("QUIT")) {
                return;
            }
            else if(Model.getCurrentPlayer().equals(this)){
                if(Model.checkPlayer(Integer.parseInt(request.substring(0, 1)),Integer.parseInt(request.substring(1, 2)))) {
                    switch(
                            Model.playerMove(
                            Integer.parseInt(request.substring(0, 1)),
                            Integer.parseInt(request.substring(1, 2)),
                            Integer.parseInt(request.substring(2, 3)),
                            Integer.parseInt(request.substring(3, 4))))
                    {
                        //poprawny ruch
                        case 1 -> {
                            Model.setCurrentPlayer(opponent);
                        }
                        default -> {
                            System.out.println("ERROR");
                        }
                    }
                    output.println(Model.fieldsToString());//do gracza
                    opponent.output.println(Model.fieldsToString());//do op gracza
                }
            }
        }
    }

    public char getMark(){
        return this.mark;
    }
}
