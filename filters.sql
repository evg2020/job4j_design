/*В системе заданы таблицы
product(id, name, type_id, expired_date, price)
type(id, name)

Задание.

1. Написать запрос получение всех продуктов с типом "СЫР"
2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
4. Написать запрос, который выводит самый дорогой продукт.
5. Написать запрос, который выводит количество всех продуктов определенного типа.
6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
8. Вывести все продукты и их тип.*/

create table type(
  id serial primary key ,
  name varchar(255)
);

create table product(
  id serial primary key ,
  name varchar(255),
  expired_date date,
  price real,
  type_id int references type(id)
);


insert into type(name) values ('milk_prod');
insert into type(name)  values ('bread_prod');
insert into type(name) values ('water_prod');
insert into type(name) values ('oil_prod');


insert into product(name, expired_date, price, type_id) VALUES ('Пармалат', '2021-03-04', 64.23, 1);
insert into product(name, expired_date, price, type_id) VALUES ('Дом в деревне', '2021-03-04', 55.23, 1);
insert into product(name, expired_date, price, type_id) VALUES ('Матроскин', '2021-04-04', 67.13, 1);
;
insert into product(name, expired_date, price, type_id) VALUES ('Бородинский', '2021-02-21', 22.11, 2);
insert into product(name, expired_date, price, type_id) VALUES ('Белый', '2021-02-23', 21.11, 2);
insert into product(name, expired_date, price, type_id) VALUES ('Черный', '2021-02-19', 11.21, 2);

insert into product(name, expired_date, price, type_id) VALUES ('Св.Источник', '2021-05-19', 55.21, 3);
insert into product(name, expired_date, price, type_id) VALUES ('Пятерочка', '2021-06-19', 18.21, 3);
insert into product(name, expired_date, price, type_id) VALUES ('Шишкин лес', '2021-07-19', 25.21, 3);

insert into product(name, expired_date, price, type_id) VALUES ('Семечка', '2022-07-19', 90.21, 4);
insert into product(name, expired_date, price, type_id) VALUES ('Подсолник', '2022-01-19', 91.21, 4);

-- 1. Написать запрос получение всех продуктов с типом "Bred_prod"
select  p.name,  t.name
from product p  join type t
    on p.type_id = t.id
where t.name = 'bread_prod';

-- 2 Написать запрос получения всех продуктов, у кого в имени есть слово "Белый"
 select * from product p where p.name like '%Мат%';

--3. Написать запрос, который выводит все продукты,
-- срок годности которых заканчивается в следующем месяце.
-- select p.name, p.expired_date from product  as p where p.expired_date > now() + interval '1 month';
select name, expired_date from product  where expired_date > current_date + interval '1 month';
select name, expired_date from product  where expired_date <'2021-03-30' and expired_date >'2021-03-01' ;
select name, expired_date from product
where  extract (month from expired_date) - extract (month from (current_date )) = 1;

--4. Написать запрос, который выводит самый дорогой продукт.
select
  p.name,
  p.price
from product p
where p.price = (select max(p.price) from product p);


--5. Написать запрос,
-- который выводит количество всех продуктов определенного типа.
 select count(p.id) from product p   where p.type_id = 2; --2 for bred_prod

 select t.name, count(*) from product p join type t on t.id = p.type_id
group by t.name having t.name = 'bread_prod'


select t.name, count(*) from product p
  join type t on t.id = p.type_id
    group by t.name;



--6. Написать запрос получение всех продуктов с типом "bread_prod" и "milk_prod"
select * from product p join type t on t.id = p.type_id
where t.name = 'bread_prod' or t.name = 'milk_prod';

--7. Написать запрос, который выводит тип продуктов, которых осталось меньше 3 штук.
select t.name, count(*) from product p
  join type t on t.id = p.type_id
group by t.name having count(*)<3;

-- 8. Вывести все продукты и их тип.
select * from product p join type t ON t.id = p.type_id;
