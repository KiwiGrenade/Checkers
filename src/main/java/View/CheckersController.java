package View;

import Model.Board;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckersController implements Initializable {
    public static final int TILE_SIZE = 100; //skala
    private static Board board = new Board(8);
    private Pawn currentPawn;
    //int ox,oy;
    @FXML
    private GridPane gpCheckerboard;

    private Client client;
    private String messageToSend;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //laczymy klienta
        try {
            client = new Client(new Socket("localhost", 12345));
            System.out.println("connected ");
            drawCheckers(gpCheckerboard);
        }catch (IOException e){
            e.printStackTrace();
        }


        //client.receiveMessageFromServer();
    }
    public static boolean isWhite(int k) {
        return k >= 1;
    }

    public void sendCoordinates(MouseEvent e) {
        //if(twoj ruch){
        if(e.getButton().equals(MouseButton.PRIMARY)) {
            if(currentPawn==null && e.getTarget() instanceof Pawn){
                messageToSend = "";
                System.out.println("S[" + GridPane.getRowIndex((Node) e.getTarget()) + "][" + GridPane.getColumnIndex((Node) e.getTarget()) + "]");//do serwera
                messageToSend += GridPane.getRowIndex((Node) e.getTarget());
                messageToSend += GridPane.getColumnIndex((Node) e.getTarget());

                //if (checkChecker(GridPane.getRowIndex((Node) e.getTarget()), GridPane.getColumnIndex((Node) e.getTarget()))){
                currentPawn = ((Pawn) e.getTarget());
                currentPawn.setEffect(new Lighting());
                //}
            }
            if(currentPawn!=null && e.getTarget() instanceof Tile) {
                //zostaje
                System.out.println("E[" + GridPane.getRowIndex((Node) e.getTarget()) + "][" + GridPane.getColumnIndex((Node) e.getTarget()) + "]");//do serwera
                //if(moveChecker(int x, int y)){
                messageToSend +=GridPane.getRowIndex((Node) e.getTarget());
                messageToSend += GridPane.getColumnIndex((Node) e.getTarget());
                messageToSend += currentPawn.testing();
                //wypada
                board.setField(currentPawn.getRow(),currentPawn.getCol(),1);
                board.setField(GridPane.getRowIndex((Node) e.getTarget()),GridPane.getColumnIndex((Node) e.getTarget()), currentPawn.testing() );
                //zostaje
                currentPawn.setEffect(null);
                currentPawn = null;
                //bedzie sie wykonywac u klienta, nie tu
                drawCheckers(gpCheckerboard);
                System.out.println(messageToSend);//do serwera - zmiana gracza
                client.sendMessageToServer(messageToSend);
                messageToSend = "";
                //repaint()
                //}
            }
        }
        //resetujemy pionek
        else {
            if(currentPawn!=null) {
                messageToSend = "";
                currentPawn.setEffect(null);
                currentPawn = null;
            }
            System.out.println("discard");
        }
        //}
    }
    //o-old n-new v-rodzaj pionka
    //String positions bierze od serwera
    //rysuje pionki bedzie wywolywane w kliencie wiec musi byc static i korzystac z platform.runlater public void drawCheckers(GridPane pane, String positions(przykladowy wyglad1,1,2,2,1)
    // ox, oy,nx,ny,v  parseToInteger
    //potem updatuje aktualny board
    public static void drawCheckers(GridPane pane) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                pane.getChildren().clear();
                //board.setField(ox,oy,1)
                //board.setField(nx,ny,v)
                for (int i = 0; i < Board.getSize(); i++) {
                    for (int j = 0; j < Board.getSize(); j++) {
                        Tile tile = new Tile(!isWhite(board.getField(j, i)));
                        pane.add(tile, j, i);
                    }
                }
                for (int j = 0; j < pane.getColumnCount(); j++) {
                    for (int i = 0; i < pane.getRowCount(); i++) {
                        switch (board.getField(i, j)) {
                            case 2 -> {
                                Pawn tempPawn = new Pawn(true, j, i);
                                pane.add(tempPawn, j, i);
                            }
                            case 3 -> {
                                Pawn tempPawn = new Pawn(false, j, i);
                                pane.add(tempPawn, j, i);
                            }
                        }
                    }
                }

            }
        });
    }

}