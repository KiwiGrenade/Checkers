package Model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @BeforeEach
    void setUp() {
        Board board = new Board(Board.getSize());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSize() {
        assertEquals(8, Board.getSize());
    }

    @Test
    void getField() {
        assertEquals();
    }

    @Test
    void setField() {
    }

    @Test
    void getAllFields() {
    }

    @Test
    void setAllFields() {
    }

    @Test
    void setFields() {
    }

    @Test
    void placeCheckers() {
    }
}