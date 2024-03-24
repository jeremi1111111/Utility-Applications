package com.lab9.Student;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lab9.Degree.Degree;
import com.lab9.Subject.Subject;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvRecurse;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "STUDENTS")
public class Student {
    @Id
    @CsvBindByName
    @Column(name = "student_id")
    @GeneratedValue
    Integer studentId;
    @CsvBindByName
    String firstName;
    @CsvBindByName
    String lastName;
    @JsonBackReference
    @CsvRecurse
    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;
    @JsonManagedReference
    @OneToMany(mappedBy = "student")
    Set<Degree> degrees = new HashSet<>();

    public Student() {}

    public Student(String firstName, String lastName, Subject subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Set<Degree> getDegrees() {
        return degrees;
    }

    public void setDegrees(Set<Degree> degrees) {
        this.degrees = degrees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getSubject(), student.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getSubject());
    }
}
