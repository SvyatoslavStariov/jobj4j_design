-- STEP 2
set session transaction isolation level read uncommitted;

start transaction;

select * from products;

-- STEP 4
select * from products;

select sum(count) from products;

-- STEP 6
select sum(count) from products;