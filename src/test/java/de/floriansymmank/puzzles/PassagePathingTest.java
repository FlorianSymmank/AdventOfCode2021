package de.floriansymmank.puzzles;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassagePathingTest {

    @Test
    void getAllPathCount() {
        List<String> passages = Arrays.asList(
                "fs-end",
                "he-DX",
                "fs-he",
                "start-DX",
                "pj-DX",
                "end-zg",
                "zg-sl",
                "zg-pj",
                "pj-he",
                "RW-he",
                "fs-DX",
                "pj-RW",
                "zg-RW",
                "start-pj",
                "he-WI",
                "zg-he",
                "pj-fs",
                "start-RW"
        );

        PassagePathing pathing = new PassagePathing(passages);
        assertEquals(226, pathing.getAllPathCount());
    }

    @Test
    void getAllPathCount2() {
        List<String> passages = Arrays.asList(
                "fs-end",
                "he-DX",
                "fs-he",
                "start-DX",
                "pj-DX",
                "end-zg",
                "zg-sl",
                "zg-pj",
                "pj-he",
                "RW-he",
                "fs-DX",
                "pj-RW",
                "zg-RW",
                "start-pj",
                "he-WI",
                "zg-he",
                "pj-fs",
                "start-RW"
        );

        PassagePathing pathing = new PassagePathing(passages);
        assertEquals(3509, pathing.getAllPathCount2());
    }

}
