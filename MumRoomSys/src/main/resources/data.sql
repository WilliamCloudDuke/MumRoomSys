-- insert into role(role) values ('ADMIN');
-- insert into role(role) values ('USER');

/* all users have the same password = password */

-- insert into person(email, last_name, first_name, enable) values('admin@coffeeshop.com', 'Admin', 'Admin', 1);
-- insert into user(email, password, active) values('admin@coffeeshop.com', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
-- insert into user_role (user_id, role_id) values (1,1);

-- insert into person(email, last_name, first_name, enable) values('test@test.com', 'Test', 'Test', 1);
-- insert into user(email, password, active) values('test@test.com', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
-- insert into user_role (user_id, role_id) values (2,2);