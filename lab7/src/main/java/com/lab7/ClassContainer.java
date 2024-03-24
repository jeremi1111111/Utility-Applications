package com.lab7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ClassContainer implements Serializable {
    public Map<String, Subject> groups;

    public ClassContainer() {
        this.groups = new TreeMap<>();
    }

    public void addClass(String name, int capacity) {
        Subject klasa = new Subject(name, new ArrayList<Student>(), capacity);
        groups.put(name, klasa);
    }

    public void removeClass(String name) {
        groups.remove(name);
    }

    public ArrayList<Subject> findEmpty() {
        ArrayList<Subject> empty = new ArrayList<Subject>();
        for (Subject subject : groups.values()) {
            if (subject.occupancy() == 0) empty.add(subject);
        }
        return empty;
    }

    public void summary() {
        System.out.println("Classes:");
        for (Map.Entry<String, Subject> group : groups.entrySet()) {
            Subject subject = group.getValue();
            System.out.printf("%s : %d%% occupancy\n", group.getKey(), subject.occupancy());
        }
    }

    public void addToClass(String className, Student student) {
        this.groups.get(className).addStudent(student);
    }

    public Subject getSubject(String className) {
        return this.groups.get(className);
    }

    public void classSummary(String className) {
        this.groups.get(className).summary();
    }

    public void searchClassPartial(String className, String part) {
        ArrayList<Student> copy = this.groups.get(className).searchPartial(part);
        if (!copy.isEmpty()) System.out.printf("Students found for \"%s\" in %s:\n", part, className);
        for (Student student : copy) {
            System.out.println(student.toString());
        }
    }

    public ArrayList<Student> findClasses(Student student) {
        ArrayList<Student> fCl = new ArrayList<>();
        double sum = 0;
        for (Subject cls : groups.values()) {
            Student student1 = cls.search(student.name, student.surname);
            if (student1 != null) {
                double mean = student1.getMean();
                fCl.add(student1);
                sum += mean;
            }
        }
        ArrayList<Degree> m = new ArrayList<>();
        if (!fCl.isEmpty())
            m.add(new Degree("Mean", sum / fCl.size()));
        else
            m.add(new Degree("Mean", 0.));
        fCl.add(new Student(student.name, student.surname, "Mean", StudentCondition.PRESENT, student.yearOfBirth, m));
        return fCl;
    }
    public ArrayList<Subject> findNewSubjects(Student student) {
        ArrayList<Subject> fNS = new ArrayList<>();
        for (Subject cls : groups.values()) {
            if (cls.search(student.name, student.surname) == null) {
                fNS.add(cls);
            }
        }
        return fNS;
    }
}
