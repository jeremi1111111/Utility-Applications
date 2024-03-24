package Problem21;

public class LectureList {
    Lecture head;
    Lecture tail;
    public LectureList() {
        this.head = null;
        this.tail = null;
    }
    public void add(Lecture lecture) {
        if (tail != null) { tail.next = lecture; }
        else { head = lecture; }
        tail = lecture;
    }

    @Override
    public String toString() {
        String string = "";
        Lecture lecture = head;
        while (lecture != null) {
            string += lecture.toString() + '\t';
            lecture = lecture.next;
        }
        return string;
    }

    public Lecture getHead() {
        return head;
    }
}
