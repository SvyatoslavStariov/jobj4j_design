create table fauna
(
    id             serial primary key,
    name           text,
    avg_age        int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values('gold_fish', 10, '1890-11-11');
insert into fauna(name, avg_age) values('baobab', 12000);
insert into fauna(name, avg_age) values('three', 22000);
insert into fauna(name, avg_age, discovery_date) values('bacteriophage', 1, '1980-01-11');

select * from fauna where name LIKE '%fish%';
select * from fauna where avg_age BETWEEN 10000 AND 21000;
select * from fauna where discovery_date is null;
select * from fauna where EXTRACT(YEAR from discovery_date) < '1950';