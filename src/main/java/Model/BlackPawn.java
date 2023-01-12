package Model;

import static Model.Model.getField;

/**
 * Klasa odpowiedzialna za czarny pionek i jego ruchy
 */
public class BlackPawn extends Pawn {
    /**
     * Tworzy czarny pionek na pozycji x, y w tablicy
     * @param x1 Pozycja x
     * @param y1 Pozycja y
     */
    public BlackPawn(int x1, int y1){
        super(x1, y1, 3);
    }

    @Override
    public boolean isPunchUpLeftAvi(int x, int y, int color) {
        return Model.getGameMode() != 1 && isDifferentColorThanPawn(x - 1, y - 1) && getField(y - 2, x - 2) == 1;
    }


    @Override
    public boolean isPunchUpRightAvi(int x, int y, int color) {
        return Model.getGameMode() != 1 && isDifferentColorThanPawn(x + 1, y - 1) && getField(y - 2, x + 2) == 1;
    }

    @Override
    public boolean isPunchDownLeftAvi(int x, int y, int color) {
        return isDifferentColorThanPawn(x - 1, y + 1) && getField(y + 2, x - 2) == 1;
    }

    @Override
    public boolean isPunchDownRightAvi(int x, int y, int color) {
        return isDifferentColorThanPawn(x + 1, y + 1) && getField(y + 2, x + 2) == 1;
    }
}
