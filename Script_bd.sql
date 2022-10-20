create database molano;

create table usuario(
    id serial not null,
    nombre varchar(20) not null,
    apellido varchar(20) not null,
    correo varchar(20) not null,
    clave varchar(20) not null,
    primary key(id)
);

insert into usuario (nombre, apellido, correo, clave) values ('jhon', 'molano', 'jhon@gmail.com', '123');
insert into usuario (nombre, apellido, correo, clave) values ('fredy', 'galindo', 'fredy@gmail.com', '123');