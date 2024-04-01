create table type(
	id serial primary key,
	name text
);

create table product(
	id serial primary key,
	name         text,
	expired_date date,
	price        int,
	type_id      int references type(id)
);
