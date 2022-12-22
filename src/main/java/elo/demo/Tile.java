package elo.demo;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//pole na szachownicy
public class Tile extends Rectangle {

    public Tile(boolean light, int x, int y) {
        setWidth(CheckersView.TILE_SIZE);
        setHeight(CheckersView.TILE_SIZE);

        relocate(x * CheckersView.TILE_SIZE, y * CheckersView.TILE_SIZE);

        setFill(light ? Color.WHITE : Color.BROWN);
    }
}
