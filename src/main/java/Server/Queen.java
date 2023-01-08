package Server;

import static Server.Model.setField;
import static java.lang.Math.abs;

public class Queen extends Pawn{
    public Queen(int x1, int y1, int color) {
        super(x1, y1, color);
    }

    @Override
    public boolean isPunchUpLeftAvi(int x, int y, int color) {
        for (x = x1, y = y1; x >= 0; x--, y--) {
            if(super.isPunchUpLeftAvi(x, y, color)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPunchUpRightAvi(int x, int y, int color) {
        for (x = x1, y = y1; y >= 0; x++, y--) {
            if(super.isPunchUpRightAvi(x, y, color)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPunchDownLeftAvi(int x, int y, int color) {
        for (x = x1, y = y1; x >= 0; x--, y++) {
            if(super.isPunchDownLeftAvi(x, y, color)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isPunchDownRightAvi(int x, int y, int color) {
        for (x = x1, y = y1; x >= 0; x++, y++) {
            if(super.isPunchDownRightAvi(x, y, color)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean normalMove(int x2, int y2) {
        if(isMoveDiagonal(x2, y2)) {
            changePosition(x2, y2);
            return true;
        }
        return false;
    }

    @Override
    public boolean punch(int x2, int y2) {
        if(isPunchUpRightAvi(x1, y1, color) && super.isPunchDownLeftAvi(x2, y2, color)) {
            changePosition(x2, y2);
            setField(y2 + 1, x2 - 1, 1);
            return true;
        }
        else if(isPunchUpLeftAvi(x1, y1, color) && super.isPunchDownRightAvi(x2, y2, color)) {
            changePosition(x2, y2);
            setField(y2 + 1, x2 + 1, 1);
            return true;
        }
        else if(isPunchDownRightAvi(x1, y1, color) && super.isPunchUpLeftAvi(x2, y2, color)) {
            changePosition(x2, y2);
            setField(y2 - 1, x2 - 1, 1);
            return true;
        }
        else if(isPunchDownLeftAvi(x1, y1, color) && super.isPunchUpRightAvi(x2, y2, color)) {
            changePosition(x2, y2);
            setField(y2 - 1, x2 + 1, 1);
            return true;
        }
        return false;
    }

    protected boolean isMoveDiagonal(int x2, int y2) {
        return abs(x1 - x2) == abs(y1 - y2);
    }
}
