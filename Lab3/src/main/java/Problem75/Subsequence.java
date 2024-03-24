package Problem75;

import java.util.ArrayList;
import java.util.Collections;

public class Subsequence {
    public static int subsequence(ArrayList<Integer> sequence) {
        int length = sequence.size();
        ArrayList<Integer> subsequenceLength = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            subsequenceLength.add(1);
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (sequence.get(i) > sequence.get(j)) {
                    subsequenceLength.set(i, Math.max(subsequenceLength.get(i), subsequenceLength.get(j) + 1));
                }
            }
        }
        return Collections.max(subsequenceLength);
    }
}
