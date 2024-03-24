package Problem235;

import java.util.ArrayList;
import java.util.Collections;

public class MinMax {
    public static ArrayList<Integer> getMinMax(ArrayList<Integer> numbers) {
        int min = 0;
        int max = 0;
        int start = 0;
        if (numbers.size() % 2 == 0) {
            min = Math.min(numbers.get(0), numbers.get(1));
            max = Math.max(numbers.get(0), numbers.get(1));
            start = 2;
        }
        else {
            min = max = numbers.get(0);
            start = 1;
        }
        for (int i = start; i < numbers.size(); i += 2) {
            int a = numbers.get(i);
            int b = numbers.get(i + 1);
            if (a < b) {
                min = Math.min(min, a);
                max = Math.max(max, b);
            }
            min = Math.min(min, b);
            max = Math.max(max, a);
        }
        ArrayList<Integer> result = new ArrayList<>();
        Collections.addAll(result, min, max);
        return result;
    }
}
