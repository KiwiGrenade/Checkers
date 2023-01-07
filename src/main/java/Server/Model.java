package Server;

import static java.lang.Math.abs;

public class Model {
    private static int[][] fields;
    private static int size;
    private static ClientHandler currentPlayer;

    public Model(int size) {
        Model.size = size;
        fields = new int [size][size];
        setTiles();
        placeCheckers();
    }

    public static void setCurrentPlayer(ClientHandler player){
        currentPlayer = player;
    }

    public static ClientHandler getCurrentPlayer(){
        return currentPlayer;
    }
    static public int getSize()
    {
        return size;
    }
    public static int getField(int row, int col) {
        return fields[row][col];
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
                if((i + j) % 2 == 1)
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
        for(int[] x : fields) {
            for(int y : x)
            {
                string = string.concat(Integer.toString(y));
            }
        }
        System.out.println(string);
        return string;
    }

    //ustawia pionki 2 - biale 3 - czarne
    public static void placeCheckers(){
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

    public static boolean checkPlayer(int x1, int y1){
        if(currentPlayer.getMark() == 'W')
            return getField(y1, x1) == 2;

        else
            return getField(y1, x1) == 3;

    }

    public static synchronized boolean move(int x1, int y1, int x2, int y2) {
        //can't move to a white field (1) or other pawn (2,3)
        if (getField(y2, x2) != 1) {
            return false;
        }
                switch (getField(y1, x1)) {
                    //if white pawn
                    case 2 -> {
                        return moveAccToColor(x1, y1, x2, y2, 2);
                    }
                    //if black pawn
                    case 3 -> {
                        return moveAccToColor(x1, y1, x2, y2, 3);
                    }
                    //if something else
                    default -> {
                        return false;
                    }
                }
    }

    //pawnColor - (2) white - (3) black
    private static boolean moveAccToColor(int x1, int y1, int x2, int y2, int pawnColor)
    {
        switch(abs(x1-x2)){
            //if destination is "sideways" by
            case 1 -> {
                //normal move
                //check if move is "upwards"
                if((y1 - y2 == 1 && pawnColor == 2) ||
                    (y1 - y2 == -1 && pawnColor == 3)) {
                    setField(y1, x1, 1);
                    setField(y2, x2, pawnColor);
                    return true;
                }
                else {
                    return false;
                }
            }
            case 2 -> {
                return punch(x1, y1, x2, y2, pawnColor);
            }
            default -> {
                return false;
            }
        }
    }

    private static boolean punch(int x1, int y1, int x2, int y2, int pawnColor)
    {
        if(x2 > x1 && y2 < y1) {
            setField(y1, x1, 1);
            setField(y1 - 1, x1 + 1, 1);
            setField(y2, x2, pawnColor);
        }
        else if(x2 < x1 && y2 < y1) {
            setField(y1, x1, 1);
            setField(y1 - 1, x1 - 1, 1);
            setField(y2, x2, pawnColor);
        }
        else if(x2 < x1 && y2 > y1) {
            setField(y1, x1, 1);
            setField(y1 + 1, x1 - 1, 1);
            setField(y2, x2, pawnColor);
        }
        else if(x2 > x1 && y2 > y1) {
            setField(y1, x1, 1);
            setField(y1 + 1, x1 + 1, 1);
            setField(y2, x2, pawnColor);
        }
        else
        {
            return false;
        }
        return true;
    }
}
