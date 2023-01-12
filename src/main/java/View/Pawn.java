package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Klasa odpowiedzialna za pionki
 */
public class Pawn extends Circle {

    /**
     * Tworzy pionek dziedziczac po Circle
     * @param white Jesli prawda, to pionek jest biały
     */
    public Pawn (boolean white) {
        super(CheckersController.TILE_SIZE / 2.5,
                white ? Color.valueOf("#fff9f4") : Color.valueOf("#282011")
        );
        this.setStroke(Color.BLACK);
        this.setStrokeWidth(CheckersController.TILE_SIZE*0.02);
    }
}
