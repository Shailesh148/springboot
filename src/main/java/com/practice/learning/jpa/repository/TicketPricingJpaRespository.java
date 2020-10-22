package com.practice.learning.jpa.repository;

import com.practice.learning.jpa.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TicketPricingJpaRespository extends JpaRepository<TicketPrice,Long> {
    //complex queries

    @Query("select tp from TicketPrice  tp where tp.basePrice < ?1 and tp.ticketType.includesWorkshop = 'true'")
    List<TicketPrice> getTicketsUnderPriceFromWorkshops(BigDecimal maxPrice);

    //alternative to the above query
//    @Query("select tp from TicketPrice tp where tp.basePrice < :maxprice and tp.ticketType.includesWorkshop = 'true'")
//    List<TicketPrice> getTicketsUnderPriceFromWorkshops(@Param("maxprice") BigDecimal maxPrice);


    //specifying the query as being a native query
//    @Query(value = "select tp from TicketPrice tp where tp.basePrice < :maxprice and tp.ticketType.includesWorkshop = 'true'", nativeQuery = true)
//    List<TicketPrice> getTicketsUnderPriceFromWorkshops(@Param("maxprice") BigDecimal maxPrice);


    //use @Modifying if there is a modification happening like updation/deletion

    List<TicketPrice> nativeFindTicketsByCategoryWithWorkshop(@Param("name") String name);


    //level of precedence, @query, namedQueries and following last is the DSLs

}
