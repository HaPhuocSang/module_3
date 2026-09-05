create database if not exists student_management;
use student_management;
create table classes(
	id int primary key auto_increment,
    name varchar(50) not null
);

create table teachers(
	id int primary key auto_increment,
    name varchar(50) not null,
    age int not null,
    country varchar(40) not null
);
