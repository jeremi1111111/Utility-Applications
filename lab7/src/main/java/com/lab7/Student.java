package com.lab7;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Comparable<Student>, Serializable {
    @SaveAnnotation(name = "Name", index = 0)
    String name;
    @SaveAnnotation(name = "Surname", index = 1)
    String surname;
    @SaveAnnotation(name = "Subject", index = 2)
    String subject;
    transient StudentCondition studentCondition;
    @SaveAnnotation(name = "Year of Birth", index = 3)
    int yearOfBirth;
    ArrayList<Degree> degrees;
    String meanString;

    public Student(String name, String surname, String subject, StudentCondition studentCondition, int yearOfBirth, ArrayList<Degree> degrees) {
        this.name = name;
        this.surname = surname;
        this.subject = subject;
        this.studentCondition = studentCondition;
        this.yearOfBirth = yearOfBirth;
        this.degrees = degrees;
        this.meanString = String.format("%.2f", getMean());
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public StudentCondition getStudentCondition() {
        return studentCondition;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public ArrayList<Degree> getDegrees() {
        return degrees;
    }

    public void setStudentCondition(StudentCondition studentCondition) {
        this.studentCondition = studentCondition;
    }

    public void addDegrees(ArrayList<Degree> ds) {
        this.degrees.addAll(ds);
        meanString = String.format("%.2f", getMean());
    }

    public void removeDegree(String comment) {
        Degree rem = null;
        for (Degree degree : degrees) {
            if (degree.comment.equals(comment)) {
                rem = degree;
                break;
            }
        }
        degrees.remove(rem);
        meanString = String.format("%.2f", getMean());
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMeanString() {
        return meanString;
    }

    public void setMeanString(String meanString) {
        this.meanString = meanString;
    }

    public double getMean() {
        double suma = 0;
        for (Degree degree : degrees) {
            suma += degree.degree;
        }
        if (degrees.isEmpty()) {
            return 0.;
        }
        return suma / degrees.size();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", subject='" + subject + '\'' +
                ", studentCondition=" + studentCondition +
                ", yearOfBirth=" + yearOfBirth +
                ", degrees=" + degrees +
                ", meanString='" + meanString + '\'' +
                '}';
    }

    public String tooltipInfo() {
        StringBuilder ds = new StringBuilder();
        for (Degree d : degrees) {
            ds.append(String.format("%.2f ", d.degree));
        }
        return studentCondition + ", średnia: " + meanString + '\n' + ds;
    }

    @Override
    public int compareTo(Student student) {
        return this.surname.compareTo(student.surname);
    }
}
