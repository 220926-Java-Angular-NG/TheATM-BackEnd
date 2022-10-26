create table "ATM-Project-Two".transactions(
trans_id serial primary key,
account_id int not null,
from_id int not null,
to_id int not null,
amount real not null,
description varchar(20) not null,
date_of_trans varchar(15) not null,

foreign key (account_id) references accounts (account_id),
foreign key (from_id) references accounts (account_id),
foreign key (to_id) references accounts (account_id)
);