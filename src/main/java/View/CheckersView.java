package View;

import Model.Board;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//przykladowy widok szachownicy, w przyszlosci kontroler bedzie odpowiadal za komunikacje
public class CheckersView extends Application {
    public static final int TILE_SIZE = 100;//skala
    final private static Board board = new Board(8);

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();

        //ustawiamy szachownice
        for (int i = 0; i < Board.getSize(); i++) {
            for (int j = 0; j < Board.getSize(); j++) {
                Tile tile = new Tile(!isWhite(board.getField(j, i)));
                pane.add(tile, j, i);
            }
        }

        drawCheckers(pane);

        pane.setOnMousePressed(this::mousePressedOnRoot);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    //zwraca x,y kliknietego pola([x][y])
    private void mousePressedOnRoot(MouseEvent e) {
        System.out.println("["+GridPane.getRowIndex((Node) e.getTarget())+"]["+GridPane.getColumnIndex((Node) e.getTarget())+"]");
    }

    public boolean isWhite(int k) {
        return k >= 1;
    }

    //rysuje pionki
    public void drawCheckers(GridPane pane) {
        for (int j = 0; j < Board.getSize(); j++) {
            for (int i = 0; i < Board.getSize(); i++) {
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

    public static void main(String[] args) {
        launch();
    }
}
