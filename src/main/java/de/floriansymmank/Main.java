package de.floriansymmank;

import de.floriansymmank.puzzles.DepthAnalysis;
import de.floriansymmank.util.FileReaderUtil;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        System.out.println(new DepthAnalysis(FileReaderUtil.readIntergerListFile("src/main/resources/puzzle1Input.txt")));
    }
}
