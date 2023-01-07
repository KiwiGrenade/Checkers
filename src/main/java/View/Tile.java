package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//pole na szachownicy
public class Tile extends Rectangle {
    public Tile(boolean white) {
        super(CheckersController.TILE_SIZE / 2.0,
                CheckersController.TILE_SIZE / 2.0,
                white ? Color.valueOf("#feb") : Color.valueOf("#582")
        );
    }
}

