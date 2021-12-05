package de.floriansymmank.puzzles;

import de.floriansymmank.puzzles.DepthAnalysis;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DepthAnalysisTest {

    @Test
    void MeasureDepthIncrease() {
        List<Integer> depths = Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
        DepthAnalysis p = new DepthAnalysis(depths);
        assertEquals(7, p.measureIncrease());
    }

    @Test
    void MeasureDepthIncreaseSlidingWindow() {
        List<Integer> depths = Arrays.asList(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);
        DepthAnalysis p = new DepthAnalysis(depths);
        assertEquals(5, p.measureIncreaseSlidingWindow());
    }
}
