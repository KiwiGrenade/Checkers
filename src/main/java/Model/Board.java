package Model;

public class Board {
    // fields should be static -> no chance of copy existing
    private static int fields[][];

    // NEVER USE PUBLIC CLASS VARIABLES!
    private int rows;

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    private int cols;
    public int getField(int col, int row) {
        return fields[col][row];
    }

    public void setField(int col, int row, int value) {
        fields[col][row] = value;
    }

    public static int[][] getAllFields() {
        return fields;
    }

    public static void setAllFields(int[][] fields) {
        Board.fields = fields;
    }

    //tworzy tablice
    public Board(int cols, int rows) {
        this.fields = new int[cols][rows];
        this.rows = rows;
        this.cols = cols;
        this.setFields();
        this.placeCheckers();
    }

    //ustawia kolory na tablicy
    public void setFields() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if((i + j) % 2 == 1)
                    fields[i][j] = 1;
                else
                    fields[i][j] = 0;
            }
        }
    }

    //ustawia pionki 2 - biale 3 - czarne
    public void placeCheckers(){
        for(int i = rows - 3; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (fields[i][j] == 1)
                    fields[i][j] = 2;
            }
        }

        for(int i = 0; i < 3; i++) {
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
        for (int i = 0; i < checkerboard.getCols(); i++) {
            for (int j = 0; j < checkerboard.getRows(); j++) {
                System.out.print(fields[i][j]);
            }
            System.out.println("");
        }
    }
}
