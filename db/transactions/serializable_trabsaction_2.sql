-- STEP 2
begin transaction isolation level serializable;

-- STEP 3
select sum(count) from products;
update products set count = 26 where name = 'product_2';
commit;