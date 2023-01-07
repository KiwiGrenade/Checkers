package Server;

public class BlackQueen extends BlackPawn implements Moves {
    public BlackQueen(int x1, int y1) {
        super(x1, y1);
    }

    @Override
    public boolean move(int x2, int y2) {
        return false;
    }

    @Override
    public boolean isPunchAvi() {
        return false;
    }

    @Override
    public boolean isPunchUpLeftAvi() {
        return false;
    }

    @Override
    public boolean isPunchUpRightAvi() {
        return false;
    }

    @Override
    public boolean isPunchDownLeftAvi() {
        return false;
    }

    @Override
    public boolean isPunchDownRightAvi() {
        return false;
    }

    @Override
    public boolean punch(int x2, int y2) {
        return false;
    }

    @Override
    public boolean normalMove(int x2, int y2) {
        return false;
    }
}
