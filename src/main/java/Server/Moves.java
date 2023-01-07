package Server;

public interface Moves {
    public boolean move(int x2, int y2);
    public boolean isPunchAvi();
    public boolean isPunchUpLeftAvi();
    public boolean isPunchUpRightAvi();
    public boolean isPunchDownLeftAvi();
    public boolean isPunchDownRightAvi();
    public boolean punch(int x2, int y2);
    public boolean normalMove(int x2, int y2);
}
