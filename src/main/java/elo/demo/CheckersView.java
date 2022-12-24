package elo.demo;

import Model.Board;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

//przykladowy widok szachownicy, w przyszlosci kontroler bedzie odpowiadal za komunikacje
public class CheckersView extends Application {
    public static final int TILE_SIZE = 100;//skala
    private Board board = new Board(8,8);

    private Tile[][] checkerboard = new Tile[board.rows][board.cols];
    private Group tiles = new Group();

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(board.rows * TILE_SIZE, board.cols * TILE_SIZE);
        root.getChildren().addAll(tiles);

        // uzupelnienie planszy polami
        setPawns();
        return root;
    }

    private void setPawns() {
        for (int col = 0; col < board.cols; col++) {
            for (int row = 0; row < board.rows; row++) {
                Tile tile = new Tile(!isWhite(board.fields[row][col]), row, col);
                checkerboard[row][col] = tile;
                tiles.getChildren().add(tile);
            }
        }
    }

    // sprawdza kolor pola, pozniej dodamy funckje sprawdzajaca rodzaj pionka
    public boolean isWhite(int k){
        return k >= 1;
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