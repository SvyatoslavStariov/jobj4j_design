create table inspectors(
    id   serial primary key,
    name varchar(50)
);

create table project(
    id   serial primary key,
    name varchar(50)
);

create table type_check(
    id serial primary key,
    name varchar(200),
    project_id integer references project (id)
);

create table inspections(
    id serial primary key,
    active boolean default true,
    type_check_id integer references type_check (id),
    inspector_id integer references inspectors (id)
);

insert into inspectors (name) values ('Иван Иванов');
insert into inspectors (name) values ('Петр Петров');

insert into project (name) values ('Больница');
insert into project (name) values ('Школа');
insert into project (name) values ('Ледовый дворец');
insert into project (name) values ('Жилой дом');

insert into type_check (name, project_id) values ('Строительный контроль', 1);
insert into type_check (name, project_id) values ('Строительный контроль', 2);
insert into type_check (name, project_id) values ('Авторский надзор', 3);
insert into type_check (name, project_id) values ('Авторский надзор', 2);
insert into type_check (name, project_id) values ('Государственный надзор', 4);
insert into type_check (name, project_id) values ('Государственный надзор', 3);
insert into type_check (name, project_id) values ('Санпин', 1);

insert into inspections (type_check_id, inspector_id)
values (1, 1);
insert into inspections (type_check_id, inspector_id)
values (3, 1);
insert into inspections (type_check_id, inspector_id)
values (4, 2);
insert into inspections (type_check_id, inspector_id)
values (4, 1);
insert into inspections (type_check_id, inspector_id)
values (2, 2);

create view show_inspections
as
select i.name as inspector, count(t.name), t.name as check
from inspectors as i
         join inspections ins on i.id = ins.inspector_id
         join type_check t on ins.type_check_id = t.id
         join project p on p.id = t.project_id
group by (i.name, t.name)
having count(t.name) >= 2;

select * from show_inspections;

alter view show_inspections rename to show_check_inspections;

select * from show_check_inspections;

drop view show_check_inspections;