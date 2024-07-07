begin transaction;

DECLARE cursor_products SCROLL cursor for select * from products;

FETCH LAST FROM cursor_products;

MOVE BACKWARD 4 FROM cursor_products;

FETCH PRIOR FROM cursor_products;

FETCH BACKWARD 8 FROM cursor_products;

FETCH BACKWARD 5 FROM cursor_products;

FETCH PRIOR FROM cursor_products;

CLOSE cursor_products;

commit;