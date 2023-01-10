package Model;

import static Model.Model.getGameMode;
import static Model.Model.getField;

public class BlackPawn extends Pawn {
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
