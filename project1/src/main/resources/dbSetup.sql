drop table if exists logins, requests;
drop table if exists api.logins, api.requests;
drop schema if exists api;
drop role if exists web_anon, todo_user, authenticator; 
create schema api


create table api.logins(
    id serial primary key,
    userName varchar,
    pass varchar,
    firstName varchar,
    lastName varchar,
    accountType int default 0
);

create table api.requests(
    id int references api.logins(id),
    descriptor varchar not null,
    image text,
    amount int not null
);

insert into api.logins (userName, pass, accountType) values ('Sean', 'sean', 1);
insert into api.logins (username, pass) values ('Luft','luft');
create role web_anon nologin;
create role authenticator noinherit login password 'password';
grant usage on schema api to web_anon;
grant all on api.logins, api.requests to web_anon;
grant web_anon to authenticator;
GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA api TO web_anon;

create role todo_user nologin;
grant todo_user to authenticator;

grant usage on schema api to todo_user;
grant all on api.logins, api.requests to todo_user;
grant usage, select on sequence api.logins_id_seq to todo_user;

select * from api.logins where id = 2;