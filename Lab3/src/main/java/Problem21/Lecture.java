package Problem21;

public class Lecture {
    int start;
    int end;
    Lecture next;
    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
        this.next = null;
    }
    public int getStart() {
        return start;
    }
    public int getEnd() {
        return end;
    }

    public Lecture getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "(" + start +
                ", " + end +
                ')';
    }
}
