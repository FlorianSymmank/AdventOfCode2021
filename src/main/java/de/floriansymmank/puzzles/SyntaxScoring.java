package de.floriansymmank.puzzles;

import java.util.*;

/**
 * https://adventofcode.com/2021/day/10
 */
public class SyntaxScoring {
    private List<String> list;

    Map<Character, Integer> errorScores = new HashMap<>();
    Map<Character, Integer> completionScores = new HashMap<>();
    Map<Character, Character> correspondingClosingChar = new HashMap<>();

    public SyntaxScoring(List<String> list) {
        this.list = list;

        errorScores.put(')', 3);
        errorScores.put(']', 57);
        errorScores.put('}', 1197);
        errorScores.put('>', 25137);

        correspondingClosingChar.put('(', ')');
        correspondingClosingChar.put('[', ']');
        correspondingClosingChar.put('{', '}');
        correspondingClosingChar.put('<', '>');

        completionScores.put(')', 1);
        completionScores.put(']', 2);
        completionScores.put('}', 3);
        completionScores.put('>', 4);
    }

    public int getTotalSyntaxErrorScore() {

        int errorsum = 0;

        for (String line : list) {
            Stack<Character> expected = new Stack<>();

            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[' || c == '{' || c == '<')
                    expected.push(correspondingClosingChar.get(c));
                else if (expected.isEmpty() || expected.pop() != c) {
                    errorsum += errorScores.get(c);
                    break;
                }

            }
        }

        return errorsum;
    }

    public long getMiddleLineCompletionScore() {

        List<Long> scores = new ArrayList<>();

        for (String line : list) {
            Stack<Character> expected = new Stack<>();

            // dont consider corrupt lines
            boolean corrupted = false;
            for (char c : line.toCharArray()) {
                if (c == '(' || c == '[' || c == '{' || c == '<')
                    expected.push(correspondingClosingChar.get(c));
                else if (expected.isEmpty() || expected.pop() != c) {
                    corrupted = true;
                    break;
                }
            }

            if (!corrupted) {
                long score = 0;
                while(!expected.isEmpty()){
                    char c = expected.pop();
                    int scoreForChar = completionScores.get(c);
                    score *= 5;
                    score += scoreForChar;
                }

                scores.add(score);
            }
        }

        scores.sort(Comparator.naturalOrder());
        return scores.get(scores.size() / 2);
    }

    @Override
    public String toString() {
        return "Day 10 (SyntaxScoring): getTotalSyntaxErrorScore() = " + getTotalSyntaxErrorScore() + "//// getMiddleLineCompletionScore() = " + getMiddleLineCompletionScore();
    }
}
