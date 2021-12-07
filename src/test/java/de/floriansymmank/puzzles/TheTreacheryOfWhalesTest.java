package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheTreacheryOfWhalesTest {

    @Test
    void calculateMinimumFuelUsageMedian() {
        List<Integer> input = Arrays.asList(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);
        TheTreacheryOfWhales c = new TheTreacheryOfWhales(input);
        assertEquals(37, c.calculateMinimumFuelUsageMedian());
    }

    @Test
    void calculateMinimumFuelUsageAverage() {
        List<Integer> input = Arrays.asList(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);
        TheTreacheryOfWhales c = new TheTreacheryOfWhales(input);
        assertEquals(168, c.calculateMinimumFuelUsageAverage());
    }
}
