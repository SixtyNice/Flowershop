--create table users

      create TABLE "USERS" (
      	"ID" UUID PRIMARY KEY,
       	"LOGIN" VARCHAR2(45 CHAR) NOT NULL,
        "PASSWORD" VARCHAR2(45 CHAR) NOT NULL,
        "NAME" VARCHAR2(45 CHAR) NOT NULL,
        "LAST_NAME" VARCHAR2(45 CHAR) NOT NULL,
        "MIDDLE_NAME" VARCHAR2(45 CHAR),
        "ADDRESS" VARCHAR(45 CHAR) NOT NULL,
        "BALANCE" INT NOT NULL,
        "DISCOUNT" INT NOT NULL,
        );

      create TABLE "FLOWERS" (
      	"NAME" VARCHAR2(45 CHAR) PRIMARY KEY,
      	"PRICE" INT NOT NULL,
        "AMOUNT" INT NOT NULL,
        );

 create TABLE "CART" (
      	"NAME" VARCHAR2(45 CHAR) PRIMARY KEY,
      	"PRICE" INT NOT NULL,
        "AMOUNT" INT NOT NULL,
        );

--create my admin
insert into USERS (ID, LOGIN,PASSWORD,NAME,LAST_NAME,MIDDLE_NAME,ADDRESS,BALANCE,DISCOUNT) values ('','admin','admin123','Dima','Skibin','Norman','NO',0,0);

--create flowers
insert into FLOWERS (NAME,PRICE,AMOUNT) values ('rose',60,100);
insert into FLOWERS (NAME,PRICE,AMOUNT) values ('verbena',74,176);
insert into FLOWERS (NAME,PRICE,AMOUNT) values ('begonia',80,150);
insert into FLOWERS (NAME,PRICE,AMOUNT) values ('herbera',70,193);
