-- STEP 1
set session transaction isolation level read uncommitted;

start transaction;

select * from products;

-- STEP 3
insert into products (name, count, price) VALUES ('product_4', 11, 64);
delete from products where price = 115;
update products set price = 75 where name = 'product_1';

-- STEP 5
ROLLBACK;
