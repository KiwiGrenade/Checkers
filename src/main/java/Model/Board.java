package Model;

import static java.lang.Math.abs;

public class Board {
    private static int[][] fields;
    private static int size;

    public Board(int size) {
        Board.size = size;
        fields = new int [size][size];
        setTiles();
        placeCheckers();
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
        Board.fields = fields;
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

    public static boolean move(int x1, int y1, int x2, int y2) {
        //can't move to a white field (1) or other pawn (2,3)
        if (getField(y2, x2) != 1) {
            return false;
        }

        switch (getField(y1, x1)) {
            //if white pawn
            case 2 -> {
                switch(abs(x1-x2)){
                    //if destination is "sideways" by
                    //one
                    case 1 -> {
                        //normal move
                        //check if move is "upwards"
                        if(y1-y2 == 1)
                        {
                            setField(y1, x1, 1);
                            setField(y2, x2, 2);
                        }
                        else {
                            return false;
                        }
                    }
                    //two
                    case 2 -> {
                        //punch
                        if(x2 > x1 && y2 < y1) {
                            setField(y1, x1, 1);
                            setField(y1 - 1, x1 + 1, 1);
                            setField(y2, x2, 2);
                        }
                        else if(x2 < x1 && y2 < y1) {
                            setField(y1, x1, 1);
                            setField(y1 - 1, x1 - 1, 1);
                            setField(y2, x2, 2);
                        }
                        else if(x2 < x1 && y2 > y1) {
                            setField(y1, x1, 1);
                            setField(y1 + 1, x1 - 1, 1);
                            setField(y2, x2, 2);
                        }
                        else if(x2 > x1 && y2 > y1) {
                            setField(y1, x1, 1);
                            setField(y1 + 1, x1 + 1, 1);
                            setField(y2, x2, 2);
                        }
                        else {
                            return false;
                        }
                    }
                    default -> {
                        return false;
                    }
                }
            }
            //if black pawn
            case 3 -> {
                switch(abs(x1-x2)){
                    //if destination is "sideways" by
                    //one
                    case 1 -> {
                        //normal move
                        //check if move is "upwards"
                        if(y2-y1 == 1)
                        {
                            setField(y1, x1, 1);
                            setField(y2, x2, 3);
                        }
                        else {
                            return false;
                        }
                    }
                    //two
                    case 2 -> {
                        //punch
                        if(x2 > x1 && y2 < y1) {
                            setField(y1, x1, 1);
                            setField(y1 - 1, x1 + 1, 1);
                            setField(y2, x2, 3);
                        }
                        else if(x2 < x1 && y2 < y1) {
                            setField(y1, x1, 1);
                            setField(y1 - 1, x1 - 1, 1);
                            setField(y2, x2, 3);
                        }
                        else if(x2 < x1 && y2 > y1) {
                            setField(y1, x1, 1);
                            setField(y1 + 1, x1 - 1, 1);
                            setField(y2, x2, 3);
                        }
                        else if(x2 > x1 && y2 > y1) {
                            setField(y1, x1, 1);
                            setField(y1 + 1, x1 + 1, 1);
                            setField(y2, x2, 3);
                        }
                        else {
                            return false;
                        }
                    }
                    default -> {
                        return false;
                    }
                }

            }
            //if something else
            default -> {
                return false;
            }
        }
        return true;
    }
}
