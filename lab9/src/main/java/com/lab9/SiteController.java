package com.lab9;

import com.lab9.Rating.Rating;
import com.lab9.Student.Student;
import com.lab9.Subject.Subject;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class SiteController {
    DatabaseService database;
    ModelAssemblers assemblers;

    public SiteController(DatabaseService database, ModelAssemblers assemblers) {
        this.database = database;
        this.assemblers = assemblers;
    }

    @GetMapping("/api/student/{id}")
    public EntityModel<Student> getStudent(@PathVariable Integer id) {
        Student student = database.findStudent(id);
        return assemblers.toEntityModel(student);
    }

    @GetMapping("/api/student")
    public CollectionModel<EntityModel<Student>> getAllStudents() {
        List<EntityModel<Student>> students = assemblers.studentsToListOfEntityModel(database.getAllStudents());
        return CollectionModel.of(students, linkTo(methodOn(SiteController.class).getAllStudents()).withSelfRel());
    }

    @GetMapping("/api/student/{id}/grade")
    public ResponseEntity<?> getScore(@PathVariable Integer id) {
        Double score = database.getStudentScore(id);
        return new ResponseEntity<>("grade: " + score, HttpStatus.OK);
    }

    @GetMapping("/api/student/csv")
    public ResponseEntity<?> getStudentsCSV() {
        String content = database.generateStudentsCSV();
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

    @PostMapping("/api/student")
    public ResponseEntity<?> addStudent(@RequestBody Student newStudent) {
        EntityModel<Student> studentEntityModel = assemblers.toEntityModel(database.addStudent(newStudent));
        return ResponseEntity
                .created(studentEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(studentEntityModel);
    }

    @DeleteMapping("/api/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        database.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/course/{id}")
    public EntityModel<Subject> getSubject(@PathVariable Integer id) {
        Subject subject = database.findSubject(id);
        return assemblers.toEntityModel(subject);
    }

    @GetMapping("/api/course")
    public CollectionModel<EntityModel<Subject>> getAllSubjects() {
        List<EntityModel<Subject>> subjects = assemblers.subjectsToListOfEntityModel(database.getAllSubjects());
        return CollectionModel.of(subjects, linkTo(methodOn(SiteController.class).getAllSubjects()).withSelfRel());
    }

    @GetMapping("/api/course/{id}/students")
    public CollectionModel<EntityModel<Student>> getStudentsInSubject(@PathVariable Integer id) {
        List<EntityModel<Student>> students = assemblers.studentsToListOfEntityModel(database.getStudentsInSubject(id));
        return CollectionModel.of(students);
    }
    @GetMapping("/api/course/{id}/fill")
    public ResponseEntity<?> getSubjectFill(@PathVariable Integer id) {
        return new ResponseEntity<>(String.format("Subject %s fill: %.2f%%", database.findSubject(id).getName(), database.getSubjectFill(id)), HttpStatus.OK);
    }

    @PostMapping("/api/course")
    public ResponseEntity<?> addSubject(@RequestBody Subject newSubject) {
        EntityModel<Subject> subjectEntityModel = assemblers.toEntityModel(database.addSubject(newSubject));
        return ResponseEntity
                .created(subjectEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(subjectEntityModel);
    }

    @DeleteMapping("/api/course/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Integer id) {
        database.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/rating")
    public ResponseEntity<?> postRating(@RequestBody Rating newRating) {
        EntityModel<Rating> ratingEntityModel = assemblers.toEntityModel(database.addRating(newRating));
        return ResponseEntity
                .created(ratingEntityModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                .body(ratingEntityModel);
    }
}
