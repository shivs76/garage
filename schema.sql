drop table department;
create table department 
(
id int primary key,
name varchar(100) not null,
description varchar(100)
)

drop table employee;
create table employee
(
id int primary key,
name varchar(100) not null,
salary int not null,
deptid int
);

insert into employee values(100,"Joe",1000,10);
insert into employee values(200,"Doe",1000,20);
insert into employee values(300,"Moe",1000,30);
insert into employee values(400,"Soe",1000,40);


insert into department
values(10, 'ACCOUNTING', 'NEW YORK');
insert into department
values(20, 'RESEARCH', 'DALLAS');
insert into department
values(30, 'SALES', 'CHICAGO');
insert into department
values(40, 'OPERATIONS', 'BOSTON');

