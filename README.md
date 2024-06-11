Database realization steps:

1. The database. 

- Use the code: 

create database supplychainmanagement;

2. Create a supplier table

- Use the code: 

create table supplier(
  id int primary key,
  suplier_name varchar(25),
  email varchar(15),
  password varchar(25),
);

3. Create a product table

- - Use the code: 

create table product (
  product_id int primary key,
  product_name varchar(25),
  quantity int,
  price int
);
