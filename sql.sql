create table Projet
(
    id     int auto_increment
        primary key,
    name   varchar(40) not null,
    budget double      not null
);

create table employee
(
    id     int auto_increment
        primary key,
    name   varchar(40) not null,
    email  varchar(30) not null,
    post   varchar(30) not null,
    skills varchar(40) not null
);

