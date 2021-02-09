create table school(
  id serial primary key,
  name varchar(100),
  number int
);
create table schoolchild(
  id serial primary key,
   name varchar(255),
  school_id int references school(id)
);
insert into school(name, number) VALUES ('Mos', 11);
insert into school(name, number) VALUES ('Dom', 12);
insert into school(name, number) VALUES ('Mos', 11);

insert  into schoolchild(name, school_id) VALUES ('Eva', 1);
insert  into schoolchild(name, school_id) VALUES ('Jon', 2);
insert  into schoolchild(name, school_id) VALUES ('Ivan', 3);

select * from schoolchild;

select ss.name as Имя, s.number  from schoolchild as ss join school as s
    on ss.school_id = s.id;