package com.doilio.tickets.repository;

import com.doilio.tickets.model.Registration;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface RegistrationRepository extends MongoRepository<Registration, String> {

    // No need to write a create or update code because the interface already gives u that

    Optional<Registration> findByTicketCode(String ticketCode);

    void deleteByTicketCode(String ticketCode);

}
