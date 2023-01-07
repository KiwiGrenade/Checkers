package Server;

public interface Moves {
    boolean move(int x2, int y2);
    boolean isPunchAvi();
    boolean isPunchUpLeftAvi();
    boolean isPunchUpRightAvi();
    boolean isPunchDownLeftAvi();
    boolean isPunchDownRightAvi();
    boolean punch(int x, int y);
    boolean normalMove(int x, int y);
    boolean isLastRow(int x, int y);
}
