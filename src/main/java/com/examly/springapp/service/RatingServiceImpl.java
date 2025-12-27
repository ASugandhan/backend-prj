package com.examly.springapp.service;

import org.springframework.stereotype.Service;
import com.examly.springapp.model.Rating;
import com.examly.springapp.repository.RatingRepo;
import java.util.*;
@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepo repo;

    public RatingServiceImpl(RatingRepo repo){
        this.repo=repo;
    }

    @Override
    public Rating  createRating(int rating ){
        Rating r = new Rating();
        r.setRating(rating);
        return repo.save(r);
    }

    @Override
    public List<Rating> getAllRating(){
        return repo.findAll();
    }

    @Override
    public Rating getRatingById(Long id){
        return repo.findById(id).orElse(null);
    }

}
