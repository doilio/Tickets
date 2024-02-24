package com.doilio.Tickets.repository;

import com.doilio.Tickets.model.Venue;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class VenueRepository {

    private final List<Venue> venues = List.of(
            new Venue(201, "IMA", "Malhampsene", "Matola", "Mozambique"),
            new Venue(202, "Standard Bank", "10 de Novembro", "Maputo", "Mozambique"),
            new Venue(203, "Madjedje 3", "Rua da Vila Olimpica", "Matola", "Mozambique"),
            new Venue(204, "OPIUM", "Marginal", "Maputo", "Mozambique")
    );

    public Optional<Venue> findById(int id){
        return venues.stream().filter(venue -> venue.id() == id).findAny();
    }
}
