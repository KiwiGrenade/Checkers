package Server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhitePawnTest {

    Model model;
    @BeforeEach
    void setUp() {
        model = new Model(8);
    }
    @Test
    void move() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.playerMove(4, 5, 5, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: move up right");
//        assertFalse(Model.playerMove(5,4, 4,5), "White: move down");
//        assertFalse(Model.playerMove(7,6,6,5), "White: step on pawn");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 2, 0, 1, 0, 2, 0, 1},//4
                {2, 0, 1, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.playerMove(2, 5, 1, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: move left");

//
//        testBoard = new int[][]{
//                //0,1, 2, 3, 4, 5, 6, 7
//                {0, 3, 0, 1, 0, 3, 0, 3},//0
//                {3, 0, 3, 0, 2, 0, 3, 0},//1
//                {0, 3, 0, 3, 0, 3, 0, 3},//2
//                {1, 0, 1, 0, 1, 0, 1, 0},//3
//                {0, 1, 0, 1, 0, 3, 0, 1},//4
//                {2, 0, 2, 0, 2, 0, 2, 0},//5
//                {0, 2, 0, 2, 0, 2, 0, 2},//6
//                {2, 0, 2, 0, 2, 0, 2, 0}//7
//        };
//        Model.setAllFields(testBoard);
//        Pawn pawn = new WhitePawn(4, 1);
//        pawn.normalMove(3, 0);
//        testBoard = new int[][] {
//                //0,1, 2, 3, 4, 5, 6, 7
//                {0, 3, 0, 4, 0, 3, 0, 3},//0
//                {3, 0, 3, 0, 1, 0, 3, 0},//1
//                {0, 3, 0, 3, 0, 3, 0, 3},//2
//                {1, 0, 1, 0, 1, 0, 1, 0},//3
//                {0, 1, 0, 1, 0, 3, 0, 1},//4
//                {2, 0, 2, 0, 2, 0, 2, 0},//5
//                {0, 2, 0, 2, 0, 2, 0, 2},//6
//                {2, 0, 2, 0, 2, 0, 2, 0}//7
//        };
//        assertArrayEquals(testBoard, Model.getAllFields(), "Change to WhiteQueen not working");
    }

    @Test
    void isPunchAvi() {
        Pawn pawn = new WhitePawn(7, 0);
        assertFalse(pawn.isPunchAvi(pawn.x1, pawn.y1, pawn.color));
        pawn = new BlackPawn(7, 7);
        assertFalse(pawn.isPunchAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchUpLeftAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 3, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhitePawn(4, 5);
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
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhitePawn(4, 5);
        assertTrue(pawn.isPunchUpRightAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchDownLeftAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhitePawn(6, 3);
        assertTrue(pawn.isPunchDownLeftAvi(pawn.x1, pawn.y1, pawn.color));
    }

    @Test
    void isPunchDownRightAvi() {
        int[][] testBoard = {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 2, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 1, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Pawn pawn = new WhitePawn(4, 3);
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
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };

        Model.setAllFields(testBoard);
        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Pawn pawn = new WhitePawn(4, 5);
        pawn.punch(6,3);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch up right");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
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
                {1, 0, 1, 0, 2, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 1, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new WhitePawn(6, 5);
        pawn.punch(4,3);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch up left");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 2, 0, 2, 0},//3
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
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new WhitePawn(4, 3);
        pawn.punch(6,5);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch down right");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
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
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        pawn = new WhitePawn(6, 3);
        pawn.punch(4,5);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch down left");
    }
}