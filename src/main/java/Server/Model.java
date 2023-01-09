package Server;

import static java.lang.Math.abs;

public class Model {
    private static int[][] fields;
    private static int size;
    private static ClientHandler currentPlayer;

    public static Pawn pawn;

    public Model(int size) {
        Model.size = size;
        fields = new int[size][size];
        setTiles();
        placeCheckers();
//        Model.setAllFields(new int[][]{
//                //0,1, 2, 3, 4, 5, 6, 7
//                {0, 3, 0, 3, 0, 3, 0, 3},//0
//                {1, 0, 1, 0, 1, 0, 1, 0},//1
//                {0, 1, 0, 1, 0, 1, 0, 1},//2
//                {1, 0, 1, 0, 5, 0, 1, 0},//3
//                {0, 4, 0, 3, 0, 1, 0, 1},//4
//                {1, 0, 1, 0, 1, 0, 1, 0},//5
//                {0, 3, 0, 1, 0, 1, 0, 1},//6
//                {1, 0, 2, 0, 2, 0, 2, 0}//7
//        });
    }

    public static void setCurrentPlayer(ClientHandler player) {
        currentPlayer = player;
    }

    public static ClientHandler getCurrentPlayer() {
        return currentPlayer;
    }

    static public int getSize() {
        return size;
    }

    public static int getField(int row, int col) {
        if ((row >= 0 && row < size)  && (col >= 0 && col < size)) {
            return fields[row][col];
        }
        else{
            return -1;
        }
    }

    public static void setField(int row, int col, int value) {
        fields[row][col] = value;
    }

    public static int[][] getAllFields() {
        return fields;
    }

    public static void setAllFields(int[][] fields) {
        Model.fields = fields;
    }

    //ustawia kolory na tablicy
    public static void setTiles() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ((i + j) % 2 == 1)
                    //black
                    fields[i][j] = 1;
                else
                    //white
                    fields[i][j] = 0;
            }
        }
    }

    public static String fieldsToString() {
        String string = "";
        for (int[] x : fields) {
            for (int y : x) {
                string = string.concat(Integer.toString(y));
            }
        }
        System.out.println(string);
        return string;
    }

    //ustawia pionki 2 - biale 3 - czarne
    public static void placeCheckers() {
        for (int i = size - 3; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (fields[i][j] == 1)
                    fields[i][j] = 2;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < size; j++) {
                if (fields[i][j] == 1)
                    fields[i][j] = 3;
            }
        }
    }

    public static boolean checkPlayer(int x1, int y1) {
        if (currentPlayer.getMark() == 'W')
            return (getField(y1, x1) == 2) || (getField(y1, x1) == 4);
        else
            return (getField(y1, x1) == 3) || (getField(y1, x1) == 5);

    }

    public static int playerMove(int x1, int y1, int x2, int y2) {
        //can't move to a white field (1) or other pawn (2,3)
        if (getField(y2, x2) != 1 || getField(y1, x1) < 2) {
            return 0;
        }
        switch (getField(y1, x1)) {
            case 2 -> pawn = new WhitePawn(x1, y1);
            case 3 -> pawn = new BlackPawn(x1, y1);
            case 4 -> pawn = new WhiteQueen(x1, y1);
            case 5 -> pawn = new BlackQueen(x1, y1);
            default -> {
                return 0;
            }
        }
        //multiple punches
        if(pawn.punch(x2, y2)) {
            if(pawn.isPunchAvi(x2, y2, getField(y2, x2))) {
                return 2;
            }
            else if(pawn.isLastRow(y2)) {
                setField(y2, x2, getField(y2, x2) == 2 ? 4 : 5);
            }
            return 1;
        }
        else if (pawn.normalMove(x2, y2)) {
            if(pawn.isLastRow(y2)) {
                setField(y2, x2, getField(y2, x2) == 2 ? 4 : 5);
            }
            return 1;
        }
        else{
            return 0;
        }
    }
}