drop table if exists logins, requests;


create table logins(
    id serial primary key,
    userName varchar,
    pass varchar,
    firstName varchar,
    lastName varchar,
    accountType int default 0
);

create table requests(
    id int references logins(id),
    descriptor varchar not null,
    image text,
    amount int not null
);

insert into logins (userName, pass, firstname, lastname, accountType) values ('Sean', 'sean', 'Sean', 'McClanahan', 1);
insert into logins (username, pass) values ('Luft','luft');
insert into requests (id, descriptor, amount) values (1, 'travel', 250);
insert into requests (id, descriptor, amount) values (1, 'boxes', 10);
insert into requests (id, descriptor, amount) values (1, 'plane ticket', 400);