package Model;

import Server.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Model model;
    @AfterEach
    void tearDown() {
    }

    @BeforeEach
    void setUp() {
        model = new Model(8);
    }

    @Test
    void getSize() {
        assertEquals(8, Model.getSize());
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
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.move(4, 5, 5, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: move up right");
        assertFalse(Model.move(5,4, 4,5), "White: move down");
        assertFalse(Model.move(7,6,6,5), "White: step on pawn");

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
        Model.move(2, 5, 1, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: move left");
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
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.move(3, 2, 4, 3);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: move up right");
        assertFalse(Model.move(2, 3, 3, 2), "Black: move down");
        assertFalse(Model.move(7, 0, 6, 1), "Black: step on pawn");

        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 1, 0, 3, 0, 1},//2
                {1, 0, 1, 0, 3, 0, 3, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 2, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.move(7, 2, 6, 3);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: move left");
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
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.move(1, 2, 2, 3);
        Model.move(2, 3, 3, 4);
        Model.move(4, 5, 2, 3);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch up left");


        Model.setTiles();
        Model.placeCheckers();
        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 2, 0},//3
                {0, 1, 0, 1, 0, 1, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.move(7, 2, 6, 3);
        Model.move(6, 3, 5, 4);
        Model.move(4, 5, 6, 3);
        assertArrayEquals(testBoard, Model.getAllFields(), "White: punch up right");
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
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.move(4, 5, 5, 4);
        Model.move(5, 4, 6, 3);
        Model.move(5, 2, 7, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: punch up left");


        Model.setTiles();
        Model.placeCheckers();
        testBoard = new int[][]{
                //0,1, 2, 3, 4, 5, 6, 7
                {0, 3, 0, 3, 0, 3, 0, 3},//0
                {3, 0, 3, 0, 3, 0, 3, 0},//1
                {0, 3, 0, 3, 0, 3, 0, 1},//2
                {1, 0, 1, 0, 1, 0, 1, 0},//3
                {0, 1, 0, 1, 0, 3, 0, 1},//4
                {2, 0, 2, 0, 1, 0, 2, 0},//5
                {0, 2, 0, 2, 0, 2, 0, 2},//6
                {2, 0, 2, 0, 2, 0, 2, 0}//7
        };
        Model.move(4, 5, 5, 4);
        Model.move(5, 4, 6, 3);
        Model.move(7, 2, 5, 4);
        assertArrayEquals(testBoard, Model.getAllFields(), "Black: punch up right");
    }
}