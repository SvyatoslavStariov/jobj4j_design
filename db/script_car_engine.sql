create table engine(
	id serial primary key,
	vin int,
	rpm int
);

create table car(
	id serial primary key,
	model varchar(255),
	engine_id int references engine(id) unique
);