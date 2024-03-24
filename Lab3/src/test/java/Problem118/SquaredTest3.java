package Problem118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquaredTest3 {

    @Test
    void square() {
        ArrayList<Integer> initial = new ArrayList<>(List.of(-2, -9, 0, 2, 3));
        ArrayList<Integer> result = Squared.square(initial);
        assertNull(result);
    }
}