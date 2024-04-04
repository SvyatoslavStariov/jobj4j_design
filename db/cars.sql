create table car_bodies(
	id serial primary key,
	name varchar(255)
);

create table car_engines(
	id serial primary key,
	name varchar(255)
);

create table car_transmissions(
	id serial primary key,
	name varchar(255)
);

create table cars(
	id serial primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(name) values('седан');
insert into car_bodies(name) values('хэтчбек');
insert into car_bodies(name) values('пикап');

insert into car_transmissions(name) values('автомат');
insert into car_transmissions(name) values('механика');
insert into car_transmissions(name) values('робот');

insert into car_engines(name) values('электро');
insert into car_engines(name) values('бензин');
insert into car_engines(name) values('дизель');

insert into cars(name, body_id, engine_id, transmission_id) values('Lada', 1, 2, 2);
insert into cars(name, body_id, engine_id, transmission_id) values('Kia', 2, 1, 3);
insert into cars(name, body_id, engine_id, transmission_id) values('Ford', 1, 2, 3);

insert into cars(name, engine_id, transmission_id) values('Honday', 1, 2);
insert into cars(name, body_id, transmission_id) values('Toyta', 1, 2);
insert into cars(name, body_id, engine_id) values('Volvo', 1, 2);

select c.id as id, c.name as car_name, b.name as body_name, e.name as engine_name, t.name as transmission_name from cars as c
	left join car_bodies as b on b.id = c.body_id
	left join car_engines as e on e.id = c.engine_id
	left join car_transmissions as t on t.id = c.transmission_id;

select b.name as body_name from car_bodies as b
    left join cars as c on c.body_id = b.id
	where c.body_id is null;

select e.name as engine_name from car_engines as e
    left join cars as c on c.engine_id = e.id
	where c.engine_id is null;

select t.name as transmission_name from car_transmissions as t
    left join cars as c on c.transmission_id = t.id
	where c.transmission_id is null;
