DROP DATABASE IF EXISTS spring_jdbc;
CREATE DATABASE spring_jdbc;

DROP TABLE IF EXISTS student;
CREATE TABLE student(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO student(name, email) VALUES ('Frank', 'frank@gmail.com');
INSERT INTO student(name, email) VALUES ('Henry', 'henry@gmail.com');
INSERT INTO student(name, email) VALUES ('Bean', 'bean@gmail.com');