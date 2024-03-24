package Problem37;

import java.util.HashSet;

public class PowerSet {
    public static HashSet<HashSet<Integer>> powerSet(HashSet<Integer> initialSet) {
        HashSet<HashSet<Integer>> resultSet = new HashSet<>();
        resultSet.add(new HashSet<>());
        for (int num : initialSet) {
            HashSet<HashSet<Integer>> additionalSets = new HashSet<>();
            for (HashSet<Integer> subset : resultSet) {
                HashSet<Integer> subsetCopy = new HashSet<>(subset);
                subsetCopy.add(num);
                additionalSets.add(subsetCopy);
            }
            resultSet.addAll(additionalSets);
        }
        return resultSet;
    }
}
