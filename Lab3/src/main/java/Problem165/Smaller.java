package Problem165;

import java.util.ArrayList;

public class Smaller {
    public static ArrayList<Integer> smaller(ArrayList<Integer> numbers) {
        ArrayList<Integer> smallerCount = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            int count = 0;
            for (int j = i + 1; j < numbers.size(); j++) {
                int compare = numbers.get(j);
                if (num > compare) {
                    count++;
                }
            }
            smallerCount.add(count);
        }
        return smallerCount;
    }
}
