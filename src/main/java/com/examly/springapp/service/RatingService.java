package com.examly.springapp.service;
import com.examly.springapp.model.Rating;
import java.util.*;

public interface RatingService {
    Rating createRating(int rating );
    List<Rating> getAllRating();
    Rating getRatingById(Long id);
}
