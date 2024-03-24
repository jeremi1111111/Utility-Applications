package com.lab9.Rating;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lab9.Subject.Subject;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "RATINGS")
public class Rating {
    @Id
    @Column(name = "rating_id")
    @GeneratedValue
    Integer ratingId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "subject_id")
    Subject subject;
    @CreationTimestamp
    Date assessmentDate;
    Integer rating;
    @Column(nullable = false)
    String comment;

    public Rating() {}

    public Rating(Subject subject, Integer rating, String comment) {
        this.subject = subject;
        this.rating = rating;
        this.comment = comment;
    }

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
