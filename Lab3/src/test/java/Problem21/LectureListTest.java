package Problem21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LectureListTest {

    @Test
    void testToString() {
        LectureList lectures = new LectureList();
        lectures.add(new Lecture(30, 75));
        lectures.add(new Lecture(0, 50));
        lectures.add(new Lecture(60, 150));
        String expected = "(30, 75)\t(0, 50)\t(60, 150)\t";
        assertEquals(expected, lectures.toString());
    }
}