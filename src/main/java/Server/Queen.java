package Server;

import static Server.Model.setField;

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
            return changePosition(x2, y2);
    }

    @Override
    public boolean punch(int x2, int y2) {
        //UpRight
        if(x2 > x1 && y2 < y1) {
            return punchUpRight(x2, y2);
        }//UpLeft
        else if(x2 < x1 && y2 < y1) {
            return punchUpLeft(x2, y2);
        }//DownLeft
        else if(x2 < x1 && y2 > y1) {
            return punchDownLeft(x2, y2);
        }//DownRight
        else if(x2 > x1 && y2 > y1) {
            return punchDownRight(x2, y2);
        }
        else{
            return false;
        }
    }

    public boolean punchUpRight(int x2, int y2){
        int pawnCounter = 0;
        for(int x = x1 + 1, y = y1 - 1; x < x2; x++, y--){
            if(isDifferentColorThanPawn(x, y)){
                pawnCounter++;
            }
        }
        if(pawnCounter == 1){
            changePosition(x2, y2);
            setField(y1 + 1, x1 - 1, 1);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean punchUpLeft(int x2, int y2) {
        int pawnCounter = 0;
        for(int x = x1 - 1, y = y1 - 1; x > x2; x--, y--){
            if(isDifferentColorThanPawn(x, y)){
                pawnCounter++;
            }
        }
        if(pawnCounter == 1){
            changePosition(x2, y2);
            setField(y1 + 1, x1 + 1, 1);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean punchDownLeft(int x2, int y2) {
        int pawnCounter = 0;
        for(int x = x1 - 1, y = y1 + 1; x > x2; x--, y++){
            if(isDifferentColorThanPawn(x, y)){
                pawnCounter++;
            }
        }
        if(pawnCounter == 1){
            changePosition(x2, y2);
            setField(y1 - 1, x1 + 1, 1);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean punchDownRight(int x2, int y2) {
        int pawnCounter = 0;
        for(int x = x1 + 1, y = y1 + 1; x < x2; x++, y++){
            if(isDifferentColorThanPawn(x, y)){
                pawnCounter++;
            }
        }
        if(pawnCounter == 1){
            changePosition(x2, y2);
            setField(y1 - 1, x1 - 1, 1);
            return true;
        }
        else {
            return false;
        }
    }
}
