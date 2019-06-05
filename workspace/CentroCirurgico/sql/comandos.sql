-- SQL
-- linguagem de consulta esctruturada
-- comando de DDL
-- linguagem de defini√ß√£o de dados 
create database centro_cirurgico;
show databeses;
use centro_cirurgico;
create table painel(
-- chave primaria
-- c√≥digo unico dentro da tabela
cod 		   int primary key auto_increment,
nome_completo  varchar(100),
status         varchar(20),
local          varchar(20),
ini_previsto   varchar(5),
ini_cirurgia   varchar(5),
fim_cirurgia   varchar(5),
saida_prevista varchar(5)
);
show tables;
desc painel;

-- DML (Linguagem de manipulaÁ„o de dados)
-- insert - update - delete
insert into painel(
	nome_completo  ,
	status         ,
	local          ,
	ini_previsto   ,
	ini_cirurgia   ,
	fim_cirurgia   ,
	saida_prevista )
values ('Luiz',
		'transferido',
		'Quarto 10',
		'02:03',
		'04:06',
		'10:15',
		'14:10'
		);

-- consulta no banco de dados
select * from painel;



