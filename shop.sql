use shop;
create table login(username varchar(20), password varchar(20));
insert into login values('admin','admin');
select * from login;

create table customer(cid int primary key,cname varchar(20) not null,cadd varchar(20) not null,cph varchar(20) not null,
					cdist int not null,cstat varchar(20));
insert into customer values(1,'yagnesh','kalina','7895410236',5,'royal');
insert into customer values(2,'harsh','vakola','8992540626',10,'royal');
insert into customer values(3,'soham','manipada','9565410398',15,'royal');
insert into customer values(4,'cust1','bigvill','9514785236',20,'regular');
insert into customer values(5,'cust2','kalina','7954786236',5,'regular');
select * from customer where cid>3;

create table product(pid int primary key,pname varchar(20) not null,price int not null);
insert into product values(1,'bread',30);
insert into product values(2,'marie gold',10);
insert into product values(3,'milk',30);
insert into product values(4,'eggs',30);
insert into product values(5,'cheese',130);
insert into product values(6,'milano',50);
insert into product values(7,'snickers',45);
insert into product values(8,'cornetto',100);
insert into product values(9,'diary milk',50);
insert into product values(10,'coke',40);
insert into product values(11,'fanta',40);
select * from product;

create table ordr (oid int primary key,cid int, FOREIGN KEY (cid) REFERENCES customer(cid),items varchar(200),costper varchar(200),total int );
insert into ordr values(1,1,'bread,eggs,cheese,cornetto,snickers','30,30,130,100,45',335);
insert into ordr values(2,2,'bread,milano,cheese,cornetto,snickers','30,50,130,100,45',355);
insert into ordr values(3,3,'bread,eggs,cheese,cornetto,diary milk','30,30,130,100,45',345);
insert into ordr values(4,4,'bread,eggs,cheese,snickers','30,30,130,45',325);
insert into ordr values(5,5,'cornetto,snickers','100,45',145);
insert into ordr values(6,1,'bread,eggs,snickers','30,30,45',105);
insert into ordr values(7,2,'bread,eggs,cheese,coke,snickers','30,30,130,50,45',285);
insert into ordr values(8,3,'bread,eggs,cheese,cornetto,snickers','30,30,130,100,45',335);
select * from ordr;
