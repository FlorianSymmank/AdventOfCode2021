package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternfishTest {

    @Test
    void LanternfishGrowth(){
        List<Integer> fishages = Arrays.asList(3,4,3,1,2);
        Lanternfish lanternfish = new Lanternfish(fishages);
        assertEquals(26, lanternfish.growPopulation(18));
        assertEquals(5934, lanternfish.growPopulation(80));
        assertEquals(26984457539l, lanternfish.growPopulation(256));

    }
}
