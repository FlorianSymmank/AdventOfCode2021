package de.floriansymmank.util;

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
}
