package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;
    @AfterEach
    void tearDown() {
    }

    @BeforeEach
    void setUp() {
        board = new Board(8);
    }

    @Test
    void getSize() {
        assertEquals(8, Board.getSize());
    }
    @Test
    void getField() {
        assertEquals(2, Board.getField(7, 0));
        assertEquals(0, Board.getField(0, 0));
        assertEquals(0, Board.getField(7, 7));
        assertEquals(3, Board.getField(0, 7));
    }
    @Test
    void setField() {
        Board.setField(6, 2, 18);
        assertEquals(18, Board.getField(6,2));
    }

    @Test
    void getAllFields() {
        Board.setTiles();
        Board.setField(0, 7, 18);
        Board.setField(7, 7, 20);
        Board.setField(7, 0, 30);
        int[][] testBoard = {
                {0, 1, 0, 1, 0, 1, 0, 18},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {30, 0, 1, 0, 1, 0, 1, 20},
        };
        assertArrayEquals(testBoard, Board.getAllFields());
    }

    @Test
    void setAllFields() {
        Board.setTiles();
        int[][] testBoard = {
                {0, 1, 0, 1, 0, 1, 0, 18},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {30, 0, 1, 0, 1, 0, 1, 20},
        };
        Board.setAllFields(testBoard);
        assertArrayEquals(testBoard, Board.getAllFields());
    }

    @Test
    void setTiles() {
        Board.setTiles();
        int[][] testBoard = {
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
        };
        assertArrayEquals(testBoard, Board.getAllFields());
    }

    @Test
    void placeCheckers() {
        int[][] testBoard = {
                {0, 3, 0, 3, 0, 3, 0, 3},
                {3, 0, 3, 0, 3, 0, 3, 0},
                {0, 3, 0, 3, 0, 3, 0, 3},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {2, 0, 2, 0, 2, 0, 2, 0},
                {0, 2, 0, 2, 0, 2, 0, 2},
                {2, 0, 2, 0, 2, 0, 2, 0},
        };
        assertArrayEquals(testBoard, Board.getAllFields());
    }

    @Test
    void moveWhite() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0},//7
        };
        Board.move(4, 5, 5, 4);
        assertArrayEquals(testBoard, Board.getAllFields(), "White: move up right");
        assertFalse(Board.move(5,4, 4,5), "White: move down");
        assertFalse(Board.move(7,6,6,5), "White: step on pawn");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 2, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 1, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0},//7
        };
        Board.move(2, 5, 1, 4);
        assertArrayEquals(testBoard, Board.getAllFields(), "White: move left");
    }

    @Test
    void moveBlack() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 1, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 3, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0},//7
        };
        Board.move(3, 2, 4, 3);
        assertArrayEquals(testBoard, Board.getAllFields(), "Black: move up right");
        assertFalse(Board.move(2, 3, 3, 2), "Black: move down");
        assertFalse(Board.move(7, 0, 6, 1), "Black: step on pawn");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 1, 0, 3, 0, 1},//2
                {1, 0, 1, 0, 3, 0, 3, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0},//7
        };
        Board.move(7, 2, 6, 3);
    }

    @Test
    void punchBlack()
    {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 1, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 3},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0},//7
        };
        Board.move(4, 5, 5, 4);
        Board.move(5, 4, 6, 3);
        Board.move(5, 2, 7, 4);
        assertArrayEquals(testBoard, Board.getAllFields(), "Black: punch up left");


        Board.setTiles();
        Board.placeCheckers();
        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0},//7
        };
        Board.move(4, 5, 5, 4);
        Board.move(5, 4, 6, 3);
        Board.move(7, 2, 5, 4);
        assertArrayEquals(testBoard, Board.getAllFields(), "Black: punch up right");
    }

    @Test
    void punchWhite()
    {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 1, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 2, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0},//7
        };
        Board.move(1, 2, 2, 3);
        Board.move(2, 3, 3, 4);
        Board.move(4, 5, 2, 3);
        assertArrayEquals(testBoard, Board.getAllFields(), "White: punch up left");


        Board.setTiles();
        Board.placeCheckers();
        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0},//7
        };
        Board.move(7, 2, 6, 3);
        Board.move(6, 3, 5, 4);
        Board.move(4, 5, 6, 3);
        assertArrayEquals(testBoard, Board.getAllFields(), "White: punch up right");
    }
}