package de.floriansymmank.puzzles;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://adventofcode.com/2021/day/5
 * Done like a 3 year old ... well it works
 */
public class HydrothermalVenture {
    private final List<Line> lines;
    private final List<Line> nonDiagonalLines;

    public HydrothermalVenture(List<Line> lines) {
        this.lines = lines;
        this.nonDiagonalLines = lines.stream().filter(line -> !line.isDiagonal()).collect(java.util.stream.Collectors.toList());
    }

    public int getNumberOfAreasToAvoid() {
        int maxXGrid = lines.stream().mapToInt(line -> Math.max(line.getStart().x, line.getEnd().x)).max().getAsInt() + 1;
        int maxYGrid = lines.stream().mapToInt(line -> Math.max(line.getStart().y, line.getEnd().y)).max().getAsInt() + 1;

        int[][] grid = new int[maxYGrid][maxXGrid];
        for (Line line : nonDiagonalLines) {
            for(Point point : line.getAllPoints()) {
                grid[point.y][point.x] = grid[point.y][point.x] + 1;
            }
        }

        int numberOfAreasToAvoid = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] > 1) {
                    numberOfAreasToAvoid++;
                }
            }
        }

        printGrid(grid);

        return numberOfAreasToAvoid;
    }


    public int getNumberOfAreasToAvoidDiagonal() {
        int maxXGrid = lines.stream().mapToInt(line -> Math.max(line.getStart().x, line.getEnd().x)).max().getAsInt() + 1;
        int maxYGrid = lines.stream().mapToInt(line -> Math.max(line.getStart().y, line.getEnd().y)).max().getAsInt() + 1;

        int[][] grid = new int[maxYGrid][maxXGrid];
        for (Line line : lines) {
            for(Point point : line.getAllPoints()) {
                grid[point.y][point.x] = grid[point.y][point.x] + 1;
            }
        }

        int numberOfAreasToAvoid = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] > 1) {
                    numberOfAreasToAvoid++;
                }
            }
        }

        //printGrid(grid);

        return numberOfAreasToAvoid;
    }

    @Override
    public String toString() {
        return "Day 5 (HydrothermalVenture): getNumberOfAreasToAvoid() = " + getNumberOfAreasToAvoid() + " //// getNumberOfAreasToAvoidDiagonal = " + getNumberOfAreasToAvoidDiagonal();
    }

    private void printGrid(int[][] grid) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                System.out.print((grid[y][x] > 0 ? grid[y][x] : ".") + " ");
            }
            System.out.println();
        }
    }
}
