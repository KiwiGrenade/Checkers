package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RussianSwedenBlackPawnTest {

    Model model;
    @BeforeEach
    void setUp() {
        model = new Model(8, "1");
    }
    @Test
    void move() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 1, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 3, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.playerMove(3, 2, 4, 3);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: move left");
//        assertFalse(Model.playerMove(4,3, 3,2), "Black: move down");
//        assertFalse(Model.playerMove(7,0,6,1), "Black: step on pawn");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 1, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 3, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.playerMove(4, 3, 3, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: move right");
    }

    @Test
    void isPunchAvi() {
        Pawn pawn = new BlackPawn(0, 0);
        assertFalse(pawn.isPunchAvi(0, 0, pawn.color));
        pawn = new BlackPawn(0, 7);
        assertFalse(pawn.isPunchAvi(0, 7, pawn.color));
    }

    //TODO change isPunchAvi... for blackpawn
    @Test
    void isPunchUpLeftAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 2, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 3, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new BlackPawn(4, 5);
        assertTrue(pawn.isPunchUpLeftAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchUpRightAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 3, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new BlackPawn(4, 5);
        assertTrue(pawn.isPunchUpRightAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchDownLeftAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 3, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new BlackPawn(6, 3);
        assertTrue(pawn.isPunchDownLeftAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchDownRightAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 3, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 1, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new BlackPawn(4, 3);
        assertTrue(pawn.isPunchDownRightAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void punch() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 3, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };

        Model.setAllFields(testBoard);
        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 3, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Pawn pawn = new BlackPawn(4, 5);
        pawn.punch(6,3);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: punch up right");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 3, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 3, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 1, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new BlackPawn(6, 5);
        pawn.punch(4,3);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: punch up left");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 3, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
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
                {2, 0, 2, 0, 1, 0, 3, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new BlackPawn(4, 3);
        pawn.punch(6,5);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: punch down right");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 3, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
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
                {2, 0, 2, 0, 3, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new BlackPawn(6, 3);
        pawn.punch(4,5);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: punch down left");


        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 3, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 3, 0},//5
                {0, 1, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        pawn = new BlackPawn(4, 3);
        assertFalse(pawn.punch(1, 6), "Black: punch is same as queen!");

    }
}