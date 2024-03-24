import Problem118.Squared;
import Problem165.Smaller;
import Problem189.Distinct;
import Problem21.Intervals;
import Problem21.Lecture;
import Problem21.LectureList;
import Problem221.Sevenish;
import Problem235.MinMax;
import Problem285.Sunset;
import Problem37.PowerSet;
import Problem71.Rand5;
import Problem75.Subsequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Problem 21");
        LectureList lectures = new LectureList();
        lectures.add(new Lecture(30, 75));
        lectures.add(new Lecture(0, 50));
        lectures.add(new Lecture(60, 150));
        System.out.println(Intervals.intervals(lectures));

        System.out.println("Problem 37");
        HashSet<Integer> initialSet = new HashSet<>();
        Collections.addAll(initialSet, 1, 2, 3);
        System.out.println(PowerSet.powerSet(initialSet));

        System.out.println("Problem 71");
        System.out.println(Rand5.rand5());

        System.out.println("Problem 75");
        ArrayList<Integer> sequence = new ArrayList<>();
        Collections.addAll(sequence, 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15);
        System.out.println(Subsequence.subsequence(sequence));

        System.out.println("Problem 118");
        ArrayList<Integer> initial = new ArrayList<>();
        Collections.addAll(initial, -9, -2, 0, 2, 3);
        System.out.println(Squared.square(initial));

        System.out.println("Problem 165");
        ArrayList<Integer> numbers = new ArrayList<>();
        Collections.addAll(numbers, 3, 4, 9, 6, 1);
        System.out.println(Smaller.smaller(numbers));

        System.out.println("Problem 189");
        ArrayList<Integer> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, 1, 6, 2, 8, 4, 3, 4, 2, 5, 5);
        System.out.println(Distinct.distinct(arrayList));

        System.out.println("Problem 221");
        System.out.println(Sevenish.sevenish(6));

        System.out.println("Problem 235");
        ArrayList<Integer> numbersList = new ArrayList<>();
        Collections.addAll(numbersList, 1000, 11, 445, 1, 330, 3000);
        System.out.println(MinMax.getMinMax(numbersList));

        System.out.println("Problem 285");
        ArrayList<Integer> street = new ArrayList<>();
        Collections.addAll(street, 3, 7, 8, 3, 6, 1);
        System.out.println(Sunset.sunset(street));

    }
}
