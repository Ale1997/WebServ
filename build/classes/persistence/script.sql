drop database if exists bdangular;
create database bdangular;

use bdangular;

Create table aluno(idAluno int primary key auto_increment,
nome varchar (50),email varchar(50) unique);

insert into aluno values (null,'luis','luis@gmail.com');
insert into aluno values (null,'lu','lu@gmail.com');
insert into aluno values (null,'gustavo','gustavo@gmail.com');
insert into aluno values (null,'alison','alison@gmail.com');

select * from aluno;

