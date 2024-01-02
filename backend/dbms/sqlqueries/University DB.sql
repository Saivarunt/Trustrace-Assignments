create database university;
use university;

create table instructor(
instructor_id int primary key,
name text,
title text,
dept text
);

create table course_offering(
course_id int primary key,
instructor_id int,
course_no int unique,
timing time,
room char(10),
semester int,
current_year year,
foreign key(instructor_id) references instructor(instructor_id)
);

create table course(
course_id int,
prerequisit text,
credit int,
title text,
syllabus text,
foreign key(course_id) references course_offering(course_id)
);

create table student(
 student_id int primary key,
 name varchar(50),
 program varchar(30)
 );

create table coursetaken(
 student_id int,
 course_id int,
 foreign key(course_id) references course_offering(course_id),
 foreign key(student_id) references student(student_id)
);

create table exam(
exam_no int primary key,
timing time,
exam_name varchar(30),
place varchar(20),
course_id int,
foreign key(course_id) references course_offering(course_id)
);

create table marks(
student_id int,
grade int,
exam_no int,
foreign key(student_id) references student(student_id),
foreign key(exam_no) references exam(exam_no)
);