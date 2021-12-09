package de.floriansymmank.puzzles;

import java.util.List;

public class SevenSegmentDisplay {

    private List<String> input;

    public SevenSegmentDisplay(List<String> input) {
        this.input = input;
    }

    public int countDigits() {
        int count = 0;

        for (String s : input)
            for (String note : s.substring(s.indexOf("|") + 2).split(" "))
                switch (note.length()) {
                    case 2, 3, 4, 7 -> count++;
                }

        return count;
    }

    public int decodeSignal() {
        return 0;
    }

    @Override
    public String toString() {
        return "Day 8 (SevenSegmentDisplay): countDigits = " + countDigits();
    }
}
