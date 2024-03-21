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
