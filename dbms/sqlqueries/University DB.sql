-- create database university 
use university;
-- create table student(
--  student_id int primary key,
--  name varchar(50),
--  program varchar(30)
--  );

-- create table course_offering(
-- course_no int primary key,
-- timing time,
-- room char(10),
-- semester int,
-- current_year year);

-- alter table student add column (course_no int);
-- alter table student add constraint foreign key(course_no) 
-- references course_offering(course_no);

-- create table exam(
-- exam_no int primary key,
-- timing time,
-- exam_name varchar(30),
-- place varchar(20),
-- course_no int,
-- student_id int,
-- foreign key(course_no) references course_offering(course_no),
-- foreign key(student_id) references student(student_id)
-- );

-- create table course(
-- course_no int,
-- prerequisit text,
-- credit int,
-- title text,
-- syllabus text,
-- foreign key(course_no) references course_offering(course_no)
-- );

-- create table instructor(
-- instructor_id int,
-- name text,
-- title text,
-- dept text,
-- course_no int,
-- foreign key(course_no) references course_offering(course_no)
-- );