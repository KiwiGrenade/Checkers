package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EnglishQueenTest {

    Model model;
    @BeforeEach
    void setUp() {
        model = new Model(8, "1");
    }

    @Test
    void normalMove() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 4, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 4, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Pawn pawn = new WhiteQueen(3, 4);
        pawn.normalMove(4, 3);
        assertArrayEquals(testBoard, Model.getAllFields(), "Queen: move up right");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 1, 0, 4, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn.normalMove(3, 2);
        assertArrayEquals(testBoard, Model.getAllFields(), "Queen: move up left");


        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 4, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn.normalMove(2, 3);
        assertArrayEquals(testBoard, Model.getAllFields(), "Queen: move down left");


        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 1, 0, 1, 0, 1, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 4, 0, 1, 0, 1},//4
                {1, 0, 1, 0, 1, 0, 1, 0},//5
                {0, 1, 0, 1, 0, 1, 0, 1},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn.normalMove(3, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "Queen: move down right");
    }

    @Test
    void isPunchUpLeftAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 1, 0},//1
                {0, 1, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 3, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 4, 0, 1, 0, 1},//4
                {2, 0, 1, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhiteQueen(3, 4);
        assertTrue(pawn.isPunchUpLeftAvi(pawn.x1, pawn.y1, pawn.color));
        assertFalse(pawn.isPunchUpRightAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchUpRightAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {1, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 1, 0, 3},//2
                {1, 0, 1, 0, 3, 0, 1, 0},//3
                {0, 1, 0, 4, 0, 1, 0, 1},//4
                {2, 0, 1, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhiteQueen(3, 4);
        assertTrue(pawn.isPunchUpRightAvi(pawn.x1, pawn.y1, pawn.color));
        assertFalse(pawn.isPunchUpLeftAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchDownLeftAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {1, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 1, 0, 3, 0, 1, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 4, 0, 1, 0, 1},//4
                {2, 0, 3, 0, 1, 0, 2, 0},//5
                {0, 1, 0, 2, 0, 3, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 1, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhiteQueen(3, 4);
        assertTrue(pawn.isPunchDownLeftAvi(pawn.x1, pawn.y1, pawn.color));
        assertFalse(pawn.isPunchDownRightAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchDownRightAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {1, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 1, 0, 3, 0, 1, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 4, 0, 1, 0, 1},//4
                {2, 0, 1, 0, 3, 0, 2, 0},//5
                {0, 3, 0, 2, 0, 1, 0, 2},//6
                {1, 0, 2, 0, 2, 0, 1, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhiteQueen(3, 4);
        assertTrue(pawn.isPunchDownRightAvi(pawn.x1, pawn.y1, pawn.color));
        assertFalse(pawn.isPunchDownLeftAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void punch() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 4, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };

        Model.setAllFields(testBoard);
        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 4, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Pawn pawn = new WhiteQueen(4, 5);
        pawn.punch(6,3);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch up right");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 4, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 4, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 1, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new WhiteQueen(6, 5);
        pawn.punch(4,3);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch up left");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 4, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 1, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 4, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new WhiteQueen(4, 3);
        pawn.punch(6,5);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch down right");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 4, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 1, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 4, 0, 1, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new WhiteQueen(6, 3);
        pawn.punch(4,5);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch down left");
    }
}
