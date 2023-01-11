package View;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;


import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class CheckersController implements Initializable {
    public static final int TILE_SIZE = 100; //skala

    @FXML
    private VBox board;
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
        client.receiveMessageFromServer(board, gpCheckerboard);
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

    public static void drawCheckers(VBox vb, GridPane pane, String string) {
        int boardSize = (int) Math.sqrt(string.length());
        int[][] board = strToBoard(string);
        Platform.runLater(() -> {
            pane.getChildren().clear();
            vb.getChildren().clear();
            vb.getChildren().add(pane);
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
    public static void winOrLose(VBox vb, GridPane pane, String winOrLose){
        Text text = new Text();
        if(winOrLose.equals("P"))
            text.setText("YOU WIN");
        else
            text.setText("YOU LOSE");

        text.setStyle("-fx-font-weight: bold");
        text.setScaleX(3);
        text.setScaleY(3);

        Button okButton = new Button("OK");
        okButton.setScaleX(2);
        okButton.setLayoutY(2);

        okButton.setOnAction(e ->{
            Platform.exit();
        });

        Platform.runLater(() -> {
            pane.getChildren().clear();
            vb.getChildren().add(text);
            vb.getChildren().add(okButton);
            vb.setSpacing(50);
        });
    }

    public static void printWaitingMSG(VBox vb){
        Text text = new Text();

        text.setText("WAITING FOR OPONENT");

        text.setStyle("-fx-font-weight: bold");
        text.setScaleX(3);
        text.setScaleY(3);
        Platform.runLater(() -> {
            vb.getChildren().add(text);
        });
    }

    public static void opponentLeft(VBox vb){
        Text text = new Text();

        text.setText("OPPONENT LEFT");

        text.setStyle("-fx-font-weight: bold");
        text.setScaleX(3);
        text.setScaleY(3);

        Button okButton = new Button("OK");
        okButton.setScaleX(2);
        okButton.setLayoutY(2);

        okButton.setOnAction(e ->{
            Platform.exit();
        });

        Platform.runLater(() -> {
            vb.getChildren().clear();
            vb.getChildren().add(text);
            vb.getChildren().add(okButton);
            vb.setSpacing(50);
        });
    }
}