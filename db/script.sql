create table users(
	id serial primary key,
	full_name text,
	age integer,
	is_activated boolean
);
insert into users(full_name, age, is_activated) values ('slava', '18', true);
delete from users;