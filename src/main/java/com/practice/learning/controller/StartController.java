package com.practice.learning.controller;


import com.practice.learning.jpa.models.Speaker;
import com.practice.learning.jpa.repository.SpeakerJpaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    @Autowired
    private SpeakerJpaRespository speakerJpaRepository;

    @GetMapping("/start_check")
    public String checkStart() {
        Speaker speaker = speakerJpaRepository.findById(1L).get();
        return "OK";
    }
}
