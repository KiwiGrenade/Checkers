package View;

import Model.Board;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

//przykladowy widok szachownicy, w przyszlosci kontroler bedzie odpowiadal za komunikacje
public class CheckersView extends Application {
    public static final int TILE_SIZE = 100;//skala
    public static final int BOARD_SIZE = 8;
    final private static Board board = new Board(BOARD_SIZE,BOARD_SIZE);

    final private Tile[][] checkerboard = new Tile[BOARD_SIZE][BOARD_SIZE];
    final private ArrayList<Pawn> checkers = new ArrayList<Pawn>();
    final private Group tiles = new Group();
    final private Group pawns = new Group();

    private void placeTiles() {
        for (int col = 0; col < BOARD_SIZE; col++) {
            for (int row = 0; row < BOARD_SIZE; row++) {
                Tile tile = new Tile(!isWhite(board.getField(row, col)), row, col);
                checkerboard[row][col] = tile;
                tiles.getChildren().add(tile);
            }
        }
    }

    //readBoard
    public void placePawns(){
        for (int j = 0; j < BOARD_SIZE; j++) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                switch (board.getField(i, j)) {
                    case 2 -> {
                        Pawn tempPawn = new Pawn(true, i, j);
                        checkers.add(tempPawn);
                        pawns.getChildren().add(tempPawn);
                    }
                    case 3 -> {
                        Pawn tempPawn = new Pawn(false, i, j);
                        checkers.add(tempPawn);
                        pawns.getChildren().add(tempPawn);
                    }
                }
            }
        }
    }

    // sprawdza kolor pola, pozniej dodamy funckje sprawdzajaca rodzaj pionka
    public boolean isWhite(int k){
        return k >= 1;
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(BOARD_SIZE * TILE_SIZE, BOARD_SIZE * TILE_SIZE);
        placeTiles();
        root.getChildren().addAll(tiles);
        placePawns();
        root.getChildren().addAll(pawns);
        // uzupelnienie planszy polami
        return root;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Checkers");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}