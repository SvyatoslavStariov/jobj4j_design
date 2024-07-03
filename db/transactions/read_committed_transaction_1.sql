-- STEP 1
begin transaction;

-- STEP 3
select * from products;

-- STEP 5
insert into products (name, count, price) VALUES ('product_4', 11, 64);
delete from products where price = 115;
update products set price = 75 where name = 'product_1';

select * from products;

-- STEP 7
commit;