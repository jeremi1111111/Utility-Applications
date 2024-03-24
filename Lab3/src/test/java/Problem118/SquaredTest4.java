package Problem118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquaredTest4 {

    @Test
    void square() {
        ArrayList<Integer> initial = new ArrayList<>(List.of(-3, -2, 0, 2, 3, 4, 5, 6));
        ArrayList<Integer> expected = new ArrayList<>(List.of(0, 4, 4, 9, 9, 16, 25, 36));
        ArrayList<Integer> result = Squared.square(initial);
        assertEquals(expected, result);
    }
}