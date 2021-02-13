create table departments(
  id serial primary key ,
  name varchar(25)
);

create table employees(
  id serial primary key ,
  name varchar(25),
  departments_id int references departments(id)
);
insert into departments(name) values
  ('Разработка'),
  ('Отдел кадров'),
  ('Администрация');

insert into employees(name, departments_id) values
  ('Petr', 1),
  ('Evg', 2),
  ('Vanya', 3),
  ('Ivan', 1),
  ('Olya', null ),
  ('Lev', 3);

select * from employees;
-- 2. Выполнить запросы с left, rigth, full, cross соединениями
select * from employees s left join departments d on s.departments_id = d.id;
select * from employees s join departments d on s.departments_id = d.id;

select * from employees s right join  departments d on s.departments_id = d.id;
select * from employees s cross join  departments d ;

-- 3. Используя left join найти департаменты, у которых нет работников

select * from employees s left join departments d on s.departments_id = d.id where d.id is null ;

-- 4. Используя left и right join написать запросы, которые давали бы одинаковый результат.

select * from departments d left join employees s on s.departments_id = d.id;
select * from employees s right join  departments d on s.departments_id = d.id;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары

create table teens(
  id serial primary key ,
  name varchar(50),
  gender char(1)
);
 insert into teens(name, gender) VALUES
   ('Petr','M'),
   ('vanya','M'),
   ('Ivan','M'),
   ('Yulia','F'),
   ('Lena','F'),
   ('Luka','F');
select t1.name, concat(t1.gender, t2.gender) as pol, t2.name FROM teens t1 cross join teens t2
where t1.gender <> t2.gender;