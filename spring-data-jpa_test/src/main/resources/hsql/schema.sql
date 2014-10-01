
drop table Article if exists;

create table Article (
	articleNo integer not null, 
	content varchar(255), 
	memberSeq integer, 
	title varchar(255), 
	primary key (articleNo)
);