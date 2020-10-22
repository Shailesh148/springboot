package com.practice.learning.service;


import com.practice.learning.entity.Flight;
import com.practice.learning.repository.CrudOperationsRepo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class H2DatabaseTest {


    @Autowired
    private CrudOperationsRepo crudOperationsRepo;


    @Test
    public void testSimpleH2() {
        Flight flight = new Flight();
        flight.setOrigin("Bangalore");
        flight.setDestination("Kathmandu");
        flight.setScheduledAt(LocalDateTime.parse("2020-08-13T12:12:00"));


        crudOperationsRepo.save(flight);

        crudOperationsRepo.findAll().forEach(System.out::println);
    }
}
