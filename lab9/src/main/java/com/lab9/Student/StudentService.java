package com.lab9.Student;

import com.lab9.BadBodyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService {
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student findById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student save(Student student) {
        for (Student s : studentRepository.findAll()) {
            if (student.equals(s)) {
                throw new ExistingStudentException();
            }
        }
        try {
            return studentRepository.save(student);
        } catch (RuntimeException ex) {
            throw new BadBodyException();
        }
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}
