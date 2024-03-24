package Problem118;

import java.util.ArrayList;

public class Squared {
    public static ArrayList<Integer> square(ArrayList<Integer> initial) {
        try {
            CheckIfSorted.validate(initial);
        }
        catch (UnsortedException e) {
            System.out.println(e);
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        ArrayList<Integer> positive = new ArrayList<>();
        for (int num : initial) {
            if (num < 0) {
                negative.add(0, (int)Math.pow(num, 2));
            }
            else {
                positive.add((int)Math.pow(num, 2));
            }
        }
        while (!negative.isEmpty() && !positive.isEmpty()) {
            Integer neg = negative.get(0);
            Integer pos = positive.get(0);
            if (neg < pos) {
                result.add(neg);
                negative.remove(neg);
                continue;
            }
            result.add(pos);
            positive.remove(pos);
        }
        if (!negative.isEmpty()) {
            result.addAll(negative);
            negative.clear();
        }
        if (!positive.isEmpty()) {
            result.addAll(positive);
            positive.clear();
        }
        return result;
    }
}
