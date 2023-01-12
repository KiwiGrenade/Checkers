package Model;

/**
 * Klasa odpowiedzialna za czarna krolowa i jej ruchy, dziedziczy po Queen
 */
public class BlackQueen extends Queen {
    /**
     * Tworzy czarna krolowa na pozycji x, y w tablicy
     * @param x1 Pozycja x
     * @param y1 Pozycja y
     */
    public BlackQueen(int x1, int y1) {
        super(x1, y1, 5);
    }

    @Override
    public boolean isPunchAvi(int x, int y, int color) {
        return super.isPunchAvi(x, y, color);
    }

    @Override
    public boolean isPunchUpLeftAvi(int x, int y, int color) {
        return super.isPunchUpLeftAvi(x, y, color);
    }

    @Override
    public boolean isPunchUpRightAvi(int x, int y, int color) {
        return super.isPunchUpRightAvi(x, y, color);
    }

    @Override
    public boolean isPunchDownLeftAvi(int x, int y, int color) {
        return super.isPunchDownLeftAvi(x, y, color);
    }

    @Override
    public boolean isPunchDownRightAvi(int x, int y, int color) {
        return super.isPunchDownRightAvi(x, y, color);
    }

    @Override
    public boolean punch(int x2, int y2) {
        return super.punch(x2, y2);
    }

    @Override
    public boolean normalMove(int x2, int y2) {
        return super.normalMove(x2, y2);
    }
}
