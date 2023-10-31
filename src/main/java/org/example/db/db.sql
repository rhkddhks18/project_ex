DROP DATABASE IF EXISTS beginner_pro;
CREATE DATABASE beginner_pro;
USE beginner_pro;
CREATE TABLE `user` (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id varchar(30) NOT NULL unique,
	`password` varchar(30) NOT NULL,
	name varchar(30) NOT NULL,
	birth date NOT NULL,
	email varchar(100) NOT NULL unique
);

SELECT * FROM `user`;

CREATE TABLE movie (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title varchar(100) NOT NULL,
	director varchar(30) NOT NULL,
	actor varchar(30) NOT NULL,
	genre varchar(30) NOT NULL
);

SELECT * FROM movie;

CREATE TABLE schedule (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	time int NOT null
);

SELECT * FROM schedule;

CREATE TABLE seat (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	seat_x varchar(3) NOT NULL,
	seat_y varchar(3) NOT NULL
);

SELECT * FROM seat;

CREATE TABLE movie_reservation (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	is_complete char(30) NOT NULL
);

SELECT * FROM movie_reservation;

CREATE TABLE review (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	score int NULL,
	writing text null
);

SELECT * FROM review;