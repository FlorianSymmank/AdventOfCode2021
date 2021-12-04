package de.floriansymmank.util;

import de.floriansymmank.puzzles.BingoBoard;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {
    public static List<Integer> readIntergerListFile(String path) {
        List<Integer> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";

            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }

        } catch (IOException ignored) {

        }

        return list;
    }

    public static List<String> readStringListFile(String path) {
        List<String> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";

            while ((line = br.readLine()) != null) {
                list.add(line);
            }

        } catch (IOException ignored) {

        }

        return list;
    }

    public static List<Integer> readBinaryListFile(String path) {
        List<Integer> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";

            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line, 2));
            }

        } catch (IOException ignored) {

        }

        return list;
    }

    public static List<BingoBoard> readBingoBoardsFromFile(String path, int numberOfRows, int numberOfColumns) {
        List<BingoBoard> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            // first line contains drawn numbers, ignore
            br.readLine();

            // intentionally ignore line, indicates new bingo board
            while (br.readLine() != null) {
                List<String> rows = new ArrayList<>();

                for (int i = 0; i < numberOfRows; i++)
                    rows.add(br.readLine());

                list.add(BingoBoard.createBingoBoardFromRows(rows, numberOfRows, numberOfColumns));
            }

        } catch (IOException ignored) {
        }

        return list;
    }

    public static List<Integer> readFirstLineAsIntegerList(String path) {
        List<Integer> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";

            if ((line = br.readLine()) != null) {
                String[] split = line.split(",");

                for (String s : split)
                    list.add(Integer.parseInt(s));
            }
        } catch (IOException ignored) {
        }

        return list;
    }
}
