import de.floriansymmank.puzzles.CourseCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CourseCalculatorTest {

    @Test
    void getEndpoint() {
        List<String> movements = Arrays.asList("forward 5", "down 5","forward 8", "up 3", "down 8", "forward 2");
        CourseCalculator courseCalculator = new CourseCalculator(movements);
        assertEquals(150, courseCalculator.getEndpoint());
    }

    @Test
    void getEndpointWithAim(){
        List<String> movements = Arrays.asList("forward 5", "down 5","forward 8", "up 3", "down 8", "forward 2");
        CourseCalculator courseCalculator = new CourseCalculator(movements);
        assertEquals(900, courseCalculator.getEndpointWithAim());
    }
}
