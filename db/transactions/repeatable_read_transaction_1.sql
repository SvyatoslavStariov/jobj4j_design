-- STEP 1
begin transaction isolation level repeatable read;

-- STEP 3
select * from products;

-- STEP 5
insert into products (name, producer, count, price) VALUES ('product_4', 'producer_4', 11, 64);
delete from products where price = 115;
update products set price = 75 where name = 'product_1';

-- STEP 7
commit;