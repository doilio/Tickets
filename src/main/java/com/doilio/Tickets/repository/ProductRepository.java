package com.doilio.Tickets.repository;

import com.doilio.Tickets.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> products = List.of(
            new Product(801, 101, "Staff", "Free Access to Collaborators", new BigDecimal("0.0")),
            new Product(802, 502, "Normal", "Normal Price", new BigDecimal("500.0")),
            new Product(803, 502, "VIP", "Vip Ticket - Includes Welcome Drink", new BigDecimal("1500.0")),
            new Product(804, 502, "VVIP", "VVIP - Includes Free Parking and Welcome Drink", new BigDecimal("2500.0")),
            new Product(805, 503, "Standard", "Normal Ticket - Before 11PM", new BigDecimal("3000.0")),
            new Product(806, 503, "Premium", "Premium Ticket - After 11PM", new BigDecimal("4500.0"))
    );

    public List<Product> findByEventId(int eventId) {
        return products.stream().filter(product -> product.eventId() == eventId).toList();
    }
}
