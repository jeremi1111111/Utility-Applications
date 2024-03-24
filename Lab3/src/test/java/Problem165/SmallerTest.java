package Problem165;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SmallerTest {

    @Test
    void smaller() {
        ArrayList<Integer> numbers = new ArrayList<>(List.of(3, 4, 9, 6, 1));
        ArrayList<Integer> expected = new ArrayList<>(List.of(1, 1, 2, 1, 0));
        ArrayList<Integer> result = Smaller.smaller(numbers);
        assertEquals(expected, result);
    }
}