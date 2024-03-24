package com.lab9.Degree;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lab9.Student.Student;
import jakarta.persistence.*;

@Entity
@Table(name = "DEGREES")
public class Degree {
    @Id
    @GeneratedValue
    Integer degreeId;
    Double degree;
    String comment;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    public Degree() {}

    public Degree(Double degree, String comment, Student student) {
        this.degree = degree;
        this.comment = comment;
        this.student = student;
    }

    public Integer getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Integer degreeId) {
        this.degreeId = degreeId;
    }

    public Double getDegree() {
        return degree;
    }

    public void setDegree(Double degree) {
        this.degree = degree;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
