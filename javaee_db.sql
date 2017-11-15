DROP DATABASE IF EXISTS beginningjavaee7;
CREATE DATABASE beginningjavaee7;
USE beginningjavaee7;

CREATE USER IF NOT EXISTS 'gigel'@'localhost' IDENTIFIED BY '54321';
GRANT ALL PRIVILEGES ON *.* TO 'gigel'@'localhost';

CREATE TABLE book
(
	book_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	title VARCHAR(40) NOT NULL, 
	description VARCHAR(1000) NOT NULL, 
	price DOUBLE(5,2), 
    isbn  VARCHAR(40) NOT NULL,
	number_of_pages INT NOT NULL,
	email VARCHAR(40) NOT NULL
);