GRANT ALL PRIVILEGES ON *.* TO 'test'@'localhost' IDENTIFIED BY 'some_pass' WITH GRANT OPTION;

create table customer (cust_id char(20) PRIMARY KEY, first_name char(20), last_name char(20), country char(20));

create table cust_bookmark (cust_id char (20), bookmark_location varchar(300), FOREIGN KEY (cust_id) REFERENCES customer(cust_id));