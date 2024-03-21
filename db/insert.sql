insert into users(full_name) values('Ivan Ivanov');
insert into roles(role_name, user_id) VALUES('Admin', 1);
insert into rules(rule_name) values('Absolute');
insert into roles_rules(roles_id, rules_id) values(1, 1);

insert into categories(category) values ('Trucks');
insert into states(state) values('Approval');
insert into items(name_item, user_id, category_id, state_id) values('Order', 1, 1, 1);
insert into comments(comment_text, item_id) values('No product', 1);
insert into attachs(file, item_id) values('No file', 1);