-- Creating a Schema

CREATE SCHEMA test;

-- Create a Book Table

CREATE TABLE test.book(

	id integer,
    title varchar(20),
    author varchar(20),
    publisher varchar(20),
    
    CONSTRAINT pk primary key (id)
    
);

-- Checking the Book Table

SELECT * FROM test.book;

-- Inserting new Book Information

INSERT INTO test.book (id, title, author, publisher)
values (0, 'Test Book', 'Test Author', 'Test Publisher');

INSERT INTO test.book (id, title, author, publisher)
values (1, 'Test Book', 'Test2 Author', 'Test2 Publisher');

INSERT INTO test.book (id, title, author, publisher)
values (2, 'Test Book', 'Test3 Author', 'Test3 Publisher');