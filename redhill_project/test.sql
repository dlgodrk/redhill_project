drop table humaninfo;
create table humaninfo(
	humanno number(10) primary key,
	name varchar2(20),
	sex varchar2(10),
	sunmoon varchar2(20),
	birthyear number,
	birthmonth number,
	birthday number,
	birthhour number,
	birthminute number,
	phonenumber varchar2(20),
	details varchar2(4000) 
)
insert into humaninfo values(1,'이철행','남성','양력',1994,12,14,9,30,'010-9919-6005','이상없음');
insert into humaninfo values(2,'염은영','여성','양력',1965,1,23,17,20,'010-2490-4491','이상없음');
insert into humaninfo values(3,'이정은','여성','양력',1992,9,9,19,10,'010-1234-5667','이상없음');
drop table fortune;
create table fortune(
	fortuneno number(10) primary key,
	humanno number(10) references humaninfo(humanno),
	innerfortune number,
	outerfortune number,
	changefortune number,
	explainfortune varchar2(4000),
	details varchar2(4000),
	fortunedate date
)
insert into fortune values(1,1,2,3,4,'재밋는운세','운세설명',sysdate);
insert into fortune values(2,1,2,3,4,'재밋는운세2','운세설명','2020-08-31');
insert into fortune values(3,1,2,3,4,'재밋는운세3','운세설명','2020-08-31');