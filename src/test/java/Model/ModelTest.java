package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Model model;

    @BeforeEach
    void setUp() {
        model = new Model(8, "1");
    }

    @Test
    void getSize() {
        assertEquals(8, Model.getSize());
    }

    @Test
    void playerMove() {
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
        assertNotEquals(1, Model.playerMove(4, 3, 3, 2), "Black: move down");
        assertNotEquals(1, Model.playerMove(7, 0, 6, 1), "Black: step on pawn");

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

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 3, 0, 2, 0, 2},//6
                {2, 0, 1, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Model.playerMove(3, 6, 2, 7);
        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 1, 0, 2, 0, 2},//6
                {2, 0, 5, 0, 2, 0, 2, 0}//7
        };
        assertArrayEquals(testBoard, Model.getAllFields(), "Change to BlackQueen not working");

        testBoard = new int[][]{
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

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 1, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 3, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.playerMove(3, 2, 4, 3);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: move left");
        assertNotEquals(1, Model.playerMove(4, 3, 3, 2), "Black: move down");
        assertNotEquals(1, Model.playerMove(7, 0, 6, 1), "Black: step on pawn");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 1, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 3, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.playerMove(4, 3, 3, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: move right");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 3, 0, 2, 0, 2},//6
                {2, 0, 1, 0, 2, 0, 2, 0}//7
        };
        Model.setAllFields(testBoard);
        Model.playerMove(3, 6, 2, 7);
        testBoard = new int[][] {
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 3},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 1, 0, 2, 0, 2},//6
                {2, 0, 5, 0, 2, 0, 2, 0}//7
        };
        assertArrayEquals(testBoard, Model.getAllFields(), "Change to BlackQueen not working");
    }

    @Test
    void getField() {
        assertEquals(2, Model.getField(7, 0));
        assertEquals(0, Model.getField(0, 0));
        assertEquals(0, Model.getField(7, 7));
        assertEquals(3, Model.getField(0, 7));
    }
    @Test
    void setField() {
        Model.setField(6, 2, 18);
        assertEquals(18, Model.getField(6,2));
    }

    @Test
    void getAllFields() {
        Model.setTiles();
        Model.setField(0, 7, 18);
        Model.setField(7, 7, 20);
        Model.setField(7, 0, 30);
        int[][] testBoard = {
                {0, 1, 0, 1, 0, 1, 0, 18},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {30, 0, 1, 0, 1, 0, 1, 20}
        };
        assertArrayEquals(testBoard, Model.getAllFields());
    }

    @Test
    void setAllFields() {
        Model.setTiles();
        int[][] testBoard = {
                {0, 1, 0, 1, 0, 1, 0, 18},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {30, 0, 1, 0, 1, 0, 1, 20}
        };
        Model.setAllFields(testBoard);
        assertArrayEquals(testBoard, Model.getAllFields());
    }

    @Test
    void setTiles() {
        Model.setTiles();
        int[][] testBoard = {
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0}
        };
        assertArrayEquals(testBoard, Model.getAllFields());
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
                {2, 0, 2, 0, 2, 0, 2, 0}
        };
        assertArrayEquals(testBoard, Model.getAllFields());
    }


}