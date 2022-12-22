package Model;

public class Board {
    public int fields[][];
    public int rows, cols;

    //tworzy tablice
    public Board(int rows, int cols){
        this.fields = new int[rows][cols];
        this.rows=rows;
        this.cols=cols;
        this.setFields();
        //this.placeCheckers();
    }

    //ustawia kolory na tablicy
    public void setFields() {
        int black = 1;
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if((i+j)%2==1)
                    fields[i][j]=black;
                else
                    fields[i][j]=0;
            }
        }
    }

    //ustawia pionki 2 - biale 3 - czarne
    public void placeCheckers(){
        for(int i=rows-3;i<rows;i++) {
            for (int j = 0; j < cols; j++) {
                if (fields[i][j] == 1)
                    fields[i][j] = 2;
            }
        }

        for(int i=0;i<3;i++) {
            for (int j = 0; j < cols; j++) {
                if (fields[i][j] == 1)
                    fields[i][j] = 3;
            }
        }
    }
    //sprawdzam czy tablica wyswietla sie poprawnie - wiadomo ze bedzie zastapione testem
    public static void main(String[] args){
        Board checkerboard = new Board(8,8);
        checkerboard.placeCheckers();
        for (int i = 0; i<8;i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(checkerboard.fields[i][j]);
            }
            System.out.println("");
        }
    }
}
