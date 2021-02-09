create table user (
  id   serial primary key,
  name varchar(255)
);

create table role (
  id   serial primary key,
  name varchar(255),
  role_id int references user(id)
);

create table rules(
  id serial primary key,
  name text
);
 create table role_rules(
   id serial primary key,
   role_id int references role(id),
   rules_id int references rules(id)
    );

create table item(
  id serial primary key,
  name varchar(255),
  user_id int references user(id)
);

create table comments(
  id serial primary key,
  name varchar(255),
  item_id references item(id)
);

create table attaches(
  id serial primary key,
  name varchar(255),
  item_id references item(id)
);

create table category(
  id serial primary key,
  name varchar(255),
  item_id references item(id)
);

create table state(
  id serial primary key,
  name varchar(255),
  item_id references item(id)
);