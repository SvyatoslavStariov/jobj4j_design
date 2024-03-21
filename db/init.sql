create table users(
	id serial primary key,
	full_name varchar(255)
);

create table roles(
	id serial primary key,
	role_name varchar(255),
	user_id int references users(id)
);

create table rules(
	id serial primary key,
	rule_name varchar(255)
);

create table roles_rules(
	id serial primary key,
	roles_id int references roles(id),
	rules_id int references rules(id)
);


insert into users(full_name) values('Ivan Ivanov');
insert into roles(role_name, user_id) VALUES('Admin', 1);
insert into rules(rule_name) values('Absolute');

insert into roles_rules(roles_id, rules_id) values(1, 1);

insert into categories(category) values ('Trucks');
insert into states(state) values('Approval');
insert into items(name_item, user_id, category_id, state_id) values('Order', 1, 1, 1);

insert into comments(comment_text, item_id) values('No product', 1);

insert into attachs(file, item_id) values('No file', 1);