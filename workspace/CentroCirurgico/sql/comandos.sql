-- SQL
-- linguagem de consulta esctruturada
-- comando de DDL
-- linguagem de definição de dados 
create database centro_cirurgico;
show databeses;
use centro_cirurgico;
create table painel(
-- chave primaria
-- código unico dentro da tabela
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