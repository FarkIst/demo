create table books (
     id int not null primary key,
     name varchar(255) not null,
     description varchar(255),
     price int,
     constraint id unique (id),
     constraint name unique (name),
)