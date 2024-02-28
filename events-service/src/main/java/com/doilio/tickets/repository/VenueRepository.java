package com.doilio.tickets.repository;

import com.doilio.tickets.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VenueRepository extends JpaRepository<Venue, Integer> {

}