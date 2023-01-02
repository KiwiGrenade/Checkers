package View;

import Model.Board;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    public static final int TILE_SIZE = 100;//skala
    public static final int BOARD_SIZE = 8;
    final private static Board board = new Board(BOARD_SIZE);
    //final private ArrayList<Pawn> checkers = new ArrayList<Pawn>();

    @Override
    public void start(Stage primaryStage) {
        // Create a GridPane
        GridPane pane = new GridPane();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Tile2 tile = new Tile2(!isWhite(board.getField(j, i)));
                pane.add(tile, j, i);
            }
        }

        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                switch (board.getField(i, j)) {
                    case 2 -> {
                        Pawn tempPawn = new Pawn(true, j, i);
                        //tempPawn.setCenterX(50);
                        //tempPawn.setCenterY(50);
                        pane.add(tempPawn,j,i);
                    }
                    case 3 -> {
                        Pawn tempPawn = new Pawn(false, j, i);
                        //tempPawn.setCenterX(50);
                        //tempPawn.setCenterY(50);
                        pane.add(tempPawn,j,i);
                    }
                }
            }
        }

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(scene); // Place in scene in the stage
        primaryStage.show();
    }

    public boolean isWhite(int k) {
        return k >= 1;
    }
}
