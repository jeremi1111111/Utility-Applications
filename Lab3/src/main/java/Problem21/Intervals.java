package Problem21;

import java.util.*;
import java.util.logging.Level;

public class Intervals {
/*    public static int intervals(ArrayList<Lecture> lectures) {
        TreeMap<Integer, Integer> cachedLectures = new TreeMap<>();
        for (Lecture newLecture : lectures) {
            int key = newLecture.getStart();
            cachedLectures.putIfAbsent(key, 0);
            cachedLectures.put(key, cachedLectures.get(key) + 1);
            key = newLecture.getEnd();
            cachedLectures.putIfAbsent(key, 0);
            cachedLectures.put(key, cachedLectures.get(key) - 1);
        }
        int currentRooms = 0;
        int maxRooms = 0;
        for (Map.Entry<Integer, Integer> classroomsNeeded : cachedLectures.entrySet()) {
            currentRooms += classroomsNeeded.getValue();
            maxRooms = Math.max(currentRooms, maxRooms);
        }
        return maxRooms;
    } */
    public static int intervals(LectureList lectures) {
        TreeMap<Integer, Integer> cachedLectures = new TreeMap<>();
        Lecture newLecture = lectures.getHead();
        while (newLecture != null) {
            int key = newLecture.getStart();
            cachedLectures.putIfAbsent(key, 0);
            cachedLectures.put(key, cachedLectures.get(key) + 1);
            key = newLecture.getEnd();
            cachedLectures.putIfAbsent(key, 0);
            cachedLectures.put(key, cachedLectures.get(key) - 1);
            newLecture = newLecture.getNext();
        }
        int currentRooms = 0;
        int maxRooms = 0;
        for (Map.Entry<Integer, Integer> classroomsNeeded : cachedLectures.entrySet()) {
            currentRooms += classroomsNeeded.getValue();
            maxRooms = Math.max(currentRooms, maxRooms);
        }
        return maxRooms;
    }
}
