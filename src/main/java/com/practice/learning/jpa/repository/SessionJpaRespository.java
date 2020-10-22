package com.practice.learning.jpa.repository;

import com.practice.learning.jpa.models.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionJpaRespository extends JpaRepository<Session, Long> {


    //find by session name like
    List<Session> findBySessionNameContains(String name);

    //findFirstBy => returns just one object
    //countBy => counter so could be set to Long

    //findByFirstNameAndLastName


    @Query("select s from Session s where s.sessionName like %: name")
    Page<Session> getSessionsWithName(@Param("name") String name, Pageable pageable);



}
