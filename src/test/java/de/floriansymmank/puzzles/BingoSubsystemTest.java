package de.floriansymmank.puzzles;

import de.floriansymmank.puzzles.BingoBoard;
import de.floriansymmank.puzzles.BingoSubsystem;
import de.floriansymmank.util.FileReaderUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BingoSubsystemTest {
    @Test
    void getFirstWinningBoardScore() {
        List<Integer> drawnNumbers = Arrays.asList(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1);

        BingoBoard board1 = BingoBoard.createBingoBoardFromRows(Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19"), 5, 5);
        BingoBoard board2 = BingoBoard.createBingoBoardFromRows(Arrays.asList(" 3 15  0  2 22", " 9 18 13 17  5", "19  8  7 25 23", "20 11 10 24  4", "14 21 16 12  6"), 5, 5);
        BingoBoard board3 = BingoBoard.createBingoBoardFromRows(Arrays.asList("14 21 17 24  4", "10 16 15  9 19", "18  8 23 26 20", "22 11 13  6  5", " 2  0 12  3  7"), 5, 5);

        List<BingoBoard> bingoBoards = List.of(board1, board2, board3);
        BingoSubsystem bingoSubsystem = new BingoSubsystem(drawnNumbers, bingoBoards);
        assertEquals(4512, bingoSubsystem.getFirstWinningBoardScore());
    }

    @Test
    void getLastWinningBoardScore(){
        List<Integer> drawnNumbers = Arrays.asList(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1);

        BingoBoard board1 = BingoBoard.createBingoBoardFromRows(Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19"), 5, 5);
        BingoBoard board2 = BingoBoard.createBingoBoardFromRows(Arrays.asList(" 3 15  0  2 22", " 9 18 13 17  5", "19  8  7 25 23", "20 11 10 24  4", "14 21 16 12  6"), 5, 5);
        BingoBoard board3 = BingoBoard.createBingoBoardFromRows(Arrays.asList("14 21 17 24  4", "10 16 15  9 19", "18  8 23 26 20", "22 11 13  6  5", " 2  0 12  3  7"), 5, 5);

        List<BingoBoard> bingoBoards = List.of(board1, board2, board3);
        BingoSubsystem bingoSubsystem = new BingoSubsystem(drawnNumbers, bingoBoards);
        assertEquals(1924, bingoSubsystem.getLastWinningBoardScore());
    }
}
