create schema if not exists hotel;
use hotel;

create table rooms
	(room_id int not null,
    num_beds int not null,
    bed_size enum('single','queen','king'),
    microwave bool,
    fridge bool,
    coffeepot bool,
    primary key(room_id));
    
create table guests
	(guest_id int not null,
    first_name varchar(20),
    last_name varchar(20),
    address varchar(25),
    phone_number varchar(20),
    email varchar(25),
    primary key(guest_id));
    
create table reservations
	(reserve_id int not null,
    start_date date,
    end_date date,
    reserver int not null,
    num_guests int,
    room_id int,
    primary key(reserve_id),
    foreign key(room_id) references rooms(room_id),
    foreign key(reserver) references guests(guest_id));