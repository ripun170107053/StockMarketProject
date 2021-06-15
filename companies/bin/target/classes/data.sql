
alter table company modify column id int NOT NULL AUTO_INCREMENT;
insert into company (company_name,turnover,ceo,stock_exchange,board_director,sector,writeup,company_code)
values('Apple',2021,'TCook','NASDAQ','Stevew',21,'first post',1337);
