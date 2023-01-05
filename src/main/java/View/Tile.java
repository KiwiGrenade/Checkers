package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//pole na szachownicy
public class Tile extends Rectangle {
    public Tile(boolean white) {
        setWidth(CheckersController.TILE_SIZE);
        setHeight(CheckersController.TILE_SIZE);

        setFill(white ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
}

