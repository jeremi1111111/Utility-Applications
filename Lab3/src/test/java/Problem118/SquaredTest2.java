package Problem118;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SquaredTest2 {

    @Test
    void square() {
        ArrayList<Integer> initial = new ArrayList<>(List.of(-2, -9, 0, 2, 3));
        UnsortedException ex = assertThrows(UnsortedException.class, () -> {CheckIfSorted.validate(initial);});
        assertEquals("List is unsorted", ex.getMessage());
    }
}