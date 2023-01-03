package Model;

public abstract class Pawn {
    private final boolean isWhite;
    private final int col;
    private final int row;

    public Pawn(boolean isWhite, int col, int row){
        this.isWhite = isWhite;
        this.col = col;
        this.row = row;
    }
}
