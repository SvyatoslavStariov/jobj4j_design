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

create table categories(
	id serial primary key,
	category text
);

create table states(
	id serial primary key,
	state text
);

create table items(
	id serial primary key,
	name_item text,
	user_id int references users(id),
	category_id int references categories(id),
	state_id int references states(id)
);

create table comments(
	id serial primary key,
	comment_text text,
	item_id int references items(id)
);

create table attachs(
	id serial primary key,
	file text,
	item_id int references items(id)
);
