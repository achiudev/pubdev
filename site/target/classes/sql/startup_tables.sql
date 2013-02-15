--Create User table
create table customer (cust_id char(20) PRIMARY KEY, first_name char(20), last_name char(20), country char(20));
insert into customer VALUES ('ABCD1234', 'Andrei', 'Apostol', 'CA');
insert into customer VALUES ('WXYZ4567', 'Alex', 'Chiu', 'CA');

--Create bookmark table
create table cust_bookmark (cust_id char (20), bookmark_location varchar(300), FOREIGN KEY (cust_id) REFERENCES customer(cust_id));
insert into cust_bookmark values ('ABCD1234', 'json_files/json.txt');