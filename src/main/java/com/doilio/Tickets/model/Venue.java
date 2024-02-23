package com.doilio.Tickets.model;

public record Venue(
        int id,
        String name,
        String street,
        String city,
        String country
) {
}
