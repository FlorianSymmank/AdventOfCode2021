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
        // fish with same time to spawn new fish can be considered to be the same fish, just store the amount of fish

        long[] fishOfAge = new long[9];

        for (int fishage : fishages)
            fishOfAge[fishage]++;

        // no need to shift values in array, just shift the index of time to spawn (tts) fish, add amount of tts 0 fish to 7

        for (int day = 0, spawnTimeIndex = 0; day < days; day++, spawnTimeIndex++)
            fishOfAge[(spawnTimeIndex + 7) % 9] += fishOfAge[spawnTimeIndex % 9];

        return Arrays.stream(fishOfAge).sum();
    }

    @Override
    public String toString() {
        return "Day 6 (Lanternfish): growPopulation(80) = " + growPopulation(80) + "//// growPopulation(256) = " + growPopulation(256);
    }
}
