package de.floriansymmank.puzzles;

import java.util.List;
import java.util.stream.Collectors;

/**
 * https://adventofcode.com/2021/day/7
 */
public class TheTreacheryOfWhales {
    private List<Integer> input;

    public TheTreacheryOfWhales(List<Integer> input) {
        this.input = input;
    }

    public int calculateMinimumFuelUsageMedian() {
        List<Integer> sorted = input.stream().sorted().collect(Collectors.toList());
        int median = sorted.get(sorted.size() / 2);

        return sorted.stream()
                .map(x -> Math.abs(x - median))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int calculateMinimumFuelUsageAverage() {
        double average = input.stream()
                .mapToDouble(x -> (double) x)
                .sum() / input.size();

        int avgF = (int)Math.floor(average);
        int avgC = (int)Math.ceil(average);
        int sumF = 0;
        int sumC = 0;

        for(Integer i : input) {
            int stepsF = Math.abs(i - avgF);
            int stepsC = Math.abs(i - avgC);
            sumF += stepsF * (stepsF + 1) / 2; // triangular number
            sumC += stepsC * (stepsC + 1) / 2;
        }

        // take the smaller of the two sums
        return Math.min(sumF, sumC);
    }

    @Override
    public String toString() {
        return "Day 7 (TheTreacheryOfWhales): calculateMinimumFuelUsageMedian = " + calculateMinimumFuelUsageMedian() + " //// calculateMinimumFuelUsageAverage = " + calculateMinimumFuelUsageAverage();
    }
}
