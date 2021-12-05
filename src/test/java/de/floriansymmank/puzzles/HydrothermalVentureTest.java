package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HydrothermalVentureTest {

    @Test
    void getNumberOfAreasToAvoid() {
        List<Line> lines = Arrays.asList(
                new Line(new Point(0, 9), new Point(5, 9)),
                new Line(new Point(8, 0), new Point(0, 8)),
                new Line(new Point(9, 4), new Point(3, 4)),
                new Line(new Point(2, 2), new Point(2, 1)),
                new Line(new Point(7, 0), new Point(7, 4)),
                new Line(new Point(6, 4), new Point(2, 0)),
                new Line(new Point(0, 9), new Point(2, 9)),
                new Line(new Point(3, 4), new Point(1, 4)),
                new Line(new Point(0, 0), new Point(8, 8)),
                new Line(new Point(5, 5), new Point(8, 2))
        );

        HydrothermalVenture htv = new HydrothermalVenture(lines);
        assertEquals(5, htv.getNumberOfAreasToAvoid());
    }

    @Test
    void getNumberOfAreasToAvoidDiagonal(){
        List<Line> lines = Arrays.asList(
                new Line(new Point(0, 9), new Point(5, 9)),
                new Line(new Point(8, 0), new Point(0, 8)),
                new Line(new Point(9, 4), new Point(3, 4)),
                new Line(new Point(2, 2), new Point(2, 1)),
                new Line(new Point(7, 0), new Point(7, 4)),
                new Line(new Point(6, 4), new Point(2, 0)),
                new Line(new Point(0, 9), new Point(2, 9)),
                new Line(new Point(3, 4), new Point(1, 4)),
                new Line(new Point(0, 0), new Point(8, 8)),
                new Line(new Point(5, 5), new Point(8, 2))
        );

        HydrothermalVenture htv = new HydrothermalVenture(lines);
        assertEquals(12, htv.getNumberOfAreasToAvoidDiagonal());
    }
}