package de.floriansymmank.puzzles;

import java.util.*;

public class DumboOctopus {
    private int[][] grid;
    private int[][] gridCopy;

    public DumboOctopus(int[][] grid) {
        this.grid = grid;

        // deep copy
        gridCopy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                gridCopy[i][j] = grid[i][j];
            }
        }
    }

    public int getFlashCount(int steps) {

        int flashCount = 0;

        for (int step = 0; step < steps; step++) {
            List<Integer> canFlash = increaseEnergyLevel();
            Set<Integer> flashed = new HashSet<>();

            for (int i = 0; i < canFlash.size(); i++) {
                if (flashed.contains(canFlash.get(i))) continue;

                int index = canFlash.get(i);
                List<Integer> neighbours = getAllNeighbours(index);
                for (Integer neighbour : neighbours) {
                    int row = neighbour / grid[0].length;
                    int col = neighbour % grid[0].length;
                    grid[row][col]++;
                    if (grid[row][col] > 9) {
                        canFlash.add(neighbour);
                    }
                }

                flashed.add(index);
                flashCount++;
            }

            for (Integer index : canFlash) {
                int row = index / grid[0].length;
                int col = index % grid[0].length;
                grid[row][col] = 0;
            }
        }

        return flashCount;
    }

    private List<Integer> increaseEnergyLevel() {
        List<Integer> canFlash = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col]++;

                if (grid[row][col] > 9) {
                    canFlash.add(row * grid[row].length + col);
                }
            }
        }

        return canFlash;
    }

    private List<Integer> getAllNeighbours(int index) {
        List<Integer> neighbours = new ArrayList<>();

        int row = index / grid[0].length;
        int col = index % grid[0].length;

        if (row > 0) {
            neighbours.add(index - grid[0].length);
        }

        if (row < grid.length - 1) {
            neighbours.add(index + grid[0].length);
        }

        if (col > 0) {
            neighbours.add(index - 1);
        }

        if (col < grid[0].length - 1) {
            neighbours.add(index + 1);
        }

        // diagonal neighbours
        if (row > 0 && col > 0) {
            neighbours.add(index - grid[0].length - 1);
        }

        if (row > 0 && col < grid[0].length - 1) {
            neighbours.add(index - grid[0].length + 1);
        }

        if (row < grid.length - 1 && col > 0) {
            neighbours.add(index + grid[0].length - 1);
        }

        if (row < grid.length - 1 && col < grid[0].length - 1) {
            neighbours.add(index + grid[0].length + 1);
        }

        return neighbours;
    }

    public int getAllFlashStep() {
        // reset grid
        grid = gridCopy;

        boolean allFlashStep = false;
        int steps = 0;

        while (!allFlashStep) {
            List<Integer> canFlash = increaseEnergyLevel();
            Set<Integer> flashed = new HashSet<>();

            for (int i = 0; i < canFlash.size(); i++) {
                if (flashed.contains(canFlash.get(i))) continue;

                int index = canFlash.get(i);
                List<Integer> neighbours = getAllNeighbours(index);
                for (Integer neighbour : neighbours) {
                    int row = neighbour / grid[0].length;
                    int col = neighbour % grid[0].length;
                    grid[row][col]++;
                    if (grid[row][col] > 9) {
                        canFlash.add(neighbour);
                    }
                }

                flashed.add(index);
            }

            for (Integer index : canFlash) {
                int row = index / grid[0].length;
                int col = index % grid[0].length;
                grid[row][col] = 0;
            }

            if(flashed.size() == 100)
                allFlashStep = true;

            steps++;
        }

        return steps;
    }

    @Override
    public String toString() {
        return "Day 11: (Dumbo Octopus) getFlashCount(100) = " + getFlashCount(100) + " //// getAllFlashStep() = " + getAllFlashStep();
    }
}
