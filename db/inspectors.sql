create table inspectors(
	id serial primary key,
	full_name varchar(255),
	position varchar(255)
);

create table build_object(
	id serial primary key,
	address text,
	inspection_id int references inspectors(id)
);

insert into inspectors(full_name, position) values('Иван Иванович Иванов', 'Младший инспектор');
insert into inspectors(full_name, position) values('Петр Петрович Петров', 'Младший инспектор');
insert into inspectors(full_name, position) values('Сергей Сергеевич Сергеев', 'Инспектор');
insert into inspectors(full_name, position) values('Начальник Начальникович Начальников', 'Руководитель отделения');
insert into inspectors(full_name, position) values('Начальник Начальникович Начальников', 'Руководитель отделения');

insert into build_object(address, inspection_id) values('г. Москва больница', 1);
insert into build_object(address, inspection_id) values('г. Санкт-Петербург школа', 2);
insert into build_object(address, inspection_id) values('г. Екатеринбург школа', 3);
insert into build_object(address, inspection_id) values('г. Москва ГУМ ', 4);
insert into build_object(address, inspection_id) values('г. Москва ГУМ ', 5);


select insp.full_name, insp.position, object.address from
	inspectors as insp join build_object as object on insp.id = object.inspection_id;

select insp.full_name as ФИО, insp.position as Должность, object.address as Адрес from
	inspectors as insp join build_object as object on insp.id = object.inspection_id;

select insp.full_name as "ФИО инспектора", insp.position as Должность, object.address as "Адрес строительства" from
	inspectors as insp join build_object as object on insp.id = object.inspection_id;

select insp.full_name as "ФИО инспектора", insp.position as Должность, object.address as "Адрес строительства" from
	inspectors as insp join build_object as object on  insp.id = object.inspection_id AND insp.position = 'Руководитель отделения';