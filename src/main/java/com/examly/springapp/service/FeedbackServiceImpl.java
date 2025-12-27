package com.examly.springapp.service;
import com.examly.springapp.model.Feedback;
import com.examly.springapp.repository.FeedbackRepo;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl  implements FeedbackService{
        private final FeedbackRepo repo;

        public FeedbackServiceImpl(FeedbackRepo repo){
                this.repo=repo;
        }

        @Override
        public Feedback createFeedBack(Feedback feedback){
                return repo.save(feedback);
        }

        @Override
        public List<Feedback> getAllFeedbacks(){
                return repo.findAll();
        }

        @Override
        public Feedback getFeedbackById(Long id){
                return repo.findById(id).orElse(null);
        }
}
