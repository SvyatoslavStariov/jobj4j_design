-- STEP 1
begin transaction isolation level serializable;

-- STEP 2
select sum(count) from products;
update products set count = 26 where name = 'product_1';

-- STEP 4
commit;