CREATE SEQUENCE todos_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE todos
(
    id        INT NOT NULL,
    title     VARCHAR(255),
    completed BOOLEAN,
    CONSTRAINT pk_todos PRIMARY KEY (id)
);