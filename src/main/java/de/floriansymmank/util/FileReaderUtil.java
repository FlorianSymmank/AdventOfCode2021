package de.floriansymmank.util;

import de.floriansymmank.puzzles.BingoBoard;
import de.floriansymmank.puzzles.Line;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtil {


    public static String readFirstLineFromFile(String path) {
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            line = br.readLine();
        } catch (IOException ignored) {
        }

        return line;
    }

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

    public static List<Line> readLinesFromFile(String path) {
        List<Line> list = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";

            while ((line = br.readLine()) != null) {
                line = line.replace(" ", "");
                String[] points = line.split("->");
                String[] p1 = points[0].split(",");
                String[] p2 = points[1].split(",");
                Point point1 = new Point(Integer.parseInt(p1[0]), Integer.parseInt(p1[1]));
                Point point2 = new Point(Integer.parseInt(p2[0]), Integer.parseInt(p2[1]));
                list.add(new Line(point1, point2));
            }

        } catch (IOException ignored) {

        }

        return list;
    }

    public static int[][] readMatrixFromFile(String path) {
        int[][] matrix = new int[0][0];

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = "";

            while ((line = br.readLine()) != null) {
                String[] split = line.split("");
                int[][] newMatrix = new int[matrix.length + 1][split.length];

                for (int i = 0; i < matrix.length; i++)
                    System.arraycopy(matrix[i], 0, newMatrix[i], 0, matrix[i].length);

                for (int i = 0; i < split.length; i++)
                    newMatrix[matrix.length][i] = Integer.parseInt(split[i]);

                matrix = newMatrix;
            }

        } catch (IOException ignored) {

        }

        return matrix;
    }
}
