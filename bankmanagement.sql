create database bankmanagementsystem;
use bankmanagementsystem;
create table login ( cardNo varchar(25),pinNo varchar(25),formNo varchar(25));
create table signup(formno varchar(25), name varchar(25), FirstName varchar(25), DateOfBirth varchar(35), Gender varchar(25), Address varchar(50), City varchar(25), Pincode varchar(25), State varchar(25));
create table signupTwo(FormNo varchar(35),Religion varchar(35), Category varchar(35),Income varchar(35),Education varchar(35),Specification varchar(35),PAN_No varchar(35), AadharNo varchar(35), SeniorCitizen varchar(35),ExistionAccount varchar(35));
create table signupThree(formno varchar(25), AccType varchar(25), cardNo varchar(25), Pin varchar(35), Facility varchar(25));
create table bank(cardNo varchar(25),pinNo varchar(25), date varchar(25), type varchar(50),amount varchar(35));
show tables;
select * from bank;
select * from login;
select * from signup;
select * from signuptwo; 
select * from signupthree;

