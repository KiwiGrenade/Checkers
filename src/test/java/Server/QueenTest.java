package Server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    Model model;
    @BeforeEach
    void setUp() {
        model = new Model(8);
    }

    @Test
    void normalMove() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 1},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 4, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhiteQueen(4, 3);
        pawn.normalMove(7, 0);

        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 4},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };

        assertArrayEquals(testBoard, Model.getAllFields(), "Move queen up right");

        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 1},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 4, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };

        Model.setAllFields(testBoard);
        pawn = new WhiteQueen(4, 3);
        pawn.normalMove(1, 0);

        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 4, 0, 1, 0, 1, 0, 1},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };

        assertArrayEquals(testBoard, Model.getAllFields(), "Move queen up left");

        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 1},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 4, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };

        Model.setAllFields(testBoard);
        pawn = new WhiteQueen(4, 3);
        pawn.normalMove(0, 7);

        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 1},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {4, 0, 1, 0, 1, 0, 1, 0}//7
        };

        assertArrayEquals(testBoard, Model.getAllFields(), "Move queen down left");

        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 1},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 4, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };

        Model.setAllFields(testBoard);
        pawn = new WhiteQueen(4, 3);
        pawn.normalMove(7, 6);

        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 1},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 4},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };
        assertArrayEquals(testBoard, Model.getAllFields(), "Move queen down right");
    }

    @Test
    void isPunchAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 3},//0
                {1, 0, 3, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 4, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 3, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhiteQueen(4, 3);
        assertTrue(pawn.isPunchUpLeftAvi(pawn.x1, pawn.y1, pawn.color), "Punch up left");
        assertFalse(pawn.isPunchUpRightAvi(pawn.x1, pawn.y1, pawn.color), "Punch up right");
        assertTrue(pawn.isPunchDownLeftAvi(pawn.x1, pawn.y1, pawn.color), "Punch down left");
        assertTrue(pawn.isPunchDownRightAvi(pawn.x1, pawn.y1, pawn.color), "Punch down right");
        assertArrayEquals(testBoard, Model.getAllFields(), "isPunchAvi() changes the map!");
    }

    @Test
    void punch() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 3},//0
                {1, 0, 3, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 4, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 3, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new Queen(4, 3, 4);
        pawn.punch(1, 0);

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 4, 0, 1, 0, 1, 0, 3},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 3, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };
        assertArrayEquals(testBoard, Model.getAllFields(), "White queen up left punch");
        pawn = new Queen(1, 0, 4);
        pawn.punch(6, 5);

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 1, 0, 1, 0, 1, 0, 3},//0
                {1, 0, 1, 0, 1, 0, 1, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 4, 0},//5
                {0, 3, 0, 1, 0, 1, 0, 1},//6
                {1, 0, 1, 0, 1, 0, 1, 0}//7
        };
        assertArrayEquals(testBoard, Model.getAllFields(), "White queen up left punch");
    }
}