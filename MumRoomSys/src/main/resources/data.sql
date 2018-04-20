insert into role(id, name) values (1, 'DIRECTOR');
insert into role(id, name) values (2, 'STUDENT');

/* all users have the same password = password */

insert into account(id, role_id, username, email, password, enabled) values(3, 1, 'admin140', 'admin140@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, username, email, password, enabled) values(4, 1, 'admin141', 'admin141@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, username, email, password, enabled) values(5, 1, 'admin142', 'admin142@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);

insert into account(id, role_id, username, email, password, enabled) values(6, 2, 'student1', 'student1@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, username, email, password, enabled) values(7, 2, 'student2', 'student2@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, username, email, password, enabled) values(8, 2, 'student3', 'student3@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
