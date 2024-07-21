select min(age) as age from customers;

select * from customers where customers.id not in (select customer_id from orders where amount > 0);