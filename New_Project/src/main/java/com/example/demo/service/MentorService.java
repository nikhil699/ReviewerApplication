// MentorService.java
package com.example.demo.service;


import com.example.demo.entity.Mentor;
import com.example.demo.entity.Rating;
import com.example.demo.entity.Review;
import com.example.demo.entity.Mentor;

public interface MentorService {
    Mentor rateMentor(Long mentorId, int stars);
    Mentor reviewMentor(Long mentorId, String comment);
}