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

CREATE TABLE movie (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title varchar(100) NOT NULL,
	director varchar(30) NOT NULL,
	actor varchar(30) NOT NULL,
	genre varchar(30) NOT NULL
);

CREATE TABLE schedule (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	movie_id int not null,
	movie_time varchar(30) NOT NULL
);

CREATE TABLE movie_reservation (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	user_id int NOT null,
	schedule_id int not null,
	seat_x int NOT NULL,
	seat_y int NOT NULL
);

CREATE TABLE review (
	id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	reservation_id int NOT NULL,
	movie_title varchar(30) NOT NULL,
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

insert into schedule (movie_id, movie_time)
VALUES(1, '1:00 PM'), (1, '4:00 PM'), (1, '7:00 PM'), (1, '10:00 PM')

insert into schedule (movie_id, movie_time)
VALUES(2, '1:00 PM'), (2, '4:00 PM'), (2, '7:00 PM'), (2, '10:00 PM')

insert into schedule (movie_id, movie_time)
VALUES(3, '1:00 PM'), (3, '4:00 PM'), (3, '7:00 PM'), (3, '10:00 PM')

insert into `user`
set id = 1,
user_id = "123",
`password` = "123",
name = "고",
birth = "97.12.08",
email = "rhkddhks@gmail.com";



