package de.floriansymmank.puzzles;

import java.util.List;

/**
 * https://adventofcode.com/2021/day/2
 * https://adventofcode.com/2021/day/2#part2
 */
public class CourseCalculator {
    private final List<String> movements;

    public CourseCalculator(List<String> movements) {
        this.movements = movements;
    }

    public int getEndpoint() {
        int x = 0;
        int y = 0;

        for (String s : movements) {
            String[] parts = s.split(" ");
            int i = Integer.parseInt(parts[1]);

            switch (parts[0]) {
                case "forward" -> x += i;
                case "down" -> y += i;
                case "up" -> y -= i;
            }
        }

        return x * y;
    }

    public int getEndpointWithAim() {
        int x = 0;
        int y = 0;
        int aim = 0;

        for (String s : movements) {
            String[] parts = s.split(" ");
            int i = Integer.parseInt(parts[1]);

            switch (parts[0]) {
                case "forward" -> {
                    x += i;
                    y += i * aim;
                }
                case "down" -> aim += i;
                case "up" -> aim -= i;
            }
        }

        return x * y;
    }

    @Override
    public String toString() {
        return "Day 2 (CourseCalculator): getEndpoint = " + getEndpoint() + ", getEndpointWithAim = " + getEndpointWithAim();
    }
}
