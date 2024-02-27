package com.doilio.Tickets.repository;

import com.doilio.Tickets.model.Event;
import com.doilio.Tickets.model.Organizer;
import com.doilio.Tickets.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;


public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findByOrganizerId(int organizerId);

/*
    private final List<Event> events = List.of(
            new Event(501, "Blue Move",
                    new Organizer(101, "Guyzel Ramos", "Guyzel Producoes"),
                    new Venue(201, "IMA", "Malhampsene", "Matola", "Maputo"),
                    LocalDate.of(2024, Month.FEBRUARY, 29),
                    LocalDate.of(2024, Month.MARCH, 1)),
            new Event(502, "Quintal do Txio Gugu",
                    new Organizer(101, "Guyzel Ramos", "Guyzel Producoes"),
                    new Venue(203, "Madjedje 3", "Rua da Vila Olimpica", "Matola", "Mozambique"),
                    LocalDate.of(2024, Month.MARCH, 8),
                    LocalDate.of(2024, Month.MARCH, 10)),
            new Event(503, "Doilio's Birthday Bash",
                    new Organizer(102, "Picasso", "Picasso o Negrao"),
                    new Venue(204, "OPIUM", "Marginal", "Maputo", "Mozambique"),
                    LocalDate.of(2024, Month.APRIL, 29),
                    LocalDate.of(2024, Month.APRIL, 30))
    );


    public List<Event> findByOrganizerId(int organizerId) {
        return events.stream().filter(event -> event.organizer().id() == organizerId).toList();
    }

    public Optional<Event> findById(int id) {
        return events.stream().filter(event -> event.id() == id).findAny();
    }

 */
}
