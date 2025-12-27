package com.examly.springapp.controller;

import com.examly.springapp.model.Rating;
import com.examly.springapp.service.RatingService;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {
    private final RatingService service;

    public RatingController(RatingService service){
        this.service= service;
    }

    @PostMapping
    public Rating post(@RequestBody int rating){
        return service.createRating(rating);
    }
    
    @GetMapping
    public List<Rating> get1(){
        return service.getAllRating();
    }

    @GetMapping("/{id}")
    public Rating get2(@PathVariable Long id){
        return service.getRatingById(id);
    }
}
