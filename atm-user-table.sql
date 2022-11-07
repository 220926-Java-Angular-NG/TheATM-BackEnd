create table "ATM-Project-Two".users(
userId serial primary key,
email varchar(30) not null,
firstname varchar(20) not null,
lastname varchar(20) not null,
pass_word varchar(20) not null,
phoneNum varchar(20) not null,
reset_password_token varchar(25)
);



