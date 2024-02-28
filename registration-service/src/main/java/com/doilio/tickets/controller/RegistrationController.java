package com.doilio.tickets.controller;

import com.doilio.tickets.model.Registration;
import com.doilio.tickets.repository.RegistrationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/registrations")
public class RegistrationController {

    private final RegistrationRepository registrationRepository;

    public RegistrationController(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @PostMapping
    public Registration create(@RequestBody Registration registration) {
        String ticketCode = UUID.randomUUID().toString();

        return registrationRepository.save(
                new Registration(null, registration.productId(), ticketCode, registration.attendeeName())
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
                        existing.id(), existing.productId(), ticketCode, registration.attendeeName()
                ));
    }

    @DeleteMapping(path = "/{ticketCode}")
    public void delete(@PathVariable("ticketCode") String ticketCode) {
        registrationRepository.deleteByTicketCode(ticketCode);
    }
}