package com.lab9;

import com.lab9.Degree.Degree;
import com.lab9.Degree.DegreeService;
import com.lab9.Rating.Rating;
import com.lab9.Rating.RatingOutOfBoundsException;
import com.lab9.Rating.RatingService;
import com.lab9.Student.Student;
import com.lab9.Student.StudentService;
import com.lab9.Subject.Subject;
import com.lab9.Subject.SubjectService;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("databaseService")
public class DatabaseService {
    @Resource(name = "subjectService")
    SubjectService subjectService;
    @Resource(name = "studentService")
    StudentService studentService;
    @Resource(name = "degreeService")
    DegreeService degreeService;
    @Resource(name = "ratingService")
    RatingService ratingService;

    public DatabaseService(SubjectService subjectService, StudentService studentService, DegreeService degreeService, RatingService ratingService) {
        this.subjectService = subjectService;
        this.studentService = studentService;
        this.degreeService = degreeService;
        this.ratingService = ratingService;
    }

    Student findStudent(Integer id) {
        return studentService.findById(id);
    }

    List<Student> getAllStudents() {
        return studentService.getAll();
    }

    Double getStudentScore(Integer id) {
        Student student = findStudent(id);
        List<Degree> degrees = student.getDegrees()
                .stream()
                .toList();
        return degrees
                .stream()
                .mapToDouble(Degree::getDegree)
                .average()
                .orElse(0.0);
    }

    String generateStudentsCSV() {
        try {
            return Conversion.studentsToCSV(getAllStudents());
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        }
    }

    Student addStudent(Student student) {
        return studentService.save(student);
    }

    void deleteStudent(Integer id) {
        studentService.delete(id);
    }

    Subject findSubject(Integer id) {
        return subjectService.findById(id);
    }

    List<Subject> getAllSubjects() {
        return subjectService.getAll();
    }

    List<Student> getStudentsInSubject(Integer id) {
        return findSubject(id).getStudents().stream().toList();
    }

    Double getSubjectFill(Integer id) {
        Subject subject = findSubject(id);
        return (double) subject.getStudents().size() / subject.getMaxCapacity() * 100;
    }

    Subject addSubject(Subject subject) {
        return subjectService.save(subject);
    }

    void deleteSubject(Integer id) {
        subjectService.delete(id);
    }

    Rating addRating(Rating rating) {
        if (rating.getRating() >= 0 && rating.getRating() <= 5)
            return ratingService.save(rating);
        throw new RatingOutOfBoundsException();
    }
}
