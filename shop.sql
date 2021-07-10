create table customer(cid int primary key,cname varchar(20) not null,cadd varchar(20) not null,cph varchar(20) not null,
					cdist int not null,cstat varchar(20));


create table product(pid int primary key,pname varchar(20) not null,price int not null);


create table bill(bid int primary key,semitot int,dis float,total int,cid int,cstat varchar(20),cname varchar(20),cadd varchar(20)
					,foreign key(cid) references customer(cid));
insert into bill values(1,0,0,0,1,'','','');   
insert into bill values(2,0,0,0,2,'','','');   
insert into bill values(3,0,0,0,3,'','','');   
insert into bill values(4,0,0,0,4,'','','');   
insert into bill values(5,0,0,0,5,'','',''); 
select * from bill;

create table ordr(oid int,bid int,foreign key(bid) references bill(bid),cstat varchar(20),cname varchar(20),cadd varchar(20),cdist int,
			i1 int,i2 int,i3 int,i4 int,semitot int,dis float,total int);  
			
create or replace trigger tg_before_insert
before insert
on ordr
for each row
begin
	:new.semitot := :new.i1 + :new.i2 + :new.i3 + :new.i4;
	
	if (:new.cstat='royal' and :new.cdist<10 and :new.semitot>1500) then :new.dis:=0.25;
    elsif (:new.cstat='royal' and :new.cdist>10 and :new.semitot<1500) then :new.dis:=0.15;
    elsif (:new.cstat='regular' and :new.cdist<10 and :new.semitot>1500) then :new.dis:=0.12;
    elsif (:new.cstat='regular' and :new.cdist>10 and :new.semitot<1500) then :new.dis:=0;
    end if;
    
	:new.total := :new.semitot - (:new.semitot * :new.dis);
	
END; 


create trigger tg_af_in
after insert
on ordr
for each row
begin
	update bill set semitot = :new.semitot where bid = :new.bid;-- ultimate + :new.total where ctid = :new.ctid;
	update bill set dis = :new.dis  where bid = :new.bid;
	update bill set total = :new.total  where bid = :new.bid;
	update bill set cstat = :new.cstat  where bid = :new.bid;
	update bill set cname = :new.cname  where bid = :new.bid;
	update bill set cadd = :new.cadd  where bid = :new.bid;
end;

select * from ordr;
select * from bill;
