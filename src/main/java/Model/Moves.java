package Model;

public class Moves {
    private int player;//umowny gracz 1-biale, 2-czarne
    private int currentRow;
    private int currentCol;

//dodac logike danego wariantu warcabow np. wzorcem state

    //zmiana na damke
    public void changeToQueen(Board board){
        if(player==1) {
            for (int col = 0; col < board.cols; col++) {
                if (board.fields[col][0] == 2) board.fields[col][0] = 4;
            }
        }
        else if(player==2) {
            for (int col = 0; col < board.cols; col++) {
                if (board.fields[col][0] == 3) board.fields[col][0] = 5;
            }
        }
    }
}
