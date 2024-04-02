create table departments(
	id serial primary key,
	name text
);

create table employees(
	id serial primary key,
	name text,
	department_id int references departments(id)
);

insert into departments(name) values('Отдел закупок');
insert into departments(name) values('Отдел продаж');
insert into departments(name) values('Отдел маркетинга');
insert into departments(name) values('Отдел качества');


insert into employees(name, department_id) values('Главный Закупкин', 1);
insert into employees(name, department_id) values('Зам Закупкин', 1);
insert into employees(name, department_id) values('Главный Продажкин', 2);
insert into employees(name, department_id) values('Зам Продажкин', 2);
insert into employees(name, department_id) values('Главный Маркетингов', 3);

select * from employees as e
	left join departments as d on e.department_id = d.id;

select * from employees as e
    right join departments as d on e.department_id = d.id;

select * from employees as e
    full join departments as d on e.department_id = d.id;

select * from employees
    cross join departments;

select * from departments as d
	left join employees as e on e.department_id = d.id
	where e.department_id is null;

select d.*, e.* from departments as d
    right join employees as e on e.department_id = d.id;

select d.*, e.* from employees as e
    left join departments as d on e.department_id = d.id;
