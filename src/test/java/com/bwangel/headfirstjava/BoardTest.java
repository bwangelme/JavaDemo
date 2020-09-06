package com.bwangel.headfirstjava;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void getUserInputNum() {
    }

    @org.junit.jupiter.api.Test
    void getCoordinateFromPos() {
        Board b = new Board(6, 5);

        String res = b.getCoordinateFromPos(0);
        assertEquals(res, "A0");
        res = b.getCoordinateFromPos(27);
        assertEquals(res, "E3");
    }

    @org.junit.jupiter.api.Test
    void getLetterFromNum() {
        Board b = new Board(7, 7);

        String res = b.getLetterFromNum(0);
        assertEquals(res, "A");
        res = b.getLetterFromNum(3);
        assertEquals(res, "D");
    }

    @org.junit.jupiter.api.Test
    void isPosInBorder() {
        Board b = new Board(7, 6);

        // 检查水平边界
        assertTrue(b.isPosInBorder(35, 2, true));
        assertTrue(b.isPosInBorder(28, 2, true));
        assertFalse(b.isPosInBorder(14, 2, true));

        // 检查垂直边界
        assertTrue(b.isPosInBorder(6, 2, false));
        assertTrue(b.isPosInBorder(40, 2, false));
        assertFalse(b.isPosInBorder(23, 2, false));
    }
}