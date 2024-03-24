package Problem189;

import java.util.ArrayList;

public class Distinct {
    public static int distinct(ArrayList<Integer> arrayList) {
        ArrayList<Integer> unique = new ArrayList<>();
        for (int n : arrayList) {
            if (!unique.contains(n)) unique.add(n);
        }
        return unique.size();
    }
}
