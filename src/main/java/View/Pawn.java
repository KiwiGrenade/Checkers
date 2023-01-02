package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// 2d representation of a pawn
public class Pawn extends Circle {
    private boolean white;
    private int col;
    private int row;

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Pawn (boolean white, int col, int row) {
        this.white = white;
        this.col = col;
        this.row = row;
        setRadius(CheckersView.TILE_SIZE / 2.0 - 5);
        setCenterX(col * CheckersView.TILE_SIZE + CheckersView.TILE_SIZE / 2.0);
        setCenterY(row * CheckersView.TILE_SIZE + CheckersView.TILE_SIZE / 2.0);
        setFill(white ? Color.WHITE : Color.BLACK);
    }
}
