package Server;

public interface Moves {
    boolean move(int x2, int y2);
    boolean isPunchAvi(int x, int y, int color);
    boolean isPunchUpLeftAvi(int x, int y, int color);
    boolean isPunchUpRightAvi(int x, int y, int color);
    boolean isPunchDownLeftAvi(int x, int y, int color);
    boolean isPunchDownRightAvi(int x, int y, int color);
    boolean punch(int x, int y);
    boolean normalMove(int x, int y);
    boolean isLastRow(int y);
    boolean changePosition(int x, int y);
}
