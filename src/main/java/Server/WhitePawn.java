package Server;

import static Server.Model.getField;
import static Server.Model.setField;
import static java.lang.Math.abs;

public class WhitePawn extends Pawn {
    public WhitePawn(int x1, int y1) {
        super(x1, y1, 2);
    }
//    @Override
//    public boolean move(int x2, int y2) {
//        boolean result;
//        switch(abs(x1 - x2)){
//            case 1 -> {
//                result = normalMove(x2, y2);
//            }
//            case 2 -> {
//                result = punch(x2, y2);
//            }
//            default -> {
//                System.out.println("Wrong distance!");
//                return false;
//            }
//        }
//        if(result) {
//            isLastRow(x2, y2);
//        }
//        return result;
//    }
//
//
//
//    @Override
//    public boolean isPunchAvi() {
//        return isPunchDownLeftAvi() ||
//                isPunchUpLeftAvi() ||
//                isPunchDownRightAvi() ||
//                isPunchUpRightAvi();
//    }
//
//    @Override
//    public boolean isPunchUpLeftAvi() {
//        int upLeft = getField(y1 - 1, x1 - 1);
//        return((upLeft == 3 || upLeft == 5)
//                && getField(y1 - 2, x1 - 2) == 1);
//    }
//
//    @Override
//    public boolean isPunchUpRightAvi() {
//        int upRight = getField(y1 - 1, x1 + 1);
//        return((upRight == 3 || upRight == 5)
//                && getField(y1 - 2, x1 + 2) == 1);
//    }
//
//    @Override
//    public boolean isPunchDownLeftAvi() {
//        int downLeft = getField(y1 + 1, x1 - 1);
//        return((downLeft == 3 || downLeft == 5)
//                && getField(y1 + 2, x1 - 2) == 1);
//    }
//
//    @Override
//    public boolean isPunchDownRightAvi() {
//        int downRight = getField(y1 + 1, x1 + 1);
//        return((downRight == 3 || downRight == 5)
//                && getField(y1 + 2, x1 + 2) == 1);
//    }
//
//    @Override
//    public boolean punch(int x2, int y2) {
//        if(isPunchUpRightAvi() && x2 > x1 && y2 < y1) {
//            setField(y1, x1, 1);
//            setField(y1 - 1, x1 + 1, 1);
//            setField(y2, x2, color);
//        }
//        else if(isPunchUpLeftAvi() && x2 < x1 && y2 < y1) {
//            setField(y1, x1, 1);
//            setField(y1 - 1, x1 - 1, 1);
//            setField(y2, x2, color);
//        }
//        else if(isPunchDownLeftAvi() && x2 < x1 && y2 > y1) {
//            setField(y1, x1, 1);
//            setField(y1 + 1, x1 - 1, 1);
//            setField(y2, x2, color);
//        }
//        else if(isPunchDownRightAvi() && x2 > x1 && y2 > y1) {
//            setField(y1, x1, 1);
//            setField(y1 + 1, x1 + 1, 1);
//            setField(y2, x2, color);
//        }
//        else {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean normalMove(int x2, int y2) {
//        if (y1 - y2 == 1)
//        {
//            setField(y1, x1, 1);
//            setField(y2, x2, color);
//            return true;
//        }
//        else {
//            System.out.println("Something wrong with normalMove!");
//            return false;
//        }
//    }
//
//    @Override
//    public void isLastRow(int x, int y) {
//        if(y == 0)
//        {
//            setField(y, x, 4);
//        }
//    }
}
