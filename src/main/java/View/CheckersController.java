package View;

import Model.Board;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


import java.net.URL;
import java.util.ResourceBundle;

public class CheckersController implements Initializable {
    public static final int TILE_SIZE = 100; //skala
    final private static Board board = new Board(8);
    private int countClicks=0;
    private Pawn currentPawn;
    @FXML
    private GridPane gpCheckerboard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //ustawiamy szachownice
        for (int i = 0; i < Board.getSize(); i++) {
            for (int j = 0; j < Board.getSize(); j++) {
                Tile tile = new Tile(!isWhite(board.getField(j, i)));
                gpCheckerboard.add(tile, j, i);
            }
        }
        //ustawiamy pionki
        drawCheckers(gpCheckerboard);
    }
    public boolean isWhite(int k) {
        return k >= 1;
    }

    public void sendCoordinates(MouseEvent e) {
        if(e.getButton().equals(MouseButton.PRIMARY)) {
            if(countClicks == 0) {
                System.out.println("[" + GridPane.getRowIndex((Node) e.getTarget()) + "][" + GridPane.getColumnIndex((Node) e.getTarget()) + "]");
                //if (checkChecker(GridPane.getRowIndex((Node) e.getTarget()), GridPane.getColumnIndex((Node) e.getTarget()))){
                if(e.getTarget() instanceof Pawn){
                    currentPawn = ((Pawn) e.getTarget());
                    currentPawn.setEffect(new Lighting());
                }
                //}
                System.out.println(countClicks);
            }
            countClicks++;
            if(countClicks==2) {
                //if(moveChecker(int x, int y)){
                System.out.println("placing " + countClicks);
                if(currentPawn!=null) {
                    currentPawn.setEffect(null);
                    currentPawn = null;
                }
                countClicks = 0;
                System.out.println("end" + countClicks);
                //}
            }

        }
        //resetujemy pionek
        else {
            if(currentPawn!=null) {
                currentPawn.setEffect(null);
                currentPawn = null;
            }
            countClicks = 0;
            System.out.println("discard " + countClicks);
        }
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

}
