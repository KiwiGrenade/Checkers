package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//pole na szachownicy
public class Tile2 extends Rectangle {

    public Tile2(boolean white) {
        setWidth(CheckersView.TILE_SIZE);
        setHeight(CheckersView.TILE_SIZE);

        setFill(white ? Color.GREY : Color.BROWN);
    }
}

