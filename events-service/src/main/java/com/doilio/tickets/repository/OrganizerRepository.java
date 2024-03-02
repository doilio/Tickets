package com.doilio.tickets.repository;


import com.doilio.tickets.model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {



/*    private final List<Organizer> organizers = List.of(
            new Organizer(101, "Guyzel Ramos", "Guyzel Producoes"),
            new Organizer(102, "Picasso", "Picasso o Negrao"),
            new Organizer(103, "GDG-Maputo", "Google Developers Group Based in Maputo City")
    );

    public List<Organizer> findAll() {
        return organizers;
    }*/
}
