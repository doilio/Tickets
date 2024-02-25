package com.doilio.Tickets.controller;

import com.doilio.Tickets.model.Event;
import com.doilio.Tickets.model.Organizer;
import com.doilio.Tickets.model.Product;
import com.doilio.Tickets.repository.EventRepository;
import com.doilio.Tickets.repository.OrganizerRepository;
import com.doilio.Tickets.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class EventController {

    private final OrganizerRepository organizerRepository;
    private final EventRepository eventRepository;
    private final ProductRepository productRepository;

    public EventController(OrganizerRepository organizerRepository, EventRepository eventRepository, ProductRepository productRepository) {
        this.organizerRepository = organizerRepository;
        this.eventRepository = eventRepository;
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/organizers")
    public List<Organizer> getOrganizers() {
        return organizerRepository.findAll();
    }

    @GetMapping(value = "/events")
    public List<Event> findEventsByOrganizer(@RequestParam("organizerId") int organizerId) {
        return eventRepository.findByOrganizerId(organizerId);
    }

    @GetMapping(value = "/events/{id}")
    public Event getEventById(@PathVariable("id") int eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new NoSuchElementException("Event with id: " + eventId + " not found!"));
    }

    @GetMapping(value = "/products")
    public List<Product> getProductsByEvent(@RequestParam("eventId") int eventId) {
        return productRepository.findByEventId(eventId);
    }
}
