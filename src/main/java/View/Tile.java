package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//pole na szachownicy
public class Tile extends Rectangle {
    public Tile(boolean white, double tileSize) {
        super(tileSize, tileSize, white ? Color.valueOf("#feb") : Color.valueOf("#582"));
    }
}
