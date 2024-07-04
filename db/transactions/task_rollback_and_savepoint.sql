-- STEP INIT DATABASE
begin transaction;

savepoint first_savepoint;

delete from products where price = 115;

select * from products;

savepoint second_savepoint;

delete from products where price = 50;

select * from products;

rollback to second_savepoint;

select * from products;

rollback to first_savepoint;

select * from products;

commit transaction;

select * from products;