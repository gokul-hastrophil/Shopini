CREATE DATABASE shopini;
USE shopini;
CREATE TABLE Admin (
    userName VARCHAR(255) NOT NULL,
    passWord VARCHAR(255) NOT NULL
);

CREATE TABLE Product (
  pid INT PRIMARY KEY AUTO_INCREMENT,
  pname VARCHAR(255) NOT NULL,
  minimum_sellquantity INT,
  price DECIMAL(10, 2) NOT NULL,
  quantity INT
);

INSERT INTO Admin (userName, passWord)
VALUES
    ('gokul', '@#67');
    
select * from Login;
select * from Product;
