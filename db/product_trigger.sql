create
or replace function after_taxes()
    returns trigger as
$$
    BEGIN
        update products
        set price = price + price * 0.13
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger after_taxes_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure after_taxes();

create
or replace function before_taxes()
    returns trigger as
$$
    BEGIN
        new.price =new.price + new.price * 0.13;
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger before_taxes_trigger
    before insert
    on products
    for each row
    execute procedure before_taxes();
