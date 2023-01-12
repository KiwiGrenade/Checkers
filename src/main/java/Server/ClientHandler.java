package Server;

import Model.Model;

import java.io.*;
import java.net.Socket;

/**
 * Klasa odpowiedzialna za obsluge dwóch klientow jako przeciwnikow i wysylanie do nich wiadomosci przez serwer
 */
public class ClientHandler implements Runnable {
    private final char mark;
    private ClientHandler opponent;
    private final BufferedReader input;
    private final PrintWriter output;

    /**
     * Tworzy klienta
     * @param socket Klient
     * @param mark Kolor gracza Biały albo Czarny
     * @throws IOException IOException
     */
    public ClientHandler(Socket socket, char mark) throws IOException {
        this.mark = mark;
        this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new PrintWriter(socket.getOutputStream(), true);
    }

    /**
     * Metoda obslugujaca klientow
     */
    @Override
    public void run() {
        try{
            setupGame();
            processRequest();
        }catch (IOException e){
            System.err.println("IO in client handler(client left)");
            if(opponent!=null)
                opponent.output.println("Enemy left");
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

    /**
     * Metoda przydziela kolory dla graczy i wysyla im startowa plansze
     * @throws IOException IOException
     */
    private void setupGame() throws IOException{
        output.println(mark);
        if(mark == 'W'){
            Model.setCurrentPlayer(this);
            output.println("MSG waiting for opponent");
        }
        else {
            opponent = Model.getCurrentPlayer();
            opponent.opponent = this;
            output.println(Model.fieldsToString());//do gracza
            opponent.output.println(Model.fieldsToString());//do przecwinika
        }
    }

    /**
     * Metoda odpowiedzialna za obsluge wiadomosci otrzymanej od klienta, zastosowanie jej na modelu i odesłanie informacji zwrotnej do obu graczy
     * @throws IOException IOException
     */
    private void processRequest() throws IOException {
        while (true) {
            String request = input.readLine();
            if(Model.getCurrentPlayer().equals(this)){
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
                    if(Model.win(Model.fieldsToString())) {
                        output.println("P");//wygrana
                        opponent.output.println("L");//przegrana
                    }
                }
            }
        }
    }

    /**
     * Getter dla znaku gracza
     * @return Znak gracza
     */
    public char getMark(){
        return this.mark;
    }
}
