create table teens(
    	id serial primary key,
    	name varchar(255),
    	gender varchar(3)
    );

insert into teens(name, gender) values ('Вася','Муж');
insert into teens(name, gender) values ('Петя','Муж');
insert into teens(name, gender) values ('Ваня','Муж');

insert into teens(name, gender) values ('Маша','Жен');
insert into teens(name, gender) values ('Оля','Жен');
insert into teens(name, gender) values ('Люда','Жен');

select t1.name , t2.name from teens as t1
    cross join teens as t2 where t1.gender != t2.gender and t1.gender != 'Муж';