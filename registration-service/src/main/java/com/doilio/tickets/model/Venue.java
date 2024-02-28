package com.doilio.tickets.model;

public record Venue(
        int id,
        String name,
        String street,
        String city,
        String country) {
}