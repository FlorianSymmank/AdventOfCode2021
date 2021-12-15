package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendedPolymerizationTest {
    @Test
    void polymerizationCount10Steps() {

        List<String> input = List.of(
                "NNCB",
                "",
                "CH -> B",
                "HH -> N",
                "CB -> H",
                "NH -> C",
                "HB -> C",
                "HC -> B",
                "HN -> C",
                "NN -> C",
                "BH -> H",
                "NC -> B",
                "NB -> B",
                "BN -> B",
                "BB -> N",
                "BC -> B",
                "CC -> N",
                "CN -> C"
        );

        ExtendedPolymerization polymerization = new ExtendedPolymerization(input);
        assertEquals(1588, polymerization.polymerizationCount(10));
    }

    @Test
    void polymerizationCount40Steps() {

        List<String> input = List.of(
                "NNCB",
                "",
                "CH -> B",
                "HH -> N",
                "CB -> H",
                "NH -> C",
                "HB -> C",
                "HC -> B",
                "HN -> C",
                "NN -> C",
                "BH -> H",
                "NC -> B",
                "NB -> B",
                "BN -> B",
                "BB -> N",
                "BC -> B",
                "CC -> N",
                "CN -> C"
        );

        ExtendedPolymerization polymerization = new ExtendedPolymerization(input);
        assertEquals(2188189693529L, polymerization.polymerizationCount(40));
    }
}
