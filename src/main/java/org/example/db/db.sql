DROP DATABASE IF EXISTS beginner_pro;
CREATE DATABASE beginner_pro;
USE beginner_pro;


CREATE TABLE `user` (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id varchar(30) NOT NULL unique,
	`password` varchar(30) NOT NULL,
	name varchar(30) NOT NULL,
	birth varchar(30) NOT NULL,
	email varchar(100) NOT NULL unique
);


DROP table IF EXISTS movie;
CREATE TABLE movie (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title varchar(100) NOT NULL,
	director varchar(30) NOT NULL,
	actor varchar(30) NOT NULL,
	genre varchar(30) NOT NULL
);


CREATE TABLE schedule (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	movie_time varchar(30) NOT NULL
);


CREATE TABLE movie_reservation (
	id int unsigned not null auto_increment primary key unique,
    user_id int unsigned not null,
    movie_id int unsigned not null,
    schedule_id int not null,
    seat_x int not null,
    seat_y int not null);



CREATE TABLE review (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id int NOT NULL,
	movie_id int not null,
	score int NOT NULL,
	writing text NOT NULL,
	regDate varchar(50) not null
);




INSERT INTO `movie`
set id =1,
title = "인셉션",
director = "크리스토퍼 놀란",
actor = "레오나르도 디카프리오, 와타나베 켄, 조셉 고든레빗",
genre = "범죄,SF,액션,어드벤처,미스터리,느와르,하이스트";


INSERT INTO `movie`
set id =2,
title = "인터스텔라",
director = "크리스토퍼 놀란",
actor = "매튜 매커너히, 앤 해서웨이, 제시카 차스테인",
genre = "SF,드라마,어드벤처,디스토피아";


INSERT INTO `movie`
set id =3,
title = "타임 패러독스",
director = "피터 스피어리그, 마이클 스피어리그",
actor = "에단 호크, 사라 스누크, 노아 테일러 외",
genre = "SF";


INSERT INTO schedule
set
movie_time = "1:00 PM";

INSERT INTO schedule
set
movie_time = "4:00 PM";

INSERT INTO schedule
set
movie_time = "7:00 PM";

INSERT INTO schedule
set
movie_time = "10:00 PM";

SELECT * FROM SCHEDULE ;
















































SELECT title from MOVIE
where id=1;

use beginner_pro;

SELECT * from `user`;
SELECT * FROM MOVIE ;

INSERT into `user`
set user_id = 123,
`password` = 123,
name = "홍길동",
BIRTH = "96.05.16",
EMAIL = "123@123.123";

drop table `user`;

CREATE TABLE `user` (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id varchar(30) NOT NULL unique,
	`password` varchar(30) NOT NULL,
	name varchar(30) NOT NULL,
	birth varchar(30) NOT NULL,
	email varchar(100) NOT NULL unique
);

SELECT *from MOVIE
where id = 2;

SELECT email from `user`
where email = "123@123.123";


CREATE TABLE schedule (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	movie_time varchar(30) NOT NULL
);

drop table SCHEDULE ;
SELECT * from SCHEDULE;
INSERT INTO schedule
set
movie_time = "1:00 PM";

INSERT INTO schedule
set
movie_time = "4:00 PM";

INSERT INTO schedule
set
movie_time = "7:00 PM";

INSERT INTO schedule
set
movie_time = "10:00 PM";


SELECT * from MOVIE;




drop table MOVIE_RESERVATION ;

create table movie_reservation(
id int unsigned not null auto_increment primary key unique,
user_id int unsigned not null,
schedule_id int not null,
seat_x int not null,
seat_y int not null);


SELECT * FROM MOVIE_RESERVATION;