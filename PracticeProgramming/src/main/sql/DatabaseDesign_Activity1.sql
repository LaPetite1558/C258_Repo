create schema if not exists petshop;
use petshop;

create table vets
	(vet_id int not null,
    pet_type int,
    hire_date date,
    primary key(vet_id));
    
create table owners
	(owner_id int not null,
    first_name varchar(20) not null,
    last_name varchar(20) not null,
    address varchar(50),
    phone_number varchar(20),
    email varchar(25),
    pet_id int,
    primary key(owner_id));
    
create table pets 
	(pet_id int not null,
    pet_name varchar(20),
    pet_type varchar(20) not null,
    birthdate date,
    vacc_id int,
    owner_id int,
    primary key(pet_id),
    foreign key(owner_id) references owners(owner_id));