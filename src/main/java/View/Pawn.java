package View;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.concurrent.SubmissionPublisher;

// 2d representation of a pawn
public class Pawn extends Circle {
    private boolean white;
    private int col;
    private int row;

    public Pawn (boolean white, int col, int row, double radius) {
        super(radius, white ? Color.valueOf("#fff9f4") : Color.valueOf("#c40003"));
        this.white = white;
        this.col = col;
        this.row = row;
    }
}
