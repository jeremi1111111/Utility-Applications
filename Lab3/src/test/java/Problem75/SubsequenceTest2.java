package Problem75;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SubsequenceTest2 {

    @Test
    void subsequence() {
        ArrayList<Integer> sequence = new ArrayList<>();
        Collections.addAll(sequence, 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15);
        assertTimeout(Duration.ofMillis(6), () -> {Subsequence.subsequence(sequence);});
    }
}