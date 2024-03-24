package Problem189;

import Problem165.Smaller;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class DistinctTest {

    @Test
    void distinct() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 6, 2, 8, 4, 3, 4, 2, 5, 5);
        int distinct = Distinct.distinct(arrayList);
        assertEquals(7, distinct);
    }
}