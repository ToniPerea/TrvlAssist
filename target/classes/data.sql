USE trvl_assist;


INSERT IGNORE INTO user (id, username, password, active, first_name, last_name, role, gender)
VALUES (1, 'admin', '$2a$10$BxwiCZxdU6S8xN2wUelMSufY15laFqHqEMgMCUraFFqf7.m.9dcVS', true, 'Admin', 'Admin', 'ADMIN','MALE');

INSERT IGNORE INTO user (id, username, password, active, first_name, last_name, role, gender)
VALUES (2, 'customer', '$2a$10$L4kl2Fq6LtWZLR3uDLc2QeZr8BqD8b0ztAJ7YzeLYIQn8lphs1CQa', true, 'Customer', 'Customer', 'USER','MALE');




INSERT IGNORE INTO product(id, name, price, description , quantity, image)
VALUES (1, 'GermanyXL', 950, 'Germany Complete',4, '' );

INSERT IGNORE INTO product(id, name, price, description , quantity, image)
VALUES (2, 'BelgiumS', 450, 'Belgium Complete',4, '' );