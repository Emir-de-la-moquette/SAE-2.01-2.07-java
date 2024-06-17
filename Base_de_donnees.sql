--create database JO;

drop table Sport;
drop table JeuxOlympique;
drop table Epreuve;
drop table Matchs;
drop table Pays;
drop table Athlete;
drop table Equipe;


create table Sport(id_sport varchar(70),valeurForce int(100),valeurEndurance int(100),valeurAgilite int(100),nbjoueur INT);

create table JeuxOlympique(id_JeuxOlympique INT,nomJeuxOlympique varchar(40),lieu varchar(100),annee DATE);

create table Epreuve(id_Epreuve INT,nomEpreuve varchar(100),categorieEpreuve varchar(100),typeEpreuve varchar(100),sexEpreuve varchar(1));

create table Matchs(id_Match INT,Matchtypes varchar(10),score INT);

create table Pays(id_pays varchar(100),medpays_or INT,medpays_argent INT,medpay_bronze INT);

create table Athlete(id_Athlete INT,NomAt varchar(50),PrenomAT varchar(50),SexeAT varchar(1),stats_Force int(100),stats_Endurance int(100),stats_agilite int(100));

create table Equipe(id_Equipe INT,medEquipe_or INT,medEquipe_argent INT,medEquipe_bronze INT,sexeEquipe varchar(1));



/*

insert into Sport values ();
insert into JeuxOlympique values ();
insert into Epreuve values ();
insert into Matchs values ();
insert into Pays values ();
insert into Athlete values ();
insert into equipe values ();

*/