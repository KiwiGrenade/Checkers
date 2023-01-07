package Server;

import static Server.Model.getField;
import static Server.Model.setField;
import static java.lang.Math.abs;

public class BlackPawn extends Pawn{

    public BlackPawn(int x1, int y1){
        super(x1, y1, 3);
    }
    @Override
    public boolean move(int x2, int y2) {
        switch(abs(x1 - x2)){
            case 1 -> {
                return normalMove(x2, y2);
            }
            case 2 -> {
                return punch(x2, y2);
            }
            default -> {
                System.out.println("Wrong distance!");
                return false;
            }
        }
    }

    @Override
    public boolean isPunchAvi() {
        return isPunchDownLeftAvi() ||
                isPunchUpLeftAvi() ||
                isPunchDownRightAvi() ||
                isPunchUpRightAvi();
    }

    @Override
    public boolean isPunchUpLeftAvi() {
        int upLeft = getField(y1 - 1, x1 - 1);
        return((upLeft == 2 || upLeft == 4)
                && getField(y1 - 2, x1 - 2) == 1);
    }

    @Override
    public boolean isPunchUpRightAvi() {
        int upRight = getField(y1 - 1, x1 + 1);
        return((upRight == 2 || upRight == 4)
                && getField(y1 - 2, x1 + 2) == 1);
    }

    @Override
    public boolean isPunchDownLeftAvi() {
        int downLeft = getField(y1 + 1, x1 - 1);
        return((downLeft == 2 || downLeft == 4)
                && getField(y1 + 2, x1 - 2) == 1);
    }

    @Override
    public boolean isPunchDownRightAvi() {
        int downRight = getField(y1 + 1, x1 + 1);
        return((downRight == 2 || downRight == 4)
                && getField(y1 + 2, x1 + 2) == 1);
    }

    @Override
    public boolean punch(int x2, int y2) {
        if(isPunchUpRightAvi() && x2 > x1 && y2 < y1) {
            setField(y1, x1, 1);
            setField(y1 - 1, x1 + 1, 1);
            setField(y2, x2, color);
        }
        else if(isPunchUpLeftAvi() && x2 < x1 && y2 < y1) {
            setField(y1, x1, 1);
            setField(y1 - 1, x1 - 1, 1);
            setField(y2, x2, color);
        }
        else if(isPunchDownLeftAvi() && x2 < x1 && y2 > y1) {
            setField(y1, x1, 1);
            setField(y1 + 1, x1 - 1, 1);
            setField(y2, x2, color);
        }
        else if(isPunchDownRightAvi() && x2 > x1 && y2 > y1) {
            setField(y1, x1, 1);
            setField(y1 + 1, x1 + 1, 1);
            setField(y2, x2, color);
        }
        else {
            return false;
        }
        return true;
    }

    @Override
    public boolean normalMove(int x2, int y2) {
        if (y1 - y2 == -1)
        {
            setField(y1, x1, 1);
            setField(y2, x2, color);
            return true;
        }
        else {
            System.out.println("Something wrong with normalMove!");
            return false;
        }
    }
}
