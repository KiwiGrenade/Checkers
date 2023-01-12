package Model;

import static Model.Model.getField;
import static Model.Model.setField;
import static java.lang.Math.abs;

/**
 * Klasa odpowiedzialna za obsluge pionkow, implementuje interfejs Moves
 */
public abstract class Pawn implements Moves {
    protected int x1;
    protected int y1;
    protected int color;

    /**
     * Tworzy pionek o podanym kolorze na pozycji x, y w tablicy
     * @param x1 Pozycja x
     * @param y1 Pozycja y
     * @param color Kolor pionka
     */
    public Pawn(int x1, int y1, int color){
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }
    @Override
    public boolean isPunchAvi(int x, int y, int color) {
        return isPunchDownLeftAvi(x, y, color) ||
                isPunchUpLeftAvi(x, y, color) ||
                isPunchDownRightAvi(x, y, color) ||
                isPunchUpRightAvi(x, y, color);
    }
    @Override
    public boolean isPunchUpLeftAvi(int x, int y, int color) {
        return isDifferentColorThanPawn(x - 1, y - 1) && getField(y - 2, x - 2) == 1;
    }


    @Override
    public boolean isPunchUpRightAvi(int x, int y, int color) {
        return isDifferentColorThanPawn(x + 1, y - 1) && getField(y - 2, x + 2) == 1;
    }

    @Override
    public boolean isPunchDownLeftAvi(int x, int y, int color) {
        return isDifferentColorThanPawn(x - 1, y + 1) && getField(y + 2, x - 2) == 1;
    }

    @Override
    public boolean isPunchDownRightAvi(int x, int y, int color) {
        return isDifferentColorThanPawn(x + 1, y + 1) && getField(y + 2, x + 2) == 1;
    }

    public boolean isDifferentColorThanPawn(int x2, int y2){
        int destinationColor = getField(y2, x2);
        switch (color) {
            case 2, 4 -> {
                return destinationColor == 3 || destinationColor == 5;
            }
            case 3, 5 -> {
                return destinationColor == 2 || destinationColor == 4;
            }
            default -> {
                return false;
            }
        }
    }

    /**
     * Metoda odpowiedzialna za sprawdzenie bicia pionka we wszystkich kierunkach
     * @param x2 Pozycja x na ktora się rusza
     * @param y2 Pozycja y na ktora się rusza
     * @return czy jest mozliwe bicie
     */
    @Override
    public boolean punch(int x2, int y2) {
        if(isPunchUpRightAvi(x1, y1, color) && x2 > x1 && y2 < y1) {
            changePosition(x2, y2);
            setField(y1 + 1, x1 - 1, 1);
        }
        else if(isPunchUpLeftAvi(x1, y1, color) && x2 < x1 && y2 < y1) {
            changePosition(x2, y2);
            setField(y1 + 1, x1 + 1, 1);
        }
        else if(isPunchDownLeftAvi(x1, y1, color) && x2 < x1 && y2 > y1) {
            changePosition(x2, y2);
            setField(y1 - 1, x1 + 1, 1);
        }
        else if(isPunchDownRightAvi(x1, y1, color) && x2 > x1 && y2 > y1) {
            changePosition(x2, y2);
            setField(y1 - 1, x1 - 1, 1);
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
        y1 = y2;
        x1 = x2;
        return getField(y2, x2) == color && getField(y1, x1) == 1;
    }

    /**
     * Metoda odpowiedzialna za sprawdzenie ruchu pionka
     * @param x2 Pozycja x na ktora się rusza
     * @param y2 Pozycja y na ktora się rusza
     * @return Czy jest mozliwy ruch
     */
    @Override
    public boolean normalMove(int x2, int y2) {
        if(abs(x1 - x2) != 1) {
            return false;
        }
        else if (((y1 - y2 == 1 && color == 2) || (y1 - y2 == -1 && color == 3))) {
            if(!noPunchNoLife()){
                changePosition(x2, y2);
            }
            return true;
        }
        else {
            System.out.println("Something wrong with normalMove!");
            return false;
        }
    }

    /**
     * Metoda wymuszajaca na pionku bicie jeśli jest ono mozliwe, w przeciwnym wypadku gracz traci pionek
     * @return Czy pionek ma zniknac
     */
    boolean noPunchNoLife() {
        if(isPunchAvi(x1, y1, color)) {
            setField(y1, x1, 1);
            return true;
        }
        else{
            for(int i = 0; i < Model.getSize(); i++) {
                for (int j = 0; j < Model.getSize(); j++) {
                    if(getField(j, i) == color && isPunchAvi(i, j, color)){
                        setField(j, i, 1);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isLastRow(int y) {
        return (color == 2 && y == 0) || (color == 3 && y == 7);
    }
}
