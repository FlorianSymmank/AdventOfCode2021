package de.floriansymmank;

import de.floriansymmank.puzzles.*;
import de.floriansymmank.util.FileReaderUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println(new DepthAnalysis(FileReaderUtil.readIntergerListFile("src/main/resources/puzzle1Input.txt")));

        System.out.println(new CourseCalculator(FileReaderUtil.readStringListFile("src/main/resources/puzzle2Input.txt")));

        System.out.println(new SubmarinPowerConsumption(FileReaderUtil.readBinaryListFile("src/main/resources/puzzle3Input.txt"), 12));

        System.out.println(new BingoSubsystem(
                FileReaderUtil.readFirstLineAsIntegerList("src/main/resources/puzzle4Input.txt"),
                FileReaderUtil.readBingoBoardsFromFile("src/main/resources/puzzle4Input.txt", 5, 5)));


        System.out.println(new HydrothermalVenture(FileReaderUtil.readLinesFromFile("src/main/resources/puzzle5Input.txt")));
        System.out.println(new Lanternfish(FileReaderUtil.readFirstLineAsIntegerList("src/main/resources/puzzle6Input.txt")));
        System.out.println(new TheTreacheryOfWhales(FileReaderUtil.readFirstLineAsIntegerList("src/main/resources/puzzle7Input.txt")));
        System.out.println(new SevenSegmentDisplay(FileReaderUtil.readStringListFile("src/main/resources/puzzle8Input.txt")));
        System.out.println(new SmokeBasin(FileReaderUtil.readMatrixFromFile("src/main/resources/puzzle9Input.txt")));
        System.out.println(new SyntaxScoring(FileReaderUtil.readStringListFile("src/main/resources/puzzle10Input.txt")));


    }
}
