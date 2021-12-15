package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransparentOrigamiTest {

    @Test
    void getVisiblePointsCount() {
        List<String> instructions = Arrays.asList(
                "6,10",
                "0,14",
                "9,10",
                "0,3",
                "10,4",
                "4,11",
                "6,0",
                "6,12",
                "4,1",
                "0,13",
                "10,12",
                "3,4",
                "3,0",
                "8,4",
                "1,10",
                "2,14",
                "8,10",
                "9,0",
                "",
                "fold along y=7",
                "fold along x=5"
        );

        TransparentOrigami origami = new TransparentOrigami(instructions);
        assertEquals(17, origami.getVisiblePointsCount(1));
    }
}
