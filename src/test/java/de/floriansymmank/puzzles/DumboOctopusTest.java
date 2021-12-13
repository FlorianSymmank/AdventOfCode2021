package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DumboOctopusTest {

    @Test
    void getFlashCount() {
        int[][] grid = new int[][]{
                new int[]{5, 4, 8, 3, 1, 4, 3, 2, 2, 3},
                new int[]{2, 7, 4, 5, 8, 5, 4, 7, 1, 1},
                new int[]{5, 2, 6, 4, 5, 5, 6, 1, 7, 3},
                new int[]{6, 1, 4, 1, 3, 3, 6, 1, 4, 6},
                new int[]{6, 3, 5, 7, 3, 8, 5, 4, 7, 8},
                new int[]{4, 1, 6, 7, 5, 2, 4, 6, 4, 5},
                new int[]{2, 1, 7, 6, 8, 4, 1, 7, 2, 1},
                new int[]{6, 8, 8, 2, 8, 8, 1, 1, 3, 4},
                new int[]{4, 8, 4, 6, 8, 4, 8, 5, 5, 4},
                new int[]{5, 2, 8, 3, 7, 5, 1, 5, 2, 6}
        };

        DumboOctopus dumbo = new DumboOctopus(grid);
        assertEquals(1656, dumbo.getFlashCount(100));
    }

    @Test
    void getAllFlashStep(){
        int[][] grid = new int[][]{
                new int[]{5, 4, 8, 3, 1, 4, 3, 2, 2, 3},
                new int[]{2, 7, 4, 5, 8, 5, 4, 7, 1, 1},
                new int[]{5, 2, 6, 4, 5, 5, 6, 1, 7, 3},
                new int[]{6, 1, 4, 1, 3, 3, 6, 1, 4, 6},
                new int[]{6, 3, 5, 7, 3, 8, 5, 4, 7, 8},
                new int[]{4, 1, 6, 7, 5, 2, 4, 6, 4, 5},
                new int[]{2, 1, 7, 6, 8, 4, 1, 7, 2, 1},
                new int[]{6, 8, 8, 2, 8, 8, 1, 1, 3, 4},
                new int[]{4, 8, 4, 6, 8, 4, 8, 5, 5, 4},
                new int[]{5, 2, 8, 3, 7, 5, 1, 5, 2, 6}
        };

        DumboOctopus dumbo = new DumboOctopus(grid);
        assertEquals(195, dumbo.getAllFlashStep());
    }
}
