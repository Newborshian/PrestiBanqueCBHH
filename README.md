# Script SQL PostgresSQL
```sql
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS conseiller CASCADE;
DROP TABLE IF EXISTS comptebancaire CASCADE;

CREATE TABLE conseiller
(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
    lastName VARCHAR NOT NULL ,
    firstName VARCHAR NOT NULL
);

CREATE TABLE client
(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,
    lastName VARCHAR NOT NULL ,
    firstName VARCHAR NOT NULL ,
    address VARCHAR NOT NULL ,
    city VARCHAR NOT NULL,
    zipCode INT NOT NULL ,
    phoneNumber VARCHAR NOT NULL ,
    id_conseiller INT,
    FOREIGN KEY (id_conseiller) REFERENCES conseiller (id)
);

CREATE TABLE compteBancaire
(
    id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    numeroDeCompte SERIAL NOT NULL,
    solde NUMERIC NOT NULL ,
    typeDeCompte VARCHAR NOT NULL ,
    createdAt VARCHAR NOT NULL ,
    id_client INT,
    FOREIGN KEY (id_client) REFERENCES client (id)
);

INSERT INTO conseiller (lastname, firstname)
VALUES
    ('Dupont', 'Jean'),
    ('Martin', 'Sophie');

INSERT INTO client (lastname, firstname, address, city, zipcode, phonenumber, id_conseiller)
VALUES
    ('Doe', 'John', '123 Main St', 'New York', 10001, '555-1234', 1), 
    ('Smith', 'Jane', '456 Elm St', 'Los Angeles', 90001, '555-5678', 2);
```
