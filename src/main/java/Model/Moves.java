package Model;

public class Moves {

    // umowny gracz 1-biale, 2-czarne
    private int player;
    private int currentRow;
    private int currentCol;

// dodac logike danego wariantu warcabow np. wzorcem state
//
    // zmiana na damke
    public void changeToQueen(Board board){
        if(player==1) {
            for (int col = 0; col < Board.getBoardSize(); col++) {
                if (board.getField(col, 0) == 2) {
                    board.setField(col, 0, 4);
                }
            }
        }
        else if(player==2) {
            for (int col = 0; col < Board.getBoardSize(); col++) {
                if (board.getField(col, 0) == 3) {
                    board.setField(col, 0, 5);
                }
            }
        }
    }
}
