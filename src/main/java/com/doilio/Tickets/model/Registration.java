package com.doilio.Tickets.model;

public record Registration(
        Integer id,
        Integer productId,
        String ticketCode,
        String attendeeName
) {
}
