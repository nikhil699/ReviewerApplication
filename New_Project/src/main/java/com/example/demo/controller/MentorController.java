// MentorController.java
package com.example.demo.controller;

import com.example.demo.entity.Mentor;
import com.example.demo.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mentors")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @PostMapping("/{mentorId}/rate")
    public Mentor rateMentor(@PathVariable Long mentorId, @RequestParam int stars) {
        return mentorService.rateMentor(mentorId, stars);
    }

    @PostMapping("/{mentorId}/review")
    public Mentor reviewMentor(@PathVariable Long mentorId, @RequestParam String comment) {
        return mentorService.reviewMentor(mentorId, comment);
    }
}
