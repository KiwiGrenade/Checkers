package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Klasa odpowiedzialna za pole na szachownicy
 */
public class Tile extends Rectangle {
    /**
     * Tworzy pole dziedziczac po Rectangle
     * @param white Jesli prawda, to pole jest biale
     */
    public Tile(boolean white) {
        super(CheckersController.TILE_SIZE,
                CheckersController.TILE_SIZE,
                white ? Color.valueOf("#feb") : Color.valueOf("#654010")
        );
    }
}

