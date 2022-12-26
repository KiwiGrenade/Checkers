package Model;

public abstract class Pawn {
    public abstract void moveUpRight();
    public abstract void moveUpLeft();
    public abstract void punchUpRight();
    public abstract void punchUpLeft();
    public abstract void punchDownRight();
    public abstract void punchDownLeft();
    public abstract int getCol();
    public abstract int getRow();
}
