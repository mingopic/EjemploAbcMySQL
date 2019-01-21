drop database if exists escuela;
create database escuela;
use escuela;

create table grupo
(
  idAlumno int not null auto_increment primary key
  , nombre varchar(40)
  , grupo varchar(10)
  , promedio float 
);


insert into grupo values (NULL,'Cesar Luna','ITI-1106',9.0);
insert into grupo values (NULL,'Mingo Luna','ITI-1107',8.0);


drop procedure if exists obtenerAlumnos;
delimiter //
create procedure obtenerAlumnos()
begin
	select * from grupo;
end
//


drop procedure if exists obtenerAlumnoPorID;
delimiter //
create procedure obtenerAlumnoPorID 
(
  IN vidAlumno int
)
begin
	select * from grupo where idAlumno = vidAlumno;
end
//


drop procedure if exists insertarAlumno;
delimiter //
create procedure insertarAlumno 
(
  in vnombre varchar(40)
  , in vgrupo varchar(10)
  , in vpromedio float
)
begin
	insert into grupo values (null,vnombre,vgrupo,vpromedio);
end
//

call insertarAlumno ('Domingo Luna','ITI-1200',8.5);