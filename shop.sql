create table login(username varchar(20), password varchar(20));


create table customer(cid int primary key,cname varchar(20) not null,cadd varchar(20) not null,cph varchar(20) not null,
					cdist int not null,cstat varchar(20));

create table product(pid int primary key,pname varchar(20) not null,price int not null);

create table ordr (oid int primary key,cid int, FOREIGN KEY (cid) REFERENCES customer(cid),items varchar(200),costper varchar(200),total int );
