package de.floriansymmank.puzzles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BingoBoard {

    private final BingoCell[][] board;
    private final int numberOfRows;
    private final int numberOfColumns;

    private BingoBoard(BingoCell[][] board, int numberOfRows, int numberOfColumns) {
        this.board = board;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public static BingoBoard createBingoBoardFromRows(List<String> rows, int numberOfRows, int numberOfColumns) {
        BingoCell[][] board = new BingoCell[numberOfRows][numberOfColumns];
        for (int row = 0; row < numberOfRows; row++) {
            String[] parts = rows.get(row).split(" ");
            List<String> cells = new java.util.ArrayList<>(List.of(parts));

            // remove empty cells
            cells.removeIf(String::isEmpty);

            for (int col = 0; col < numberOfColumns; col++) {
                board[row][col] = new BingoCell(Integer.parseInt(cells.get(col)));
            }
        }

        return new BingoBoard(board, numberOfRows, numberOfColumns);
    }

    public void markNumber(int number) {
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                if (board[row][col].getNumber() == number) {
                    board[row][col].mark();
                }
            }
        }
    }

    public boolean isBingo() {
        // check rowbingo
        for (int row = 0; row < numberOfRows; row++) {
            boolean rowBingo = true;
            for (int col = 0; col < numberOfColumns; col++)
                rowBingo &= board[row][col].isMarked();

            if (rowBingo)
                return true;
        }

        // check columnbingo
        for (int col = 0; col < numberOfColumns; col++) {
            boolean columnBingo = true;
            for (int row = 0; row < numberOfRows; row++)
                columnBingo &= board[row][col].isMarked();

            if (columnBingo)
                return true;
        }

        return false;
    }

    public List<Integer> getAllUnmarkedNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                if (!board[row][col].isMarked())
                    numbers.add(board[row][col].getNumber());
            }
        }
        return numbers;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(board);
    }
}
