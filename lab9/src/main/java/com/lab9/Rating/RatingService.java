package com.lab9.Rating;

import com.lab9.BadBodyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ratingService")
public class RatingService {
    RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating findById(Integer id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new RatingNotFoundException(id));
    }

    public Rating save(Rating rating) {
        try {
            return ratingRepository.save(rating);
        }
        catch (RuntimeException ex) {
            throw new BadBodyException();
        }
    }

    void delete(Integer id) {
        ratingRepository.deleteById(id);
    }

    List<Rating> getAll() {
        return ratingRepository.findAll();
    }
}
