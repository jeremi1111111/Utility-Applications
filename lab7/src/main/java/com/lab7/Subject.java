package com.lab7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Subject implements Serializable {
    @SaveAnnotation(name = "Subject", index = 0)
    String className;
    ArrayList<Student> studentsList;
    @SaveAnnotation(name = "Maximum capacity", index = 1)
    int maxCapacity;

    public Subject(String className, ArrayList<Student> studentsList, int maxCapacity) {
        this.className = className;
        this.studentsList = studentsList;
        this.maxCapacity = maxCapacity;
    }

    public String getOccupancy() {
        return studentsList.size() + "/" + maxCapacity;
    }

    public String getClassName() {
        return className;
    }

    public void addStudent(Student student) {
        for (Student student1 : studentsList) {
            if (student.name.equals(student1.name) && student.surname.equals(student1.surname)) {
                System.out.println("com.lab7.Student is already enrolled.");
                return;
            }
        }
        if (studentsList.contains(student)) {
            System.out.println("com.lab7.Student is already enrolled.");
            return;
        }
        if (studentsList.size() == maxCapacity) {
            System.err.println("Maximum capacity exceeded");
            return;
        }
        studentsList.add(student);
    }

    public void getStudent(Student student) {
        studentsList.remove(student);
    }

    public void addDegree(Student student, ArrayList<Degree> degrees) {
        student.addDegrees(degrees);
    }

    public void changeCondition(Student student, StudentCondition studentCondition) {
        student.setStudentCondition(studentCondition);
    }

    public void removeDegree(Student student, String comment) {
        student.removeDegree(comment);
    }

    public Student search(String name, String surname) {
        for (Student student : studentsList) {
            if (student.getName().equals(name) && student.getSurname().equals(surname)) return student;
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
            if (student.studentCondition == studentCondition) studentCount++;
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
        Comparator<Student> studentComparator = Comparator.comparing(Student::getMean).reversed();
        studentsList.sort(studentComparator);
    }

    public void max() {
        Comparator<Student> studentComparator = Comparator.comparing(Student::getMean);
        System.out.println("Max points:");
        System.out.println(Collections.max(studentsList, studentComparator));
    }

    public int occupancy() {
        return studentsList.size() * 100 / maxCapacity;
    }
}
