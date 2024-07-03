-- STEP 2
begin transaction isolation level repeatable read;

-- STEP 4
select * from products;

-- STEP 6
update products set price = 75 where name = 'product_1';