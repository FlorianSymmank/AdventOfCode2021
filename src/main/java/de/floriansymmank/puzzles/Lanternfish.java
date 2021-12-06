package de.floriansymmank.puzzles;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Lanternfish {
    private List<Integer> fishages;

    public Lanternfish(List<Integer> fishages) {
        this.fishages = fishages;
    }

    public long growPopulation(int days) {
        // numbers get big very fast, so we need to use long, BigInteger would work too
        // fish of same age can be considered to be the same fish, just store the amount of fish of each age

        long[] fishOfAge = new long[9];

        for (int fishage : fishages)
            fishOfAge[fishage]++;

        // re-categorize fish each day, remember amount of fish in category 0, 1 -> 0 2 -> 1, 3 -> 2 ...
        // then add remembered fish in category 8, and 6 plus the amount already in category 6

        for (int day = 0; day < days; day++) {
            long newFish = 0;
            for (int i = 0; i < fishOfAge.length; i++) {
                if (i == 0)
                    newFish = fishOfAge[i];
                else
                    fishOfAge[i - 1] = fishOfAge[i];

            }
            fishOfAge[8] = newFish;
            fishOfAge[6] += newFish;
        }

        return Arrays.stream(fishOfAge).sum();
    }

    @Override
    public String toString() {
        return "Day 6 (Lanternfish): growPopulation(80) = " + growPopulation(80) + "//// growPopulation(256) = " + growPopulation(256);
    }
}
