select * from product as p
	join type as t on t.id = p.type_id and t.name = 'СЫР';

select * from product where name ilike '%мороженное%';

select * from product where expired_date < current_date;

select * from product as p where p.price = (select max(product.price) from product);

select t.name, count(p) from type as t
	join product as p on t.id = p.type_id
	group by t.name;

select * from product as p
	join type as t on t.id = p.type_id
	where t.name = 'МОЛОКО' or t.name = 'СЫР';

select t.name, count(t) from type as t
	join product as p on p.type_id = t.id
	group by t.name
	having count(t) < 10

select p.*, t.name from product as p
	join type as t on p.type_id = t.id;
