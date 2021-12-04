package de.floriansymmank.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * https://adventofcode.com/2021/day/4
 */
public class BingoSubsystem {
    private final List<Integer> drawnNumbers;
    private List<BingoBoard> bingoBoards;
    private final List<BingoBoard> originalBingoBoards;

    public BingoSubsystem(List<Integer> drawnNumbers, List<BingoBoard> bingoBoards) {
        this.drawnNumbers = drawnNumbers;
        this.bingoBoards = bingoBoards;
        this.originalBingoBoards = bingoBoards;
    }

    public int getFirstWinningBoardScore() {
        for (int drawnNumber : drawnNumbers) {
            for (BingoBoard bingoBoard : bingoBoards) {
                bingoBoard.markNumber(drawnNumber);

                if (bingoBoard.isBingo())
                    return scoreBoard(bingoBoard, drawnNumber);
            }
        }

        reset();
        return 0;
    }

    public int getLastWinningBoardScore() {
        List<BingoBoard> remainingBoards = new ArrayList<>(bingoBoards); // ArrayList to allow removing boards

        for (int drawnNumber : drawnNumbers) {
            for (int i = remainingBoards.size() - 1; i >= 0; i--) {
                BingoBoard bingoBoard = remainingBoards.get(i);
                bingoBoard.markNumber(drawnNumber);

                if (bingoBoard.isBingo()) {
                    if (remainingBoards.size() == 1) { // last board to win
                        int score = scoreBoard(bingoBoard, drawnNumber);
                        reset();
                        return score;
                    }
                    remainingBoards.remove(i);
                }
            }
        }

        reset();
        return 0;
    }

    private int scoreBoard(BingoBoard bingoBoard, int drawnNumber) {
        List<Integer> numbers = bingoBoard.getAllUnmarkedNumbers();
        int score = 0;
        for (Integer number : numbers)
            score += number;

        return score * drawnNumber;
    }

    // states of the boards habe been changed, so we need to reset them to not mess up the next run
    private void reset() {
        bingoBoards = originalBingoBoards;
    }

    @Override
    public String toString() {
        return "Day 4 (BingoSubsystem): getFirstWinningBoardScore = " + getFirstWinningBoardScore() + "//// getLastWinningBoardScore = " + getLastWinningBoardScore();
    }
}
