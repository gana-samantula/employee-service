DROP TABLE IF EXISTS EMPLOYEES;

CREATE TABLE EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

INSERT INTO EMPLOYEES (first_name, last_name, email) VALUES
  ('Gana', 'Samantula', 'gana.samantula@gmail.com'),
  ('Soumya Sree', 'Sridharala', 'infosoumyasree@email.com'),
  ('Soumik Ragnar', 'Samantula', 'soumikragnar@marvel.com');