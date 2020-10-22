package com.practice.learning.jpa.repository;

import com.practice.learning.jpa.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerJpaRespository extends JpaRepository<Speaker, Long> {

    List<Speaker> findByFirstNameAndLastName(String firstName, String lastname);

//    List<Speaker> findBySessionLengthNot(String name);
//
//    List<Speaker> findBySessionNameLike(String name);
//
//    List<Speaker> findBySessionNameStartingWithAndEndingWith(String firstName, String lastName);
//
//    List<Speaker> findDistinctBySessionName(String name);
//

    //limiting query
//    List<Speaker> findTop5BySessionName(String name);
//
//
//    List<Speaker> findFirstByFirstName(String firstName);
//
//    List<Speaker> findByLastNameOrderByFirstName(String lastName);
}
