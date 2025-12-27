package com.examly.springapp.controller;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.examly.springapp.model.Feedback;
import com.examly.springapp.service.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {
    private final FeedbackService service;

    public FeedbackController(FeedbackService service){
        this.service = service;
    }
    
    @PostMapping
    public Feedback put(@RequestBody Feedback feedback){
        return service.createFeedBack(feedback);
    }

    @GetMapping
    public List<Feedback> get1(){
        return  service.getAllFeedbacks();
    }

    @GetMapping("/{id}")
    public Feedback get2(@PathVariable Long id){
        return service.getFeedbackById(id);
    }
}
