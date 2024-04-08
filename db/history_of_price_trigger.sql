create
or replace function after_products()
    returns trigger as
$$
    BEGIN
        INSERT INTO history_of_price (
		name, price, date)
		values(new.name, new.price, now());
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger after_product_history_trigger
    after insert
    on products
    for each row
    execute procedure after_products();
