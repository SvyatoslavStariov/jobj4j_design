insert into products (name, producer, count) VALUES ('product_0', 'producer_0', 0);
insert into products (name, producer, count) VALUES ('product_1', 'producer_1', 1);
insert into products (name, producer, count) VALUES ('product_2', 'producer_2', 2);
insert into products (name, producer, count) VALUES ('product_3', 'producer_3', 3);
insert into products (name, producer, count) VALUES ('product_4', 'producer_4', 4);
insert into products (name, producer, count) VALUES ('product_5', 'producer_5', 5);
insert into products (name, producer, count) VALUES ('product_6', 'producer_6', 6);
insert into products (name, producer, count) VALUES ('product_7', 'producer_7', 7);
insert into products (name, producer, count) VALUES ('product_8', 'producer_8', 8);
insert into products (name, producer, count) VALUES ('product_9', 'producer_9', 9);
insert into products (name, producer, count) VALUES ('product_10', 'producer_10', 10);
insert into products (name, producer, count) VALUES ('product_11', 'producer_11', 11);
insert into products (name, producer, count) VALUES ('product_12', 'producer_12', 12);

create
or replace function f_delete_empty_count_by_id(u_count integer, u_id integer)
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
    begin
        if u_count = 0 THEN
			select into result count
            from products
            where id = u_id;
            delete from products
            where id = u_id;
        end if;
        return result;
    end;
$$;

select f_delete_by_id_empty_count(0, 13);

create
or replace procedure p_delete_all_count_more_then(u_count integer)
language 'plpgsql'
as $$
    BEGIN
        delete from products
        where count >= u_count;
    end;
$$;

call p_delete_all_count_more_then(10);
