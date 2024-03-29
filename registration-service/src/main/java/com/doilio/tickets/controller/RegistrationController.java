package com.doilio.tickets.controller;

import com.doilio.tickets.client.EventsClient;
import com.doilio.tickets.model.Event;
import com.doilio.tickets.model.Product;
import com.doilio.tickets.model.Registration;
import com.doilio.tickets.repository.RegistrationRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/registrations")
public class RegistrationController {

    private final EventsClient eventsClient;
    private final RegistrationRepository registrationRepository;

    public RegistrationController(EventsClient eventsClient, RegistrationRepository registrationRepository) {
        this.eventsClient = eventsClient;
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        Product product = eventsClient.getProductById(registration.productId());
        Event event = eventsClient.getEventById(product.eventId());

        String ticketCode = UUID.randomUUID().toString();

        return registrationRepository.save(
                new Registration(null,
                        registration.productId(),
                        event.name(),
                        product.price(),
                        ticketCode,
                        registration.attendeeName()
                )
        );
    }

    @GetMapping(path = "/{ticketCode}")
    public Registration get(@PathVariable("ticketCode") String ticketCode) {
        return registrationRepository.findByTicketCode(ticketCode)
                .orElseThrow(() -> new NoSuchElementException("Registration with ticketCode: " + ticketCode + " not found!"));
    }

    @PutMapping
    public Registration update(@RequestBody Registration registration) {
        // Find the existing registration by ticket code.
        String ticketCode = registration.ticketCode();
        var existing = registrationRepository
                .findByTicketCode(ticketCode)
                .orElseThrow(() ->
                        new NoSuchElementException("Registration with ticket code: " + ticketCode + " not found!")
                );

        // Only update the attendee name
        return registrationRepository.save(
                new Registration(
                        existing.id(), existing.productId(), existing.eventName(), existing.amount(), ticketCode, registration.attendeeName()
                ));
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}
