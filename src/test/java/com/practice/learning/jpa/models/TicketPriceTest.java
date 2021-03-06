package com.practice.learning.jpa.models;


import com.practice.learning.jpa.repository.TicketPricingJpaRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TicketPriceTest {

    @Autowired
    private TicketPricingJpaRespository ticketPricingJpaRespository;

//
//    @Autowired
//    private PricingCategoryRepository pcRepository;
//
//    @Autowired
//    private TicketTypeRepository ttRepository;

    @Test
    public void testFind() throws Exception {
        TicketPrice ticket = ticketPricingJpaRespository.findById(1L).get();
        assertNotNull(ticket);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        TicketPrice tp = new TicketPrice();
        tp.setBasePrice(BigDecimal.valueOf(200, 2));

//        tp.setPricingCategory(pcRepository.find("E"));
//
//        tp.setTicketType(ttRepository.find("C"));
//
//        tp = repository.create(tp);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
//        entityManager.clear();

//        TicketPrice otherTp = repository.find(tp.getTicketPriceId());
//        assertEquals(BigDecimal.valueOf(200, 2), otherTp.getBasePrice());

//        repository.delete(otherTp.getTicketPriceId());
    }


    @Test
    public void testQueryAnnotation() throws Exception{
        List<TicketPrice> ticketPrice = ticketPricingJpaRespository.getTicketsUnderPriceFromWorkshops(BigDecimal.valueOf(1000));
        assertTrue(ticketPrice.size()>0);
    }
}
