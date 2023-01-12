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

/**
 * Klasa kontrolera - odpowiedzialna za aktualizowanie GUI i stworzenie informacji dla serwera, lączy widok z modelem (serwerem)
 */
public class CheckersController implements Initializable {
    public static final int TILE_SIZE = 100; //skala

    @FXML
    private VBox board;
    @FXML
    private GridPane gpCheckerboard;

    private Client client;
    private String messageToSend;
    private Pawn currentPawn;

    /**
     * Glowna metoda dla interpretacji pliku FXML ze szkieletem GUI, wywolanie skutkuje stworzeniem i polaczeniem klietna z serwerem oraz zbudowaniem GUI
     * @param url sciezka pliku
     * @param resourceBundle plik zrodlowy
     */
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

    /**
     * Metoda odpowiedzialna za przygotowanie informacji dla serwera na podstawie aktywnosci uzytkownika na GUI
     * LPM po raz pierwszy - wybranie pionka i odczytanie jego pozycji startowej
     * LPM po raz drugi - wybranie pola, na ktore pionek ma sie przemiescic i wyslanie informacji do serwera
     * PPM - resetuje wybor pionka
     * @param e Obsluga klikniec myszki
     */
    public void sendCoordinates(MouseEvent e) {
        if(e.getButton().equals(MouseButton.PRIMARY)) {
            if(currentPawn==null && e.getTarget() instanceof Pawn){
                messageToSend = "";
                //System.out.println("S[" + GridPane.getRowIndex((Node) e.getTarget()) + "][" + GridPane.getColumnIndex((Node) e.getTarget()) + "]");//sprawdza
                messageToSend += GridPane.getRowIndex((Node) e.getTarget());
                messageToSend += GridPane.getColumnIndex((Node) e.getTarget());

                currentPawn = ((Pawn) e.getTarget());
                currentPawn.setEffect(new Lighting());
            }
            if(currentPawn!=null && e.getTarget() instanceof Tile) {
                //System.out.println("E[" + GridPane.getRowIndex((Node) e.getTarget()) + "][" + GridPane.getColumnIndex((Node) e.getTarget()) + "]");//sprawdza
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
        }
    }

    /**
     * Metoda odpowiedzialna za zamiane wiadomosci z serwera z ciagu cyfr w int[][] w celu ulatwienia interpretacji
     * @param str Wiadomosc z serwera
     * @return Tablica w postaci int[][]
     */
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

    /**
     * Metoda odpowiedzialna za obrocenie tablicy dla czarnych pionkow
     * @param pane Tablica
     */
    public static void rotateForBlack(GridPane pane){
        Platform.runLater(() -> {
            pane.setScaleY(-1);
        });
    }

    /**
     * Metoda odpowiedzialna za rysowanie tablicy na podstawie wiadomosci otrzymanej z serwera
     * @param vb Glowna plansza
     * @param pane Widoczna czesc szachownicy
     * @param string Wiadomosc z serwera
     */
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

    /**
     * Metoda odpowiedzialna za rysowanie ekranu dla zwyciezcy i przegranego
     * @param vb Glowna plansza
     * @param pane Widoczna czesc szachownicy
     * @param winOrLose Wiadomosc z serwera, czy wygral, czy przegral
     */
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

    /**
     * Metoda odpowiedzialna za rysownaie ekranu oczekiwania
     * @param vb Glowna tablica
     */
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

    /**
     * Metoda odpowiedzialna za zaktualizowanie widoku w przypadku opuszczenia gry przez jednego z klientow
     * @param vb Glowna tablica
     */
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