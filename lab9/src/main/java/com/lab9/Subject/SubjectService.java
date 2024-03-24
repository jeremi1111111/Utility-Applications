package com.lab9.Subject;

import com.lab9.BadBodyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subjectService")
public class SubjectService {
    SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public Subject findById(Integer id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new SubjectNotFoundException(id));
    }

    public Subject save(Subject subject) {
        try {
            return subjectRepository.save(subject);
        }
        catch (RuntimeException ex) {
            throw new BadBodyException();
        }
    }

    public void delete(Integer id) {
        subjectRepository.deleteById(id);
    }

    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }
}
