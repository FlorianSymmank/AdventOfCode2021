package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmokeBasinTest {

    @Test
    void sumOfLowPoints() {
        int[][] map = new int[][]{
                new int[]{2, 1, 9, 9, 9, 4, 3, 2, 1, 0},
                new int[]{3, 9, 8, 7, 8, 9, 4, 9, 2, 1},
                new int[]{9, 8, 5, 6, 7, 8, 9, 8, 9, 2},
                new int[]{8, 7, 6, 7, 8, 9, 6, 7, 8, 9},
                new int[]{9, 8, 9, 9, 9, 6, 5, 6, 7, 8}
        };

        SmokeBasin smokeBasin = new SmokeBasin(map);
        assertEquals(15, smokeBasin.sumOfLowPoints());
    }

    @Test
    void getValueOfThreeBiggestBasins(){
        int[][] map = new int[][]{
                new int[]{2, 1, 9, 9, 9, 4, 3, 2, 1, 0},
                new int[]{3, 9, 8, 7, 8, 9, 4, 9, 2, 1},
                new int[]{9, 8, 5, 6, 7, 8, 9, 8, 9, 2},
                new int[]{8, 7, 6, 7, 8, 9, 6, 7, 8, 9},
                new int[]{9, 8, 9, 9, 9, 6, 5, 6, 7, 8}
        };

        SmokeBasin smokeBasin = new SmokeBasin(map);
        assertEquals(1134, smokeBasin.getValueOfThreeBiggestBasins());
    }
}
