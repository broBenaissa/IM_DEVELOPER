create database if not exists IMDEVELOPPER ;
use IMDEVELOPPER;
create table users (uid int unique auto_increment,uname varchar(50),upawd varchar(30),uemail varchar(50),umobile varchar(50));
INSERT INTO `imdevelopper`.`users` (`uid`, 'uname',`upwd`, `uemail`,'umobile') VALUES ('1', devlopper, 123,
123456789);

create table projects (pid int unique auto_increment,pname varchar(50),pdescription varchar(1000));
INSERT INTO `imdevelopper`.`services` (`pid`, `pname`, `sdescription`) VALUES ('1', 'im developper', 
'Cette Application représente le portfolio et les
 services d un développeur.
 le portfolio est un outil utilisé pour présenter des
 réalisations, des compétences et des expérience
 professionnelle à un employeur ou à des clients
 potentiels.
 Il présente les projets de design du concepteur,
 avec une brève description de chaque projet, les
 technologies utilisées et des images ou des vidéos
 du produit final. Il peut également inclure des
 témoignages de clients satisfaits');

create table services (pid int unique auto_increment,sname varchar(50),sdescription varchar(1000));
INSERT INTO `imdevelopper`.`project` (`pid`, `sname`, `sdescription`) VALUES ('1', 'myService', 
'le design de site web, le design');

select * from users ;