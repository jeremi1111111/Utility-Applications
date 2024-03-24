package Problem118;

import java.util.ArrayList;

public class CheckIfSorted {
    static void validate(ArrayList<Integer> list) throws UnsortedException {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i+1)) {
                throw new UnsortedException("List is unsorted");
            }
        }
    }
}
