
-- Создать структур данных в базе.
-- Таблицы.
-- Кузов. Двигатель, Коробка передач.
-- Создать структуру Машина. Машина не может существовать без данных из п.1.
-- Заполнить таблицы через insert.

-

create database car;

create table body(
  id serial primary key ,
  name varchar(55)
);
create table engine(
  id serial primary key ,
  name varchar(55)
);
create table gearbox(
  id serial primary key ,
  name varchar(55)
);
create table car(
  id serial primary key ,
  brend_name varchar(55),
id_body int references body(id),
id_engine int references engine(id),
id_gearbox int references gearbox(id)
);


insert into body(name) values   ('sedan'),  ('cupe'),  ('vagon'), ('sport');
insert into engine(name) values   ('1.6_Turbo'),  ('1.8'),  ('2.0_turbo'),('3.0');
insert into gearbox(name) values   ('Mech'),  ('Auto');





insert into car(brend_name, id_body, id_engine, id_gearbox) values
  ('Lada', 2,1,1),
  ('BMV', 3,1,1),
  ('Mers',2,1,2);


select * from car  ;

- Создать SQL запросы:--
-- 1. Вывести список всех машин и все привязанные к ним детали.--

select c.brend_name, b.name as кузов, e.name as двиг, g.name as коробка
from car c
  join body b on c.id_body = b.id
  join engine e on c.id_engine = e.id
join gearbox g on c.id_gearbox = g.id;


-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select b.name from body b
  left join car ON b.id = car.id_body
where car.id_body is null ;

select g.name from gearbox g
  left join car ON g.id = car.id_gearbox
where car.id_gearbox is null ;

select g.name from engine e
  left join car ON e.id = car.id_engine
where car.id_engine is null ;

