create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

insert into products (name, producer, count, price) VALUES ('product_1', 'producer_1', 8, 100);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 200);
insert into products (name, producer, count, price) VALUES ('product_3', 'producer_3', 8, 300);
