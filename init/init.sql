create table if not exists users (
	id serial primary key,
	email varchar(100) not null unique,
	password text not null,
	role varchar(20) not null,
	created_at timestamptz default now(),
    updated_at timestamptz default now(),
    deleted_at timestamptz
);

create table if not exists task (
	id serial primary key,
	title text not null,
	content text not null,
	completed bool default false,
	user_id int not null,
	created_at timestamptz default now(),
	updated_at timestamptz default now(),
	deleted_at timestamptz,
	constraint fk_tests_students foreign key (user_id) REFERENCES users(id)
);