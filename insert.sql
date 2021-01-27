insert into user(name) values ('ivan'),('Vanua'), ('petr');

insert into role(name, role_id) values ('driver', 1), ('programmer', 2);

insert into rules(name) values ('right');

insert into rules_role(rules_id, role_id) values (1,1);

insert into comments(name, comments_id) values ('comments', 1);

insert into item(name, user_id) values ('item01', 1);

insert into attaches(name, attaches_id) values ('attaches01', 1);

insert into category(name, category_id) values ('category01', 1);

insert into state(name, state_id) values ('state01', 1);
