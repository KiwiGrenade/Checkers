package Model;

import Model.Model;

import static Model.Model.getField;
import static Model.Model.setField;
import static java.lang.Math.abs;

public class Queen extends Pawn {
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
        if(Model.getGameMode() == 1 && abs(x1 - x2) != 1){
            return false;
        }
        if(!noPunchNoLife()){
            return changePosition(x2, y2);
        }
        else {
            return true;
        }
    }

    @Override
    public boolean punch(int x2, int y2) {
        if(Model.getGameMode() == 1) {
            return super.punch(x2, y2);
        }
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
        int pawnPositionX = 10;
        int pawnPositionY = 10;
        for(int x = x1 + 1, y = y1 - 1; x < x2; x++, y--){
            if(getField(y, x) != 1) {
                pawnCounter++;
                pawnPositionX = x;
                pawnPositionY = y;
            }
        }
        if((pawnCounter == 1) && isDifferentColorThanPawn(pawnPositionY, pawnPositionX)){
            changePosition(x2, y2);
            setField(pawnPositionY, pawnPositionX, 1);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean punchUpLeft(int x2, int y2) {
        int pawnCounter = 0;
        int pawnPositionX = 10;
        int pawnPositionY = 10;
        for(int x = x1 - 1, y = y1 - 1; x > x2; x--, y--){
            if(getField(y, x) != 1){
                pawnCounter++;
                pawnPositionX = x;
                pawnPositionY = y;
            }
        }
        if(pawnCounter == 1 && isDifferentColorThanPawn(pawnPositionY, pawnPositionX)){
            changePosition(x2, y2);
            setField(pawnPositionY, pawnPositionX, 1);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean punchDownLeft(int x2, int y2) {
        int pawnCounter = 0;
        int pawnPositionX = 10;
        int pawnPositionY = 10;
        for(int x = x1 - 1, y = y1 + 1; x > x2; x--, y++){
            if(getField(y, x) != 1){
                pawnCounter++;
            }
        }
        if(pawnCounter == 1){
            changePosition(x2, y2);
            setField(pawnPositionY, pawnPositionX, 1);
            return true;
        }
        else {
            return false;
        }
    }

    private boolean punchDownRight(int x2, int y2) {
        int pawnCounter = 0;
        int pawnPositionX = 10;
        int pawnPositionY = 10;
        for(int x = x1 + 1, y = y1 + 1; x < x2; x++, y++){
            if(getField(y, x) != 1){
                pawnCounter++;
            }
        }
        if(pawnCounter == 1){
            changePosition(x2, y2);
            setField(pawnPositionY, pawnPositionX, 1);
            return true;
        }
        else {
            return false;
        }
    }
}
