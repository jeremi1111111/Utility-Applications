package com.lab7;

import java.io.Serializable;

public class Degree implements Serializable {
    @SaveAnnotation(name = "Name", index = 0)
    String studentName;
    @SaveAnnotation(name = "Surname", index = 1)
    String studentSurname;
    @SaveAnnotation(name = "Subject", index = 2)
    String subject;
    @SaveAnnotation(name = "Comment", index = 3)
    String comment;
    @SaveAnnotation(name = "Degree", index = 4)
    double degree;

    public Degree(String studentName, String studentSurname, String subject, String comment, double degree) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.subject = subject;
        this.comment = comment;
        this.degree = degree;
    }

    public Degree(String comment, double degree) {
        this.comment = comment;
        this.degree = degree;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDegree() {
        return String.format("%.2f", degree);
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "comment='" + comment + '\'' +
                ", degree=" + degree +
                '}';
    }
}
