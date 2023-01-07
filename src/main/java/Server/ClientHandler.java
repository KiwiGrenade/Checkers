package Server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private char mark;
    private Board board;
    private ClientHandler opponent;
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter out;

    public ClientHandler(Socket socket, Board board, char mark) throws IOException {
        this.socket = socket;
        this.board = board;
        this.mark = mark;
    }

    @Override
    public void run() {
        try{
            setupGame();
            processCommands();
        }catch (IOException e){
            System.err.println("IO in client handler(client left)");
        }
        finally {
            out.close();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setupGame() throws IOException{
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
        out.println("WELCOME " + mark);
        if(mark == 'W'){
            board.setCurrentPlayer(this);
            out.println("MSG waiting for opponent");
            String currentBoard = board.fieldsToString();

            out.println(currentBoard);//do gracza
        }
        else {
            opponent = board.getCurrentPlayer();
            opponent.opponent = this;
            opponent.out.println("MSG Your move");
            String currentBoard = board.fieldsToString();

            out.println(currentBoard);//do gracza
        }
    }

    private void processCommands() throws IOException {
        while (true) {
            var command = bufferedReader.readLine();
            if (command.startsWith("QUIT")) {
                return;
            } else {
                System.out.println(command);
                int ox = Integer.parseInt(command.substring(0,1));
                int oy = Integer.parseInt(command.substring(1,2));
                int nx = Integer.parseInt(command.substring(2,3));
                int ny = Integer.parseInt(command.substring(3,4));

                board.move(ox,oy,nx,ny,this);
                String currentBoard = board.fieldsToString();

                out.println(currentBoard);//do gracza
                opponent.out.println(currentBoard);//do op gracza
            }
        }
    }

    public ClientHandler getOpponent(){
        return opponent;
    }

    public char getMark(){
        return mark;
    }
}
