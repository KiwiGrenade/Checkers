package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// 2d representation of a pawn
public class Pawn extends Circle {
    private boolean white;
    private int col;
    private int row;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int testing(){
        if(white)
            return 2;
        else
            return 3;
    }

    public Pawn (boolean white, int col, int row) {
        this.white = white;
        this.col = col;
        this.row = row;
        setRadius(CheckersController.TILE_SIZE / 2.0);
        setFill(white ? Color.valueOf("#fff9f4") : Color.valueOf("#c40003"));
    }
}
