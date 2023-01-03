package View;

import Model.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//przykladowy widok szachownicy, w przyszlosci kontroler bedzie odpowiadal za komunikacje
public class CheckersView extends Application {
    public static final int TILE_SIZE = 100;//skala
    public static final int BOARD_SIZE = 8;
    final private static Board board = new Board(BOARD_SIZE);

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();

        //ustawiamy szachownice
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Tile tile = new Tile(!isWhite(board.getField(j, i)));
                pane.add(tile, j, i);
            }
        }

        drawCheckers(pane);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public boolean isWhite(int k) {
        return k >= 1;
    }

    //rysuje pionki
    public void drawCheckers(GridPane pane) {
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
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
