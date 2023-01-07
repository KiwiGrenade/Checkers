package Model;

import Server.Model;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {
    Model model;

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


}