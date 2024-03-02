package com.doilio.tickets.repository;

import com.doilio.tickets.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByEventId(int eventId);


}
