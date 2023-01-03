package Model;

public class Board {
    private static int[][] fields;
    private static int size;

    public Board(int size) {
        Board.size = size;
        fields = new int [size][size];
        this.setFields();
        this.placeCheckers();
    }
    static public int getSize()
    {
        return size;
    }
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

    //ustawia kolory na tablicy
    public void setFields() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if((i + j) % 2 == 1)
                    fields[i][j] = 1;
                else
                    fields[i][j] = 0;
            }
        }
    }

    //ustawia pionki 2 - biale 3 - czarne
    public void placeCheckers(){
        for(int i = size - 3; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (fields[i][j] == 1)
                    fields[i][j] = 2;
            }
        }

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < size; j++) {
                if (fields[i][j] == 1)
                    fields[i][j] = 3;
            }
        }
    }
}
