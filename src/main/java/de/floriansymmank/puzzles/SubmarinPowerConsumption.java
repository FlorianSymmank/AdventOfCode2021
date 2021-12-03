package de.floriansymmank.puzzles;

import java.util.ArrayList;
import java.util.List;

import static de.floriansymmank.util.BitHelper.*;

/**
 * https://adventofcode.com/2021/day/3
 */
public class SubmarinPowerConsumption {
    private List<Integer> byteList;
    private int usedBits;

    public SubmarinPowerConsumption(List<Integer> byteList, int usedBits) {
        this.byteList = byteList;
        this.usedBits = usedBits;
    }

    public int getPowerConsumption() {
        int result = getGammeRate();
        return result * getEpsilonRate(result);
    }

    public int getGammeRate() {
        int result = 0;
        for (int bit = 0; bit < usedBits; bit++) {
            // store most common bit at position
            if (getMostCommonBitAt(bit, byteList) == 1)
                result = result | 1 << bit;
        }

        return result;
    }

    //inversed result xor mask of used bits
    public int getEpsilonRate(int gammaRate) {
        return (~gammaRate ^ (~0 << usedBits));
    }

    public int getLifeSupportRating() {
        return getOxygenGeneratorRating() * getCO2ScrubberRating();
    }

    public int getOxygenGeneratorRating() {
        List<Integer> remainingNumbers = new ArrayList<>(byteList);
        int postion = usedBits - 1;

        while (remainingNumbers.size() > 1) {
            List<Integer> newRemainingNumbers = new ArrayList<>();
            int mostCommonBit = getMostCommonBitAt(postion, remainingNumbers, true);

            for (int i = 0; i < remainingNumbers.size(); i++)
                if (getBitAt(postion, remainingNumbers.get(i)) == mostCommonBit)
                    newRemainingNumbers.add(remainingNumbers.get(i));

            remainingNumbers = newRemainingNumbers;
            postion--;
        }

        return remainingNumbers.get(0);
    }

    public int getCO2ScrubberRating() {
        List<Integer> remainingNumbers = new ArrayList<>(byteList);
        int postion = usedBits - 1;

        while (remainingNumbers.size() > 1) {
            List<Integer> newRemainingNumbers = new ArrayList<>();
            int leastCommonBit = getLeastCommonBitAt(postion, remainingNumbers);

            for (int i = 0; i < remainingNumbers.size(); i++)
                if (getBitAt(postion, remainingNumbers.get(i)) == leastCommonBit)
                    newRemainingNumbers.add(remainingNumbers.get(i));

            remainingNumbers = newRemainingNumbers;
            postion--;
        }

        return remainingNumbers.get(0);
    }

    @Override
    public String toString() {
        return "Day 3 (SubmarinPowerConsumption): getPowerConsumption() = " + getPowerConsumption() + " //// getLifeSupportRating() = " + getLifeSupportRating();
    }
}
