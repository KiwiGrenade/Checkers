package Server;

public class WhiteQueen extends WhitePawn{
    public WhiteQueen(int x1, int y1) {
        super(x1, y1);
    }

    @Override
    public boolean move(int x2, int y2) {
        return false;
    }

    @Override
    public boolean isPunchAvi() {
        return super.isPunchAvi();
    }

    @Override
    public boolean isPunchUpLeftAvi() {
        return super.isPunchUpLeftAvi();
    }

    @Override
    public boolean isPunchUpRightAvi() {
        return super.isPunchUpRightAvi();
    }

    @Override
    public boolean isPunchDownLeftAvi() {
        return super.isPunchDownLeftAvi();
    }

    @Override
    public boolean isPunchDownRightAvi() {
        return super.isPunchDownRightAvi();
    }

    @Override
    public boolean punch(int x2, int y2) {
        return super.punch(x2, y2);
    }

    @Override
    public boolean normalMove(int x2, int y2) {
        return super.normalMove(x2, y2);
    }
}
