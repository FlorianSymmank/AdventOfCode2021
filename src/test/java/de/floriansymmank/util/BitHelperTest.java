package de.floriansymmank.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BitHelperTest {

    @Test
    void getMostCommonBitAt() {
        List<Integer> list = Arrays.asList(0b101, 0b101, 0b010, 0b100);
        assertEquals(0, BitHelper.getMostCommonBitAt(0, list));
        assertEquals(0, BitHelper.getMostCommonBitAt(1, list));
        assertEquals(1, BitHelper.getMostCommonBitAt(2, list));
    }

    @Test
    void getMostCommonBitAtPreferOneIfEquals() {
        List<Integer> list = Arrays.asList(0b101, 0b101, 0b010, 0b100);
        assertEquals(1, BitHelper.getMostCommonBitAt(0, list, true));
        assertEquals(0, BitHelper.getMostCommonBitAt(1, list, true));
        assertEquals(1, BitHelper.getMostCommonBitAt(2, list, true));
    }

    @Test
    void getLeastCommonBitAt(){
        List<Integer> list = Arrays.asList(0b101, 0b101, 0b010, 0b100);
        assertEquals(0, BitHelper.getLeastCommonBitAt(0, list));
        assertEquals(1, BitHelper.getLeastCommonBitAt(1, list));
        assertEquals(0, BitHelper.getLeastCommonBitAt(2, list));
    }

    @Test
    void getLeastCommonBitAtPreferOneIfEquals(){
        List<Integer> list = Arrays.asList(0b101, 0b101, 0b010, 0b100);
        assertEquals(1, BitHelper.getLeastCommonBitAt(0, list, true));
        assertEquals(1, BitHelper.getLeastCommonBitAt(1, list, true));
        assertEquals(0, BitHelper.getLeastCommonBitAt(2, list, true));
    }

    @Test
    void getBitAt() {
        assertEquals(1, BitHelper.getBitAt(0, 0b101));
        assertEquals(0, BitHelper.getBitAt(1, 0b101));
        assertEquals(1, BitHelper.getBitAt(2, 0b101));
    }
}