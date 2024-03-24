package Problem118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquaredTest {

    @Test
    void square() {
        ArrayList<Integer> initial = new ArrayList<>(List.of(-9, -2, 0, 2, 3));
        ArrayList<Integer> expected = new ArrayList<>(List.of(0, 4, 4, 9, 81));
        ArrayList<Integer> result = Squared.square(initial);
        assertEquals(expected, result);
    }
}