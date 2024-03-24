package com.lab9;

import com.lab9.Degree.Degree;
import com.lab9.Degree.DegreeModelAssembler;
import com.lab9.Rating.Rating;
import com.lab9.Rating.RatingModelAssembler;
import com.lab9.Student.Student;
import com.lab9.Student.StudentModelAssembler;
import com.lab9.Subject.Subject;
import com.lab9.Subject.SubjectModelAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModelAssemblers {
    SubjectModelAssembler subjectModelAssembler;
    StudentModelAssembler studentModelAssembler;
    DegreeModelAssembler degreeModelAssembler;
    RatingModelAssembler ratingModelAssembler;

    public ModelAssemblers(SubjectModelAssembler subjectModelAssembler, StudentModelAssembler studentModelAssembler, DegreeModelAssembler degreeModelAssembler, RatingModelAssembler ratingModelAssembler) {
        this.subjectModelAssembler = subjectModelAssembler;
        this.studentModelAssembler = studentModelAssembler;
        this.degreeModelAssembler = degreeModelAssembler;
        this.ratingModelAssembler = ratingModelAssembler;
    }

    EntityModel<Student> toEntityModel(Student student) {
        return studentModelAssembler.toModel(student);
    }
    EntityModel<Subject> toEntityModel(Subject subject) {
        return subjectModelAssembler.toModel(subject);
    }
    EntityModel<Rating> toEntityModel(Rating rating) {
        return ratingModelAssembler.toModel(rating);
    }
    EntityModel<Degree> toEntityModel(Degree degree) {
        return degreeModelAssembler.toModel(degree);
    }

    List<EntityModel<Student>> studentsToListOfEntityModel(List<Student> students) {
        return students
                .stream()
                .map(this::toEntityModel)
                .toList();
    }
    List<EntityModel<Subject>> subjectsToListOfEntityModel(List<Subject> subjects) {
        return subjects
                .stream()
                .map(this::toEntityModel)
                .toList();
    }
    List<EntityModel<Rating>> ratingsToListOfEntityModel(List<Rating> ratings) {
        return ratings
                .stream()
                .map(this::toEntityModel)
                .toList();
    }
    List<EntityModel<Degree>> degreesToListOfEntityModel(List<Degree> degrees) {
        return degrees
                .stream()
                .map(this::toEntityModel)
                .toList();
    }
}
