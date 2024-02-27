INSERT INTO organizers (id, name, description) VALUES (101, 'Guyzel Ramos', 'Guyzel Producoes');
INSERT INTO organizers (id, name, description) VALUES (102, 'Picasso', 'Picasso o Negrao');
INSERT INTO organizers (id, name, description) VALUES (103, 'GDG-Maputo', 'Google Developers Group Based in Maputo City');

INSERT INTO venues (id, name, street, city, country) VALUES (201, 'IMA', 'Malhampsene', 'Matola', 'Mozambique');
INSERT INTO venues (id, name, street, city, country) VALUES (202, 'Standard Bank', '10 de Novembro', 'Maputo', 'Mozambique');
INSERT INTO venues (id, name, street, city, country) VALUES (203, 'Madjedje 3', 'Rua da Vila Olimpica', 'Matola', 'Mozambique');
INSERT INTO venues (id, name, street, city, country) VALUES (204, 'OPIUM', 'Marginal', 'Maputo', 'Mozambique');

INSERT INTO events (id, name, organizer_id, venue_id, start_date, end_date) VALUES (501, 'Blue Move', 101, 201, '2024-02-29', '2024-03-01');
INSERT INTO events (id, name, organizer_id, venue_id, start_date, end_date) VALUES (502, 'Quintal do Txio Gugu', 101, 203, '2024-03-08', '2024-03-10');
INSERT INTO events (id, name, organizer_id, venue_id, start_date, end_date) VALUES (503, 'Doilios Birthday Bash', 102, 204, '2024-04-29', '2024-04-30');

INSERT INTO products (id, event_id, name, description, price) VALUES (801, 501, 'Staff', 'Free Access to Collaborators', 0.00);
INSERT INTO products (id, event_id, name, description, price) VALUES (802, 502, 'Normal', 'Normal Price', 500.00);
INSERT INTO products (id, event_id, name, description, price) VALUES (803, 502, 'VIP', 'Vip Ticket - Includes Welcome Drink', 1500.00);
INSERT INTO products (id, event_id, name, description, price) VALUES (804, 502, 'VVIP', 'VVIP - Includes Free Parking and Welcome Drink', 2500.00);
INSERT INTO products (id, event_id, name, description, price) VALUES (805, 503, 'Standard', 'Normal Ticket - Before 11PM', 3000.00);
INSERT INTO products (id, event_id, name, description, price) VALUES (806, 503, 'Premium', 'Premium Ticket - After 11PM', 4500.00);