package Model;

import Server.ClientHandler;

/**
 * Glowna klasa odpowiedzialna za caly model warcabow
 */
public class Model {
    private static int[][] fields;
    private static int size;
    private static ClientHandler currentPlayer;
    private static int gameMode;
    public static int getGameMode() {
        return gameMode;
    }

    /**
     * Tworzy tablice do gry o podanym rozmiarze i trybie
     * @param size Rozmiar tablicy
     * @param gameMode1 Tryb rozgrywki
     */
    public Model(int size, String gameMode1) {
        Model.size = size;
        fields = new int[size][size];
        gameMode = Integer.parseInt(gameMode1);
        setTiles();
        placeCheckers();
    }

    /**
     * Ustawia aktualnego gracza
     * @param player Aktualny gracz
     */
    public static void setCurrentPlayer(ClientHandler player) {
        currentPlayer = player;
    }

    public static ClientHandler getCurrentPlayer() {
        return currentPlayer;
    }

    static public int getSize() {
        return size;
    }

    /**
     * Zwraca konkretne pole na tablicy
     * @param row Rzad
     * @param col Kolumna
     * @return Zawartosc pola x,y
     */
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

    /**
     * Metoda pomocnicza dla testow jednostkowych, ustawia konkretne wartosci dla tablicy
     * @param fields Wartosci pol
     */
    public static void setAllFields(int[][] fields) {
        Model.fields = fields;
    }

    /**
     * Metoda ustawiajaca kolory pol na szachownicy
     */
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

    /**
     * Metoda przerabiajaca aktualny stan tablicy na ciag cyfr w celu ulatwienia komunikacji z serwerem
     * @return Tablica w postaci ciagu cyfr
     */
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

    /**
     * Metoda sprawdzajaca aktualny stan tablicy i informujaca o zwyciestwie jednego z graczy
     * @param boardState Stan tablicy
     * @return Informacja o zwyciestwie
     */
    public static boolean win(String boardState){
        if(!boardState.contains("3") && !boardState.contains("5"))
            return true;
        if(!boardState.contains("2") && !boardState.contains("4"))
            return true;
        else
            return false;
    }

    /**
     * Metoda rozstawiajaca pionki na starcie gry
     */
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

    /**
     * Metoda sprawdzajaca kolor danego gracza w celu weryfikacji poprawnego wybrania pionka
     * @param x1 Pozycja x pionka
     * @param y1 Pozycja y pionka
     * @return Czy gracz ma prawo sie nim ruszac
     */
    public static boolean checkPlayer(int x1, int y1) {
        if (currentPlayer.getMark() == 'W')
            return (getField(y1, x1) == 2) || (getField(y1, x1) == 4);
        else
            return (getField(y1, x1) == 3) || (getField(y1, x1) == 5);

    }

    /**
     * Metoda obslugujaca ruchy pionkow
     * @param x1 Pozycja poczatkowa x
     * @param y1 Pozycja poczatkowa y
     * @param x2 Pozycja koncowa x
     * @param y2 Pozycja koncowa y
     * @return Czy mozna wykonac ruch
     */
    public static int playerMove(int x1, int y1, int x2, int y2) {
        //can't move to a white field (1) or other pawn (2,3)
        if (getField(y2, x2) != 1 || getField(y1, x1) < 2) {
            return 0;
        }
        Pawn pawn;
        switch (getField(y1, x1)) {
            case 2 -> pawn = new WhitePawn(x1, y1);
            case 3 -> pawn = new BlackPawn(x1, y1);
            case 4 -> pawn = new WhiteQueen(x1, y1);
            case 5 -> pawn = new BlackQueen(x1, y1);
            default -> {
                return 0;
            }
        }
        //multiple punches - change to queen in the middle of the game
        if(pawn.punch(x2, y2)) {
            if(gameMode == 1 && pawn.isLastRow(y2)) {
                Model.setField(y2, x2, pawn.color == 2 ? 4 : 5);
                return 1;
            }
            if(pawn.isPunchAvi(x2, y2, getField(y2, x2))) {
                if(gameMode == 3 && pawn.isLastRow(y2)) {
                    Model.setField(y2, x2, pawn.color == 2 ? 4 : 5);
                }
                return 2;
            }
            if(pawn.isLastRow(y2)){
                Model.setField(y2, x2, pawn.color == 2 ? 4 : 5);
            }
            return 1;
        }
        else if (pawn.normalMove(x2, y2)){
            if(pawn.isLastRow(y2)){
                Model.setField(y2, x2, pawn.color == 2 ? 4 : 5);
            }
            return 1;
        }
        else{
            return 0;
        }
    }
}