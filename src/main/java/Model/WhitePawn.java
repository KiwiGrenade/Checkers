package Model;

public class WhitePawn extends Pawn{
    private boolean isWhite;
    private int col;
    private int row;
    public WhitePawn(boolean isWhite, int col, int row) {
        this.isWhite = isWhite;
        this.col = col;
        this.row = row;
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
