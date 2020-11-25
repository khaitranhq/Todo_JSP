use todo_netprog;

CREATE TABLE `Tasks` (
  `id` int NOT NULL AUTO_INCREMENT,
  `taskName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` varchar(100) DEFAULT 'open',
  `taskDescription` varchar(100) DEFAULT NULL,
  `targetDate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

create table UserAccounts (
	id int not null auto_increment primary key,
	email varchar(100) not null,
	password varchar(100) not null
);
	
-- seed 
insert into UserAccounts (email, password) 
values 
	('user1@ezteam.net', '123'),
	('user2@ezteam.net', '123'),
	('user5@ezteam.net', '123');

-- Test query
select *  from Tasks;

insert into Tasks (taskName, taskDescription, targetDate) ('Task 5','des','Sun Mar 04 00:00:00 ICT 2012');

query * from Tasks where id=6