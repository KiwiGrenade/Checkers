package Server;

import static Server.Model.getField;
import static Server.Model.setField;
import static java.lang.Math.abs;

public class Pawn implements Moves {
    protected int x1;
    protected int y1;
    protected int color;
    public Pawn(int x1, int y1, int color){
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }
//    @Override
//    public boolean move(int x2, int y2) {
//        boolean result;
//        switch(1){
//            case 1 -> result = normalMove(x2, y2);
//            case 2 -> result = punch(x2, y2);
//            default -> {
//                return false;
//            }
//        }
//
//        //TODO create a test for this functionality
//
//    }
    @Override
    public boolean isPunchAvi(int x, int y, int color) {
        return isPunchDownLeftAvi(x, y, color) ||
                isPunchUpLeftAvi(x, y, color) ||
                isPunchDownRightAvi(x, y, color) ||
                isPunchUpRightAvi(x, y, color);
    }
    @Override
    public boolean isPunchUpLeftAvi(int x, int y, int color) {
        int upLeft = getField(y - 1, x - 1);
        switch(color)
        {
            case 5:
                case 3: {
                    return ((upLeft == 2 || upLeft == 4)
                            && getField(y - 2, x - 2) == 1);
                }
            case 2:
                case 4: {
                    return  ((upLeft == 3 || upLeft == 5)
                            && getField(y - 2, x - 2) == 1);
                }
            default:
                return false;
        }
    }

    @Override
    public boolean isPunchUpRightAvi(int x, int y, int color) {
        int upLeft = getField(y - 1, x + 1);
        switch(color)
        {
            case 5:
            case 3: {
                return ((upLeft == 2 || upLeft == 4)
                        && getField(y - 2, x + 2) == 1);
            }
            case 2:
            case 4: {
                return  ((upLeft == 3 || upLeft == 5)
                        && getField(y - 2, x + 2) == 1);
            }
            default:
                return false;
        }
    }

    @Override
    public boolean isPunchDownLeftAvi(int x, int y, int color) {
        int upLeft = getField(y + 1, x - 1);
        switch(color)
        {
            case 5:
            case 3: {
                return ((upLeft == 2 || upLeft == 4)
                        && getField(y + 2, x - 2) == 1);
            }
            case 2:
            case 4: {
                return  ((upLeft == 3 || upLeft == 5)
                        && getField(y + 2, x - 2) == 1);
            }
            default:
                return false;
        }
    }

    @Override
    public boolean isPunchDownRightAvi(int x, int y, int color) {
        int upLeft = getField(y + 1, x + 1);
        switch(color)
        {
            case 3:
            case 5: {
                return ((upLeft == 2 || upLeft == 4)
                        && getField(y + 2, x + 2) == 1);
            }
            case 2:
            case 4: {
                return  ((upLeft == 3 || upLeft == 5)
                        && getField(y + 2, x + 2) == 1);
            }
            default:
                return false;
        }
    }
    @Override
    public boolean punch(int x2, int y2) {
        if(isPunchUpRightAvi(x1, y1, color) && x2 > x1 && y2 < y1) {
            changePosition(x2, y2);
            setField(y1 - 1, x1 + 1, 1);
        }
        else if(isPunchUpLeftAvi(x1, y1, color) && x2 < x1 && y2 < y1) {
            changePosition(x2, y2);
            setField(y1 - 1, x1 - 1, 1);
        }
        else if(isPunchDownLeftAvi(x1, y1, color) && x2 < x1 && y2 > y1) {
            changePosition(x2, y2);
            setField(y1 + 1, x1 - 1, 1);
        }
        else if(isPunchDownRightAvi(x1, y1, color) && x2 > x1 && y2 > y1) {
            changePosition(x2, y2);
            setField(y1 + 1, x1 + 1, 1);
        }
        else {
            return false;
        }
        return true;
    }

    @Override
    public boolean changePosition(int x2, int y2) {
        setField(y1, x1, 1);
        setField(y2, x2, color);
        return getField(y2, x2) == color && getField(y1, x1) == 1;
    }

    @Override
    public boolean normalMove(int x2, int y2) {
        if(abs(x1 - x2) != 1) {
            return false;
        }
        else if ((y1 - y2 == 1 && color == 2) ||
                (y1 - y2 == -1 && color == 3))
        {
            changePosition(x2, y2);
            return true;
        }
        else {
            System.out.println("Something wrong with normalMove!");
            return false;
        }
    }

    @Override
    public boolean isLastRow(int y) {
        return (color == 2 && y == 0) || (color == 3 && y == 7);
    }
}
