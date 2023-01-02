package Model;

public abstract class Pawn {
    private boolean isWhite;
    private int col;
    private int row;

    public Pawn(boolean isWhite, int col, int row){
        this.isWhite = isWhite;
        this.col = col;
        this.row = row;
    }

    public abstract void moveUpRight();
    public abstract void moveUpLeft();
    public abstract void punchUpRight();
    public abstract void punchUpLeft();
    public abstract void punchDownRight();
    public abstract void punchDownLeft();
    public abstract int getCol();
    public abstract int getRow();
}
