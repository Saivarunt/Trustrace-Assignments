create database exampledb;
use exampledb;

-- int - varchar (error)
-- create table table1(
-- sno int primary key,
-- name varchar(10)
-- );

-- create table table2(
-- sno varchar(10),
-- foreign key(sno) references table1(sno)
-- );
-- drop database exampledb;

-- small varchar - large varchar no effect when creating table
-- create table table1(
-- sno varchar(5) primary key,
-- name varchar(10)
-- );
-- insert into table1 values("12345","x");

-- create table table2(
-- sno varchar(10),
-- foreign key(sno) references table1(sno)
-- );
-- insert into table2 values("1234567891");-- error when trying to insert larger value than primary key 
-- drop database exampledb;

--  large varchar - small varchar (no effect) when creating table
-- create table table1(
-- sno varchar(10) primary key,
-- name varchar(10)
-- );
-- insert into table1 values("1234567890","x");

-- create table table2(
-- sno varchar(5),
-- foreign key(sno) references table1(sno)
-- );
-- insert into table2 values("12345");-- error when trying to insert smaller value than primary key 
-- drop database exampledb;

-- int - float (error)
-- create table table1(
-- sno int primary key,
-- name varchar(10)
-- );

-- create table table2(
-- sno float,
-- foreign key(sno) references table1(sno)
-- );
-- drop database exampledb;

-- float - int (error)
-- create table table1(
-- sno float primary key,
-- name varchar(10)
-- );

-- create table table2(
-- sno int,
-- foreign key(sno) references table1(sno)
-- );
-- drop database exampledb;