create table inspectors(
	id serial primary key,
	full_name varchar(255),
	position text
);

create table build_objects(
	id serial primary key,
	address text,
	remark text
);

create table inspectors_objects(
	id serial primary key,
	inspector_id int references inspectors(id),
	build_id int references build_objects(id)
)

