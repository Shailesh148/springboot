package com.practice.learning.jpa.models;


import com.practice.learning.jpa.repository.SpeakerJpaRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class SpeakerTest {


    @Autowired
    private SpeakerJpaRespository speakerJpaRepository;

    @Test
    public void testFind() throws Exception {
        Speaker speaker = speakerJpaRepository.getOne(1L);
        assertNotNull(speaker);
    }

    @org.junit.jupiter.api.Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        Speaker s = new Speaker();
        s.setCompany("Pluralsight");
        s.setFirstName("Dan");
        s.setLastName("Bunker");
        s.setTitle("Author");
        s.setSpeakerBio("Consulting and mentoring");
        s = speakerJpaRepository.saveAndFlush(s);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
//        entityManager.clear();

        Speaker otherSpeaker = speakerJpaRepository.getOne(s.getSpeakerId());
        assertEquals("Dan", otherSpeaker.getFirstName());

        speakerJpaRepository.deleteById(otherSpeaker.getSpeakerId());
    }

    @Test
    public void findByFirstLastName() throws Exception{
        List<Speaker> speaker = speakerJpaRepository.findByFirstNameAndLastName("Justin", "Clark");
        assertTrue(speaker.size()>0);
    }


}
