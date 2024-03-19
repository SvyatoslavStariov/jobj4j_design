create table nobel_prize(
	id serial primary key,
	subject varchar(255)
);

create table scientists(
	id serial primary key,
	full_name varchar(255),
	country varchar(255),
	nobel_prize_id int references nobel_prize(id)
);