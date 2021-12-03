package de.floriansymmank;

import de.floriansymmank.puzzles.CourseCalculator;
import de.floriansymmank.puzzles.DepthAnalysis;
import de.floriansymmank.puzzles.SubmarinPowerConsumption;
import de.floriansymmank.util.FileReaderUtil;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println(new DepthAnalysis(FileReaderUtil.readIntergerListFile("src/main/resources/puzzle1Input.txt")));
        System.out.println(new CourseCalculator(FileReaderUtil.readStringListFile("src/main/resources/puzzle2Input.txt")));
        System.out.println(new SubmarinPowerConsumption(FileReaderUtil.readBinaryListFile("src/main/resources/puzzle3Input.txt"), 12));
    }
}
