import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Class {
    String className;
    ArrayList<Student> studentsList;
    int capacity;

    public Class(String className, ArrayList<Student> studentsList, int capacity) {
        this.className = className;
        this.studentsList = studentsList;
        this.capacity = capacity;
    }

    public void addStudent(Student student) {
        for (Student student1 : studentsList) {
            if (student.name.equals(student1.name) && student.surname.equals(student1.surname)) {
                System.out.println("Student already enrolled in class.");
                return;
            }
        }
        if (studentsList.contains(student)) {
            System.out.println("Student already enrolled in class.");
            return;
        }
        if (studentsList.size() == capacity) {
            System.err.println("Class capacity exceeded.");
            return;
        }
        studentsList.add(student);
    }

    public void getStudent(Student student) {
        studentsList.remove(student);
    }

    public void addPoints(Student student, int points) {
        student.addPoints(points);
    }

    public void changeCondition(Student student, StudentCondition studentCondition) {
        student.setStudentStatus(studentCondition);
    }

    public void removePoints(Student student, double points) {
        student.removePoints(points);
    }

    public Student search(String surname) {
        for (Student student : studentsList) {
            if (student.getSurname().equals(surname)) return student;
        }
        return null;
    }

    public ArrayList<Student> searchPartial(String part) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student student : studentsList) {
            if (student.getSurname().contains(part)) students.add(student);
            if (student.getName().contains(part)) students.add(student);
        }
        return students;
    }

    public int countByCondition(StudentCondition studentCondition) {
        int studentCount = 0;
        for (Student student : studentsList) {
            if (student.studentStatus == studentCondition) studentCount++;
        }
        return studentCount;
    }

    public void summary() {
        System.out.println(this.className);
        for (Student student : studentsList) {
            System.out.println(student.toString());
        }
    }

    public void sortByName() {
        Comparator<Student> studentComparator = Comparator.comparing(Student::getName);
        studentsList.sort(studentComparator);
    }

    public void sortByPoints() {
        Comparator<Student> studentComparator = Comparator.comparing(Student::getPoints).reversed();
        studentsList.sort(studentComparator);
    }

    public void max() {
        Comparator<Student> studentComparator = Comparator.comparing(Student::getPoints);
        System.out.println("Max points:");
        System.out.println(Collections.max(studentsList, studentComparator));
    }

    public int getOccupancy() {
        return studentsList.size() * 100 / capacity;
    }
}
