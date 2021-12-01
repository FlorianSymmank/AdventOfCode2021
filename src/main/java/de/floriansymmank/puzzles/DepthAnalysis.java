package de.floriansymmank.puzzles;

import java.util.List;

/**
 * https://adventofcode.com/2021/day/1
 * https://adventofcode.com/2021/day/1#part2
 */
public class DepthAnalysis {

    private final List<Integer> depths;

    public DepthAnalysis(List<Integer> depths) {
        this.depths = depths;
    }

    /**
     * Counts the number of times a depth measurement increases
     * @return
     */
    public int measureIncrease() {
        int increaseCount = 0;
        int lastDepth = depths.get(0);

        for (int currentDepth : depths) {
            if (currentDepth > lastDepth)
                increaseCount++;
            lastDepth = currentDepth;
        }

        return increaseCount;
    }

    /**
     * Counts the number of times a depth measurement increases with three-measurement sliding window
     * @return
     */
    public int measureIncreaseSlidingWindow() {
        int increaseCount = 0;
        int lastDepthSum = depths.get(0) + depths.get(1) + depths.get(2);

        for (int i = 3; i < depths.size(); i++) {
            int newDepthSum = depths.get(i - 2) + depths.get(i - 1) + depths.get(i);
            if (newDepthSum > lastDepthSum)
                increaseCount++;

            lastDepthSum = newDepthSum;
        }

        return increaseCount;
    }

    @Override
    public String toString() {
        return "Day 1 (DepthAnalysis): measureIncrease = " + measureIncrease() + " //// measureIncreaseSlidingWindow = " + measureIncreaseSlidingWindow();
    }
}
