package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//pole na szachownicy
public class Tile extends Rectangle {

    private Pawn pawn;
    public Tile(boolean white, int x, int y) {
        setWidth(CheckersView.TILE_SIZE);
        setHeight(CheckersView.TILE_SIZE);

        relocate(x * CheckersView.TILE_SIZE, y * CheckersView.TILE_SIZE);

        setFill(white ? Color.GREY : Color.BROWN);
    }
}
