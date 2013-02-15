--Create User table
create table CUSTOMER (CUST_ID char(20) PRIMARY KEY, FIRST_NAME char(20), LAST_NAME char(20), COUNTRY char(20));
insert into CUSTOMER VALUES ('ABCD1234', 'Andrei', 'Apostol', 'CA');
insert into CUSTOMER VALUES ('WXYZ4567', 'Alex', 'Chiu', 'CA');
insert into CUSTOMER VALUES ('Tester', 'Test', 'Chiu', 'CA');

--Create bookmark table
create table CUST_BOOKMARK (CUST_ID char (20), BOOKMARK_LOCATION varchar(300), FOREIGN KEY (CUST_ID) REFERENCES CUSTOMER(CUST_ID));
insert into CUST_BOOKMARK values ('ABCD1234', 'json_andrei.txt');