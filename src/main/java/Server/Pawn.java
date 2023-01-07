package Server;

public abstract class Pawn implements moves{
    protected int x1;
    protected int y1;
    protected int color;
    public Pawn(int x1, int y1, int color){
        this.x1 = x1;
        this.y1 = y1;
        this.color = color;
    }
}
