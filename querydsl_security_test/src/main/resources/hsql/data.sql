insert into member values('min', 'min', 'min');
insert into member values('kim', 'kim', 'kim');
insert into member values('lee', 'lee', 'lee');
insert into member values('park', 'park', 'park');
insert into member values('tmon', 'tmon', 'tmon');

insert into article(memberId, title, content) values('min', '가나다1', 'ㅋㅋㅋ1');
insert into article(memberId, title, content) values('min', '가나다2', 'ㅋㅋㅋ2');
insert into article(memberId, title, content) values('kim', '가나다3', 'adㄱㄱsf');
insert into article(memberId, title, content) values('kim', 'zxcv', 'ㅋㅋㄱㅈㄷㅋ4');
insert into article(memberId, title, content) values('lee', '가나다5', 'ㅋㅋㄷㄷㅋ5');
insert into article(memberId, title, content) values('lee', '테스트1', 'ㅋㅋㅇㅋ1');
insert into article(memberId, title, content) values('park', '가2', 'ㅋㅋㄴㄴㅋ2');
insert into article(memberId, title, content) values('park', '나다3', 'adsf');
insert into article(memberId, title, content) values('tmon', 'zxcv', 'ㅋㅋㅇㅇㅋ4');
insert into article(memberId, title, content) values('tmon', '다5', 'ㅋㅁㄴㅇㅋㅋ5');


insert into memberRole(memberId, role) values('min', 'ROLE_USER');
insert into memberRole(memberId, role) values('kim', 'ROLE_USER');
