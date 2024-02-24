package com.doilio.Tickets.repository;

import com.doilio.Tickets.model.Organizer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrganizerRepository {

    private final List<Organizer> organizers = List.of(
            new Organizer(101, "Guyzel Ramos", "Guyzel Producoes"),
            new Organizer(102, "Picasso", "Picasso o Negrao"),
            new Organizer(103, "GDG-Maputo", "Google Developers Group Based in Maputo City")
    );

    public List<Organizer> findAll() {
        return organizers;
    }
}