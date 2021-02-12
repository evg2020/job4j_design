/*create table devices(
  id serial primary key ,
  name varchar(255),
  price float
);
create table people(
  id serial primary key ,
  name varchar(255)
);
create  table devices_people(
  id serial primary key,
devices_id int references devices(id),
people_id int references people(id)
);*/
 /*insert into devices(name, price) values ('Ball', 23.234);
insert into devices(name, price) values ('table', 14.231);
insert into devices(name, price) values ('pen', 11.001);

insert into people(name) values ('Ivan');
insert into people(name) values ('Vanya');
insert into people(name) values ('Andrey');
*/
/*insert into devices_people(devices_id, people_id) values (1,1);
insert into devices_people(devices_id, people_id) values (2,1);

insert into devices_people(devices_id, people_id) values (1,2);
insert into devices_people(devices_id, people_id) values (2,2);
insert into devices_people(devices_id, people_id) values (3,2);

insert into devices_people(devices_id, people_id) values (2,3);
insert into devices_people(devices_id, people_id) values (1,3);
insert into devices_people(devices_id, people_id) values (3,3);
insert into devices_people(devices_id, people_id) values (3,3);*/


--среднюю цену устройств

select avg(price) from devices;

-- Используя группировку вывести для каждого человеку среднюю цену его устройств

select p.name, avg(d.price) from people p JOIN devices_people d_p on p.id = d_p. people_id
JOIN devices d on d.id = d_p.devices_id group by p.name;


-- Дополнить запрос п.4. условием, что цена устройства должны быть больше 15
select p.name, avg(d.price) from devices_people d_p join people p on p.id = d_p.people_id
join devices d on d.id = d_p. devices group by p.name having avg(d.price) > 15;