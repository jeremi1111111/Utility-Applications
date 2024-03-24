package Problem235;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxTest2 {

    @Test
    void getMinMax() {
        ArrayList<Integer> numbersList = new ArrayList<>(List.of(10, 11, 421, 535, 324));
        ArrayList<Integer> expected = new ArrayList<>(List.of(10, 535));
        ArrayList<Integer> result = MinMax.getMinMax(numbersList);
        assertEquals(expected, result);
    }
}