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
        Board.placeCheckers();
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
}