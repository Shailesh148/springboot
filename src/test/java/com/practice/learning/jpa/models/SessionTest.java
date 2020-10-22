package com.practice.learning.jpa.models;


import com.practice.learning.jpa.repository.SessionJpaRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionJpaRespository repository;

    @Test
    public void test() throws Exception {
        List<Session> sessions = repository.findBySessionNameContains("Java");
        assertTrue(sessions.size() > 0);
    }


    @Test
    public void testPageable() throws Exception{
        Page<Session> page = repository.getSessionsWithName("S", PageRequest.of(1,5, Sort.by(Sort.Direction.ASC, "sessionLength") ));
        assertTrue(page.getTotalElements()>0);
    }

}
