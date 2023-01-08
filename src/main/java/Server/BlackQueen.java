package Server;

public class BlackQueen extends Queen {
    public BlackQueen(int x1, int y1) {
        super(x1, y1, 5);
    }

    @Override
    public boolean move(int x2, int y2) {
        return false;
    }

    @Override
    public boolean isPunchAvi(int x, int y, int color) {
        return false;
    }

    @Override
    public boolean isPunchUpLeftAvi(int x, int y, int color) {
        return false;
    }

    @Override
    public boolean isPunchUpRightAvi(int x, int y, int color) {
        return false;
    }

    @Override
    public boolean isPunchDownLeftAvi(int x, int y, int color) {
        return false;
    }

    @Override
    public boolean isPunchDownRightAvi(int x, int y, int color) {
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
