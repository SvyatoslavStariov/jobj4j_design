create table devices
(
    id    serial primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   serial primary key,
    name varchar(255)
);

create table devices_people
(
    id        serial primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices(name, price) values('phone', 3000.00);
insert into devices(name, price) values('phone', 4000.00);

insert into devices(name, price) values('laptop', 10000.00);
insert into devices(name, price) values('laptop', 30000.00);

insert into devices(name, price) values('TV', 30000.00);
insert into devices(name, price) values('TV', 50000.00);

insert into people(name) values('Oleg');
insert into people(name) values('Alex');
insert into people(name) values('Nikita');

insert into devices_people(device_id, people_id) values(1, 1);
insert into devices_people(device_id, people_id) values(3, 1);
insert into devices_people(device_id, people_id) values(5, 1);

insert into devices_people(device_id, people_id) values(2, 2);
insert into devices_people(device_id, people_id) values(4, 2);
insert into devices_people(device_id, people_id) values(6, 2);

insert into devices_people(device_id, people_id) values(2, 3);
insert into devices_people(device_id, people_id) values(2, 3);

select avg(devices.price) from devices;

select p.name, avg(d.price) as avg_price from devices_people as dp
	join people as p on p.id = dp.people_id
	join devices as d on d.id = dp.device_id
	group by p.name;

select p.name, avg(d.price) as avg_price from devices_people as dp
    	join people as p on p.id = dp.people_id
    	join devices as d on d.id = dp.device_id
    	group by p.name
    	having avg(d.price) > 5000;