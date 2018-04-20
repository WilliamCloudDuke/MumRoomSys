insert into role(id, name) values (1, 'DIRECTOR');
insert into role(id, name) values (2, 'STUDENT');

/* all users have the same password = password */

insert into student(id, name, email) values(9, 'admin140', 'admin140@mum.edu');
insert into student(id, name, email) values(10, 'admin141', 'admin141@mum.edu');
insert into student(id, name, email) values(11, 'admin142', 'admin142@mum.edu');
insert into student(id, name, email) values(12, 'student1', 'student1@mum.edu');
insert into student(id, name, email) values(13, 'student2', 'student2@mum.edu');
insert into student(id, name, email) values(14, 'student3', 'student3@mum.edu');

insert into account(id, role_id, student_id, username, email, password, enabled) values(3, 1, 9, 'admin140', 'admin140@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(4, 1, 10, 'admin141', 'admin141@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(5, 1, 11, 'admin142', 'admin142@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);

insert into account(id, role_id, student_id, username, email, password, enabled) values(6, 2, 12, 'student1', 'student1@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(7, 2, 13, 'student2', 'student2@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(8, 2, 14, 'student3', 'student3@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
