package com.practice.learning.repository;

import com.practice.learning.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudOperationsRepo extends CrudRepository<Flight, Long> {
}
