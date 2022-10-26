create table "ATM-Project-Two".accounts(
account_id serial primary key,
account_type varchar(30) not null,
account_owner int not null,

foreign key (account_owner) references users (userId)
);
