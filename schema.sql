CREATE TABLE boards(
	id         INTEGER PRIMARY KEY,
	name       VARCHAR(256),
	created_at DATETIME
);

CREATE TABLE quotes(
	id         INTEGER PRIMARY KEY,
	boards_id  INTEGER,
	body       TEXT,
	created_at DATETIME
);




