// MentorServiceImpl.java
package com.example.demo.service;

import com.example.demo.entity.Mentor;
import com.example.demo.entity.Rating;
import com.example.demo.entity.Review;
import com.example.demo.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorRepository mentorRepository;

@Override
	public Mentor rateMentor(Long mentorId, int stars) {
		Mentor mentor = mentorRepository.findById(mentorId).orElse(null);
		if (mentor != null) {
			Rating rating = new Rating();
			rating.setStars(stars);
			rating.setMentor(mentor);
			mentor.getRatings().add(rating);
			// Calculate and update overall rating logic here
			// Save mentor
			mentor = mentorRepository.save(mentor);
		}
		return mentor;
	}

@Override
	public Mentor reviewMentor(Long mentorId, String comment) {
		Mentor mentor = mentorRepository.findById(mentorId).orElse(null);
		if (mentor != null) {
			Review review = new Review();
			review.setComment(comment);
			review.setMentor(mentor);
			mentor.getReviews().add(review);
			// Save mentor
			mentor = mentorRepository.save(mentor);
		}
		return mentor;
	}
}
