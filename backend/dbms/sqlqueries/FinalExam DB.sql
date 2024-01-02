create database finalexams;

use finalexams;

create table course(
c_number int primary key,
name varchar(255),
department varchar(255)
);

create table room(
r_number int primary key,
building varchar(255),
capacity int
);

create table exam(
exam_id int primary key,
exam_time time,
r_number int,
foreign key (r_number) references room(r_number)
);

create table student(
student_id int primary key,
name varchar(255)
);

create table section(
s_number int,
student_id int,
c_number int,
exam_id int,
foreign key (c_number) references course(c_number),
foreign key (exam_id) references exam(exam_id),
foreign key (student_id) references student(student_id)
);