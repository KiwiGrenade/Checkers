package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

// 2d representation of a pawn
public class Pawn extends Circle {

    public Pawn (boolean white) {
        super(CheckersController.TILE_SIZE / 2.0,
                white ? Color.valueOf("#fff9f4") : Color.valueOf("#c40003")
        );
    }
}
