package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SyntaxScoringTest {

    @Test
    void getTotalSyntaxErrorScore() {
        List<String> list = Arrays.asList(
                "[({(<(())[]>[[{[]{<()<>>",
                "[(()[<>])]({[<{<<[]>>(",
                "{([(<{}[<>[]}>{[]{[(<()>",
                "(((({<>}<{<{<>}{[]{[]{}",
                "[[<[([]))<([[{}[[()]]]",
                "[{[{({}]{}}([{[{{{}}([]",
                "{<[[]]>}<{[{[{[]{()[[[]",
                "[<(<(<(<{}))><([]([]()",
                "<{([([[(<>()){}]>(<<{{",
                "<{([{{}}[<[[[<>{}]]]>[]]");

        SyntaxScoring syntaxScoring = new SyntaxScoring(list);
        assertEquals(26397, syntaxScoring.getTotalSyntaxErrorScore());
    }

    @Test
    void getMiddleLineCompletionScore() {
        List<String> list = Arrays.asList(
                "[({(<(())[]>[[{[]{<()<>>",
                "[(()[<>])]({[<{<<[]>>(",
                "{([(<{}[<>[]}>{[]{[(<()>",
                "(((({<>}<{<{<>}{[]{[]{}",
                "[[<[([]))<([[{}[[()]]]",
                "[{[{({}]{}}([{[{{{}}([]",
                "{<[[]]>}<{[{[{[]{()[[[]",
                "[<(<(<(<{}))><([]([]()",
                "<{([{{}}[<[[[<>{}]]]>[]]");

        SyntaxScoring syntaxScoring = new SyntaxScoring(list);
        assertEquals(288957L, syntaxScoring.getMiddleLineCompletionScore());
    }
}
