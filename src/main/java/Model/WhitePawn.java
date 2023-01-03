package Model;

public class WhitePawn extends Pawn implements Moves{
    public WhitePawn(boolean isWhite, int col, int row) {
        super(isWhite, col, row);
    }
    @Override
    public void moveUpRight() {

    }

    @Override
    public void moveUpLeft() {

    }

    @Override
    public void punchUpRight() {

    }

    @Override
    public void punchUpLeft() {

    }

    @Override
    public void punchDownRight() {

    }

    @Override
    public void punchDownLeft() {

    }

    @Override
    public int getCol() {
        return 0;
    }

    @Override
    public int getRow() {
        return 0;
    }
}
