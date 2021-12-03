package de.floriansymmank.util;

import java.util.List;

public class BitHelper {

    public static int getMostCommonBitAt(int position, List<Integer> byteList, boolean preferOneIfEqual) {
        int oneBitCount = 0;

        for (Integer number : byteList)
            if (getBitAt(position, number) == 1)
                oneBitCount++;

        if (byteList.size() - oneBitCount == oneBitCount && preferOneIfEqual)
            return 1;

        return oneBitCount > byteList.size() / 2 ? 1 : 0;
    }

    public static int getMostCommonBitAt(int position, List<Integer> byteList) {
        return getMostCommonBitAt(position, byteList, false);
    }

    public static int getLeastCommonBitAt(int position, List<Integer> byteList, boolean preferOneIfEqual) {
        int oneBitCount = 0;

        for (Integer number : byteList)
            if (getBitAt(position, number) == 1)
                oneBitCount++;

        if (byteList.size() - oneBitCount == oneBitCount && preferOneIfEqual)
            return 1;

        if (byteList.size() - oneBitCount == oneBitCount && !preferOneIfEqual)
            return 0;

        return oneBitCount > byteList.size() / 2 ? 0 : 1;
    }

    public static int getLeastCommonBitAt(int position, List<Integer> byteList) {
        return getLeastCommonBitAt(position, byteList, false);
    }


    public static int getBitAt(int position, int number) {
        return ((number >> position) & 1);
    }
}
