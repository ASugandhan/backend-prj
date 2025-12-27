package com.examly.springapp.service;
import java.util.*;
import com.examly.springapp.model.Feedback;

public interface FeedbackService {
    Feedback createFeedBack(Feedback feedback);
    List<Feedback> getAllFeedbacks();
    Feedback getFeedbackById(Long id);
}
