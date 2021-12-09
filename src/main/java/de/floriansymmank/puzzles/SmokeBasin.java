package de.floriansymmank.puzzles;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class SmokeBasin {
    private int[][] map;

    public SmokeBasin(int[][] map) {
        this.map = map;
    }

    public int sumOfLowPoints() {
        int sum = 0;
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                if (isLowPoint(map[i][j], getNeighborValues(i, j)))
                    sum += map[i][j] + 1;

        return sum;
    }

    private Map<Point, Integer> getNeighborValues(int row, int column) {
        Map<Point, Integer> neighbors = new HashMap<>();
        if (row > 0)
            neighbors.put(new Point(row - 1, column), map[row - 1][column]);

        if (row < map.length - 1)
            neighbors.put(new Point(row + 1, column), map[row + 1][column]);

        if (column > 0)
            neighbors.put(new Point(row, column - 1), map[row][column - 1]);

        if (column < map[0].length - 1)
            neighbors.put(new Point(row, column + 1), map[row][column + 1]);

        return neighbors;
    }

    private boolean isLowPoint(int value, Map<Point, Integer> adjacents) {
        return adjacents.values().stream().min(Comparator.naturalOrder()).get() > value;
    }

    public int getValueOfThreeBiggestBasins() {

        Set<Point> checkedPoints = new HashSet<>();
        List<List<Point>> basins = new ArrayList<>();

        // try all points, skip if already checked means already part of a basin
        for (int row = 0; row < map.length; row++)
            for (int column = 0; column < map[0].length; column++) {
                Point p = new Point(row, column);
                if (!checkedPoints.contains(p)) {
                    List<Point> basin = getAllPointsOfBasin(p, checkedPoints);
                    basins.add(basin);
                }
            }

        // get three biggest basins and multiply their values
        basins.sort(Comparator.comparingInt(List::size));
        Collections.reverse(basins);
        return basins.get(0).size() * basins.get(1).size() * basins.get(2).size();
    }

    private List<Point> getAllPointsOfBasin(Point point, Set<Point> checkedPoints) {

        List<Point> points = new ArrayList<>();

        if (checkedPoints.contains(point) || map[point.x][point.y] == 9) // 9 cant be part of a basin
            return points;

        points.add(point);
        checkedPoints.add(point);

        Map<Point, Integer> n = getNeighborValues(point.x, point.y);

        for (Point p : n.keySet())
            points.addAll(getAllPointsOfBasin(p, checkedPoints));

        return points;
    }

    @Override
    public String toString() {
        return "Day 9 (SmokeBasin): sumOfLowPoints = " + sumOfLowPoints() + " //// getValueOfThreeBiggestBasins = " + getValueOfThreeBiggestBasins();
    }
}
