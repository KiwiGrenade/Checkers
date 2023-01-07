package Server;

import static Server.Model.getField;
import static Server.Model.setField;
import static java.lang.Math.abs;

public abstract class Pawn implements Moves {
    protected int x1;
    protected int y1;
    protected int color;
    public Pawn(int x1, int y1, int color){
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
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
        switch(color)
        {
            case 5:
                case 3: {
                    return ((upLeft == 2 || upLeft == 4)
                            && getField(y1 - 2, x1 - 2) == 1);
                }
            case 2:
                case 4: {
                    return  ((upLeft == 3 || upLeft == 5)
                            && getField(y1 - 2, x1 - 2) == 1);
                }
            default:
                return false;
        }
    }

    @Override
    public boolean isPunchUpRightAvi() {
        int upLeft = getField(y1 - 1, x1 + 1);
        switch(color)
        {
            case 5:
            case 3: {
                return ((upLeft == 2 || upLeft == 4)
                        && getField(y1 - 2, x1 + 2) == 1);
            }
            case 2:
            case 4: {
                return  ((upLeft == 3 || upLeft == 5)
                        && getField(y1 - 2, x1 + 2) == 1);
            }
            default:
                return false;
        }
    }

    @Override
    public boolean isPunchDownLeftAvi() {
        int upLeft = getField(y1 + 1, x1 - 1);
        switch(color)
        {
            case 5:
            case 3: {
                return ((upLeft == 2 || upLeft == 4)
                        && getField(y1 + 2, x1 - 2) == 1);
            }
            case 2:
            case 4: {
                return  ((upLeft == 3 || upLeft == 5)
                        && getField(y1 + 2, x1 - 2) == 1);
            }
            default:
                return false;
        }
    }

    @Override
    public boolean isPunchDownRightAvi() {
        int upLeft = getField(y1 + 1, x1 + 1);
        switch(color)
        {
            case 5:
            case 3: {
                return ((upLeft == 2 || upLeft == 4)
                        && getField(y1 + 2, x1 + 2) == 1);
            }
            case 2:
            case 4: {
                return  ((upLeft == 3 || upLeft == 5)
                        && getField(y1 + 2, x1 + 2) == 1);
            }
            default:
                return false;
        }
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
        if ((y1 - y2 == 1 && color == 2) ||
                (y1 - y2 == -1 && color == 3))
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

    @Override
    public boolean isLastRow(int x, int y) {
        return (color == 2 && y == 7) || (color == 3 && y ==0);
    }
}
