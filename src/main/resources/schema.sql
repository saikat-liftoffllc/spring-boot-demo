DROP TABLE IF EXISTS users;

CREATE TABLE users (
	id serial PRIMARY KEY,
	name VARCHAR ( 255 ),
	email VARCHAR ( 255 ) UNIQUE NOT NULL
);