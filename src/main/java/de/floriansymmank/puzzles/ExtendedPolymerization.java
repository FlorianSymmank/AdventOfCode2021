package de.floriansymmank.puzzles;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ExtendedPolymerization {

    private final Map<String, Character> template = new HashMap<>();
    private final String originalPolymer;

    public ExtendedPolymerization(List<String> input) {

        originalPolymer = input.get(0);

        input.stream().skip(2).forEach(s -> {
            String[] split = s.split(" -> ");
            template.put(split[0], split[1].charAt(0));
        });
    }

    public int polymerizationCount(int steps) {

        List<Character> polymer = originalPolymer.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        List<Character> result = polymerize(polymer, steps);
        
        IntSummaryStatistics stats = result.stream()
                .collect(Collectors.groupingBy(c -> c))
                .values().stream()
                .mapToInt(List::size)
                .summaryStatistics();

        return stats.getMax() - stats.getMin();
    }

    private List<Character> polymerize(List<Character> polymer, int steps) {
        List<Character> list = polymerizeStep(polymer, steps);
        list.add(polymer.get(polymer.size() - 1));
        return list;
    }


    private List<Character> polymerizeStep(List<Character> polymer, int stepsLeft) {
        if (stepsLeft == 0) {
            polymer.remove(2);
            return polymer;
        }

        List<Character> characters = new ArrayList<>();
        for (int i = 1; i < polymer.size(); i++) {
            char c1 = polymer.get(i - 1);
            char c2 = polymer.get(i);
            String pair = String.valueOf(c1) + String.valueOf(c2);

            if (template.containsKey(pair)) {
                List<Character> newPolymer = new ArrayList<>(0);
                newPolymer.add(c1);
                newPolymer.add(template.get(pair));
                newPolymer.add(c2);
                characters.addAll(polymerizeStep(newPolymer, stepsLeft - 1));
            }
        }

        return characters;
    }

    @Override
    public String toString() {
        return "Day 14 (ExtendedPolymerization): polymerizationCount(10) = " + polymerizationCount(10);
    }
}
