create table schedule (
idx     number          GENERATED AS IDENTITY PRIMARY key,
sDate   Date            default sysdate,
memo    varchar2(2000)  not null

);

insert into schedule (sDate, memo) values ('2024-03-03', '3�� 3���Դϴ�');
insert into schedule (sDate, memo) values ('2024-03-01', '3.1�� ���');


commit;