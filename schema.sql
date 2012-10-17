DROP TABLE IF EXISTS boards;

CREATE TABLE boards(
	id         INTEGER ,
	name       VARCHAR(256),
	created_at TIMESTAMP,
	PRIMARY KEY (id)
);

DROP TABLE IF EXISTS quotes;
CREATE TABLE quotes(
	id         INTEGER,
	boards_id  INTEGER,
	body       TEXT,
	created_at TIMESTAMP,
	PRIMARY KEY (id)
);




