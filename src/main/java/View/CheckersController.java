package View;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;


import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckersController implements Initializable {
    public static final int TILE_SIZE = 100; //skala
    @FXML
    private GridPane gpCheckerboard;

    private Client client;
    private String messageToSend;
    private Pawn currentPawn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            client = new Client(new Socket("localhost", 12345));
        }catch (IOException e){
            e.printStackTrace();
        }
        client.receiveMessageFromServer(gpCheckerboard);
        Rotate rotate = new Rotate();
        rotate.setPivotX(400);
        rotate.setPivotY(400);
        rotate.setAngle(90);
        gpCheckerboard.getTransforms().addAll(rotate);
        gpCheckerboard.setScaleX(-1);
    }

    public void sendCoordinates(MouseEvent e) {
        if(e.getButton().equals(MouseButton.PRIMARY)) {
            if(currentPawn==null && e.getTarget() instanceof Pawn){
                messageToSend = "";
                System.out.println("S[" + GridPane.getRowIndex((Node) e.getTarget()) + "][" + GridPane.getColumnIndex((Node) e.getTarget()) + "]");//sprawdza
                messageToSend += GridPane.getRowIndex((Node) e.getTarget());
                messageToSend += GridPane.getColumnIndex((Node) e.getTarget());

                currentPawn = ((Pawn) e.getTarget());
                currentPawn.setEffect(new Lighting());
            }
            if(currentPawn!=null && e.getTarget() instanceof Tile) {
                System.out.println("E[" + GridPane.getRowIndex((Node) e.getTarget()) + "][" + GridPane.getColumnIndex((Node) e.getTarget()) + "]");//sprawdza
                messageToSend += GridPane.getRowIndex((Node) e.getTarget());
                messageToSend += GridPane.getColumnIndex((Node) e.getTarget());
                currentPawn.setEffect(null);
                currentPawn = null;
                client.sendMessageToServer(messageToSend);
                messageToSend = "";
            }
        }
        else {
            if(currentPawn!=null) {
                messageToSend = "";
                currentPawn.setEffect(null);
                currentPawn = null;
            }
            System.out.println("discard");
        }
    }

    public static int[][] strToBoard (String str) {
        int size = (int) Math.sqrt(str.length());
        int counter = 0;
        int[][] board = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(str.substring(counter, counter + 1));
                counter++;
            }
        }
        return board;
    }

    public static void rotateForBlack(GridPane pane){
        Platform.runLater(() -> {
            pane.setScaleY(-1);
        });
    }

    public static void drawCheckers(GridPane pane, String string) {
        int boardSize = (int) Math.sqrt(string.length());
        int[][] board = strToBoard(string);
        Platform.runLater(() -> {
            pane.getChildren().clear();
            for (int j = 0; j < boardSize; j++) {
                for (int i = 0; i < boardSize; i++) {
                    Tile tile = new Tile(board[j][i] < 1);
                    pane.add(tile, j, i);
                }
            }
            for (int j = 0; j < boardSize; j++) {
                for (int i = 0; i < boardSize; i++) {
                    switch (board[j][i]) {
                        case 2 -> {
                            Pawn tempPawn = new Pawn(true);
                            pane.add(tempPawn, j, i);
                        }
                        case 3 -> {
                            Pawn tempPawn = new Pawn(false);
                            pane.add(tempPawn, j, i);
                        }
                        case 4 -> {
                            Pawn tempPawm = new Pawn(true);
                            tempPawm.setStroke(Color.BLUE);
                            pane.add(tempPawm,j,i);
                        }
                        case 5 -> {
                            Pawn tempPawm = new Pawn(false);
                            tempPawm.setStroke(Color.BLUE);
                            pane.add(tempPawm,j,i);
                        }
                    }
                }
            }
        });
    }
}