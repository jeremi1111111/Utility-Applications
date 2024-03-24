package com.lab9.Subject;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lab9.Rating.Rating;
import com.lab9.Student.Student;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "SUBJECTS")
public class Subject {
    @Id
    @CsvBindByName
    @Column(name = "subject_id")
    @GeneratedValue
    Integer subjectId;
    String name;
    Integer maxCapacity;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    Set<Student> students = new HashSet<>();
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    Set<Rating> ratings = new HashSet<>();

    public Subject() {}

    public Subject(String name, Integer maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Objects.equals(getSubjectId(), subject.getSubjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubjectId());
    }
}
