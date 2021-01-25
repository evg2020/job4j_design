create database cars;
create table cars(
  id primary key,
  mark varchar(255),
  years int,
  area text
);
insert into cars(mark, years, area) values ('Ferrari', 1985, 'Italia');
insert into cars(mark, years, area) values ('BMW', 1985, 'Rusia');
update cars set area = 'RUS';
select * from cars;
