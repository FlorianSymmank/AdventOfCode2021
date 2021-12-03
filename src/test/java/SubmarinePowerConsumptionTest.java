package de.floriansymmank.puzzles;

import de.floriansymmank.puzzles.SubmarinPowerConsumption;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubmarinePowerConsumptionTest {

    @Test
    void SubmarinPowerConsumption() {
        List<Integer> byteList = Arrays.asList(0b00100, 0b11110, 0b10110, 0b10111, 0b10101, 0b01111, 0b00111, 0b11100, 0b10000, 0b11001, 0b00010, 0b01010);
        SubmarinPowerConsumption submarine = new SubmarinPowerConsumption(byteList, 5);
        assertEquals(198, submarine.getPowerConsumption());
    }

    @Test
    void getGammeRate() {
        List<Integer> byteList = Arrays.asList(0b00100, 0b11110, 0b10110, 0b10111, 0b10101, 0b01111, 0b00111, 0b11100, 0b10000, 0b11001, 0b00010, 0b01010);
        SubmarinPowerConsumption submarine = new SubmarinPowerConsumption(byteList, 5);
        assertEquals(22, submarine.getGammeRate());
    }

    @Test
    void getEpsilonRate() {
        List<Integer> byteList = Arrays.asList(0b00100, 0b11110, 0b10110, 0b10111, 0b10101, 0b01111, 0b00111, 0b11100, 0b10000, 0b11001, 0b00010, 0b01010);
        SubmarinPowerConsumption submarine = new SubmarinPowerConsumption(byteList, 5);
        assertEquals(9, submarine.getEpsilonRate(22));
    }

    @Test
    void getLifeSupportRating(){
        List<Integer> byteList = Arrays.asList(0b00100, 0b11110, 0b10110, 0b10111, 0b10101, 0b01111, 0b00111, 0b11100, 0b10000, 0b11001, 0b00010, 0b01010);
        SubmarinPowerConsumption submarine = new SubmarinPowerConsumption(byteList, 5);
        assertEquals(230, submarine.getLifeSupportRating());
    }

    @Test
    void getOxygenGeneratorRating() {
        List<Integer> byteList = Arrays.asList(0b00100, 0b11110, 0b10110, 0b10111, 0b10101, 0b01111, 0b00111, 0b11100, 0b10000, 0b11001, 0b00010, 0b01010);
        SubmarinPowerConsumption submarine = new SubmarinPowerConsumption(byteList, 5);
        assertEquals(23, submarine.getOxygenGeneratorRating());
    }

    @Test
    void getCO2ScrubberRating() {
        List<Integer> byteList = Arrays.asList(0b00100, 0b11110, 0b10110, 0b10111, 0b10101, 0b01111, 0b00111, 0b11100, 0b10000, 0b11001, 0b00010, 0b01010);
        SubmarinPowerConsumption submarine = new SubmarinPowerConsumption(byteList, 5);
        assertEquals(10, submarine.getCO2ScrubberRating());
    }
}
