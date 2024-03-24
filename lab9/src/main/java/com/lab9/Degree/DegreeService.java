package com.lab9.Degree;

import com.lab9.BadBodyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("degreeService")
public class DegreeService {
    DegreeRepository degreeRepository;

    public DegreeService(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    Degree finById(Integer id) {
        return degreeRepository.findById(id)
                .orElseThrow(() -> new DegreeNotFoundException(id));
    }

    Degree save(Degree degree) {
        try {
            return degreeRepository.save(degree);
        } catch (RuntimeException ex) {
            throw new BadBodyException();
        }
    }

    void delete(Integer id) {
        degreeRepository.deleteById(id);
    }

    List<Degree> getAll() {
        return degreeRepository.findAll();
    }
}
