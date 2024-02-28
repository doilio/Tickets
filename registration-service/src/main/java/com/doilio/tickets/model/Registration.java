package com.doilio.tickets.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("registrations")
public record Registration(
        @Id String id,
        Integer productId,
        String ticketCode,
        String attendeeName
) {
}