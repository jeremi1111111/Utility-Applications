package Problem37;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerSetTest {

    @Test
    void powerSet() {
        HashSet<Integer> initialSet = new HashSet<>();
        Collections.addAll(initialSet, 1, 2, 3);
        HashSet<HashSet<Integer>> expectedSet = new HashSet<>();
        expectedSet.add(new HashSet<>());
        expectedSet.add(new HashSet<>(Set.of(1)));
        expectedSet.add(new HashSet<>(Set.of(2)));
        expectedSet.add(new HashSet<>(Set.of(1, 2)));
        expectedSet.add(new HashSet<>(Set.of(3)));
        expectedSet.add(new HashSet<>(Set.of(1, 3)));
        expectedSet.add(new HashSet<>(Set.of(2, 3)));
        expectedSet.add(new HashSet<>(Set.of(1, 2, 3)));
        HashSet<HashSet<Integer>> resultSet = PowerSet.powerSet(initialSet);
        assertEquals(expectedSet, resultSet);
    }
}