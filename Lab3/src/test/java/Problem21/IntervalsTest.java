package Problem21;

import static org.junit.jupiter.api.Assertions.*;

class IntervalsTest {

    @org.junit.jupiter.api.Test
    void intervals() {
        LectureList lectures = new LectureList();
        lectures.add(new Lecture(30, 75));
        lectures.add(new Lecture(0, 50));
        lectures.add(new Lecture(60, 150));
        int classes = Intervals.intervals(lectures);
        assertEquals(2, classes);
    }
}