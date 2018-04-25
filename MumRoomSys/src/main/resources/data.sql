insert into role(id, name) values (1, 'DIRECTOR');
insert into role(id, name) values (2, 'STUDENT');

/* all users have the same password = password */

insert into student(id, name, email, phone) values(9, 'admin140', 'admin140@mum.edu', '+15152034404');
insert into student(id, name, email) values(10, 'admin141', 'admin141@mum.edu');
insert into student(id, name, email) values(11, 'admin142', 'admin142@mum.edu');
insert into student(id, name, email, phone) values(12, 'student1', 'student1@mum.edu','+17088873465');
insert into student(id, name, email) values(13, 'student2', 'student2@mum.edu');
insert into student(id, name, email) values(14, 'student3', 'student3@mum.edu');
insert into student(id, name, email) values(50, 'student4', 'student4@mum.edu');
insert into student(id, name, email) values(51, 'student5', 'student5@mum.edu');
insert into student(id, name, email) values(52, 'student6', 'student6@mum.edu');
insert into student(id, name, email) values(53, 'student7', 'student7@mum.edu');
insert into student(id, name, email) values(54, 'student8', 'student8@mum.edu');
insert into student(id, name, email) values(55, 'student9', 'student9@mum.edu');
insert into student(id, name, email) values(56, 'student10', 'student10@mum.edu');

insert into account(id, role_id, student_id, username, email, password, enabled) values(3, 1, 9, 'admin140', 'admin140@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(4, 1, 10, 'admin141', 'admin141@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(5, 1, 11, 'admin142', 'admin142@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);

insert into account(id, role_id, student_id, username, email, password, enabled) values(6, 2, 12, 'student1', 'student1@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(7, 2, 13, 'student2', 'student2@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(8, 2, 14, 'student3', 'student3@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);

insert into account(id, role_id, student_id, username, email, password, enabled) values(60, 2, 50, 'student4', 'student4@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(61, 2, 51, 'student5', 'student5@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(62, 2, 52, 'student6', 'student6@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(63, 2, 53, 'student7', 'student7@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(64, 2, 54, 'student8', 'student8@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(65, 2, 55, 'student9', 'student9@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);
insert into account(id, role_id, student_id, username, email, password, enabled) values(66, 2, 56, 'student10', 'student10@mum.edu', '$2a$10$R1kmVEHTHJ90GcejrpmTdOirALp9ZJ7ugMkPSDRKlOhTc1j92WClW', 1);


insert into room(id, build_number, number, status) values(15, 140, 1, 'READY');
insert into room(id, build_number, number, status) values(16, 140, 2, 'READY');
insert into room(id, build_number, number, status) values(17, 140, 3, 'READY');
insert into room(id, build_number, number, status) values(24, 140, 4, 'READY');
insert into room(id, build_number, number, status) values(25, 140, 5, 'READY');
insert into room(id, build_number, number, status) values(26, 140, 6, 'READY');
insert into room(id, build_number, number, status) values(27, 140, 7, 'MAINTENANCE');
insert into room(id, build_number, number, status) values(18, 141, 1, 'READY');
insert into room(id, build_number, number, status) values(19, 141, 2, 'READY');
insert into room(id, build_number, number, status) values(20, 141, 3, 'READY');
insert into room(id, build_number, number, status) values(21, 142, 1, 'READY');
insert into room(id, build_number, number, status) values(22, 142, 2, 'READY');
insert into room(id, build_number, number, status) values(23, 142, 3, 'MAINTENANCE');

insert into booking(id,room_id,student_id,move_in_date,status) values(30,15,12,'2018-04-25','NEW');

insert into booking(id,room_id,student_id,move_in_date,status) values(31,16,13,'2018-04-27','NEW');
insert into booking(id,room_id,student_id,move_in_date,status) values(32,17,14,'2018-04-28','NEW');
insert into booking(id,room_id,student_id,move_in_date,status) values(33,24,9,'2018-03-28','NEW');
insert into booking(id,room_id,student_id,move_in_date,status) values(34,25,10,'2018-03-29','NEW');
insert into booking(id,room_id,student_id,move_in_date,status) values(35,26,11,'2018-03-30','NEW');

insert into request(id,student_id,type,description) values(40,12,'MAINTENANCE','Test Request 1');
insert into request(id,student_id,type,description) values(41,13,'CHANGING_ROOM','Test Request 2');



