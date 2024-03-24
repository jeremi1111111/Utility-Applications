package Problem235;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxTest {

    @Test
    void getMinMax() {
        ArrayList<Integer> numbersList = new ArrayList<>(List.of(1000, 11, 445, 1, 330, 3000));
        ArrayList<Integer> expected = new ArrayList<>(List.of(1, 3000));
        ArrayList<Integer> result = MinMax.getMinMax(numbersList);
        assertEquals(expected, result);
    }
}